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
import com.nsep.dom.BankDtls;

/**
 * Servlet implementation class BankDetails
 */
public class BankDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		String bankid= request.getParameter("view");
        
		System.out.println("BankID:"+bankid);
		BankDetailsDao bdao=new BankDetailsDao();
		BankDtls b = new BankDtls();
		b=bdao.getBankDtls(Integer.parseInt(bankid));
		System.out.println("Before set attribute"+b.getBankId());
		request.setAttribute("bankdetails",b);
		System.out.println(b.getBankId());
		RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		rd.forward(request,response);
		PrintWriter pw=response.getWriter();
		pw.print("sucess");
		pw.println(bankid);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    	 
		
		
			
	
	
	}

}
