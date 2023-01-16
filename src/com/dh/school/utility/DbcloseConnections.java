package com.dh.school.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dh.school.dao.StudentDaoImplementation;

public class DbcloseConnections {

	private static final Logger logger = LoggerFactory.getLogger(DbcloseConnections.class);
	
	public static void closeCallableStatement(CallableStatement callableStatement ) {
		
		try {
				if(callableStatement != null)
				{
					callableStatement.close();
					logger.warn("callable Statement Closed");
				}
				
			}catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		
		
	}
	
	
	
	public static void closeConnection(Connection conn) {
		
		
		try {
			if(conn != null) 
			{
				conn.close();
				logger.warn("Connection Closed");
			}
			
		}catch (SQLException e) {
			
			logger.error(e.getMessage());
		}
		
	}
	
	
	public static void closeResultStatement(ResultSet resultSet) {
		
		try {
			if(resultSet !=null) {
				
				resultSet.close();
				logger.warn("Result Statement Closed");
			}
			
		}catch (SQLException e) {
			
			logger.error(e.getMessage());
		}
		
	}
	
	public static void closeStatement(Statement statement) {
		
		try {
			
			if(statement !=null) {
				
				statement.close();
				logger.warn("Statement Closed");
			}
			
		}catch (SQLException e) {
			
			logger.error(e.getMessage());
		}
	}
}
