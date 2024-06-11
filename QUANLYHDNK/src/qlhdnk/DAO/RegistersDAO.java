package qlhdnk.DAO;

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
	private String idAccount="N21DCCN000";
	
	@SuppressWarnings("unchecked")
	public List<RegistersEntity> getListRegisters(){
		Session session = sessionFactory.getCurrentSession();
		String hql="FROM RegistersEntity where flagDK = 0 and registrant=:id ORDER BY idRegister ASC";
		Query query = session.createQuery(hql);
		query.setString("id", idAccount);
		List<RegistersEntity> list = query.list();
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
	
    @SuppressWarnings("unchecked")
    public List<RegistersEntity> getListByActivity(int activityId){
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "FROM RegistersEntity WHERE activityRegis.idActivity = :activityId";
    	Query query = session.createQuery(hql);
    	query.setInteger("activityId", activityId);
    	List<RegistersEntity> list = query.list();
    	return list;
    }    
    public RegistersEntity getRegister(int idActivity, String idAccount) {
    	Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RegistersEntity WHERE registrant = :idAccount AND activityRegis = :idActivity AND flagDK = false";
        Query query = session.createQuery(hql);
        query.setParameter("idAccount", idAccount);
        query.setParameter("idActivity", idActivity);
        return (RegistersEntity) query.uniqueResult();
    }
    
    public boolean checkRegister(ActivitiesEntity activity, AccountsEntity account){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RegistersEntity WHERE registrant = :account AND activityRegis = :activity AND flagDK = 1";
        Query query = session.createQuery(hql);
        query.setParameter("account", account);
        query.setParameter("activity", activity);
        return query.uniqueResult() != null;
    }

    public void updateRegister(RegistersEntity register){
        Session session = sessionFactory.getCurrentSession();
//        session.evict(register);
//        register.setFlagDK(false);
//        register.setTimeRegister(new Date());
        session.update(session);
    }

    public void insertRegister(RegistersEntity register){
        Session session = sessionFactory.getCurrentSession();
//        RegistersEntity registerEntity = new RegistersEntity();
//        registerEntity.setActivityRegis(activity);
//        registerEntity.setRegistrant(account);
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
