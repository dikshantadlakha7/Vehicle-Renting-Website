package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Dao d=new Dao();
		PrintWriter out=response.getWriter();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Expires", "0");
		if(session.getAttribute("id")==null)
		{
			response.sendRedirect("userlogin.jsp");
		}
		
		String i=request.getParameter("val");
		if(i==null || i.trim().equals("")){  
			out.print("");  
			}
		else if(i!=null)
	    {
	    	ArrayList<Getter> li=d.searchsecond(i);
	    	  Iterator itr=li.iterator();  
	    for(Getter g:li)
	    {
	       out.println(g.getPname());
	    }
	    	
	    }
	    else
	    {
	    	out.println(" ");
	    }
		
		String pname=request.getParameter("sear");
		
		if(pname!=null)
		{
		HttpSession ses=request.getSession();
		ses.setAttribute("pro", pname);
		ArrayList<Getter> li=d.searchsecond(pname);
		request.setAttribute("search", li);
		   RequestDispatcher rd=request.getRequestDispatcher("searching.jsp");
		   rd.forward(request, response);
	}
	}

}
