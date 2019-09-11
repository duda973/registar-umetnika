package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.ClanstvoDAO;
import registar_umetnika.regum.entity.Clanstvo;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.entity.Umetnik;

@Repository
public class ClanstvoDAOImpl implements ClanstvoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Umetnik> vratiUmetnikePoUdruzenju(int udruzenjeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT * "
				+ "FROM umetnik as u " + "JOIN clanstvo as c " + "ON u.umetnikid = c.umetnikid "
				+ "WHERE c.udruzenjeid = " + udruzenjeId + ";";

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Umetnik.class);

		List lista = query.list();

		return lista;
	}

	@Override
	public void sacuvajNovoClanstvo(Clanstvo c) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(c);
	}
	
}
