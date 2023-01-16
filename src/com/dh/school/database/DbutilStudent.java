package com.dh.school.database;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

public class DbutilStudent {

	private static final Logger logger = LoggerFactory.getLogger(DbutilStudent.class);
	private static HikariDataSource datasourceStudent = new HikariDataSource();
	
	static{
		
		try {
				logger.debug("Static method called to set the data source");
				datasourceStudent.setDriverClassName("com.mysql.cj.jdbc.Driver");
				datasourceStudent.setJdbcUrl("jdbc:mysql://localhost:3306/student");
				datasourceStudent.setUsername("root");
				datasourceStudent.setPassword("root");
			
				datasourceStudent.setMinimumIdle(2);
				datasourceStudent.setMaximumPoolSize(2);
			}catch(Exception e)
			{
				System.out.println("Error : " +e );
			}
		}
	


		public static DataSource getDataSourceStudent()
		{	
					logger.debug("Inside getDataSourceStudent");
					return datasourceStudent;
		}
	
}
