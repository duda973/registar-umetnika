package registar_umetnika.regum.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import registar_umetnika.regum.entity.Uplata;
import registar_umetnika.regum.service.interfaces.UplateService;

@RestController
@RequestMapping("/api")
public class UplateController {

	@Autowired
	private UplateService uplateService;
	
	@RequestMapping("/uplate")
	public List<Uplata> vratiUplate() {
		return uplateService.vratiUplate();
	}
}
