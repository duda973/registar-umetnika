package registar_umetnika.regum.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.PripadnostUdruzenjaDAO;
import registar_umetnika.regum.entity.KulturnoPodrucje;
import registar_umetnika.regum.entity.PripadnostUdruzenja;

@Repository
public class PripadnostUdruzenjaDAOImpl implements PripadnostUdruzenjaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void sacuvaj(PripadnostUdruzenja pu) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(pu);
	}

	@Override
	public void ocistiPripadnostiUdruzenja(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete PripadnostUdruzenja where udruzenjeID = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

	@Override
	public List<KulturnoPodrucje> vratiKulturnaPodrucjaZaUdruzenje(int id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT kp.podrucjeid, kp.nazivpodrucja, kp.umetnicko " + 
				"FROM kulturnopodrucje as kp " + 
				"JOIN pripadnostudruzenja as pu " + 
				"ON kp.podrucjeid = pu.kulturnopodrucjeID " + 
				"WHERE pu.udruzenjeID = " + id + ";";
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(KulturnoPodrucje.class);
		
		List lista = query.list();
		
		return lista;
	}

	@Override
	public void obrisiUpis(int udruzenjeId, int podrucjeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete PripadnostUdruzenja where udruzenjeId = :udruzenjeid and kulturnopodrucjeId =:podrucjeid");
		
		query.setParameter("udruzenjeid", udruzenjeId);
		query.setParameter("podrucjeid", podrucjeId);
		
		query.executeUpdate();
	}

	@Override
	public List<PripadnostUdruzenja> vratiPripadnostiPoUdruzenju(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from PripadnostUdruzenja where udruzenjeId = :udruzenjeid");
		
		query.setParameter("udruzenjeid", id);
		
		return query.getResultList();
	}
}
