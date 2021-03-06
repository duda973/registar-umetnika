package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;

public interface UmetnikService {

	List<Umetnik> vratiUmetnike();

	List<TipUmetnika> vratiTipoveUmetnika();

	void sacuvajUmetnika(Umetnik u);

	TipUmetnika vratiTipUmetnika(int id);


	Umetnik vratiUmetnika(String property, String value);

	void obrisiUmetnika(int id);

	void azurirajKorisnikaUmetniku(Integer umetnikID, Integer korisnikId);

	boolean imaUmetnikNalog(String id);
}
