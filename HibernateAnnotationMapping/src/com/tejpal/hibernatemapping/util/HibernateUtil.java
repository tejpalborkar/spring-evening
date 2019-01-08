package com.tejpal.hibernatemapping.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Tejpal Borkar
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}
