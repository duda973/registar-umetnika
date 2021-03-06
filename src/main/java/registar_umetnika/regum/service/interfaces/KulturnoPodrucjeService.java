package registar_umetnika.regum.service.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;

public interface KulturnoPodrucjeService {

	List<KulturnoPodrucje> vratiKulturnaPodrucja();

	KulturnoPodrucje vratiKulturnoPodrucje(Integer integer);

	void obrisiKulturnoPodrucje(int podrucjeId);

	void dodajNovoKulturnoPodrucje(KulturnoPodrucje kp);

}
