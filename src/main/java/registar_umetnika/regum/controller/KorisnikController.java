package registar_umetnika.regum.controller;

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

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.KorisnikService;
import registar_umetnika.regum.service.interfaces.UmetnikService;
import registar_umetnika.regum.util.KorisnikEditor;
import registar_umetnika.regum.util.UlogaEditor;

@Controller
@RequestMapping("/administracija")
@SessionAttributes({"umetnik"})
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private UmetnikService umetnikService;
	@Autowired
	private KorisnikEditor korisnikEditor;
	@Autowired
	private UlogaEditor ulogaEditor;
	
	@RequestMapping("/korisnici")
	public String prikaziKorisnike(Model theModel) {
		List<Korisnik> korisnici = korisnikService.vratiKorisnike();
		theModel.addAttribute("korisnici", korisnici);
		
		return "lista-korisnika";
	}
	
	@GetMapping("/korisnici/dodaj-novog-korisnika")
	public String dodajKorisnika(Model theModel, 
			@RequestParam(value = "umetnikID", required = false) String id, 
			@ModelAttribute("umetnik") Umetnik umetnik) {
		
		Korisnik k = new Korisnik();
		List<Uloga> uloge = korisnikService.vratiUloge();

		if(id != null) {
			if(umetnikService.imaUmetnikNalog(id)) {
				return "redirect:/administracija/umetnici";
			}

			umetnik = umetnikService.vratiUmetnika("umetnikid", id);
			theModel.addAttribute("umetnik", umetnik);
			
			k.setIme(umetnik.getIme());
			k.setPrezime(umetnik.getPrezime());
			
			for(Uloga u : uloge) {
				if(u.getNazivUloge().equals("Umetnik")) {
					k.setUloga(u);
					break;
				}
			}
			
			theModel.addAttribute("uloge", uloge);
			theModel.addAttribute("korisnik", k);
			
			return "korisnik-forma-za-umetnika";
		}
		
		
		theModel.addAttribute("uloge", uloge);
		theModel.addAttribute("korisnik", k);
		
		return "korisnik-forma";
	}
	
	@PostMapping("/korisnici/sacuvaj-korisnika")
	public String sacuvajKorisnika(@ModelAttribute("korisnik") Korisnik noviKorisnik, 
			@ModelAttribute("umetnik") Umetnik umetnik) {
		
		korisnikService.sacuvajKorisnika(noviKorisnik);
		
		if(umetnik != null) {
			umetnik.setKorisnik(noviKorisnik);
			umetnikService.sacuvajUmetnika(umetnik);
		}
		
		return "redirect:/administracija/korisnici";
	}
	
	@GetMapping("/korisnici/izmeni-korisnika")
	public String izmeniKorisnika(@RequestParam("korisnikId") int id, Model theModel) {
		Korisnik k = korisnikService.vratiKorisnika("id", id+"");
		
		List<Uloga> u = korisnikService.vratiUloge();

		theModel.addAttribute("korisnik", k);
		theModel.addAttribute("uloge", u);
		
		return "korisnik-forma";
	}
	
	@RequestMapping("/korisnici/uloge")
	public String prikaziUloge(Model theModel) {
		
		List<Uloga> uloge = korisnikService.vratiUloge();
		theModel.addAttribute("uloge", uloge);
		
		return "lista-uloga";
	}
	
	@GetMapping("/korisnici-po-ulozi")
	public String prikaziKorisnikePoUlozi( @RequestParam(name="ulogaId") int idUlogeZaPrikaz, Model theModel) {
		List<Korisnik> korisnici = korisnikService.vratiKorisnike(idUlogeZaPrikaz);
		
		theModel.addAttribute("korisnici", korisnici);
		
		return "lista-korisnika";
	}
	
	@GetMapping("/korisnici/obrisi-korisnika")
	public String obrisiKorisnika(@RequestParam("korisnikId") int id) {
		korisnikService.obrisiKorisnika(id);
		
		return "redirect:/administracija/korisnici";
	}
	
	@ModelAttribute("umetnik")
	private Umetnik umetnik() {
		return null;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Uloga.class, this.korisnikEditor);
		binder.registerCustomEditor(Uloga.class, this.ulogaEditor);
	}
}
