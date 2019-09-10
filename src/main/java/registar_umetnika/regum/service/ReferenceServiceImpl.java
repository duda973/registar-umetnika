package registar_umetnika.regum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import registar_umetnika.regum.dao.interfaces.ReferenceDAO;
import registar_umetnika.regum.entity.Referenca;
import registar_umetnika.regum.service.interfaces.ReferenceService;

@Service
public class ReferenceServiceImpl implements ReferenceService {

	@Autowired
	private ReferenceDAO referenceDAO;

	@Override
	@Transactional
	public List<Referenca> vratiReference(int umetnikId) {
		return referenceDAO.vratiReference(umetnikId);
	}

	@Override
	@Transactional
	public void sacuvajReferencu(Referenca novaReferenca) {
		referenceDAO.sacuvajReferencu(novaReferenca);
	}
	

	
}
