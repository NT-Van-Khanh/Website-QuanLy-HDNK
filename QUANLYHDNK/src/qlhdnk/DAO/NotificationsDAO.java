package qlhdnk.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import qlhdnk.entity.NotificationsEntity;

@Transactional
@Repository
public class NotificationsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<NotificationsEntity> getTB(String idAccount){
		Session session = sessionFactory.getCurrentSession();	    
		String hql = "SELECT n FROM NotificationsEntity n " +
                "JOIN n.activityNotifi a " +
                "JOIN a.registers r " +
                "WHERE r.registrant.userId = :id";
	   Query query = session.createQuery(hql);
	   query.setParameter("id", idAccount);
	   List<NotificationsEntity> notifications = query.list();
	   return notifications;	
	   }
}
