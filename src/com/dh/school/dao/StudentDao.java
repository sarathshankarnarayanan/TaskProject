package com.dh.school.dao;

import java.util.List;

import com.dh.school.pojo.Student;

public interface StudentDao {
	/**
	 * This method is used to add the student to the database
	 * @param student Student object
	 */
	public void addNewStudent(Student student);
	
	
	/**
	 * This method is used to get the student info just by passing the Roll Number of the student
	 * @param rollNo int Roll number of the student
	 */
	public void serachStudentByRollNo(int rollNo);
	
	
	/**
	 * This method is used to get all the student details present in the database.
	 * @return Returns list of all the student.
	 */
	public List<Student> getAllStudent();
	
	
	/**
	 * This method is used to get all the details of the student with its subject.
	 */
	public void getStudentDetailWithMarks();
}
