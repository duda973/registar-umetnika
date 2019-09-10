package registar_umetnika.regum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import registar_umetnika.regum.entity.Referenca;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.entity.Uplata;
import registar_umetnika.regum.service.interfaces.ReferenceService;
import registar_umetnika.regum.service.interfaces.UmetnikService;
import registar_umetnika.regum.service.interfaces.UplateService;
import registar_umetnika.regum.util.UmetnikEditor;

@Controller
@RequestMapping("/administracija")
public class UmetnikController {

	@Autowired
	private UmetnikService umetnikService;
	@Autowired
	private UplateService uplateService;
	@Autowired
	private ReferenceService referenceService;
	@Autowired
	private UmetnikEditor umetnikEditor;

	@RequestMapping("/umetnici")
	public String prikaziUmetnike(Model theModel) {
		List<Umetnik> umetnici = umetnikService.vratiUmetnike();

		theModel.addAttribute("umetnici", umetnici);

		return "lista-umetnika";
	}
	
	@GetMapping("/umetnici/obrisi-umetnika")
	public String obrisiUmetnika(@RequestParam("umetnikID") int id) {
		
		umetnikService.obrisiUmetnika(id);

		return "redirect:/administracija/umetnici";
	}
	
	@GetMapping("/umetnici/izmeni-umetnika")
	public String izmeniUmetnika(@RequestParam("umetnikID") int id, Model model) {
		model.addAttribute("umetnik", umetnikService.vratiUmetnika("id", id + ""));
		model.addAttribute("tipoviUmetnika", umetnikService.vratiTipoveUmetnika());

		return "umetnik-forma";
	}
	
	@RequestMapping("/umetnici/{jmbg}")
	public String prikaziUmetnika(Model model, @PathVariable(name = "jmbg") String jmbg) {
		Umetnik u = umetnikService.vratiUmetnika("jmbg", jmbg);

		model.addAttribute("umetnik", u);

		return "profil-umetnika";
	}

	@RequestMapping("/umetnici/{jmbg}/uplate")
	public String prikaziUplateUmetnika(Model model, @PathVariable(name = "jmbg") String jmbg) {
		Umetnik u = umetnikService.vratiUmetnika("jmbg", jmbg);

		model.addAttribute("umetnik", u);

		List<Uplata> uplate = uplateService.vratiUplate(u.getUmetnikId());

		model.addAttribute("uplate", uplate);

		return "profil-umetnika-uplate";
	}
	
	@RequestMapping("/umetnici/{jmbg}/dodaj-referencu")
	public String dodajReferencuUmetniku(Model model, @PathVariable(name = "jmbg") String jmbg) {
		Referenca referenca = new Referenca();
		
		model.addAttribute("referenca", referenca);
		
		return "umetnik-referenca-forma";
	}
	
	@RequestMapping("/umetnici/{jmbg}/sacuvaj-novu-referencu")
	public String sacuvajReferencu(@PathVariable(name = "jmbg") String jmbg,
			@ModelAttribute("referenca") Referenca novaReferenca) {
		novaReferenca.setOdobren(0);
		novaReferenca.setUmetnik(umetnikService.vratiUmetnika("jmbg", jmbg));
		
		referenceService.sacuvajReferencu(novaReferenca);
		
		return "redirect:/administracija/umetnici/"+jmbg+"/reference";
	}

	@RequestMapping("/umetnici/{jmbg}/reference")
	public String prikaziReferenceUmetnika(Model model, @PathVariable(name = "jmbg") String jmbg) {
		Umetnik u = umetnikService.vratiUmetnika("jmbg", jmbg);

		model.addAttribute("umetnik", u);

		List<Referenca> reference = referenceService.vratiReference(u.getUmetnikId());

		model.addAttribute("reference", reference);

		return "profil-umetnika-reference";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Umetnik.class, this.umetnikEditor);
	}
}
