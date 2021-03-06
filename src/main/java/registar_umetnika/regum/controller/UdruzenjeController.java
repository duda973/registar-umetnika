package registar_umetnika.regum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.PripadnostUdruzenja;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.interfaces.ClanstvoService;
import registar_umetnika.regum.service.interfaces.KulturnoPodrucjeService;
import registar_umetnika.regum.service.interfaces.PripadnostUdruzenjaService;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;
import registar_umetnika.regum.util.KulturnoPodrucjeEditor;
import registar_umetnika.regum.util.UdruzenjeEditor;

@Controller
@RequestMapping("/administracija")
@Transactional
public class UdruzenjeController {
	
	@Autowired
	private UdruzenjeService udruzenjeService;
	@Autowired
	private PripadnostUdruzenjaService pripadnostUdruzenjaService;
	@Autowired
	private KulturnoPodrucjeService kulturnoPodrucjeService;
	@Autowired
	private ClanstvoService clanstvoService;
	@Autowired
	private KulturnoPodrucjeEditor kulturnoPodrucjeEditor;
	@Autowired
	private UdruzenjeEditor udruzenjeEditor;
	
	
	@RequestMapping("/udruzenja")
	public String prikaziUdruzenja(Model theModel) {
		List<Udruzenje> udruzenja = udruzenjeService.vratiUdruzenja();
		theModel.addAttribute("udruzenja", udruzenja);
		return "lista-udruzenja";
	}
	
	@RequestMapping("/udruzenja/{pib}")
	public String prikaziUdruzenje(@PathVariable("pib") int pib, Model theModel) {
		Udruzenje u = udruzenjeService.vratiUdruzenje("pib", pib + "");
		theModel.addAttribute("udruzenje", u);
		
		List<KulturnoPodrucje> podrucjaKojimaPripada = new ArrayList<KulturnoPodrucje>();
		List<PripadnostUdruzenja> pripadnosti = pripadnostUdruzenjaService.vratiPripadnostiPoUdruzenju(u.getUdruzenjeId());
		
		for(PripadnostUdruzenja pu : pripadnosti) {
			KulturnoPodrucje kp = kulturnoPodrucjeService.vratiKulturnoPodrucje(pu.getKulturnoPodrucje().getPodrucjeId());
			podrucjaKojimaPripada.add(kp);
		}
		
		theModel.addAttribute("podrucjaKojimaPripada", podrucjaKojimaPripada);
		theModel.addAttribute("pripadnosti", pripadnosti);
		
		return "profil-udruzenja";
	}
	
	@RequestMapping("/udruzenja/{pib}/umetnici")
	public String prikaziUmetnikeUdruzenja(@PathVariable("pib") int pib, Model theModel) {
		Udruzenje u = udruzenjeService.vratiUdruzenje("pib", pib + "");
		theModel.addAttribute("udruzenje", u);
		
		theModel.addAttribute("umetnici", clanstvoService.vratiUmetnikePoUdruzenju(u.getUdruzenjeId()));
		
		return "profil-udruzenja-umetnici";
	}
	
	@RequestMapping("/udruzenja/{pib}/kulturna-podrucja")
	public String prikaziKulturnaPodrucjaUdruzenja(@PathVariable("pib") int pib, Model theModel) {
		Udruzenje u = udruzenjeService.vratiUdruzenje("pib", pib + "");
		theModel.addAttribute("udruzenje", u);

		List<KulturnoPodrucje> podrucja = pripadnostUdruzenjaService.vratiKulturnaPodrucjaZaUdruzenje(u.getUdruzenjeId());;
		
		
		theModel.addAttribute("podrucja", podrucja);
		
		return "profil-udruzenja-kulturna-podrucja";
	}
	
	@GetMapping("/udruzenja/obrisi-kulturno-podrucje-udruzenju")
	public String obrisiPodrucjeUdruzenju(Model theModel,
			@RequestParam("udruzenjeID") int udruzenjeId, 
			@RequestParam("podrucjeID") int podrucjeId) {
		
		pripadnostUdruzenjaService.obrisiUpis(udruzenjeId, podrucjeId);
		
		return "redirect:/administracija/udruzenja/" + udruzenjeId;
	}
	
	@GetMapping("/udruzenja/obrisi-udruzenje")
	public String obrisiUdruzenje(@RequestParam("udruzenjeID") int id) {
		pripadnostUdruzenjaService.ocistiPripadnostiUdruzenja(id);
		udruzenjeService.obrisiUdruzenje(id);
		return "redirect:/administracija/udruzenja";
	}
	
	@GetMapping("/udruzenja/izmeni-udruzenje")
	public String izmeniUdruzenje(@RequestParam("udruzenjeID") int id,
			Model theModel) {
		Udruzenje u = udruzenjeService.vratiUdruzenje(id);
		
		theModel.addAttribute("udruzenje", u);
		
		return "udruzenje-forma-izmena";
	}
	
	@PostMapping("/udruzenja/sacuvaj-izmene")
	public String sacuvajIzmene(@ModelAttribute(name="udruzenje") Udruzenje u) {
		udruzenjeService.sacuvajUdruzenje(u);
		return "redirect:/administracija/udruzenja";
	}
	
	@GetMapping("/udruzenja/clanovi")
	public String clanoviUdruzenja(@RequestParam("udruzenjeID") int id, Model theModel) {
		
		// inicijalizacija liste umetnika
		
		// dodavanje liste u model
		
		return "clanovi-udruzenja";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(KulturnoPodrucje.class, this.kulturnoPodrucjeEditor);
		binder.registerCustomEditor(Udruzenje.class, this.udruzenjeEditor);
	}
}
