/**
 * 
 */
package com.tejpal.hibernatemapping.onetoone.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 * 
 * @author Tejpal Borkar
 *
 */
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	@NotNull(message="Employee id can not be null")
	@NotEmpty(message="Employee id can not be empty")
	private Integer employeeId;
	
	@Column(name="first_name",nullable=false)
	@NotNull(message="First name cannot be null")
	@NotEmpty(message="First name cannot be blank")
	private String firstName;
	
	@Column(name="lastName",nullable=true)
	@NotNull(message="Last name cannot be null")
	@NotEmpty(message="last name cannot be blank")
	private String lastName;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellPhone;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="employee")
	@JoinColumn(name="employee_id")
	private EmployeeDetail employeeDetail;
	/*
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}*/
	public Employee(){
		
	}
	public Employee( String firstName, String lastName,
			Date birthDate, String cellPhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cellPhone = cellPhone;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", cellPhone=" + cellPhone + ", employeeDetail="
				 + "]";
	}
	
}
