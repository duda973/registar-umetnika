package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.Clanstvo;
import registar_umetnika.regum.entity.Umetnik;

public interface ClanstvoService {

	List<Umetnik> vratiUmetnikePoUdruzenju(int udruzenjeId);

	void sacuvajNovoClanstvo(Clanstvo c);

}
