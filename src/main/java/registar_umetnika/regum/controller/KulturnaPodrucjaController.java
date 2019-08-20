package registar_umetnika.regum.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.PripadnostUdruzenja;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.interfaces.KulturnoPodrucjeService;
import registar_umetnika.regum.service.interfaces.PripadnostUdruzenjaService;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;
import registar_umetnika.regum.util.KulturnoPodrucjeEditor;
import registar_umetnika.regum.util.UdruzenjeEditor;

@Controller
@RequestMapping("/administracija")
@Transactional
public class KulturnaPodrucjaController {
	
	@Autowired
	private UdruzenjeService udruzenjeService;
	@Autowired
	private PripadnostUdruzenjaService pripadnostUdruzenjaService;
	@Autowired
	private KulturnoPodrucjeService kulturnoPodrucjeService;
	@Autowired
	private KulturnoPodrucjeEditor kulturnoPodrucjeEditor;
	@Autowired
	private UdruzenjeEditor udruzenjeEditor;
	
	
	@RequestMapping("/kulturna-podrucja")
	public String prikaziKulturnaPodrucja(Model theModel) {
		List<KulturnoPodrucje> kulturnaPodrucja = kulturnoPodrucjeService.vratiKulturnaPodrucja();
		theModel.addAttribute("podrucja", kulturnaPodrucja);
		return "lista-podrucja";
	}
	
	@GetMapping("/kulturna-podrucja/obrisi-kulturno-podrucje")
	public String obrisiKulturnoPodrucje(@RequestParam("podrucjeId") int podrucjeId) {
		kulturnoPodrucjeService.obrisiKulturnoPodrucje(podrucjeId);
		return "redirect:/administracija/kulturna-podrucja";
	}

	@GetMapping("/kulturna-podrucja/udruzenja")
	public String prikaziUdruzenjaPoKulturnomPodrucju(@RequestParam("podrucjeId") int podrucjeId, 
			Model theModel) {
		List<Udruzenje> udruzenja = udruzenjeService.vratiUdruzenja(podrucjeId);
		theModel.addAttribute("udruzenja", udruzenja);
		return "lista-udruzenja";
	}
	
	@RequestMapping("/kulturna-podrucja/dodaj-novo-kulturno-podrucje")
	public String dodajNovoKulturnoPodrucje(Model theModel) {
		KulturnoPodrucje kp = new KulturnoPodrucje();
		theModel.addAttribute("podrucje", kp);
		
		return "podrucje-forma";
	}
	
	@PostMapping("/kulturna-podrucja/sacuvaj-kulturno-podrucje")
	public String sacuvajKulturnoPodrucje(Model theModel, @ModelAttribute("podrucje") KulturnoPodrucje kp) {
		
		kulturnoPodrucjeService.dodajNovoKulturnoPodrucje(kp);
		
		return "redirect:/administracija/kulturna-podrucja";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(KulturnoPodrucje.class, this.kulturnoPodrucjeEditor);
		binder.registerCustomEditor(Udruzenje.class, this.udruzenjeEditor);
	}
}
