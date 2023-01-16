package com.dh.school.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dh.school.database.DbUtil;
import com.dh.school.database.DbutilStudent;
import com.dh.school.dto.StudentSubject;
import com.dh.school.pojo.Student;
import com.dh.school.utility.DbcloseConnections;



public class StudentDaoImplementation implements StudentDao {
	

	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImplementation.class);
	private  Connection conn;
	private  PreparedStatement preparedStatement;
	private  Statement statement;
	private  ResultSet resultSet;
	private  CallableStatement callableStatement;
	
	
	
	public void addNewStudent(Student student) {
		
		
		
		try {
			  logger.debug("Inside addNewStudent method");
			  //getting connection
			  conn = DbutilStudent.getDataSourceStudent().getConnection();
			  callableStatement =conn.prepareCall("{call addStudent(?,?,?)}"); 
			  callableStatement.setInt(1, student.getRollNumber()); 
			  callableStatement.setString(2, student.getName()); 
			  callableStatement.setString(3,student.getAddress()); 
			  //execute the query and storing the return value 
			  int count= callableStatement.executeUpdate(); 
			  System.out.println("Student added Successfully");
			  logger.info(count +" rows effected" );
			  
			}
			
			catch(Exception e)
			{
			String error = e.getMessage();
			System.out.println("Unexpected error");
			logger.error(error);
			}
		
			finally 
			{
				
				DbcloseConnections.closeCallableStatement(callableStatement);
					
				DbcloseConnections.closeConnection(conn);
				
			}
		
			
	}
	
	
	public void serachStudentByRollNo(int rollNo) {
			
		Student student = new Student();
			
		try {
			logger.debug(" Inside searchStudentByRollNo method");
			//getting connection 
			conn = DbutilStudent.getDataSourceStudent().getConnection();
			callableStatement = conn.prepareCall("{call getStudentByRollNumber(?)}");
			callableStatement.setInt(1, rollNo);
			//executing the procedure and storing the return value in resultset
			resultSet = callableStatement.executeQuery();
			
			//checking if resultset return not empty
			if(resultSet.next()) {
				
				student.setRollNumber(resultSet.getInt("Roll_No"));
				student.setName(resultSet.getString("Name"));
				student.setAddress(resultSet.getString("Address"));
				
				System.out.println(student);
			}else {
						//if returned empty 
						System.out.println("No records Found");
					
				  }
		}
		
		catch(Exception e)
		{
		String error = e.getMessage();
		System.out.println("Unexpected error");
		logger.error(error);
		}
		finally 
		{
				DbcloseConnections.closeResultStatement(resultSet);
			
				DbcloseConnections.closeCallableStatement(callableStatement);
				
				DbcloseConnections.closeConnection(conn);
			
		}
		
	}
	
	
	public List<Student> getAllStudent(){
		
		List<Student> studentList = new ArrayList<Student>();
		
		
		try {
			logger.debug("Inside getAllStudent Method");
			
			//getting connection
			conn = DbutilStudent.getDataSourceStudent().getConnection();
			
			statement = conn.createStatement();
			
			//executing the procedure and storing the return value in resultset
			resultSet = statement.executeQuery("select * from mca_Student");
			
			//checking if return set is empty
			if(!resultSet.next()) {
				
				return null;
				
			}else {
				
						do {
								  //if not empty get the value of each row and set it int student object
								  Student student = new Student();
								  student.setRollNumber(resultSet.getInt("Roll_No"));
								  student.setName(resultSet.getString("Name"));
								  student.setAddress(resultSet.getString("Address"));
								 
								  //adding the each student details to the list of student
								  studentList.add(student);
								
							}while(resultSet.next());
						
				  }
			
		}
		
		catch(Exception e)
		{
		String error = e.getMessage();
		System.out.println("Unexpected error");
		logger.error(error);
		}
		
		finally 
		{
				DbcloseConnections.closeResultStatement(resultSet);
			
				DbcloseConnections.closeStatement(statement);
				
				DbcloseConnections.closeConnection(conn);
			
		}
		
		return  studentList;
	}
	
	
	
	public void getStudentDetailWithMarks() {
		
		logger.debug("getStudentDetailWithMarks method");
		//created object
		SubejctDao subjectDao = new SubjectDaoImplementation();
		StudentDao studentDao = new StudentDaoImplementation();
		
		try {
			List<Student> studentList = new ArrayList<Student>();
			
			//calling studentdao method to get the details of all student and storing it in a list of student
			studentList=studentDao.getAllStudent();
			
			
			//Checking if student list is null or not
			if(studentList.equals(null)) {
				
				//if null 
				System.out.println("No Records Found");
				
			}else {
						//if not null then loop through each student
						for(Student student : studentList ) {
							
							//calling subjectDao method to get the subject for each student
							subjectDao.getStudentSubject(student);	 
						}
				
				}
		}
		
		catch(Exception e)
		{
		String error = e.getMessage();
		System.out.println("Unexpected error");
		logger.error(error);
		}
		
	}
	
}
