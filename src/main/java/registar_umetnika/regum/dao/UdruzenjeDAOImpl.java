package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import antlr.StringUtils;
import registar_umetnika.regum.dao.interfaces.UdruzenjeDAO;
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

	@Override
	public void obrisiUdruzenje(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete Udruzenje where udruzenjeId = :id");
		query.setParameter("id", id);

		query.executeUpdate();
	}

	@Override
	public Udruzenje vratiUdruzenje(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Udruzenje where udruzenjeId = :id");
		query.setParameter("id", id);

		return (Udruzenje) query.getResultList().get(0);
	}

	@Override
	public Udruzenje vratiUdruzenje(String text) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Udruzenje where naziv = :nazivUdruzenja");
		query.setParameter("nazivUdruzenja", text);

		return (Udruzenje) query.getResultList().get(0);
	}

	@Override
	public List<Udruzenje> vratiUdruzenja(int podrucjeId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT u.udruzenjeid, u.maticnibroj, u.pib, u.naziv, u.sediste, u.adresa, u.datumosnivanja, u.zastupnik, u.registarskibroj "
				+ "FROM udruzenje as u " + "JOIN pripadnostudruzenja as pu " + "ON u.udruzenjeid = pu.udruzenjeid "
				+ "WHERE pu.kulturnopodrucjeid = " + podrucjeId + ";";

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Udruzenje.class);

		List lista = query.list();

		return lista;
	}

	@Override
	public Udruzenje vratiUdruzenje(String property, String value) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "SELECT * FROM udruzenje WHERE " + property + " = '" + value + "';";

		SQLQuery query = currentSession.createSQLQuery(sql);
		query.addEntity(Udruzenje.class);

		List lista = query.list();
		
		return (Udruzenje) lista.get(0);
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
