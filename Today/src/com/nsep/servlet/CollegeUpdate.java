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
public class CollegeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeUpdate() {
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
		String collegeid= request.getParameter("view");
		System.out.println("CollegeID:"+collegeid);
		CollegeDetailsDao cdao=new CollegeDetailsDao();
		ColDtls c = new ColDtls();
		c=cdao.getCollegeDtls(Integer.parseInt(collegeid));
		
		request.setAttribute("college details update",c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/CollegeUpdate.jsp");
		rd.forward(request,response);
		
		
	}

}
