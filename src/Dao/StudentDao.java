package Dao;

import pojo.Student;

public interface StudentDao {

	public void addNewStudent(Student student);
	public void serachStudentByRollNo(int rollNo);
	public void getAllStudent();
	public void getStudentDetailWithMarks();
}
