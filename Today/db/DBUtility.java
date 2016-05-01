package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static Connection con=null;
	public static java.sql.Statement stm=null;
	
	public static Connection getConnection()
	{
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String password="abc123";
		con=DriverManager.getConnection(url,username,password);
	}
	
	catch(ClassNotFoundException e) 
	{
		
		e.printStackTrace();
	 } 
	catch(SQLException e) {
		
		e.printStackTrace();
	}
	return con;
}
	



}
