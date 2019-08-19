package registar_umetnika.regum.dao.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;

public interface UdruzenjeDAO {

	List<Udruzenje> vratiUdruzenja();

	void sacuvajUdruzenje(Udruzenje novoUdruzenje);

	KulturnoPodrucje vratiPodrucjePoIDu(Long valueOf);

	void obrisiUdruzenje(int id);

	Udruzenje vratiUdruzenje(int id);

	Udruzenje vratiUdruzenje(String text);

	List<Udruzenje> vratiUdruzenja(int podrucjeId);

}
