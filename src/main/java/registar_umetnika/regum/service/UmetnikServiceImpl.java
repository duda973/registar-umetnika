package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import registar_umetnika.regum.dao.interfaces.UmetnikDAO;
import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.UmetnikService;

@Service
public class UmetnikServiceImpl implements UmetnikService {

	@Autowired
	private UmetnikDAO umetnikDAO;
	
	@Override
	@Transactional
	public List<Umetnik> vratiUmetnike() {
		return umetnikDAO.vratiUmetnike();
	}

	@Override
	@Transactional
	public List<TipUmetnika> vratiTipoveUmetnika() {
		return umetnikDAO.vratiTipoveUmetnika();
	}

	@Override
	@Transactional
	public void sacuvajUmetnika(Umetnik u) {
		umetnikDAO.sacuvajUmetnika(u);
	}

	@Override
	@Transactional
	public TipUmetnika vratiTipUmetnika(int id) {
		return umetnikDAO.vratiTipUmetnika(id);
	}

	@Override
	@Transactional
	public Umetnik vratiUmetnika(String property, String value) {
		return umetnikDAO.vratiUmetnika(property, value);
	}

	@Override
	@Transactional
	public void obrisiUmetnika(int id) {
		umetnikDAO.obrisiUmetnika(id);
	}
}
