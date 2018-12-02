package com.tejpal.hibernatemapping.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tejpal.hibernatemapping.onetoone.model.Employee;

@Entity
@Table(name = "dept")
public class Department {

	public Department() {
	}

	public Department(String name) {
		this.departmentName = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dept_id")
	private int departmentId;
	@Column(name = "dept_name")
	private String departmentName;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "dept_id")
	// @IndexColumn(name="idx")
	private List<Employee> employees;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}
	
	
}
