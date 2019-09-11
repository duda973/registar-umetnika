package registar_umetnika.regum.dao.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.Clanstvo;
import registar_umetnika.regum.entity.Umetnik;

public interface ClanstvoDAO {

	List<Umetnik> vratiUmetnikePoUdruzenju(int udruzenjeId);

	void sacuvajNovoClanstvo(Clanstvo c);
	
}
