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

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		System.out.println("Building session factory....");
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("session factory initializeds....");
		return sessionFactory;
	}

	public static Session getSession() {
		System.out.println("Getting session from sessionFactory");
		return sessionFactory.openSession();
	}

}
