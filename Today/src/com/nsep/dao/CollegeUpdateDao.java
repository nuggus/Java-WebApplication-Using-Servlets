package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.DBUtility;
import com.nsep.dom.*;

public class CollegeUpdateDao {
	
	public void createCollegeUpdateDtls(ColDtls colDtls)
	{
		PreparedStatement pstmt = null;
		Connection con=null;
				System.out.println("in dao main");	
			try
			{
			con = DBUtility.getConnection();
			System.out.println("in dao try");
		    String sqlQuery ="update clg_dtls set CNAME=?,C_SPOC=?,C_SPOCNO=? where C_ID=?";	
		    pstmt = con.prepareStatement(sqlQuery);
		    
			System.out.println("in dao try1");
			pstmt.setString(1,colDtls.getcName());
			pstmt.setString(2,colDtls.getCspocName());
			pstmt.setLong(3,colDtls.getCmobileNo());
			pstmt.setInt(4,colDtls.getcId());
			
			pstmt.executeUpdate();
			System.out.println(" afetr saving college dtls");
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
