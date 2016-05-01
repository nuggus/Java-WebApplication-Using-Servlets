package com.nsep.dao;
import com.db.DBUtility;
import com.nsep.dom.*;

import java.sql.*;
import java.util.*;

public class CollegeDeleteDao {

	public void delete(int cId)
	{
		Connection con=null;
		Statement pstmt = null;
		System.out.println("inside college deletedao");
		
		
try
		
		{
	    con = DBUtility.getConnection();
		String sqlQuery = "Delete from clg_dtls where C_ID="+cId;
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
