package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.KorisnikDAO;
import registar_umetnika.regum.entity.Korisnik;
import registar_umetnika.regum.entity.Uloga;
import registar_umetnika.regum.entity.Umetnik;

@Repository
public class KorisnikDAOImpl implements KorisnikDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Korisnik> vratiKorisnike() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Korisnik order by ulogaid", Korisnik.class);
		return theQuery.getResultList();
	}

	@Override
	public void sacuvajKorisnika(Korisnik noviKorisnik) {
		Session currentSession = sessionFactory.getCurrentSession();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		noviKorisnik.setPassword(encoder.encode(noviKorisnik.getPassword()));
		currentSession.saveOrUpdate(noviKorisnik);
	}


	@Override
	public List<Uloga> vratiUloge() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("SELECT u FROM Uloga u", Uloga.class).getResultList();
	}

	@Override
	public void obrisiUlogu(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete Uloga where ulogaid = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Override
	public List<Korisnik> vratiKorisnike(int idUlogeZaPrikaz) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Korisnik where ulogaid = :ID");
		query.setParameter("ID", idUlogeZaPrikaz);
		return query.getResultList();
	}

	@Override
	public Uloga vratiUlogu(Integer valueOf) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from Uloga where ulogaId = :id");
		query.setParameter("id", valueOf);

		return (Uloga) query.getResultList().get(0);
	}

	@Override
	public void obrisiKorisnika(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete Korisnik where korisnikId = :ID");
		query.setParameter("ID", id);
		
		query.executeUpdate();
	}

	@Override
	public Korisnik vratiKorisnika(String property, String value) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM korisnik WHERE " + property + " = '" + value + "';";

		SQLQuery query = currentSession.createSQLQuery(sql);
		query.addEntity(Korisnik.class);

		List lista = query.list();
		
		if(lista.size() > 0)
			return (Korisnik) lista.get(0);
		
		return null;
	}


}
