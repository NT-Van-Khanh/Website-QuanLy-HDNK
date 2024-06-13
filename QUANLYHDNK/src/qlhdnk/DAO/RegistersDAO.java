package qlhdnk.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RegistersEntity;
@Transactional
@Repository
public class RegistersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<RegistersEntity> getListRegisters(String idAccount){
		Session session = sessionFactory.getCurrentSession();
		String hql="FROM RegistersEntity where flagDK = 0 and registrant=:id ORDER BY idRegister ASC";
		Query query = session.createQuery(hql);
		query.setString("id", idAccount);
		List<RegistersEntity> list = query.list();
		return list;
	}
    @SuppressWarnings("unchecked")
	public List<RegistersEntity> getListDaTG(String idAccount) {
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
	
    public long getListByActivity(int activityId){
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "SELECT COUNT(*) FROM RegistersEntity WHERE activityRegis.idActivity = :activityId AND FlagDK =false ";
    	Query query = session.createQuery(hql);
    	query.setInteger("activityId", activityId);
    	long count = (long) query.uniqueResult();
    	return count;
    }    
    
    public RegistersEntity getRegister(ActivitiesEntity activity, AccountsEntity account) {
    	Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RegistersEntity WHERE registrant = :idAccount AND activityRegis = :idActivity AND flagDK = true";
        Query query = session.createQuery(hql);
        query.setParameter("idAccount", account);
        query.setParameter("idActivity", activity);
        return (RegistersEntity) query.uniqueResult();
    }
    
    public boolean checkRegister(ActivitiesEntity activity, AccountsEntity account){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RegistersEntity WHERE registrant = :account AND activityRegis = :activity AND flagDK = true";
        Query query = session.createQuery(hql);
        query.setParameter("account", account);
        query.setParameter("activity", activity);
        return query.uniqueResult() != null;
    }

    public void updateRegister(RegistersEntity register){
        Session session = sessionFactory.getCurrentSession();
        session.evict(register);
        register.setFlagDK(false);
        register.setTimeRegister(new Date());
        session.update(register);
    }

    public void insertRegister(ActivitiesEntity activity, AccountsEntity account){
        Session session = sessionFactory.getCurrentSession();
        RegistersEntity register = new RegistersEntity();
        register.setActivityRegis(activity);
        register.setRegistrant(account);
        register.setFlagDK(false);
        register.setTimeRegister(new Date());
        session.save(register);
    }
    
	public void cancelRegister(ActivitiesEntity activity, AccountsEntity account){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RegistersEntity WHERE registrant = :account AND activityRegis = :activity AND flagDK = 0";
        Query query = session.createQuery(hql);
        query.setParameter("account", account);
        query.setParameter("activity", activity);
        RegistersEntity register = (RegistersEntity) query.uniqueResult();
        if (register != null) {
            register.setFlagDK(true);
            session.update(register);
        }
    }
	
}

