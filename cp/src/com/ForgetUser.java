package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForgetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
Dao d=new Dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("i3"));
		String nick=request.getParameter("ni2");
		String pass=d.userforget(id, nick);
		
		if(!(pass.equals("invalid")))
		{
	
			out.println("value of pass is"+pass);
		}
		
		else
		{
			out.println("not valid");
		}
	}

}
