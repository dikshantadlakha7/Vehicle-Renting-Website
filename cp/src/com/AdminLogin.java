package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao d=new Dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("i3"));
		String password=request.getParameter("pass2");
		if(d.adminlog(id, password))
			
		{
		 RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
		 rd.forward(request, response);
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
			out.println("plz enter valid id and password");
			rd.include(request, response);
		}
		
		
	}

}
