package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.entity.Uplata;

public interface UplateService {

	List<Uplata> vratiUplate(int umetnikId);

	List<Uplata> vratiUplate();

}
