package registar_umetnika.regum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import registar_umetnika.regum.dao.interfaces.UmetnikDAO;
import registar_umetnika.regum.dao.interfaces.UplateDAO;
import registar_umetnika.regum.entity.Uplata;
import registar_umetnika.regum.service.interfaces.UplateService;

@Service
public class UplateServiceImpl implements UplateService {

	@Autowired
	private UplateDAO uplateDAO;
	
	@Override
	@Transactional
	public List<Uplata> vratiUplate(int umetnikId) {
		return uplateDAO.vratiUplate(umetnikId);
	}

	@Override
	@Transactional
	public List<Uplata> vratiUplate() {
		return uplateDAO.vratiUplate();
	}
}
