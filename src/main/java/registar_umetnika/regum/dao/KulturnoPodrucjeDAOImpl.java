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
	public KulturnoPodrucje vratiKulturnoPodrucje(Integer valueOf) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from KulturnoPodrucje where podrucjeId = :id");
		query.setParameter("id", valueOf);
		return (KulturnoPodrucje) query.getResultList().get(0);
	}

	@Override
	public void obrisiKulturnoPodrucje(int podrucjeId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete KulturnoPodrucje where podrucjeId = :id");
		query.setParameter("id", podrucjeId);
		
		query.executeUpdate();
	}

	@Override
	public void dodajNovoKulturnoPodrucje(KulturnoPodrucje kp) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(kp);
	}
	
}
