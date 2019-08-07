package registar_umetnika.regum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administracija")
public class UmetniciController {
	@RequestMapping("/umetnici")
	public String prikaziUdruzenja(Model theModel) {
		
		return "lista-umetnika";
	}
}
