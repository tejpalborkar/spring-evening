package com.tejpal.hibernatemapping.onetoone.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class TestOneToOne {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		/*
		 * Employee emp = new Employee("Mamata", "DFSFG", new Date(0), ""); //
		 * session.save(emp);
		 * 
		 * 
		 * 
		 * System.out.println(emp.getEmployeeId()); EmployeeDetail empDetail = new
		 * EmployeeDetail("Lane2", "Pune", "Maharashtra", "India");
		 * emp.setEmployeeDetail(empDetail);
		 * 
		 * empDetail.setEmployee(emp);
		 * 
		 * session.saveOrUpdate(emp); session.beginTransaction().commit();
		 * session.close();
		 */

		session = HibernateUtil.getSession();

		Employee employee = (Employee) session.get(Employee.class.getCanonicalName(), 1);

		System.out.println("Employee: " + employee);

		System.out.println("EmployeeDetail: " + employee.getEmployeeDetail());
		EmployeeDetail empDetails = employee.getEmployeeDetail();

		empDetails.setCity("Nashik");
		System.out.println("Updating employee address");

		session.update(employee);

		session.beginTransaction().commit();
		/*
		 * session.delete(employee);
		 * 
		 * session.beginTransaction().commit();
		 * System.out.println(employee.getFirstName() + " : " +
		 * employee.getEmployeeDetail().getCity()); session.close();
		 */

		/*
		 * session = HibernateUtil.getSession(); EmployeeDetail eDetail =
		 * (EmployeeDetail) session.get(EmployeeDetail.class, employee.getEmployeeId());
		 * System.out.println(eDetail.getCity() + " : " +
		 * eDetail.getEmployee().getFirstName());
		 * System.out.println("Hibernate One-To-One example (Annotation)");
		 * 
		 * session = HibernateUtil.getSession();
		 * 
		 * EmployeeDetail employeeDetail = new EmployeeDetail(null, "10th Street", "LA",
		 * "San Francisco", "U.S.");
		 * 
		 * Employee employee2 = new Employee("Nina", "Mayers", new Date(121212),
		 * "114-857-965"); employee.setEmployeeDetail(employeeDetail);
		 * employeeDetail.setEmployee(employee2); session.save(employeeDetail);
		 * session.beginTransaction().commit();
		 * System.out.println("==========Querying all results======"); List<Employee>
		 * employees = session.createQuery("from Employee").list(); for (Employee
		 * employee1 : employees) { System.out.println(employee1.getFirstName() + " , "
		 * + employee1.getLastName() + ", " + employee1.getEmployeeDetail().getState());
		 * }
		 * 
		 * session.getTransaction().commit(); session.close();
		 */ }

}
