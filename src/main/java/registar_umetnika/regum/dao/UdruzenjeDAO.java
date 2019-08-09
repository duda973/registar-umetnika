package registar_umetnika.regum.dao;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;

public interface UdruzenjeDAO {

	List<Udruzenje> vratiUdruzenja();

	List<KulturnoPodrucje> vratiKulturnaPodrucja();

	KulturnoPodrucje vratiKulturnoPodrucje(String nazivPodrucja);

	void sacuvajUdruzenje(Udruzenje novoUdruzenje);

	KulturnoPodrucje vratiPodrucjePoIDu(Long valueOf);

}
