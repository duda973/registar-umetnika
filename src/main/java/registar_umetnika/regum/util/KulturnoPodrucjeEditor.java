package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.service.interfaces.KulturnoPodrucjeService;

@Component
public class KulturnoPodrucjeEditor extends PropertyEditorSupport {
	@Autowired
	private KulturnoPodrucjeService kulturnoPodrucjeService;
	
	public void setAsText(String text) {
		KulturnoPodrucje kp = this.kulturnoPodrucjeService.vratiKulturnoPodrucje(text);
		this.setValue(kp);
	}
}
