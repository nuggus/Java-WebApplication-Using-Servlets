package com.nsep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBUtility;
import com.nsep.dom.BankDtls;

public class BankDao {

	public int verifybank(BankDtls bankDtls) {

		Statement pstmt = null;
		Connection con = null;

		ResultSet rs = null;
		int flag = 0, i = 0;

		String num = bankDtls.getBcode();
		try {
			con = DBUtility.getConnection();

			String sqlQuery = "select count(*) from bank_details where b_code=" + num;
			System.out.println(sqlQuery);
			pstmt = con.createStatement();
			// pstmt.setString(1,list.getColName());
			rs = pstmt.executeQuery(sqlQuery);
			rs.next();
			i = rs.getInt(1);
			System.out.println("count=" + i);
			pstmt.close();
			con.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (i > 0)
			flag = 0;
		else
			flag = 1;

		return flag;
	}

	public void createBankDtls(BankDtls bankDtls) {
		PreparedStatement pstmt = null;
		Connection con = null;
		System.out.println("in dao main");
		try {
			con = DBUtility.getConnection();
			System.out.println("in dao try");
			String sqlQuery = "insert into bank_details(BANKID,BANK_NAME,LOCATION,SPOC_NAME,MOBILE_NO,BANK_TYPE,TYPE_OF_ACCOUNT,b_code)values(BANK_ID_SEQ.nextval,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sqlQuery);

			System.out.println("in dao try1");
			pstmt.setString(1, bankDtls.getBankName());
			pstmt.setString(2, bankDtls.getBankLocation());
			pstmt.setString(3, bankDtls.getSpocName());
			pstmt.setLong(4, bankDtls.getMobileNo());
			pstmt.setString(5, bankDtls.getBankType());
			pstmt.setString(6, bankDtls.getTypeOfAccounts());
			pstmt.setString(7, bankDtls.getBcode());
			pstmt.executeUpdate();
			System.out.println(" afetr saving bank dtls");
			pstmt.close();

			con.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

}
