package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.BankDao;
import com.nsep.dom.BankDtls;

/**
 * Servlet implementation class BankServlet
 */
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
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
		String bankName = request.getParameter("Bname");
		String city = request.getParameter("city");
		String disablebox = request.getParameter("disablebox");
		String sname = request.getParameter("Sname"); 
		String bcode=request.getParameter("bcode");
		String scontact = request.getParameter("Scontact"); 
		String[] actype = request.getParameterValues("actype");
		String actTypes = "";
		
		for(int i=0;i<actype.length;i++)
		{
			actTypes = actTypes + actype[i] + ",";
		}
		
		//System.out.println("actype:"+actype);
		
		String national = request.getParameter("national"); 
		System.out.println("national:"+national);
		
		BankDtls bankDtls = new BankDtls();
		bankDtls.setBankLocation(city);
		bankDtls.setBankName(bankName);
		bankDtls.setSpocName(sname);
		bankDtls.setMobileNo(Long.parseLong(scontact));
		bankDtls.setTypeOfAccounts(actTypes);
		bankDtls.setBankType(national);
		bankDtls.setBcode(bcode);
		BankDao dao =  new BankDao();
		
		
		PrintWriter out = response.getWriter();
		int flag=dao.verifybank(bankDtls);
		 if(flag!=0)
			 {
			 dao.createBankDtls(bankDtls);
		      
		      out.println("data entered successfully");
			 }
		 else
					
		out.println(" BANK is Registered Already!");
	}

}
