package registar_umetnika.regum.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import registar_umetnika.regum.entity.Clanstvo;
import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.ClanstvoService;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;
import registar_umetnika.regum.service.interfaces.UmetnikService;
import registar_umetnika.regum.util.KorisnikEditor;
import registar_umetnika.regum.util.TipUmetnikaEditor;
import registar_umetnika.regum.util.UmetnikEditor;

@Controller
@RequestMapping("/administracija")
@SessionAttributes({ "umetnik", "tipoviUmetnika", "clanstvo" })
public class DodavanjeUmetnikaController {

	@Autowired
	private UmetnikService umetnikService;
	@Autowired
	private UdruzenjeService udruzenjeService;
	@Autowired
	private ClanstvoService clanstvoService;
	@Autowired
	private TipUmetnikaEditor tipUmetnikaEditor;
	@Autowired
	private KorisnikEditor korisnikEditor;
	@Autowired
	private UmetnikEditor umetnikEditor;

	@GetMapping("/umetnici/dodaj-novog-umetnika")
	public String dodajNovogUmetnikaUdruzenju(Model theModel,
			@RequestParam(value = "udruzenjeID", required = false) String id, 
			@ModelAttribute("umetnik") Umetnik u,
			@ModelAttribute("clanstvo") Clanstvo c) {
		
		if(id != null) {
			c.setUdruzenje(udruzenjeService.vratiUdruzenje(Integer.parseInt(id)));
		}

		return "umetnik-forma";
	}

	@PostMapping("/umetnici/sacuvaj-novog-umetnika")
	public String sacuvajNovogUmetnika(@ModelAttribute(name = "umetnik") Umetnik u,
			@ModelAttribute("clanstvo") Clanstvo c) {

		Umetnik proveraJMBG = umetnikService.vratiUmetnika("jmbg", u.getJmbg());

		if(proveraJMBG == null || proveraJMBG.getUmetnikId() == u.getUmetnikId()) {
			u.setKorisnik(proveraJMBG.getKorisnik());
			
			umetnikService.sacuvajUmetnika(u);
			
			if (c.getUdruzenje() != null) {
				c.setUmetnik(u);
				c.setDatum(new Date(System.currentTimeMillis()));
				clanstvoService.sacuvajNovoClanstvo(c);
			}
		} else {
			// nesto je promenjeno sto ne bi smelo
		}

		return "redirect:/administracija/umetnici";
	}

	@ModelAttribute("umetnik")
	public Umetnik umetnik() {
		return new Umetnik();
	}

	@ModelAttribute("tipoviUmetnika")
	public List<TipUmetnika> tipoviUmetnika() {
		return umetnikService.vratiTipoveUmetnika();
	}

	@ModelAttribute("clanstvo")
	public Clanstvo clanstvo() {
		return new Clanstvo();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TipUmetnika.class, this.tipUmetnikaEditor);
		binder.registerCustomEditor(Umetnik.class, this.umetnikEditor);
		binder.registerCustomEditor(Korisnik.class, this.korisnikEditor);
	}
}
