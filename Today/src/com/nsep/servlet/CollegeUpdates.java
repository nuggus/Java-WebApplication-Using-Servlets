 package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.*;
import com.nsep.dom.*;

/**
 * Servlet implementation class BankUpdates
 */
public class CollegeUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeUpdates() {
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
	String c_id=request.getParameter("cid");
		System.out.println("b"+c_id);
		
		String cname=request.getParameter("Cname");
		System.out.println("c:"+cname);
		String SpocName=request.getParameter("SPOCname");
		String SpocMob=request.getParameter("SPOCcontactno");
	
		ColDtls colDtls = new ColDtls();
		colDtls.setcId(Integer.parseInt(c_id));
		colDtls.setcName(cname);
		colDtls.setCspocName(SpocName);
		colDtls.setCmobileNo(Long.parseLong(SpocMob));
		
	    CollegeUpdateDao dao=new CollegeUpdateDao();
		dao.createCollegeUpdateDtls(colDtls);
		
		PrintWriter out = response.getWriter();
		out.println(" College dtls updated succesfully");
	}

}
