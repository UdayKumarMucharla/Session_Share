package com.kgfsl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public UserDao(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	// Create
	public void create(UserModel user) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			session = sessionFactory.openSession();
		}
		
		session.getTransaction().begin();
		session.persist(user);
		session.getTransaction().commit();
		session.close();

	}
	
	
	// Update
	
		public void updateUser(UserModel user) {
			Session session = null;
			try {
				session = sessionFactory.getCurrentSession();
			} catch (org.hibernate.HibernateException he) {
				session = sessionFactory.openSession();
			}
			session.beginTransaction();
			session.createQuery("Update UserModel u set u.Name = :Name,u.Email = :Email , u.Password = :Password , u.phone = :phone ,u.Street = :Street , u.Suite = :Suite, u.City = :City,u.Zipcode = :Zipcode WHERE u.Id = :Id")
			.setParameter("Name", user.getName())
			.setParameter("Email",user.getEmail())
			.setParameter("Password",user.getPassword())
			.setParameter("phone", user.getPhone())
			.setParameter("Street", user.getStreet())
			.setParameter("Suite", user.getSuite())
			.setParameter("City", user.getCity())
			.setParameter("Zipcode",user.getZipcode())
			.setParameter("Id",user.getId()).executeUpdate();
			session.getTransaction().commit();
			session.close();

		}
	
	
	
	

	// Fetch All
	@SuppressWarnings("unchecked")
	public List fetchAll() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			session = sessionFactory.openSession();
		}
		session.beginTransaction();
		List<UserModel> list = session.createQuery("from UserModel").list();
		session.close();
		return list;
	}

	// Fetch By ID
	@SuppressWarnings("unchecked")
	public UserModel fetchById(int id) {

		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			session = sessionFactory.openSession();
		}
		session.beginTransaction();
		UserModel user = (UserModel) session.createQuery("FROM UserModel user WHERE user.Id =:id").setParameter("id", id)
				.uniqueResult();
		session.close();
		return user;
	}

	// Fetch By Email
	
	public UserModel fetchByEmail(String Email) {

		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			session = sessionFactory.openSession();
		}
		session.beginTransaction();

		UserModel user = (UserModel) session.createQuery("FROM UserModel user WHERE user.Email = :Email")
				.setParameter("Email", Email).uniqueResult();
		session.close();
		return user;
	}
	public void delete(Integer id) {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
		}catch(org.hibernate.HibernateException he){
			session = sessionFactory.openSession();
		}session.beginTransaction();
		session.createQuery("DELETE FROM UserModel user WHERE user.Id = :id").setParameter("id",id).executeUpdate();
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("deprecation")
	public void updateTable(String column, String dataType) {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
		}catch(org.hibernate.HibernateException he){
			session = sessionFactory.openSession();
		}session.beginTransaction();
		
		
    //    String sql = "Alter table user Add :column :dataType";
   
        
        session.createQuery("Alter table user Add "+" "+column+" "+dataType)
	//	 .setParameter("dataType",dataType)
	//	.setParameter("column", column)
		.executeUpdate();
		session.getTransaction().commit();
	}
}
