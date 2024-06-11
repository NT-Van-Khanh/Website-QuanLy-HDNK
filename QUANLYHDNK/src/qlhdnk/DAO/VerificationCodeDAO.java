package qlhdnk.DAO;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import qlhdnk.entity.VerificationsEntity;
import qlhdnk.util.DateTimeUtil;

@Repository
@Transactional
public class VerificationCodeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void createVerifyCode(String email, String code) {
		Session session = sessionFactory.getCurrentSession();
		VerificationsEntity verificationCode = new VerificationsEntity(email,code,DateTimeUtil.convertToDate(LocalDateTime.now()));
		session.save(verificationCode);
	}

	public int confirmVerifyCode(String email, String code) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM VerificationsEntity WHERE email = :e AND vertificationCode= :c";
		Query query = session.createQuery(hql);
		query.setString("e",email);
		query.setString("c", code);
		VerificationsEntity verificationCode = (VerificationsEntity) query.uniqueResult();
		if(verificationCode==null){
			return 1; //error 1: sai ma 
		}else {
			System.out.println(DateTimeUtil.convertToLocalDateTime(verificationCode.getExpiryTime()).plusMinutes(5).toString());
			System.out.println(LocalDateTime.now());
			if(DateTimeUtil.convertToLocalDateTime(verificationCode.getExpiryTime()).plusMinutes(5).isAfter(LocalDateTime.now())) {
				return 0; //0 co error
			}
			return 2;//error 2: ma het han su dung
		}
	}

	public VerificationsEntity checkAvailableEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		return (VerificationsEntity) session.get(VerificationsEntity.class,email);
	}
	
	public void updateVerifyCode(VerificationsEntity verificationCode,String code) {
		Session session = sessionFactory.getCurrentSession();
		session.evict(verificationCode);
		verificationCode.setVertificationCode(code);
		verificationCode.setExpiryTime(DateTimeUtil.convertToDate(LocalDateTime.now()));
		session.update(verificationCode);
	}
}
