package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	
	private static Connection conn=null;
	
	public static Connection getconn() {
		
		try {
			
			
				 Class.forName("com.mysql.cj.jdbc.Driver");

	              // Creating connection
	              String url = "jdbc:mysql://localhost:3306/student_dbs";
	              String username = "root";
	              String password = "sarvesh1122#";

	              conn = DriverManager.getConnection(url, username, password);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	

}
