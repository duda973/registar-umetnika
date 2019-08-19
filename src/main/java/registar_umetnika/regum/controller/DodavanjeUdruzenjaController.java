package registar_umetnika.regum.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@SessionAttributes({"novaPripadnost", "udruzenje", "podrucja"})
public class DodavanjeUdruzenjaController {

	@Autowired
	private UdruzenjeService udruzenjeService;
	@Autowired
	private KulturnoPodrucjeService kulturnoPodrucjeService;
	@Autowired
	private PripadnostUdruzenjaService pripadnostUdruzenjaService;
	@Autowired
	private KulturnoPodrucjeEditor kulturnoPodrucjeEditor;
	@Autowired
	private UdruzenjeEditor udruzenjeEditor;

	private List<PripadnostUdruzenja> pripadnosti = new ArrayList<PripadnostUdruzenja>();
	
	@RequestMapping("/udruzenja/dodaj-novo-udruzenje")
	public String dodajUdruzenje(Model theModel) {
		return "udruzenje-forma";
	}
	
	@PostMapping(value = "/udruzenja/odaberi-kulturna-podrucja", params = "pocni")
	public String pocniBiranjeKulturnihPodrucja(Model theModel, 
			@ModelAttribute("udruzenje") Udruzenje novoUdruzenje,
			@ModelAttribute("novaPripadnost") PripadnostUdruzenja novaPripadnost,
			@ModelAttribute("podrucja") ArrayList<KulturnoPodrucje> podrucja, 
			SessionStatus session) {
		
		return "udruzenje-podrucja-forma";
	}

	@PostMapping(value = "/udruzenja/odaberi-kulturna-podrucja", params = "dalje")
	public String odaberiKulturnoPodrucje(Model theModel, 
			@ModelAttribute("udruzenje") Udruzenje novoUdruzenje,
			@ModelAttribute("novaPripadnost") PripadnostUdruzenja novaPripadnost, 
			RedirectAttributes redirectAttributes) {
		
		novaPripadnost.setDatumUnosaUBazu(new Date(System.currentTimeMillis()));
		novaPripadnost.setReprezentativno("ne");
		novaPripadnost.setUdruzenje(novoUdruzenje);
		
		pripadnosti.add(novaPripadnost);
		
		theModel.addAttribute("novaPripadnost", new PripadnostUdruzenja());
		
		return "udruzenje-podrucja-forma";
	}

	@PostMapping(value = "/udruzenja/odaberi-kulturna-podrucja", params = "sacuvaj")
	public String sacuvajUdruzenje(Model theModel, 
			@ModelAttribute("udruzenje") Udruzenje novoUdruzenje,
			@ModelAttribute("novaPripadnost") PripadnostUdruzenja novaPripadnost, 
			SessionStatus status) {
		
		novaPripadnost.setDatumUnosaUBazu(new Date(System.currentTimeMillis()));
		novaPripadnost.setReprezentativno("ne");
		novaPripadnost.setUdruzenje(novoUdruzenje);
		pripadnosti.add(novaPripadnost);
		
		udruzenjeService.sacuvajUdruzenje(novoUdruzenje);

		for (int i = 0; i < pripadnosti.size(); i++) {
			pripadnostUdruzenjaService.sacuvaj(pripadnosti.get(i));
		}

		pripadnosti.clear();
		status.setComplete();
		
		return "redirect:/administracija/udruzenja";
	}

	@RequestMapping(value = "/udruzenja/odaberi-kulturna-podrucja", params = "odustani")
	public String odustaniOdUnosNovogUdruzenja(SessionStatus session) {
		session.setComplete();
		pripadnosti.clear();
		return "redirect:/administracija/udruzenja";
	}
	
	@GetMapping("/udruzenja/dodaj-kulturno-podrucje")
	public String dodajKulturnoPodrucje(Model theModel, 
			@RequestParam("udruzenjeID") int udruzenjeId) {
		
		PripadnostUdruzenja pu = new PripadnostUdruzenja();
		Udruzenje u = udruzenjeService.vratiUdruzenje(udruzenjeId);
		pu.setUdruzenje(u);
		pu.setReprezentativno("ne");
		pu.setDatumUnosaUBazu(new Date(System.currentTimeMillis()));
		
		theModel.addAttribute("novaPripadnost", pu);
		
		List<KulturnoPodrucje> podrucja = kulturnoPodrucjeService.vratiKulturnaPodrucja();
		theModel.addAttribute("podrucja", podrucja);
		
		return "udruzenje-dodaj-podrucje-forma";
	}
	
	@PostMapping(value= "/udruzenja/sacuvaj-kulturno-podrucje", params="sacuvaj")
	public String sacuvajKulturnoPodrucje(@ModelAttribute("novaPripadnost") PripadnostUdruzenja pu,
			SessionStatus session) {
		pripadnostUdruzenjaService.sacuvaj(pu);
		session.setComplete();
		return "redirect:/administracija/udruzenja/prikaz?udruzenjeID=" + pu.getUdruzenje().getUdruzenjeId();
	}

	@ModelAttribute("podrucja")
	public List<KulturnoPodrucje> vratiPodrucja() {
		return kulturnoPodrucjeService.vratiKulturnaPodrucja();
	}

	@ModelAttribute("novaPripadnost")
	public PripadnostUdruzenja novaPripadnost() {
		return new PripadnostUdruzenja();
	}

	@ModelAttribute("udruzenje")
	public Udruzenje udruzenje() {
		return new Udruzenje();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(KulturnoPodrucje.class, this.kulturnoPodrucjeEditor);
		binder.registerCustomEditor(Udruzenje.class, this.udruzenjeEditor);
	}
}
