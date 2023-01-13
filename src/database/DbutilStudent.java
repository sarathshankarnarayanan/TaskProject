package database;


import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DbutilStudent {

	
	private static HikariDataSource datasourceStudent = new HikariDataSource();
	
	static{
		
		try {
				
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
					return datasourceStudent;
		}
	
}
