package registar_umetnika.regum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministracijaController {
	
	@RequestMapping("/administracija")
	public String administracija() {
		return "administracija";
	}
}
