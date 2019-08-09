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

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.service.UdruzenjeService;
import registar_umetnika.regum.util.UdruzenjeEditor;

@Controller
@RequestMapping("/administracija")
public class UdruzenjeController {
	
	@Autowired
	private UdruzenjeService udruzenjeService;
	
	@Autowired
	private UdruzenjeEditor udruzenjeEditor;
	
	@RequestMapping("/udruzenja")
	public String prikaziUdruzenja(Model theModel) {
		List<Udruzenje> udruzenja = udruzenjeService.vratiUdruzenja();
		theModel.addAttribute("udruzenja", udruzenja);
		return "lista-udruzenja";
	}
	
	@RequestMapping("/udruzenja/dodaj-novo-udruzenje")
	public String dodajUdruzenje(Model theModel) {

		Udruzenje u = new Udruzenje();
		List<KulturnoPodrucje> podrucja = udruzenjeService.vratiKulturnaPodrucja();
		
		theModel.addAttribute("udruzenje", u);
		theModel.addAttribute("podrucja", podrucja);
		return "udruzenje-forma";
	}
	
	@PostMapping("/udruzenja/sacuvaj-udruzenje")
	public String sacuvajUdruzenje(@ModelAttribute("udruzenje") Udruzenje novoUdruzenje) {

		// mali test
		System.out.println(novoUdruzenje.getKulturnoPodrucje().getPodrucjeId() + " " + novoUdruzenje.getKulturnoPodrucje());

//		KulturnoPodrucje kp = udruzenjeService.vratiKulturnoPodrucje(novoUdruzenje.getKulturnoPodrucje().getNazivPodrucja());
//		novoUdruzenje.setKulturnoPodrucje(kp);
		udruzenjeService.sacuvajUdruzenje(novoUdruzenje);

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
		System.out.println("uslo ovde");
		binder.registerCustomEditor(KulturnoPodrucje.class, this.udruzenjeEditor);
	}
}
