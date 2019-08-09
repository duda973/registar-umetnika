package registar_umetnika.regum.service;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;

public interface UdruzenjeService {

	List<Udruzenje> vratiUdruzenja();

	List<KulturnoPodrucje> vratiKulturnaPodrucja();

	KulturnoPodrucje vratiKulturnoPodrucje(String nazivPodrucja);

	void sacuvajUdruzenje(Udruzenje novoUdruzenje);

	KulturnoPodrucje vratiPodrucjePoIDu(Long long1);

	
}
