package dto;

public class StudentSubject {

	private int studentrollNo;
	private String studentName;
	private String studentAddress;
	private String studentSubject1;
	private String studentSubject2;
	private String studentSubject3;
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
	public String getStudentSubject1() {
		return studentSubject1;
	}
	public void setStudentSubject1(String studentSubject1) {
			
			this.studentSubject1 = studentSubject1;
		
	}
	public String getStudentSubject2() {
		
		return studentSubject2;
	}
	public void setStudentSubject2(String studentSubject2) {
			
			this.studentSubject2 = studentSubject2;
		
		
	}
	public String getStudentSubject3() {
		return studentSubject3;
	}
	public void setStudentSubject3(String studentSubject3) {
		
				this.studentSubject3 = studentSubject3;
		
	}
	@Override
	public String toString() {
		return "[studentrollNo=" + studentrollNo + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", studentSubject1=" + studentSubject1 + ", studentSubject2=" + studentSubject2
				+ ", studentSubject3=" + studentSubject3 + "]";
	}
	
	
	
}
