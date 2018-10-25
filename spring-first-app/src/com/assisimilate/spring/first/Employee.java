package com.assisimilate.spring.first;

public class Employee {

	private Integer id;
	private String firstName;
	
	private Address empAddress;
	
	
	private Employee() {
		System.out.println("Executing Employee constructor....");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + "]";
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	
	
	
	
}
