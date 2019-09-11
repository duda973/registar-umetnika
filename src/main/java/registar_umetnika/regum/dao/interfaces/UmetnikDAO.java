package registar_umetnika.regum.dao.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;

public interface UmetnikDAO {

	List<Umetnik> vratiUmetnike();

	List<TipUmetnika> vratiTipoveUmetnika();

	void sacuvajUmetnika(Umetnik u);

	TipUmetnika vratiTipUmetnika(int id);

	Umetnik vratiUmetnika(String property, String value);

	void obrisiUmetnika(int id);

	void azurirajKorisnikaUmetniku(Integer umetnikID, Integer korisnikID);

	boolean imaUmetnikNalog(String id);

}
