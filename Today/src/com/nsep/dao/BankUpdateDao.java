package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.DBUtility;
import com.nsep.dom.BankDtls;

public class BankUpdateDao {
	
	public void createBankUpdateDtls(BankDtls bankDtls)
	{
		PreparedStatement pstmt = null;
		Connection con=null;
				System.out.println("in dao main");	
			try
			{
			con = DBUtility.getConnection();
			System.out.println("in dao try");
		    String sqlQuery ="update bank_details set BANK_NAME=?,LOCATION=?,SPOC_NAME=?,MOBILE_NO=?,BANK_TYPE=? where BANKID=?";	
		    pstmt = con.prepareStatement(sqlQuery);
		    
			System.out.println("in dao try1");
			pstmt.setString(1,bankDtls.getBankName());
			pstmt.setString(2,bankDtls.getBankLocation());
			pstmt.setString(3,bankDtls.getSpocName());
			pstmt.setLong(4,bankDtls.getMobileNo());
			pstmt.setString(5,bankDtls.getBankType());
			pstmt.setInt(6,bankDtls.getBankId());
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
