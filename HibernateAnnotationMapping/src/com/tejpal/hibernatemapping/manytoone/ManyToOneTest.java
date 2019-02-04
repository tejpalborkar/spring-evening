package com.tejpal.hibernatemapping.manytoone;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class ManyToOneTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			// By using cascade=all option the address need not be saved
			// explicitly when the student object is persisted the address will
			// be automatically saved.
			session.save(address);
			
			
			Student student1 = new Student("Eswar", address);
			Student student2 = new Student("Joe", address);

			Set<Student> students = new HashSet<Student>();
			students.add(student1);
			students.add(student2);

			address.setStudents(students);
			//If we save address object first then it will be one to many
			//session.save(address);
			 session.save(student1);
			 session.save(student2);
			transaction.commit();

			// Fetch student
			System.out.println("Student Record with address fetched by many to one");
			Student student = (Student) session.get(Student.class, student1.getStudentId());
			System.out.println(student.getStudentName() + "Address: " + student.getStudentAddress().getCity());

			System.out.println("Address Record with student fetched by many to one");
			Address addressFetched = (Address) session.get(Address.class, address.getAddressId());
			System.out.println(addressFetched.getCity() + " Total Students " + addressFetched.getStudents().size());

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
