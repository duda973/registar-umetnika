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
public class UdruzenjeController {
	
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
	
	
	@RequestMapping("/udruzenja")
	public String prikaziUdruzenja(Model theModel) {
		List<Udruzenje> udruzenja = udruzenjeService.vratiUdruzenja();
		theModel.addAttribute("udruzenja", udruzenja);
		return "lista-udruzenja";
	}
	
	@GetMapping("/udruzenja/prikaz")
	public String prikaziUdruzenje(@RequestParam("udruzenjeID") int id, Model theModel) {
		theModel.addAttribute("udruzenje", udruzenjeService.vratiUdruzenje(id));
		
		List<KulturnoPodrucje> podrucjaKojimaPripada = new ArrayList<KulturnoPodrucje>();
		List<PripadnostUdruzenja> pripadnosti = pripadnostUdruzenjaService.vratiPripadnostiPoUdruzenju(id);
		for(PripadnostUdruzenja pu : pripadnosti) {
			KulturnoPodrucje kp = kulturnoPodrucjeService.vratiKulturnoPodrucje(pu.getKulturnoPodrucje().getNazivPodrucja());
			podrucjaKojimaPripada.add(kp);
		}
		
		theModel.addAttribute("podrucjaKojimaPripada", podrucjaKojimaPripada);
		theModel.addAttribute("pripadnosti", pripadnosti);
		
		return "udruzenje-prikaz";
	}
	
	@GetMapping("/udruzenja/obrisi-kulturno-podrucje-udruzenju")
	public String obrisiPodrucjeUdruzenju(Model theModel,
			@RequestParam("udruzenjeId") int udruzenjeId, 
			@RequestParam("podrucjeId") int podrucjeId) {
		
		pripadnostUdruzenjaService.obrisiUpis(udruzenjeId, podrucjeId);
		
		return "redirect:/administracija/udruzenja/prikaz?udruzenjeID=" + udruzenjeId;
	}
	
	@GetMapping("/udruzenja/obrisi-udruzenje")
	public String obrisiUdruzenje(@RequestParam("udruzenjeID") int id) {
		pripadnostUdruzenjaService.ocistiPripadnostiUdruzenja(id);
		udruzenjeService.obrisiUdruzenje(id);
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
