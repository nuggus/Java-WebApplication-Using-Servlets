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
public class StudentUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdates() {
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
		String sid=request.getParameter("Sid");
		System.out.println("S"+sid);
		String sfname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String ad=request.getParameter("add");
		String con=request.getParameter("contact");
		String email=request.getParameter("email");
		
		StudentDtls studentkDtls = new StudentDtls();
		studentkDtls.setsId(Integer.parseInt(sid));
		studentkDtls.setSfName(sfname);
		studentkDtls.setSlName(lname);
		studentkDtls.setsAddress(ad);
		studentkDtls.setsContact(Integer.parseInt(con));
		studentkDtls.setsEmail(email);
		
	    StudentUpdateDao dao=new StudentUpdateDao();
		dao.createStudentUpdateDtls(studentkDtls);
		
		PrintWriter out = response.getWriter();
		out.println(" Bank dtls updated succesfully");
	}

}
