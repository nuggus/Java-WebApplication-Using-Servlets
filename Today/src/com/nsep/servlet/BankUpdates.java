package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.*;
import com.nsep.dom.BankDtls;

/**
 * Servlet implementation class BankUpdates
 */
public class BankUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankUpdates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid=request.getParameter("Bid");
		System.out.println("b"+bid);
		String bankName = request.getParameter("Bname");
		String city = request.getParameter("city");
		String sname = request.getParameter("Sname"); 
		String scontact = request.getParameter("Scontact"); 
		String national = request.getParameter("national"); 
		
		
		BankDtls bankDtls = new BankDtls();
		bankDtls.setBankId(Integer.parseInt(bid));
		bankDtls.setBankLocation(city);
		bankDtls.setBankName(bankName);
		bankDtls.setSpocName(sname);
		bankDtls.setMobileNo(Long.parseLong(scontact));
		bankDtls.setBankType(national);
		
	    BankUpdateDao dao=new BankUpdateDao();
		dao.createBankUpdateDtls(bankDtls);
		
		PrintWriter out = response.getWriter();
		out.println(" Bank dtls updated succesfully");
	}

}
