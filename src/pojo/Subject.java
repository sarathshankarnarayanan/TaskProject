package pojo;

public class Subject {
	
	private int studentRollNo;
	private String subject1;
	private String subject2;
	private String Subject3;
	public int getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public String getSubject3() {
		return Subject3;
	}
	public void setSubject3(String subject3) {
		Subject3 = subject3;
	}
	@Override
	public String toString() {
		return "Subject [studentRollNo=" + studentRollNo + ", subject1=" + subject1 + ", subject2=" + subject2
				+ ", Subject3=" + Subject3 + "]";
	}
	
	
}
