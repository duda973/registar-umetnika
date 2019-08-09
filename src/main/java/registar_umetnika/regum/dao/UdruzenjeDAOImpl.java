package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.Udruzenje;
import registar_umetnika.regum.entity.Uloga;

@Repository
public class UdruzenjeDAOImpl implements UdruzenjeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Udruzenje> vratiUdruzenja() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Udruzenje order by naziv", Udruzenje.class);
		return theQuery.getResultList();
	}

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
	public void sacuvajUdruzenje(Udruzenje novoUdruzenje) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(novoUdruzenje);		
	}

	@Override
	public KulturnoPodrucje vratiPodrucjePoIDu(Long valueOf) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from KulturnoPodrucje where podrucjeId = :id");
		query.setParameter("id", valueOf);
		List<KulturnoPodrucje> podrucja = query.getResultList();
		
		return podrucja.get(0);
	}

}
