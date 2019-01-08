package com;

import java.io.IOException;
import java.util.ArrayList;

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
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Expires", "0");
		if(session.getAttribute("id")==null)
		{
			response.sendRedirect("userlogin.jsp");
		}
		String pname=request.getParameter("sear");
		Dao d=new Dao();
		HttpSession ses=request.getSession();
		ses.setAttribute("pro", pname);
		ArrayList<Getter> li=d.searchsecond(pname);
		request.setAttribute("search", li);
		   RequestDispatcher rd=request.getRequestDispatcher("searching.jsp");
		   rd.forward(request, response);
	}

}
