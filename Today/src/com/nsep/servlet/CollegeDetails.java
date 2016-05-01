package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.BankDetailsDao;
import com.nsep.dao.CollegeDetailsDao;
import com.nsep.dom.BankDtls;
import com.nsep.dom.ColDtls;

/**
 * Servlet implementation class BankDetails
 */
public class CollegeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		String collegeid= request.getParameter("view");
        
		System.out.println("CollegeID:"+collegeid);
		CollegeDetailsDao cdao=new CollegeDetailsDao();
		ColDtls c = new ColDtls();
		c=cdao.getCollegeDtls(Integer.parseInt(collegeid));
		System.out.println("Before set attribute"+c.getcId());
		request.setAttribute("collegedetails",c);
		System.out.println(c.getcId());
		RequestDispatcher rd = request.getRequestDispatcher("/clgview.jsp");
		rd.forward(request, response);
		PrintWriter pw=response.getWriter();
		pw.print("sucess");
		pw.println(collegeid);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    	 
		
		
			
	
	
	}

}
