/*package com.kgfsl.session;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

@Repository
@Transactional
public class Session_ShareDaoImpl implements Session_Share_Dao{

	
	
	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	@Bean
	public SessionFactory setSessionFactory(SessionFactory sessionFactory) {
		return this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String create(Session_share_Model ss) {
		  Session session = this.sessionFactory.openSession();
		  session.beginTransaction();
		session.persist(ss);
		session.close();
		return RequestContextHolder.currentRequestAttributes().getSessionId();
	}

	@Override
	public List fetchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Session_share_Model> list= (List<Session_share_Model>) session.createQuery("from Session_share_Model");
		session.close();
		return list;
	}



	
	public String session() {
		this.sessionFactory.getCurrentSession().beginTransaction();
		String id = RequestContextHolder.currentRequestAttributes().getSessionId();
		return "Hello";
	}
	

}
*/