package com.nsep.dao;
import com.db.DBUtility;
import com.nsep.dom.*;

import java.sql.*;
import java.util.*;

public class StudentDetailsDao {

	public StudentDtls getStudentDtls(int sId)
	{
		Connection con=null;
		Statement pstmt = null;
		
		System.out.println("inside getStudentDetails");
		StudentDtls list = new StudentDtls();
		
try
		
		{
	    con = DBUtility.getConnection();
		String sqlQuery = "select  * from student_details where S_ID="+sId;
		System.out.println(sqlQuery);
		pstmt = con.createStatement();
		ResultSet rs =  pstmt.executeQuery(sqlQuery);
		
		
			while(rs.next())
			{	
			
			list.setsId(rs.getInt(1));
			list.setSfName(rs.getString(2));
			list.setSlName(rs.getString(3));
			list.setsGender(rs.getString(4));
			list.setsAddress(rs.getString(5));
			list.setsCity(rs.getString(6));
			list.setsState(rs.getString(7));
			list.setsContact(rs.getLong(8));
			list.setsEmail(rs.getString(9));
			list.setsQualification(rs.getString(10));
			list.setsYear(rs.getString(11));
			list.setsCamt(rs.getInt(12));
			list.setsBname(rs.getString(13));
			list.setsAcno(rs.getLong(14));
			list.setsStart(rs.getString(15));
			
			
			}
		
		
		System.out.println("With in  Dao"+list.getsId());
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
