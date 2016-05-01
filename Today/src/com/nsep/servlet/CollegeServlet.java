package com.nsep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsep.dao.BankDao;
import com.nsep.dao.CollegeDao;
import com.nsep.dom.BankDtls;
import com.nsep.dom.ColDtls;

/**
 * Servlet implementation class ColDtls
 */
public class CollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeServlet() {
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
	
		String cName = request.getParameter("Cname");
		String city = request.getParameter("city");
		String sname = request.getParameter("SPOCname"); 
		String scontact = request.getParameter("SPOCcontactno"); 
		String affl=request.getParameter("affiliated");
		String code=request.getParameter("code");
		String[] courses = request.getParameterValues("courses");
		String cour = "";
		
		for(int i=0;i<courses.length;i++)
		{
			cour = cour + courses[i] + ",";
		}
		
		ColDtls coldtls=new ColDtls();
		coldtls.setcName(cName);
		coldtls.setcLocation(city);
		coldtls.setCspocName(sname);
		coldtls.setCmobileNo(Long.parseLong(scontact));
		coldtls.setcType(affl);
		coldtls.setCtypeOfcourses(cour);
		coldtls.setcCode(code);
		CollegeDao dao =  new CollegeDao();
		
		
		PrintWriter out = response.getWriter();
		int flag=dao.verifycollege(coldtls);
		 if(flag!=0)
			 {
			 dao.createColDtls(coldtls);
		      
		      out.println("data entered successfully");
			 }
		 else
					
		out.println(" College is Registered Already!");
		
		
		
	}

}
