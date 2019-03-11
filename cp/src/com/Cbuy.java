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


public class Cbuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	HttpSession ses=request.getSession(); 
		String pid=request.getParameter("a");
		String pname=request.getParameter("b");
		String milege=request.getParameter("c");
		String  price=request.getParameter("d");
	    int maxd=Integer.parseInt(request.getParameter("e"));
	    String fileName=request.getParameter("f");
	    int qty=Integer.parseInt(request.getParameter("g"));
	    out.println(pid+" "+pname+" "+milege+" "+price+" "+maxd+" "+fileName+" "+qty);
	    ses.setAttribute("pp", pid);
	    ses.setAttribute("rr", pname);
	    ses.setAttribute("ii", milege);
	    ses.setAttribute("nn", price);
	    ses.setAttribute("cc", fileName);
	    ses.setAttribute("ma",maxd);
	    ses.setAttribute("qt",qty);	    
	    RequestDispatcher rd=request.getRequestDispatcher("newdetail.jsp");
		  out.println("plz fill this");
		  rd.include(request, response);
		
	}

}
