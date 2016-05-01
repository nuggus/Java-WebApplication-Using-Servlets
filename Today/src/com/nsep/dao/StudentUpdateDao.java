package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.DBUtility;
import com.nsep.dom.*;

public class StudentUpdateDao {
	
	public void createStudentUpdateDtls(StudentDtls studentDtls)
	{
		PreparedStatement pstmt = null;
		Connection con=null;
				System.out.println("in dao main");	
			try
			{
			con = DBUtility.getConnection();
			System.out.println("in dao try");
		    String sqlQuery ="update student_details set S_FNAME=?,S_LNAME=?,S_ADDRESS=?,S_CONTACT=?,S_EMAIL=? where s_id=?";	
		    pstmt = con.prepareStatement(sqlQuery);
		    
			System.out.println("in dao try1");
			pstmt.setString(1,studentDtls.getSfName());
			pstmt.setString(2,studentDtls.getSlName());
			pstmt.setString(3,studentDtls.getsAddress());
			pstmt.setLong(4,studentDtls.getsContact());
			pstmt.setString(5,studentDtls.getsEmail());
			pstmt.setInt(6,studentDtls.getsId());
			
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
