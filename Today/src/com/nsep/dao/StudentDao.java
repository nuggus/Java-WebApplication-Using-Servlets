package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBUtility;
import com.nsep.dom.*;

public class StudentDao {
	
	
	
	public int verifystudent(long num)
	{
		System.out.println(num);
		Statement pstmt = null;
		Connection con=null;
		StudentDtls list=new StudentDtls();
		ResultSet rs=null;
		int flag=0,i=0;
			try
			{
			con = DBUtility.getConnection();
				
		    String sqlQuery = "select count(*) from student_details where S_ACNO="+num;	
		    System.out.println(sqlQuery);
		    pstmt = con.createStatement();
			//pstmt.setString(1,list.getColName());
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
		
	
	public void createStudentDtls(StudentDtls studentDtls)
	{
		PreparedStatement pstmt = null;
		Connection con=null;
				System.out.println("in dao main");	
			try
			{
			con = DBUtility.getConnection();
			System.out.println("in dao try");
		    String sqlQuery ="insert into student_details(S_ID,S_FNAME,S_LNAME,S_GENDER,S_ADDRESS,S_CITY,S_STATE,S_CONTACT,S_EMAIL,S_QUALIFICATION,S_YEAR,S_CAMT,S_BNAME,S_ACNO,S_START)values(S_ID_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		    pstmt = con.prepareStatement(sqlQuery);
		    
			System.out.println("in dao try1");
			pstmt.setString(1,studentDtls.getSfName());
			pstmt.setString(2,studentDtls.getSlName());
			pstmt.setString(3,studentDtls.getsGender());
			pstmt.setString(4,studentDtls.getsAddress());
			pstmt.setString(5,studentDtls.getsCity());
			pstmt.setString(6,studentDtls.getsState());
            pstmt.setLong(7,studentDtls.getsContact());
			pstmt.setString(8,studentDtls.getsEmail());
			pstmt.setString(9,studentDtls.getsQualification());
			pstmt.setString(10,studentDtls.getsYear());
			pstmt.setInt(11,studentDtls.getsCamt());
			pstmt.setString(12,studentDtls.getsBname());
			pstmt.setLong(13,studentDtls.getsAcno());
			pstmt.setString(14,studentDtls.getsStart());
			pstmt.executeUpdate();
			System.out.println(" afetr saving bank dtls");
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
