package registar_umetnika.regum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.service.interfaces.KorisnikService;
import registar_umetnika.regum.service.interfaces.UmetnikService;

@Controller
public class ProfilController {
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private UmetnikService umetnikService;
	
	@RequestMapping("/profil")
	public String profil(Model model, HttpSession session) {
		String username = LoginController.getPrincipal();
		
		if(session.getAttribute("user") == null) {
			session.setAttribute("user", username);
		}
		
		Korisnik ulogovaniKorisnik = korisnikService.vratiKorisnika("username", username);
		if(ulogovaniKorisnik.getUloga().getNazivUloge().equals("Umetnik")) {
			model.addAttribute("umetnik", umetnikService.vratiUmetnika("korisnikId", ulogovaniKorisnik.getKorisnikId()+""));
			
			return "profil-umetnika";
		}
		
		return "redirect:/pocetna";
	}
}
