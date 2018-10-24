package com.assimilate;

public class Student {
	private String name;
	
	private String mobileNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void displayInfo() {
		System.out.println("Hello: " + name);
		
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
