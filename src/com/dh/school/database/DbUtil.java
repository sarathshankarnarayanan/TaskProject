package com.dh.school.database;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dh.school.dao.SubjectDaoImplementation;
import com.zaxxer.hikari.HikariDataSource;

public class DbUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(DbUtil.class);
	private static HikariDataSource datasourceSubject = new HikariDataSource(); 
	
	
	static{
		
			try {
				logger.debug("Static method called to set the data source");
				datasourceSubject.setDriverClassName("com.mysql.cj.jdbc.Driver");
				datasourceSubject.setJdbcUrl("jdbc:mysql://localhost:3306/subject");
				datasourceSubject.setUsername("root");
				datasourceSubject.setPassword("root");
			
				datasourceSubject.setMinimumIdle(2);
				datasourceSubject.setMaximumPoolSize(2);
				}catch(Exception e)
				{
					logger.error("Error :" +e.getMessage());
					System.out.println("Error : " +e );
				}
			}
	
	public static DataSource getDataSourceSubject() {
		
			logger.debug("Inside getDataSourceSubject");
			return datasourceSubject;
}
			
	
		
}