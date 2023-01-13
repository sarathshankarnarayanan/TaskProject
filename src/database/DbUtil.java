package database;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DbUtil {


	private static HikariDataSource datasourceSubject = new HikariDataSource(); ;
	
	
	static{
		
			try {
					
				datasourceSubject.setDriverClassName("com.mysql.cj.jdbc.Driver");
				datasourceSubject.setJdbcUrl("jdbc:mysql://localhost:3306/subject");
				datasourceSubject.setUsername("root");
				datasourceSubject.setPassword("root");
			
				datasourceSubject.setMinimumIdle(2);
				datasourceSubject.setMaximumPoolSize(2);
				}catch(Exception e)
				{
					System.out.println("Error : " +e );
				}
			}
	
	public static DataSource getDataSourceSubject() {
	
			return datasourceSubject;
}
			
	
		
}