package qlhdnk.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.entity.ActivitiesEntity;

@Transactional
@Repository
public class ActivitiesDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ActivitiesEntity> getListActivities(String idAccount){
		Session session = sessionFactory.getCurrentSession();
		System.out.println(idAccount);
		@SuppressWarnings("unchecked")
		List<ActivitiesEntity> list = session.createQuery("from ActivitiesEntity a \r\n"
				+ "	   where a.flagHD = 0\r\n"
				+ "    and a.startTime <= current_date()\r\n"
				+ "    and a.endTime >= current_date()\r\n"
				+ "    and a.idActivity not in (\r\n"
				+ "    select re.activityRegis from RegistersEntity re\r\n"
				+ "        where re.registrant.userId  = :id \r\n"
				+ "        and re.flagDK = 0\r\n"
				+ "    )\r\n"
				+ "ORDER BY nameActivity ASC").setParameter("id", idAccount).list();
		return list;
	}
	
	public ActivitiesEntity getActivitiesId(int id) {
		Session session = sessionFactory.getCurrentSession();
		ActivitiesEntity activitiesId = (ActivitiesEntity) session.createQuery("FROM ActivitiesEntity WHERE idActivity=" + id).uniqueResult();
		return activitiesId;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActivitiesEntity> getActivitiesManage(){
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM ActivitiesEntity";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ActivitiesEntity> sortListActivity(String sortBy){
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM ActivitiesEntity ";
		if(sortBy!=null) {
			switch(sortBy) {
			case "id":
				hql=hql+"ORDER BY idActivity ";
				break;
			case "name":
				hql=hql+"ORDER BY nameActivity ";
				break;
			case "create-date":
				hql=hql+"ORDER BY postTime ";
				break;
			case "start-date":
				hql=hql+"ORDER BY startTime ";
				break;
			case "end-date":
				hql=hql+"ORDER BY endTime ";
				break;
			default:
				break;
			}
		}
		return session.createQuery(hql).list();
	}
	
    public void insertActivity(ActivitiesEntity activity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(activity);
    }

//	public List<Product> listProducts() {
//	Session session = sessionFactory.getCurrentSession();
//	@SuppressWarnings("unchecked")
//	List<Product> list = session.createQuery("FROM Product ORDER BY productId DESC").list();
//	return list;
//}
}
