package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;
import registar_umetnika.regum.dao.interfaces.KorisnikDAO;
import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.service.interfaces.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikDAO korisnikDAO;
	
	@Override
	@Transactional
	public List<Korisnik> vratiKorisnike() {
		return korisnikDAO.vratiKorisnike();
	}

	@Override
	@Transactional
	public void sacuvajKorisnika(Korisnik noviKorisnik) {
		korisnikDAO.sacuvajKorisnika(noviKorisnik);
	}

	@Override
	@Transactional
	public List<Uloga> vratiUloge() {
		return korisnikDAO.vratiUloge();
	}

	@Override
	@Transactional
	public void obrisiUlogu(int id) {
		korisnikDAO.obrisiUlogu(id);
	}

	@Override
	@Transactional
	public List<Korisnik> vratiKorisnike(int idUlogeZaPrikaz) {
		return korisnikDAO.vratiKorisnike(idUlogeZaPrikaz);
	}

	@Override
	@Transactional
	public Uloga vratiUlogu(Integer valueOf) {
		return korisnikDAO.vratiUlogu(valueOf);
	}

	@Override
	@Transactional
	public void obrisiKorisnika(int id) {
		korisnikDAO.obrisiKorisnika(id);
	}

	@Override
	@Transactional
	public Korisnik vratiKorisnika(String property, String value) {
		return korisnikDAO.vratiKorisnika(property, value);
	}
	
}
