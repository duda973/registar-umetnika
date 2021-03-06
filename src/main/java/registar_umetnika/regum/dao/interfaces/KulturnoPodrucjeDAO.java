package registar_umetnika.regum.dao.interfaces;

import java.util.List;

import registar_umetnika.regum.entity.KulturnoPodrucje;

public interface KulturnoPodrucjeDAO {

	List<KulturnoPodrucje> vratiKulturnaPodrucja();

	KulturnoPodrucje vratiKulturnoPodrucje(Integer valueOf);

	void obrisiKulturnoPodrucje(int podrucjeId);

	void dodajNovoKulturnoPodrucje(KulturnoPodrucje kp);

}
