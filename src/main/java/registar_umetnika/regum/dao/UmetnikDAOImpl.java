package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.UmetnikDAO;
import registar_umetnika.regum.entity.TipUmetnika;
import registar_umetnika.regum.entity.Udruzenje;
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
		String sql = "SELECT * FROM umetnik WHERE " + property + " = '" + value + "';";

		SQLQuery query = currentSession.createSQLQuery(sql);
		query.addEntity(Umetnik.class);

		List lista = query.list();
		
		if(lista.size() > 0)
			return (Umetnik) lista.get(0);
		
		return null;
	}

	@Override
	public void obrisiUmetnika(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete Umetnik where umetnikId = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Override
	public void azurirajKorisnikaUmetniku(Integer umetnikID, Integer korisnikID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update Umetnik set korisnikId = :korisnikid where umetnikId = :umetnikid");
		
		query.setParameter("korisnikid", korisnikID);
		query.setParameter("umetnikid", umetnikID);
		
		query.executeUpdate();
	}

	@Override
	public boolean imaUmetnikNalog(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Umetnik where umetnikId = :umetnikid");
		query.setParameter("umetnikid", Integer.parseInt(id));
		
		List<Umetnik> umetnici = query.getResultList();
		if(umetnici.get(0).getKorisnik() != null) {
			return true;
		}
		return false;
	}
}
