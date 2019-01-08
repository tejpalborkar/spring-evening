package com.tejpal.hibernatemapping.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.tejpal.hibernatemapping.manytoone.Student;
import com.tejpal.hibernatemapping.util.HibernateUtil;

public class ManyToManyTest {
	// https://dzone.com/tutorials/java/hibernate/hibernate-example/hibernate-mapping-many-to-many-using-annotations-1.html
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Course course1 = new Course("Maths");
		Course course2 = new Course("English");
		Course course3 = new Course("Sciense");

		Student student1 = new Student("Eswar");
		Set<Course> courses = new HashSet<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

	//	student1.setCourses(courses);
		Student student2 = new Student("Ram");
		// student2.setCourses(courses);

		// session.save(student1);
		// session.save(student2);
		// session.beginTransaction().commit();
		System.out.println("Record inserted successfully");

		// Retriving student and its courses
		Student studentFetched = (Student) session.get(Student.class, student2.getStudentId());
		// System.out.println(studentFetched + " Courses : " +
		// studentFetched.getCourses().size());

		Course c1 = new Course("History");
//		Course c2 = new Course("Geo");

		Set<Student> students = new HashSet<>();
		students.add(student1);
		students.add(student2);

		c1.setStudents(students);
		session.save(c1);
		session.beginTransaction().commit();
		// Fetch Course with students. from courses find students
		Course course = (Course) session.get(Course.class, c1.getCourseId());
		System.out.println(course + " Student Count" + course.getStudents().size());
		session.close();
		session  =HibernateUtil.getSession();
		
		//Fetch bidirectional results. from student find its courses.
		Student stu = (Student) session.get(Student.class, student1.getStudentId());
		System.out.println(stu + " Courses: " + stu.getCourses().iterator().next());
	}
}
