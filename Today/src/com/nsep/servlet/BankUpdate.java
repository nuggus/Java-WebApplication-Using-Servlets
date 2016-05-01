package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.BankDetailsDao;
import com.nsep.dom.BankDtls;

/**
 * Servlet implementation class BankUpdate
 */
public class BankUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankUpdate() {
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
		String bankid= request.getParameter("view");
		System.out.println("BankID:"+bankid);
		BankDetailsDao bdao=new BankDetailsDao();
		BankDtls b = new BankDtls();
		b=bdao.getBankDtls(Integer.parseInt(bankid));
		System.out.println("Before set attribute"+b.getBankId());
		request.setAttribute("bankdetailsupdate", b);
		System.out.println(b.getBankId());
		RequestDispatcher rd = request.getRequestDispatcher("/BankUpdate.jsp");
		rd.forward(request,response);
		
		
	}

}
