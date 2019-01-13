package com.assimilate.emp.app.model;

public class Employee {

	private Integer id;
	private String name;
	private Integer salary;

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int salary) {
		// 

		this.id =id;
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}
