package com.assimilate.springboot.web.models;

public class Employee {

	private Integer id;
	private String firstName;
	private String lastName;
	private int yearlyIncome;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Integer id) {
		super();
		this.firstName = name;
		this.id = id;
	}

	public Employee(Integer id, String firstName, String lastName, int yearlyIncome) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlyIncome = yearlyIncome;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearlyIncome() {
		return yearlyIncome;
	}

	public void setYearlyIncome(int yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearlyIncome="
				+ yearlyIncome + "]";
	}

}
