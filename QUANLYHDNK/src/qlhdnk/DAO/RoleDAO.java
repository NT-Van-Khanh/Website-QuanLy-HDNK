package qlhdnk.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhdnk.entity.RolesEntity;
@Transactional
@Repository
public class RoleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<RolesEntity> getRoleList(){
		Session session = sessionFactory.getCurrentSession();
		String hql="FROM RolesEntity";
		List<RolesEntity> roles =  new ArrayList<>();
		roles = session.createQuery(hql).list();
		return roles;
	}
	public RolesEntity getRole(String idRole){
		Session session = sessionFactory.getCurrentSession();;
		return (RolesEntity) session.get(RolesEntity.class,idRole);
	}
}
