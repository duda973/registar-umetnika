package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.service.interfaces.KorisnikService;

@Component
public class KorisnikEditor extends PropertyEditorSupport {
	@Autowired
	private KorisnikService korisnikService;
	
	public void setAsText(String nazivUloge) {
		Uloga u = this.korisnikService.vratiUlogu(nazivUloge);
		this.setValue(u);
	}
}
