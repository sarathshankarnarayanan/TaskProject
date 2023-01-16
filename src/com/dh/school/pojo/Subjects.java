package com.dh.school.pojo;

import java.util.List;

public class Subjects {

	private int studentRollNo;
	private List<String> subjects;
	
	
	public int getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Subjects [studentRollNo=" + studentRollNo + ", subjects=" + subjects + "]";
	}
	
	
	
}
