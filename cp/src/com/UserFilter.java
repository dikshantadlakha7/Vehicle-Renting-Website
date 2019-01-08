package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
		String pname=request.getParameter("fil");
	  int price=Integer.parseInt(request.getParameter("r1"));
	    //out.println("id"+pid+" price"+price);
	    Dao d=new Dao();
	    HttpSession sess=request.getSession();
	    sess.setAttribute("pr",price);
		   ArrayList<Getter> li=d.searchfilter(pname, price);
			request.setAttribute("items", li);
		   RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
		   rd.forward(request, response);
		   
	}

}