package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.DbUtil;
import dto.StudentSubject;
import pojo.Subject;

public class SubjectDaoImplementation implements SubejctDao {

	
	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private CallableStatement callableStatement;
	private static final Logger logger = LoggerFactory.getLogger(SubjectDaoImplementation.class);
	
	
	public void addSubject(Subject subject) {
		
		try {
			  logger.info("Inside addnewBook");
			  conn = DbUtil.getDataSourceSubject().getConnection();
			  callableStatement =conn.prepareCall("{call addSubject(?,?,?,?)}"); 
			  callableStatement.setInt(1, subject.getStudentRollNo()); 
			  callableStatement.setString(2, subject.getSubject1()); 
			  callableStatement.setString(3, subject.getSubject2()); 
			  callableStatement.setString(4,subject.getSubject3()); 
			  int count= callableStatement.executeUpdate(); 
			  System.out.println("Subject added Successfully");
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
	
	public void getStudentSubject(StudentSubject studentSubject){
		
		
		try {
			logger.info("Inside search subject by roll no");
			conn = DbUtil.getDataSourceSubject().getConnection();
			callableStatement = conn.prepareCall("{call getSubjectByRollNumber(?)}");
			callableStatement.setInt(1, studentSubject.getStudentrollNo());
			resultSet = callableStatement.executeQuery();
			
				
				
			if(resultSet.next()) {
								
			studentSubject.setStudentSubject1(resultSet.getString("Subject1"));
			studentSubject.setStudentSubject2(resultSet.getString("Subject2"));
			studentSubject.setStudentSubject3(resultSet.getString("Subject3"));
						
			System.out.println(studentSubject);
			}
			else {
				
				studentSubject.setStudentSubject1("No subject added");
				studentSubject.setStudentSubject2("No subject added");
				studentSubject.setStudentSubject3("No subject added");
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
			try {
				callableStatement.close();
				conn.close();
				logger.info("Connection Closed");
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
	}

	
}
