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


public class Prev extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	out.println("finally reached");
	HttpSession ses=request.getSession();
	String userid=(String) ses.getAttribute("userid");
	Dao d=new Dao();
    ArrayList<Get> li=d.prevdetails(userid);
	ses.setAttribute("items",li);
	RequestDispatcher rd=request.getRequestDispatcher("previous.jsp");
	rd.forward(request, response);
	}

}
