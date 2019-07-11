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


public class GoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Dao d=new Dao();
    HttpSession ses=request.getSession();
    String userid=(String) ses.getAttribute("userid");
 System.out.println(userid);
    ArrayList<Get> li=d.gocart(userid);
	ses.setAttribute("item",li);
	System.out.println("hahahahahhaha");
	RequestDispatcher rd=request.getRequestDispatcher("cartopen.jsp");
	rd.forward(request, response);
		
	}

}
