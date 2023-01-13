package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.DbUtil;
import database.DbutilStudent;
import dto.StudentSubject;
import pojo.Student;



public class StudentDaoImplementation implements StudentDao {
	

	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImplementation.class);
	private  Connection conn;
	private  PreparedStatement preparedStatement;
	private  Statement statement;
	private  ResultSet resultSet;
	private  CallableStatement callableStatement;
	
	
	

	
	public void addNewStudent(Student student) {
		
		
		
		try {
			  logger.info("Inside addnewBook");
			  conn = DbutilStudent.getDataSourceStudent().getConnection();
			  callableStatement =conn.prepareCall("{call addStudent(?,?,?)}"); 
			  callableStatement.setInt(1, student.getRollNumber()); 
			  callableStatement.setString(2, student.getName()); 
			  callableStatement.setString(3,student.getAddress()); 
			  int count= callableStatement.executeUpdate(); 
			  System.out.println("Book added Successfully");
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
				try {
					callableStatement.close();
					conn.close();
				
					logger.info("Connection Closed");
				} catch (SQLException e) {
					
					logger.error(e.getMessage());
				}
			}
		
			
	}
	
	
	public void serachStudentByRollNo(int rollNo) {
			
		Student student = new Student();
			
		try {
			logger.info("Inside search by roll no");
			conn = DbutilStudent.getDataSourceStudent().getConnection();
			callableStatement = conn.prepareCall("{call getStudentByRollNumber(?)}");
			callableStatement.setInt(1, rollNo);
			resultSet = callableStatement.executeQuery();
			if(resultSet.next()) {
				
				student.setRollNumber(resultSet.getInt("Roll_No"));
				student.setName(resultSet.getString("Name"));
				student.setAddress(resultSet.getString("Address"));
				
				System.out.println(student);
			}else {
						
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
			try {
				callableStatement.close();
				conn.close();
				logger.info("Connection Closed");
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
		
	}
	
	
	public void getAllStudent(){
		
		Student student = new Student();
		
		
		try {
			logger.info("Inside get all student");
			conn = DbutilStudent.getDataSourceStudent().getConnection();
			callableStatement = conn.prepareCall("{ call getAllStudent }");
			resultSet = callableStatement.executeQuery();
			
			
			if(!resultSet.next()) {
				
				System.out.println("No records Found");
				
			}else {
				
						do {
								student.setRollNumber(resultSet.getInt("Roll_No"));
								student.setName(resultSet.getString("Name"));
								student.setAddress(resultSet.getString("Address"));
						
								System.out.println(student);
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
			try {
				callableStatement.close();
				conn.close();
				logger.info("Connection Closed");
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
		
	}
	
	
	
	public void getStudentDetailWithMarks() {
		
		StudentSubject studentSubject = new StudentSubject();
		SubjectDaoImplementation subjectDao = new SubjectDaoImplementation();
		
		try {
			logger.info("Inside search by roll no");
			conn = DbutilStudent.getDataSourceStudent().getConnection();
			String Query = "select * from mca_student";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(Query);
			
				if(!resultSet.next()) {
				
							System.out.println("No records Found");
					
					}else {
				
						do {
							
							  studentSubject.setStudentrollNo(resultSet.getInt("Roll_No"));
							  studentSubject.setStudentName(resultSet.getString("Name"));
							  studentSubject.setStudentAddress(resultSet.getString("Address"));
							 
							  subjectDao.getStudentSubject(studentSubject);
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
			try {
				
			//	statement.close();
				conn.close();
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
	}
	
}
