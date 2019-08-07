package registar_umetnika.regum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.service.KorisnikService;

@Controller
@RequestMapping("/administracija")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping("/korisnici")
	public String prikaziKorisnike(Model theModel) {
		List<Korisnik> korisnici = korisnikService.vratiKorisnike();
		theModel.addAttribute("korisnici", korisnici);
		
		return "lista-korisnika";
	}
	
	@RequestMapping("/korisnici/dodaj-novog-korisnika")
	public String dodajKorisnika(Model theModel) {
		
		Korisnik k = new Korisnik();
		List<Uloga> u = korisnikService.vratiUloge();
		
		theModel.addAttribute("korisnik", k);
		theModel.addAttribute("uloge", u);
		
		return "korisnik-forma";
	}
	
	@PostMapping("/korisnici/sacuvaj-korisnika")
	public String sacuvajKorisnika(@ModelAttribute("korisnik") Korisnik noviKorisnik) {
		
		System.out.println(noviKorisnik.getUloga().getUlogaId() + " " + noviKorisnik.getUloga());
		Uloga u = korisnikService.vratiUlogu(noviKorisnik.getUloga().getNazivUloge());
		noviKorisnik.setUloga(u);
		korisnikService.sacuvajKorisnika(noviKorisnik);
		
		return "redirect:/administracija/korisnici";
	}
	
	@GetMapping("/korisnici/izmeni-korisnika")
	public String izmeniKorisnika(@RequestParam("korisnikId") int id, Model theModel) {
		Korisnik k = korisnikService.vratiKorisnika(id);
		
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
}
