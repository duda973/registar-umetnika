package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import registar_umetnika.regum.dao.interfaces.UdruzenjeDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.service.interfaces.UdruzenjeService;

@Service
public class UdruzenjeServiceImpl implements UdruzenjeService {

	@Autowired
	private UdruzenjeDAO udruzenjeDAO;

	@Override
	@Transactional
	public List<Udruzenje> vratiUdruzenja() {
		return udruzenjeDAO.vratiUdruzenja();
	}

	@Override
	@Transactional
	public void sacuvajUdruzenje(Udruzenje novoUdruzenje) {
		udruzenjeDAO.sacuvajUdruzenje(novoUdruzenje);
	}

	@Override
	@Transactional
	public KulturnoPodrucje vratiPodrucjePoIDu(Long valueOf) {
		return udruzenjeDAO.vratiPodrucjePoIDu(valueOf);
	}

	@Override
	@Transactional
	public void obrisiUdruzenje(int id) {
		udruzenjeDAO.obrisiUdruzenje(id);
	}

	@Override
	@Transactional
	public Udruzenje vratiUdruzenje(int id) {
		return udruzenjeDAO.vratiUdruzenje(id);
	}

	@Override
	@Transactional
	public Udruzenje vratiUdruzenje(String text) {
		return udruzenjeDAO.vratiUdruzenje(text);
	}

	@Override
	@Transactional
	public List<Udruzenje> vratiUdruzenja(int podrucjeId) {
		return udruzenjeDAO.vratiUdruzenja(podrucjeId);
	}

	@Override
	@Transactional
	public Udruzenje vratiUdruzenje(String property, String value) {
		return udruzenjeDAO.vratiUdruzenje(property, value);
	}
	
	
}
