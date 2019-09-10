package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.Referenca;

public interface ReferenceService {

	List<Referenca> vratiReference(int umetnikId);

	void sacuvajReferencu(Referenca novaReferenca);

}
