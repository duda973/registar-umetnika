package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.UdruzenjeService;

@Component
public class UdruzenjeEditor extends PropertyEditorSupport {
	@Autowired
	private UdruzenjeService udruzenjeService;
	
	public void setAsText(String text) {
		KulturnoPodrucje kp = this.udruzenjeService.vratiKulturnoPodrucje(text);
		System.out.println("aj probamo ovako" + kp.getNazivPodrucja());
		this.setValue(kp);
	}
}
