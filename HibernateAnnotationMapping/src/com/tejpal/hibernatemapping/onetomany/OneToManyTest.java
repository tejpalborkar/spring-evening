package com.tejpal.hibernatemapping.onetomany;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.tejpal.hibernatemapping.onetoone.model.Employee;
import com.tejpal.hibernatemapping.util.HibernateUtil;

public class OneToManyTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Department dept = new Department("List");
		Employee e1 = new Employee("Raghu1", "Borkar", new Date(1990, 05, 10), "9096865304");
		Employee e2 = new Employee("Raghu2", "Borkar", new Date(1990, 05, 10), "9096865304");
		Employee e3 = new Employee("Raghu3", "Borkar", new Date(1990, 05, 10), "9096865304");
		Employee e4 = new Employee("Raghu4", "Borkar", new Date(1990, 05, 10), "9096865304");
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		dept.setEmployees(list);
		session.save(dept);
		session.beginTransaction().commit();
		System.out.println("Record inserted successfully");
		System.out.println("Department fetched with employees");
		Department d = (Department) session.get(Department.class, dept.getDepartmentId());
		System.out.println(d);
	}
}
