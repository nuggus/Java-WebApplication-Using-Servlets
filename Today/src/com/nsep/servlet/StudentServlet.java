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
 * Servlet implementation class BankServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		
		 
		 String sfName=request.getParameter("firstname");
		 String slName=request.getParameter("lastname");
		 String sGender=request.getParameter("sex");
		 String sAddress=request.getParameter("add");
		 String sCity=request.getParameter("city");
		 String sState=request.getParameter("state");
		 String sContact=request.getParameter("contact");
		 String sEmail=request.getParameter("email");
		 String sQualification=request.getParameter("qualification");
		 String sYear=request.getParameter("year");
		 String sCamt=request.getParameter("amount");
		 String sBname=request.getParameter("bank");
		 String sAcno=request.getParameter("acno");
		 String sStart=request.getParameter("start");
		
		StudentDtls studentDtls = new StudentDtls();
		studentDtls.setSfName(sfName);
		studentDtls.setSlName(slName);
		studentDtls.setsGender(sGender);
		studentDtls.setsAddress(sAddress);
		studentDtls.setsCity(sCity);
		studentDtls.setsState(sState);
		studentDtls.setsContact(Long.parseLong(sContact));
		studentDtls.setsEmail(sEmail);
		studentDtls.setsQualification(sQualification);
		studentDtls.setsYear(sYear);
		studentDtls.setsCamt(Integer.parseInt(sCamt));
		studentDtls.setsBname(sBname);
		studentDtls.setsAcno(Long.parseLong(sAcno));
		studentDtls.setsStart(sStart);
		StudentDao dao =  new StudentDao();
		
		
		PrintWriter out = response.getWriter();
	
		
		int flag=dao.verifystudent(Long.parseLong(sAcno));
		 if(flag!=0)
			 {
			 dao.createStudentDtls(studentDtls);
		      
		      out.println("data entered successfully");
			 }
		 else
			out.println("Student is Already Registered"); 
		
		
		
	}

}
