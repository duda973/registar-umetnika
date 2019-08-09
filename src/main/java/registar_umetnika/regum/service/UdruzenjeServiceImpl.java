package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import registar_umetnika.regum.dao.UdruzenjeDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;

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
	public List<KulturnoPodrucje> vratiKulturnaPodrucja() {
		return udruzenjeDAO.vratiKulturnaPodrucja();
	}

	@Override
	@Transactional
	public KulturnoPodrucje vratiKulturnoPodrucje(String nazivPodrucja) {
		return udruzenjeDAO.vratiKulturnoPodrucje(nazivPodrucja);
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

	
}
