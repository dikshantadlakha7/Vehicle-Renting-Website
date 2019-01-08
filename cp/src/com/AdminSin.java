package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSin extends HttpServlet {
	private static final long serialVersionUID = 1L;
Dao d=new Dao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	    PrintWriter out=response.getWriter();
	    System.out.println("hiiiiiiiii");
		int id=Integer.parseInt(request.getParameter("i2"));
	    String name=request.getParameter("n1");
	    String password=request.getParameter("p1");
	    String mail=request.getParameter("m1");
	    String address=request.getParameter("a1");
	    String nick =request.getParameter("nick1");
	    System.out.println("name "+name);
	    if(d.adminsignup(id, name, password, mail, address, nick))
	    {
	    RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
	    rd.forward(request, response);
	    }
	    else
	    {
	    	out.println("somne error");
	    }
	}

	}


