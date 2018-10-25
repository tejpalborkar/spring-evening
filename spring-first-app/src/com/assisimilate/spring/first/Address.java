package com.assisimilate.spring.first;

public class Address {

	private String city;
	private String state;
	
	
	private Address() {
		System.out.println("Executing constructor....");
	}


	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
		System.out.println("Executing Address constructor....");
	}


	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	
	
	
	
}
