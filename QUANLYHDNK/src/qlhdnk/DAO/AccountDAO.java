package qlhdnk.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.util.SHA256Encryption;

@Transactional
@Repository
public class AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public AccountsEntity login(String id,String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity WHERE userId = :id AND password =:pw";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		query.setString("pw", SHA256Encryption.toSHA256(password));
		AccountsEntity account = (AccountsEntity) query.uniqueResult();
		return account;
	}
	public AccountsEntity getAccount(String id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity WHERE userId = :id";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		AccountsEntity account = (AccountsEntity) query.uniqueResult();
		return account;
	}
	
	@SuppressWarnings("unchecked")
	public List<AccountsEntity> getListAccount(){
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity";
		List<AccountsEntity> accounts = new ArrayList<>();
		accounts= session.createQuery(hql).list();
		return accounts;
	}
	
	public boolean updateAvatar(String id, byte[] byteImage) {
		Session session =sessionFactory.getCurrentSession();
		String hql="UPDATE AccountsEntity SET avatar= :image byteImage WHERE userId= :id";
		Query query= session.createQuery(hql);
		query.setString("id", id);
		query.setParameter("image", byteImage);
		return query.executeUpdate()>0;
	}
	
	public boolean chekUserEmail(String id, String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity WHERE userId = :id AND email =:e";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		query.setString("e",email);
		if((AccountsEntity)query.uniqueResult()!=null) return true;
		else return false;
	}
}
