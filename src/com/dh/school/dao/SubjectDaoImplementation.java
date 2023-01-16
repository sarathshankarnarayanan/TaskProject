package com.dh.school.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dh.school.database.DbUtil;
import com.dh.school.dto.StudentSubject;
import com.dh.school.pojo.Student;
import com.dh.school.utility.DbcloseConnections;
import com.dh.school.utility.Validator;

public class SubjectDaoImplementation implements SubejctDao {

	
	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private CallableStatement callableStatement;
	private static final Logger logger = LoggerFactory.getLogger(SubjectDaoImplementation.class);
	Scanner scan = new Scanner(System.in);
	
	
	public void addSubject(int rollNo,String subject) {
		
		try {
			  logger.debug("Inside addSubject method");
			  //getting connection
			  conn = DbUtil.getDataSourceSubject().getConnection();
			  callableStatement =conn.prepareCall("{call addSubject(?,?)}"); 
			  callableStatement.setInt(1, rollNo); 
			  callableStatement.setString(2,subject); 
			  int count= callableStatement.executeUpdate(); 
			  System.out.println( subject + " Subject added Successfully");
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
	
	
	public void getStudentSubject(Student student){
		List<String> subjects = new ArrayList<String>();
		StudentSubject studentSubject =new StudentSubject();
		
		try {
			logger.debug("Inside getStudentSubject");
			//getting connection
			conn = DbUtil.getDataSourceSubject().getConnection();
			callableStatement = conn.prepareCall("{call getSubjectByRollNumber(?)}");
			callableStatement.setInt(1, student.getRollNumber());
			
			//executing the procedure and storing the returned values in the resultset
			resultSet = callableStatement.executeQuery();
			
			//checking if resultset is null	
			if(!resultSet.next()) {
				
				//if null
				System.out.println(" studentrollNo =" + student.getRollNumber() + " studentName =" + student.getName() + " studentAddress =" + student.getAddress() + " subjects =[No subject Found for the student]");
				
			}else {
				
				//if not null store the values from the resultset to a string and add it in a list of subject 
				do {
					
						String subject = resultSet.getString("Subjects");
						subjects.add(subject);
						
						
					}while(resultSet.next());
				
				//storing the info of student and its each subject taken by him
				studentSubject.setStudentrollNo(student.getRollNumber());
				studentSubject.setStudentName(student.getName());
				studentSubject.setStudentAddress(student.getAddress());
				studentSubject.setSubjects(subjects);
				System.out.println(studentSubject);
				
				
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
	
	
	public List<String> getSubjectFromUser(){
		
		logger.debug("Inside getSubjectFromUser method");
		
		Validator validator = new Validator();
		List<String> subjectList = new ArrayList<String>();
		int choice =0;
		
		do {
			
			System.out.println("Enter Student Subject :");
			String subject = scan.nextLine();
			
			//get the values from the user until the value of choice is no and add the subject to the subject list
			subjectList.add(subject);
			
			System.out.println("Do you want to add another Subject :");
			System.out.println("1)Yes");
			System.out.println("2)No");
			choice = validator.validInt();
			
			if(choice != 1 && choice !=2)
			{
				System.out.println("You have Entered a wrong input");
				logger.debug("Wrong input from the user");
				choice = 2;
			}
		
			
		}while(choice != 2);
		
		return subjectList;
		
		
	}

	
}
