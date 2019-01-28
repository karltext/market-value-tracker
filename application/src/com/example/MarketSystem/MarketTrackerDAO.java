package com.example.MarketSystem;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.MarketSystem.Role;

public class MarketTrackerDAO implements DataAccessObject<Role>{
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Role add(Role newRole) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(newRole); //insert
		session.getTransaction().commit();
		session.close();
		return newRole;
	}

	@Override
	public List<Role> find(int key) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Role rol = session.get(Role.class, key);
		session.getTransaction().commit();
		session.close();
		
		List<Role> list = new ArrayList<>();
		list.add(rol);
		return list;
	}
	
	

}
