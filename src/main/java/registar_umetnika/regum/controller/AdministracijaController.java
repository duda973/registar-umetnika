package registar_umetnika.regum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministracijaController {
	
	@RequestMapping("/administracija")
	public String administracija(HttpSession session) {
		if(session.getAttribute("user") == null) {
			session.setAttribute("user", LoginController.getPrincipal());
		}
		return "administracija";
	}
}
