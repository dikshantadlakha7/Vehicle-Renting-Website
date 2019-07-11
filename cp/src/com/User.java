package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao d=new Dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("n1"));
	    String name=request.getParameter("na1");
	    String password=request.getParameter("p1");
	    String mail=request.getParameter("m1");
	    String address=request.getParameter("a1");
	    String nick =request.getParameter("nick1");
	    if(d.adduser(id, name, password, mail, address,nick))
	    {
	    	System.out.println("aaa gayabahauuya");
	    RequestDispatcher rd=request.getRequestDispatcher("userlogin.jsp");
	    rd.forward(request, response);
	    }
	    else
	    {
	    	out.println("somne error");
	    }
	}

}
