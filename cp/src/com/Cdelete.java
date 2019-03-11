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


public class Cdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Dao d=new Dao();
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		String pid=request.getParameter("a");
		String userid=(String) ses.getAttribute("userid");
		out.println(pid+" "+userid);
		if(d.cdel(pid, userid))
		{
		response.sendRedirect("GoCart");
		}
		
	}

}
