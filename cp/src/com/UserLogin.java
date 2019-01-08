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


public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao d=new Dao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("i1"));
		String uid=request.getParameter("i1");
		String password=request.getParameter("p1");
		if(d.userlog(id, password))
		{
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("userid", uid);
			RequestDispatcher rd=request.getRequestDispatcher("abcd");
			rd.forward(request, response);
			
		}
		else
		{
			out.println("wrong id and password");
		}
		
	}

}
