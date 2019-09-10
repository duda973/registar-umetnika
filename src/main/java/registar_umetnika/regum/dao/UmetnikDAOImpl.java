package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.UmetnikDAO;
import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Umetnik;

@Repository
public class UmetnikDAOImpl implements UmetnikDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Umetnik> vratiUmetnike() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Umetnik", Umetnik.class);
		return theQuery.getResultList();
	}

	@Override
	public List<TipUmetnika> vratiTipoveUmetnika() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from TipUmetnika", TipUmetnika.class);
		return theQuery.getResultList();
	}

	@Override
	public void sacuvajUmetnika(Umetnik u) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(u);
	}

	@Override
	public TipUmetnika vratiTipUmetnika(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from TipUmetnika where tipUmetnikaId=:id", TipUmetnika.class);
		theQuery.setParameter("id", id);
		return (TipUmetnika) theQuery.getResultList().get(0);
	}

	@Override
	public Umetnik vratiUmetnika(String property, String value) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Umetnik where " + property + "=:value", Umetnik.class);
		
		if(property.equals("id"))
			theQuery.setParameter("value", Integer.parseInt(value));
		else 
			theQuery.setParameter("value", value);
			
		return (Umetnik) theQuery.getResultList().get(0);
	}

	@Override
	public void obrisiUmetnika(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete Umetnik where umetnikId = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}
}
