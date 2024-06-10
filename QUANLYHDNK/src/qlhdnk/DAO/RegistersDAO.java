package qlhdnk.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.entity.RegistersEntity;
@Transactional
@Repository
public class RegistersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private String idAccount="N21DCCN000";
	public List<RegistersEntity> getListRegisters(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<RegistersEntity> list = session.createQuery("FROM RegistersEntity where flagDK = 0 ORDER BY idRegister ASC").list();
		return list;
	}
    @SuppressWarnings("unchecked")
	public List<RegistersEntity> getListDaTG() {
	    Session session = sessionFactory.getCurrentSession();
	    String hql="SELECT re FROM RegistersEntity re "
	            + "JOIN FETCH re.activityRegis a "
	            + "JOIN FETCH a.posterActi account "
	            + "JOIN FETCH a.title t "
	            + "WHERE re.flagDK = 0 "
	            + "AND re.registrant = :id "
	            + "AND a.endTime >= current_date() "
	            + "AND account.flagTK = 0";
	    
	    Query query = session.createQuery(hql);
		query.setString("id", idAccount);
		List<RegistersEntity> list = query.list();
	    return list;
	}
	
	public void saveRegistration(RegistersEntity register) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(register);
	}
}
