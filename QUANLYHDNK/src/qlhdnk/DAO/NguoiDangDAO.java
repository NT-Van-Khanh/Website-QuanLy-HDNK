package qlhdnk.DAO;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RegistersEntity;

@Transactional
@Repository
public class NguoiDangDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public void updateActivity(ActivitiesEntity activity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(activity);
    }

    public ActivitiesEntity getActivityById(int activityId) {
        Session session = sessionFactory.getCurrentSession();
        ActivitiesEntity activity = (ActivitiesEntity) session.get(ActivitiesEntity.class, activityId);
        return activity;
    }
    @SuppressWarnings("unchecked")
    public List<ActivitiesEntity> getActivitiesByPoster(String nguoiDangId) {
        Session session = sessionFactory.getCurrentSession();
        Date now = new Date();
        List<ActivitiesEntity> list = session.createQuery("from ActivitiesEntity where posterActi.userId = :nguoiDangId and :now between startTime and endTime")
                .setParameter("nguoiDangId", nguoiDangId).setParameter("now", now).list();
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<ActivitiesEntity> getTakenActivitiesByPoster(String nguoiDangId) {
        Session session = sessionFactory.getCurrentSession();
        Date now = new Date();
       /* List<ActivitiesEntity> list = session.createQuery("from ActivitiesEntity where posterActi.userId = :nguoiDangId").setParameter("nguoiDangId", nguoiDangId).list();*/

		 List<ActivitiesEntity> list = session.
		 createQuery("from ActivitiesEntity where posterActi.userId = :nguoiDangId and (startTime >= :now or endTime <= :now)").setParameter("nguoiDangId", nguoiDangId).setParameter("now", now).list();
		 
        return list;
    }
	/*
	 * public List<RegistersEntity> getRegistrantsByActivityId(int activityId) {
	 * Session session = sessionFactory.getCurrentSession();
	 * 
	 * @SuppressWarnings("unchecked") List<RegistersEntity> list = session.
	 * createQuery("from RegistersEntity r where r.activityRegis.idActivity = :activityId"
	 * ) .setParameter("activityId", activityId).list(); return list; }
	 */
    
}
