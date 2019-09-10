package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.UmetnikService;

@Component
public class UmetnikEditor extends PropertyEditorSupport {
	@Autowired
	private UmetnikService umetnikService;
	
	public void setAsText(String text) {
		Umetnik u = this.umetnikService.vratiUmetnika("id", text);
		this.setValue(u);
	}
}
