package com.tejpal.hibernatemapping.basiccrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class ProductClient {

	public Product save(Product product) {
		/*
		 * StandardServiceRegistry ssr = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 */

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		return product;
	}

	public Product getProductById(int id) {
		System.out.println("Fetching product by id: " + id);
		// SessionFactory sessionFactory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);

		return product;
	}

	public void update(Product product) {

		System.out.println("Updating product: " + product.getProductName());
		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();

	}

	public void delete(Integer id) {
		System.out.println("Deleting product : " + id);
		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Product product = getProductById(id);

		if (product == null) {
			System.out.println("Product not found");
			return;
		} else {
			session.delete(product);
			transaction.commit();
			System.out.println("Deleted successfully");
		}
	}

}
