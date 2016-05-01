package com.nsep.dao;
import com.db.DBUtility;
import com.nsep.dom.*;

import java.sql.*;
import java.util.*;

public class BankDetailsDao {

	public BankDtls getBankDtls(int bId)
	{
		Connection con=null;
		
		Statement pstmt = null;
		
		System.out.println("inside getbank details");
		BankDtls list = new BankDtls();
		
try
		
		{
	con = DBUtility.getConnection();
		String sqlQuery = "select  * from bank_details where BANKID="+bId;
		System.out.println(sqlQuery);
		pstmt = con.createStatement();
		
		ResultSet rs =  pstmt.executeQuery(sqlQuery);
		
		
			while(rs.next())
			{	
			list.setBankId(rs.getInt(1));
			list.setBankName(rs.getString(2));
			list.setBankLocation(rs.getString(3));
			list.setSpocName(rs.getString(4));
			list.setMobileNo(rs.getLong(5));
			list.setBankType(rs.getString(6));
			list.setTypeOfAccounts(rs.getString(7));
			}
		
		
		System.out.println("With in  Dao"+list.getBankId());
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
