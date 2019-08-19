package registar_umetnika.regum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import registar_umetnika.regum.dao.interfaces.PripadnostUdruzenjaDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.PripadnostUdruzenja;
import registar_umetnika.regum.service.interfaces.PripadnostUdruzenjaService;

@Service
public class PripadnostUdruzenjaServiceImpl implements PripadnostUdruzenjaService {

	@Autowired
	private PripadnostUdruzenjaDAO pripadnostUdruzenjaDAO;

	@Override
	@Transactional
	public void sacuvaj(PripadnostUdruzenja pu) {
		pripadnostUdruzenjaDAO.sacuvaj(pu);
	}

	@Override
	@Transactional
	public void ocistiPripadnostiUdruzenja(int id) {
		pripadnostUdruzenjaDAO.ocistiPripadnostiUdruzenja(id);
	}

	@Override
	@Transactional
	public List<KulturnoPodrucje> vratiKulturnaPodrucjaZaUdruzenje(int id) {
		return pripadnostUdruzenjaDAO.vratiKulturnaPodrucjaZaUdruzenje(id);
	}

	@Override
	@Transactional
	public void obrisiUpis(int udruzenjeId, int podrucjeId) {
		pripadnostUdruzenjaDAO.obrisiUpis(udruzenjeId, podrucjeId);
	}

	@Override
	@Transactional
	public List<PripadnostUdruzenja> vratiPripadnostiPoUdruzenju(int id) {
		return pripadnostUdruzenjaDAO.vratiPripadnostiPoUdruzenju(id);
	}
	
	
}
