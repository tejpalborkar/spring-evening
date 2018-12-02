package com.tejpal.hibernatemapping.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "employee_detail")
public class EmployeeDetail {

	@Id
	@Column(name = "employee_id")
	@NotNull(message = "Employee id cannot be null")
	@ForeignKey(name="FK_EMP_ID")
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee") )
	@GeneratedValue(generator = "generator")
	private Integer employeeId;

	@Column(name = "street")
	@NotNull(message = "Street name cannot be null")
	private String street;

	@Column(name = "city")
	@NotNull(message = "city cannot be null")
	private String city;

	@Column(name = "state")
	@NotNull(message = "State cannot be null")
	private String state;

	@Column(name = "country")
	@NotNull(message = "Country cannot be null")
	private String country;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	@PrimaryKeyJoinColumn
	private Employee employee;

	public EmployeeDetail() {

	}

	public EmployeeDetail(Integer employeeId, String street, String city, String state, String country) {
		super();
		this.employeeId = employeeId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public EmployeeDetail(String street, String city, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeDetail [employeeId=" + employeeId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", employee=" + employee + "]";
	}

}
