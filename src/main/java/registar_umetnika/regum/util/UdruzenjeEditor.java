package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;

@Component
public class UdruzenjeEditor extends PropertyEditorSupport {
	@Autowired
	private UdruzenjeService udruzenjeService;
	
	public void setAsText(String text) {
		Udruzenje u = this.udruzenjeService.vratiUdruzenje(text);
		this.setValue(u);
	}
}
