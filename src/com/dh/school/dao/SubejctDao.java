package com.dh.school.dao;

import java.util.List;

import com.dh.school.dto.StudentSubject;
import com.dh.school.pojo.Student;

public interface SubejctDao {
	
	/**
	 * This method is used to add the subject to the database
	 * @param rollNo int roll number
	 * @param subject String Subject
	 */
	public void addSubject(int rollNo ,String subject);
	
	
	/**
	 * This method is used to get the student subjects
	 * @param student Student Object 
	 */
	public void getStudentSubject(Student student);
	
	
	/**
	 * This method is used to get the subject from details from the user
	 * @return List of subject
	 */
	public List<String> getSubjectFromUser();

}
