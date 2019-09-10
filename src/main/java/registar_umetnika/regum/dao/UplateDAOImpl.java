package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.UplateDAO;
import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Uplata;

@Repository
public class UplateDAOImpl implements UplateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Uplata> vratiUplate(int umetnikId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Uplata where umetnikId = :id", Uplata.class);
		theQuery.setParameter("id", umetnikId);
		return theQuery.getResultList();
	}

	@Override
	public List<Uplata> vratiUplate() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Uplata", Uplata.class);
		return theQuery.getResultList();
	}
	
}
