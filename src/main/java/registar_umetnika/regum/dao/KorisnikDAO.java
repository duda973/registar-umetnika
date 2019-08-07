package registar_umetnika.regum.dao;

import java.util.List;

import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.Uloga;;

public interface KorisnikDAO {
	
	public List<Korisnik> vratiKorisnike();

	public void sacuvajKorisnika(Korisnik noviKorisnik);

	public Korisnik vratiKorisnika(int id);

	public List<Uloga> vratiUloge();

	public void obrisiUlogu(int id);

	public List<Korisnik> vratiKorisnike(int idUlogeZaPrikaz);

	public Uloga vratiUlogu(String nazivUloge);

	public void obrisiKorisnika(int id);
}
