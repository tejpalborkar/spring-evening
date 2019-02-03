package com.tejpal.hibernatemapping.basiccrud;

import org.hibernate.Session;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class TestProduct {
	public static void main(String[] args) {
		/*ProductDao productDao = new ProductDao();

		Product product = new Product();
		product.setProductName("Laptop");
		product.setPrice((double) 45000);
		product.setBrand("HP");

		// productDao.save(product);

		System.out.println("Getting all products from db");
		List<Product> allProducts = productDao.getAllProducts();
		
		for (Product productFromDb : allProducts) {
			System.out.println(productFromDb);
		}
		
		System.out.println("==============================================");
		
		System.out.println("Getting product by product id");
		
		Product productById =productDao.getProductByProductID(2);
		
		System.out.println("product by id: "+ productById);
		
		System.out.println("===============================================");
		
		System.out.println("Delete product by productId");
		
		int productId= 2;
//		productDao.deleteProductById(productId);
		
		System.out.println("================================================");
		
		System.out.println("Product update test");
		
		Product productTobeUpdated = new Product();
		
		productTobeUpdated.setProductId(1);
		productTobeUpdated.setBrand("Dell");
		productTobeUpdated.setPrice((double) 30000);
		
		productDao.updateProduct(productTobeUpdated);
*/	
		
		EmployeeAssimilate employee= new EmployeeAssimilate();
	employee.setEmployeeName("Tejpal Borkar");
	employee.setMobile("789845652");
	
	
	
	Session session = HibernateUtil.getSession();
	
	System.out.println("Storing employee in database");
	
	session.save(employee);
	session.beginTransaction().commit();
	
	}
}
