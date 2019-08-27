package registar_umetnika.regum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.UmetnikService;
import registar_umetnika.regum.util.UmetnikEditor;

@Controller
@RequestMapping("/administracija")
public class UmetnikController {
	
	@Autowired
	private UmetnikService umetnikService;
	
	@Autowired
	private UmetnikEditor umetnikEditor;
	
	@RequestMapping("/umetnici")
	public String prikaziUmetnike(Model theModel) {
		List<Umetnik> umetnici = umetnikService.vratiUmetnike();
		
		theModel.addAttribute("umetnici", umetnici);

		return "lista-umetnika";
	}
		
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Umetnik.class, this.umetnikEditor);
	}
}
