package com.tejpal.hibernatemapping.basiccrud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class ProductDao {

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

	public List<Product> getAllProducts() {
		Session session = HibernateUtil.getSession();
		List<Product> products = session.createCriteria(Product.class).list();
		return products;
	}

	public Product getProductByProductID(int productId) {

		Session session = HibernateUtil.getSession();

		return (Product) session.get(Product.class, productId);

	}

	public void deleteProductById(int productId) {

		Session session = HibernateUtil.getSession();

		Product product = getProductByProductID(productId);

		session.delete(product);

		session.beginTransaction().commit();

		System.out.println("Product deleted successfully with id:" + productId);

	}

	public void updateProduct(Product productTobeUpdated) {
		Session session = HibernateUtil.getSession();

		Product product = getProductByProductID(productTobeUpdated.getProductId());

		product.setBrand(productTobeUpdated.getBrand());
		product.setPrice(productTobeUpdated.getPrice());

		session.update(product);
		session.beginTransaction().commit();

	}

}
