package registar_umetnika.regum.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;
import registar_umetnika.regum.service.interfaces.UmetnikService;

@Component
public class TipUmetnikaEditor extends PropertyEditorSupport {
	
	@Autowired
	private UmetnikService umetnikService;
	
	public void setAsText(String id) {
		TipUmetnika tu = this.umetnikService.vratiTipUmetnika(Integer.valueOf(id));
		this.setValue(tu);
	}
}
