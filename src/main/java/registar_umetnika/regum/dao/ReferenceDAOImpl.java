package registar_umetnika.regum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import registar_umetnika.regum.dao.interfaces.ReferenceDAO;
import registar_umetnika.regum.entity.Referenca;
import registar_umetnika.regum.entity.Uplata;

@Repository
public class ReferenceDAOImpl implements ReferenceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Referenca> vratiReference(int umetnikId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Referenca where umetnikId = :id", Referenca.class);
		theQuery.setParameter("id", umetnikId);
		return theQuery.getResultList();
	}

	@Override
	public void sacuvajReferencu(Referenca novaReferenca) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(novaReferenca);
	}

}
