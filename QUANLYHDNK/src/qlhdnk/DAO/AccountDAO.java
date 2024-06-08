package qlhdnk.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.entity.AccountsEntity;

@Transactional
@Repository
public class AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AccountsEntity getAccount(String id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity WHERE userId = :id";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		AccountsEntity account = (AccountsEntity) query.uniqueResult();
		/* session.close(); */
		return account;
	}
}
