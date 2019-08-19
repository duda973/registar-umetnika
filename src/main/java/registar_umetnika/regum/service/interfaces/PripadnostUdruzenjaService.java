package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.PripadnostUdruzenja;

public interface PripadnostUdruzenjaService {

	void sacuvaj(PripadnostUdruzenja pu);

	void ocistiPripadnostiUdruzenja(int id);

	List<KulturnoPodrucje> vratiKulturnaPodrucjaZaUdruzenje(int id);

	void obrisiUpis(int udruzenjeId, int podrucjeId);

	List<PripadnostUdruzenja> vratiPripadnostiPoUdruzenju(int id);
	
}
