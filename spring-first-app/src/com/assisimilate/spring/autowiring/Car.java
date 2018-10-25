package com.assisimilate.spring.autowiring;

public class Car {
	
	private String model;
	
	private Integer year;
	
	private Engine engine;
	
	
	/*public Car() {
		
	}*/
	
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}
	public Car(String model, Integer year,Engine engine) {
		super();
		this.model = model;
		this.year = year;
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
		return "Car engine=" + engine + "]";
	}

	
	
	
}
