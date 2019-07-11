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


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao d=new Dao();
		ArrayList<Getter> li=d.getallitems();
		HttpSession ses=request.getSession();
		ses.setAttribute("items", li);
		RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
		rd.forward(request, response);

	}

}
