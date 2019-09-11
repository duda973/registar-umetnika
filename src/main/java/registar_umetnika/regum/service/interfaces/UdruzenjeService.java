package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;

public interface UdruzenjeService {

	List<Udruzenje> vratiUdruzenja();

	void sacuvajUdruzenje(Udruzenje novoUdruzenje);

	KulturnoPodrucje vratiPodrucjePoIDu(Long long1);

	void obrisiUdruzenje(int id);

	Udruzenje vratiUdruzenje(int id);

	Udruzenje vratiUdruzenje(String text);

	List<Udruzenje> vratiUdruzenja(int podrucjeId);

	Udruzenje vratiUdruzenje(String property, String value);

	
}
