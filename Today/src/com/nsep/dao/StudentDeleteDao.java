package com.nsep.dao;
import com.db.DBUtility;
import com.nsep.dom.*;

import java.sql.*;
import java.util.*;

public class StudentDeleteDao {

	public void delete(int sId)
	{
		Connection con=null;
		Statement pstmt = null;
		System.out.println("inside student deletedao");
		
		
try
		
		{
	    con = DBUtility.getConnection();
		String sqlQuery = "Delete from student_details where S_ID="+sId;
		System.out.println(sqlQuery);
		pstmt = con.createStatement();
		ResultSet rs =  pstmt.executeQuery(sqlQuery);
		pstmt.close();
		System.out.println("sucess");
		 
		//Statement st=con.createStatement();
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
     
			      
		  
	}
		   


	}}
