package com.assisimilate.spring.autowiring;

import com.assisimilate.spring.first.Address;

public class Car {

	private String model;

	private Integer year;

	private Engine engine;
	
	private Address address;

	public Car() {

	}

	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	public Car(String model, Integer year, Engine engine) {
		super();
		this.model = model;
		this.year = year;
		this.engine = engine;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}


	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", engine=" + engine + ", address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
