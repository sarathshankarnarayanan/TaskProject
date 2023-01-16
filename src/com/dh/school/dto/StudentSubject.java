package com.dh.school.dto;

import java.util.List;

public class StudentSubject {

	private int studentrollNo;
	private String studentName;
	private String studentAddress;
	private List<String> subjects;
	public int getStudentrollNo() {
		return studentrollNo;
	}
	public void setStudentrollNo(int studentrollNo) {
		this.studentrollNo = studentrollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return " studentrollNo =" + studentrollNo + ", studentName =" + studentName + ", studentAddress ="
				+ studentAddress + ", subjects =" + subjects ;
	}
	
	
	
	
}
