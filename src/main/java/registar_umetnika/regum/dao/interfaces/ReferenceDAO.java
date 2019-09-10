package registar_umetnika.regum.dao.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.Referenca;
import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.entity.Uplata;

public interface ReferenceDAO {

	List<Referenca> vratiReference(int umetnikId);

	void sacuvajReferencu(Referenca novaReferenca);

}
