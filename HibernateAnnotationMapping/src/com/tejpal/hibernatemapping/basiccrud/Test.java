package com.tejpal.hibernatemapping.basiccrud;

public class Test {

	public static void main(String[] args) {
		ProductClient productClient = new ProductClient();

		/*Product product = new Product();

		product.setProductName("Laptop");
		product.setBrand("HP");
		product.setPrice(45000.0);
		
		System.out.println("Product before saving: "+product);

		product = productClient.save(product);
		
		System.out.println("Product after saved: "+product);
*/		
		
		Product productById=	productClient.getProductById(2);
		System.out.println("Product by id: "+productById);
		/*
		productById.setBrand("Lenovo");
		
		productClient.update(productById);
		
		
		Product p =productClient.getProductById(2);
		System.out.println("Product after update: "+p);
		*/
		productClient.delete(2);
		
		 productById=	productClient.getProductById(2);
		System.out.println("Product by id: "+productById);
	}
}
