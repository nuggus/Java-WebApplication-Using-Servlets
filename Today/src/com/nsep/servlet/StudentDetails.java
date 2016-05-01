package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.StudentDetailsDao;
import com.nsep.dom.StudentDtls;

/**
 * Servlet implementation class StudentDetails
 */
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentid= request.getParameter("view");
        
        StudentDetailsDao sdao=new StudentDetailsDao();
        
		StudentDtls s = new StudentDtls();
		
		s=sdao.getStudentDtls(Integer.parseInt(studentid));
		
	
		request.setAttribute("studentdetails",s);
		System.out.println(s.getsId());
		RequestDispatcher rd = request.getRequestDispatcher("/studentview.jsp");
		rd.forward(request, response);
		PrintWriter pw=response.getWriter();
		pw.print("sucess");
		pw.println(studentid);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
