package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.KulturnoPodrucjeDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;

@Repository
public class KulturnoPodrucjeDAOImpl implements KulturnoPodrucjeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<KulturnoPodrucje> vratiKulturnaPodrucja() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from KulturnoPodrucje", KulturnoPodrucje.class);
		return theQuery.getResultList();
	}
	
	@Override
	public KulturnoPodrucje vratiKulturnoPodrucje(String nazivPodrucja) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from KulturnoPodrucje where nazivPodrucja = :naziv");
		query.setParameter("naziv", nazivPodrucja);
		List<KulturnoPodrucje> podrucja = query.getResultList();
		
		return podrucja.get(0);
	}

	@Override
	public void obrisiKulturnoPodrucje(int podrucjeId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete KulturnoPodrucje where podrucjeId = :id");
		query.setParameter("id", podrucjeId);
		
		query.executeUpdate();
	}
	
}
