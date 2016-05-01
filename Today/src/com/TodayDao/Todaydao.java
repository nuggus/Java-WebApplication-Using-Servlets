package com.TodayDao;
import java.sql.*;
public class Todaydao {
public void data(String t) throws Exception
{
	String t1=t;
	Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
		System.out.println("inside dao try");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("afterclass.forname");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String password="abc123";
		con=DriverManager.getConnection(url,username,password);
	    String sqlQuery ="insert into example(name)values(?)";	
	    pstmt = con.prepareStatement(sqlQuery);
	    
		System.out.println("in dao try1");
		pstmt.setString(1,t1);
		pstmt.executeUpdate();
		System.out.println(" afetr saving bank dtls");
		pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
