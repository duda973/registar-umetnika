package registar_umetnika.regum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.UmetnikService;
import registar_umetnika.regum.util.TipUmetnikaEditor;

@Controller
@RequestMapping("/administracija")
@SessionAttributes({"umetnik", "tipoviUmetnika"})
public class DodavanjeUmetnikaController {
	
	@Autowired
	private UmetnikService umetnikService;
	@Autowired
	private TipUmetnikaEditor tipUmetnikaEditor;
	
	@RequestMapping("/umetnici/dodaj-novog-umetnika")
	public String dodajNovogUmetnika(Model theModel) {
		return "umetnik-forma";
	}

	@PostMapping("/umetnici/sacuvaj-novog-umetnika")
	public String sacuvajNovogUmetnika(@ModelAttribute(name="umetnik") Umetnik u) {
		
		umetnikService.sacuvajUmetnika(u);
		
		return "redirect:/administracija/umetnici";
	}

	@ModelAttribute("umetnik")
	public Umetnik umetnik() {
		return new Umetnik();
	}
	
	@ModelAttribute("tipoviUmetnika")
	public List<TipUmetnika> tipoviUmetnika() {
		return umetnikService.vratiTipoveUmetnika();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TipUmetnika.class, this.tipUmetnikaEditor);
	}
}
