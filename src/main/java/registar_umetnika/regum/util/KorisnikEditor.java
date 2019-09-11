package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.service.interfaces.KorisnikService;

@Component
public class KorisnikEditor extends PropertyEditorSupport {
	@Autowired
	private KorisnikService korisnikService;
	
	public void setAsText(String text) {
		Korisnik k = this.korisnikService.vratiKorisnika("id", text);
		this.setValue(k);
	}
}
