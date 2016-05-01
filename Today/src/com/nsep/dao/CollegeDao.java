package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBUtility;
import com.nsep.dom.ColDtls;
import com.nsep.dom.StudentDtls;

public class CollegeDao {
	
	
	public int verifycollege(ColDtls coldtls)
	{
		
		Statement pstmt = null;
		Connection con=null;
		
		ResultSet rs=null;
		int flag=0,i=0;
		String num=coldtls.getcCode();
			try
			{
			con = DBUtility.getConnection();
				
		    String sqlQuery = "select count(*) from clg_dtls where c_id="+num;	
		    System.out.println(sqlQuery);
		    pstmt = con.createStatement();
			
		    rs=pstmt.executeQuery(sqlQuery);
		    rs.next();
		    i=rs.getInt(1);
		   System.out.println("count="+i);
			pstmt.close();
			con.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   if(i>0)
		   	flag=0;
		   else
			   flag=1;
			
	return flag;
	}
	
	public void createColDtls(ColDtls coldtls)
	{
		PreparedStatement pstmt = null;
		Connection con=null;
					
			try
			{
			con = DBUtility.getConnection();
			
			System.out.println(coldtls.getcName());
			System.out.println(coldtls.getcLocation());
			System.out.println(coldtls.getCspocName());
			System.out.println(coldtls.getCmobileNo());
			System.out.println(coldtls.getcType());
			System.out.println(coldtls.getCtypeOfcourses());
		    String sqlQuery = "insert into clg_dtls(C_ID,CNAME,C_CITY ,C_SPOC,C_SPOCNO,C_AFF,C_COURSES,c_code) values (c_id_seq.nextval,?,?,?,?,?,?,?) ";	
		    pstmt = con.prepareStatement(sqlQuery);
		    
			
			pstmt.setString(1,coldtls.getcName());
			pstmt.setString(2,coldtls.getcLocation());
			pstmt.setString(3,coldtls.getCspocName());
			pstmt.setLong(4,coldtls.getCmobileNo());
			pstmt.setString(5,coldtls.getcType());
			pstmt.setString(6,coldtls.getCtypeOfcourses());
			pstmt.setString(7,coldtls.getcCode());
			pstmt.executeUpdate();
			System.out.println(" after saving college dtls");
			pstmt.close();
			
			
			
		    con.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try

	}

}
