package com.tejpal.hibernatemapping.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tejpal.hibernatemapping.manytoone.Student;

@Entity
@Table(name = "COURSE")
public class Course {

	private long courseId;
	private String courseName;

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name = "COURSE_NAME", nullable = false)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	private Set<Student> students;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "COURSE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STUDENT_ID") })
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

}
