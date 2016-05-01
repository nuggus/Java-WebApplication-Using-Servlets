package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.*;
import com.nsep.dom.*;

/**
 * Servlet implementation class BankUpdate
 */
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
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
		String studentid= request.getParameter("view");
		System.out.println("StudentID:"+studentid);
		StudentDetailsDao bdao=new StudentDetailsDao();
		StudentDtls b = new StudentDtls();
		b=bdao.getStudentDtls(Integer.parseInt(studentid));
		System.out.println("Before set attribute"+b.getsId());
		request.setAttribute("student details update", b);
		System.out.println(b.getsId());
		RequestDispatcher rd = request.getRequestDispatcher("/StudentUpdate.jsp");
		rd.forward(request,response);
		PrintWriter pw=response.getWriter();
		pw.print("sucess");
		pw.println(studentid);
		
	}

}
