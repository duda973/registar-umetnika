package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import registar_umetnika.regum.dao.interfaces.KulturnoPodrucjeDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.service.interfaces.KulturnoPodrucjeService;

@Service
public class KulturnoPodrucjeServiceImpl implements KulturnoPodrucjeService {
	
	@Autowired
	private KulturnoPodrucjeDAO kulturnoPodrucjeDAO;
	
	@Override
	@Transactional
	public List<KulturnoPodrucje> vratiKulturnaPodrucja() {
		return kulturnoPodrucjeDAO.vratiKulturnaPodrucja();
	}

	@Override
	@Transactional
	public KulturnoPodrucje vratiKulturnoPodrucje(Integer valueOf) {
		return kulturnoPodrucjeDAO.vratiKulturnoPodrucje(valueOf);
	}

	@Override
	@Transactional
	public void obrisiKulturnoPodrucje(int podrucjeId) {
		kulturnoPodrucjeDAO.obrisiKulturnoPodrucje(podrucjeId);
	}

	@Override
	@Transactional
	public void dodajNovoKulturnoPodrucje(KulturnoPodrucje kp) {
		kulturnoPodrucjeDAO.dodajNovoKulturnoPodrucje(kp);
	}
}
