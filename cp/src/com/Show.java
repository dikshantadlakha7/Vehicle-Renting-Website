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
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	    int pid=Integer.parseInt(request.getParameter("a"));
	    String ppid=request.getParameter("a");
	    String pname=request.getParameter("b");
	    String milege=request.getParameter("c");
	    String price=request.getParameter("d");
	    String fileName=request.getParameter("e");
	    System.out.println(milege);
	    HttpSession ses=request.getSession();
	    ses.setAttribute("pp", ppid);
	    ses.setAttribute("rr", pname);
	    ses.setAttribute("ii", milege);
	    ses.setAttribute("nn", price);
	    ses.setAttribute("cc", fileName);
	   Dao d=new Dao();
	   ArrayList<Getter> li=d.showp(pid);
		ses.setAttribute("detail", li);
	   RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
	   rd.forward(request, response);
	
	}

}
