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
	
	@SuppressWarnings("unchecked")
	public List<AccountsEntity> fillListAccount(String sortBy,String fillBy){
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity ";
		if(fillBy!=null &&!fillBy.equals("ALL")) {
			hql=hql+"WHERE role.id = :fill ";
		}
		if(sortBy!=null) {
			switch(sortBy) {
			case "id":
				hql=hql+"ORDER BY userId ";
				break;
			case "name":
				hql=hql+"ORDER BY userName ";
				break;
			case "create-date":
				hql=hql+"ORDER BY createDate ";
				break;
			default:
				break;
			}
		}
		List<AccountsEntity> accounts = new ArrayList<>();
		Query query = session.createQuery(hql);
		if(fillBy!=null &&!fillBy.equals("ALL")) {
			query.setString("fill", fillBy);
		}
		accounts= query.list();
		return accounts;
	}
	
	public boolean updateAvatar(String id, byte[] byteImage) {
		Session session =sessionFactory.getCurrentSession();
		String hql="UPDATE AccountsEntity SET avatar= :byteImage WHERE userId= :id";
		Query query= session.createQuery(hql);
		query.setString("id", id);
		query.setParameter("image", byteImage);
		return query.executeUpdate()>0;
	}
	
	public boolean chekUserEmail(String id, String email){
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM AccountsEntity WHERE userId = :id AND email =:e";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		query.setString("e",email);
		if((AccountsEntity)query.uniqueResult()!=null) return true;
		else return false;
	}
	
	public boolean changePassword(String userName, String newPassword) {
		Session session =sessionFactory.getCurrentSession();
		String hql="UPDATE AccountsEntity SET password= :pw WHERE userId= :id";
		Query query= session.createQuery(hql);
		query.setString("id", userName);
		query.setParameter("pw", newPassword);
		return query.executeUpdate()>0;
	}
	public void insertAccount(AccountsEntity account){
		Session session =sessionFactory.getCurrentSession();
		session.save(account);
	}
}
