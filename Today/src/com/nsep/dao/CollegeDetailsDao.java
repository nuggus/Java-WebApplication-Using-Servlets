package com.nsep.dao;
import com.db.DBUtility;
import com.nsep.dom.*;

import java.sql.*;
import java.util.*;

public class CollegeDetailsDao {

	public ColDtls getCollegeDtls(int cId)
	{
		Connection con=null;
		
		Statement pstmt = null;
		
		System.out.println("inside getUserTest");
		ColDtls list = new ColDtls();
		
try
		
		{
	    con = DBUtility.getConnection();
		String sqlQuery = "select  * from clg_dtls where C_ID="+cId;
		System.out.println(sqlQuery);
		pstmt = con.createStatement();
		
		ResultSet rs =  pstmt.executeQuery(sqlQuery);
		
		
			while(rs.next())
			{	
			list.setcId(rs.getInt(1));
			list.setcName(rs.getString(2));
			list.setcLocation(rs.getString(3));
			list.setCspocName(rs.getString(4));
			list.setCmobileNo(rs.getInt(5));
			list.setcType(rs.getString(6));
			list.setCtypeOfcourses(rs.getString(7));
			}
		
		
		System.out.println("With in  Dao"+list.getcId());
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
		   return list;


	}}
