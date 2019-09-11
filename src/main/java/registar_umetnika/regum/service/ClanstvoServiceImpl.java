package registar_umetnika.regum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import registar_umetnika.regum.dao.interfaces.ClanstvoDAO;
import registar_umetnika.regum.entity.Clanstvo;
import registar_umetnika.regum.entity.Umetnik;
import registar_umetnika.regum.service.interfaces.ClanstvoService;

@Service
public class ClanstvoServiceImpl implements ClanstvoService {

	@Autowired
	private ClanstvoDAO clanstvoDAO;

	@Override
	@Transactional
	public List<Umetnik> vratiUmetnikePoUdruzenju(int udruzenjeId) {
		return clanstvoDAO.vratiUmetnikePoUdruzenju(udruzenjeId);
	}

	@Override
	@Transactional
	public void sacuvajNovoClanstvo(Clanstvo c) {
		clanstvoDAO.sacuvajNovoClanstvo(c);
	}
	
}
