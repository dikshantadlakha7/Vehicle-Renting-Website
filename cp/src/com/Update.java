package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao d=new Dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		System.out.println("servley page");
		  String pname=request.getParameter("pname");
		  int pid=Integer.parseInt(request.getParameter("pr1"));
		  String milege=request.getParameter("ml1");
		  String price=request.getParameter("pr");
		  String qty=request.getParameter("qt");
		  HttpSession ses=request.getSession();
		   response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		   response.setHeader("Progress", "no-cache");
		   response.setHeader("Expires", "0");
			if(ses.getAttribute("login")==null)
			{
				RequestDispatcher rs=request.getRequestDispatcher("adminlogin.html");
				 rs.forward(request, response);
			}
if(d.update(pid, pname, milege, price,qty))
{
	RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
    rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
	out.println("updation fail");
	rd.include(request, response);
}
   

		  
	}

}
