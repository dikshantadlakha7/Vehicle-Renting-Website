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


public class Addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession();
		Dao d=new Dao();
		String userid=(String) ses.getAttribute("userid");
		String pid=(String) ses.getAttribute("pp");
		String pname=(String) ses.getAttribute("rr");
		String milege=(String) ses.getAttribute("ii");
		String p=(String) ses.getAttribute("nn");
		int price=Integer.parseInt(p);
		String fileName=(String) ses.getAttribute("cc");
		int maxd=Integer.parseInt(request.getParameter("max"));
		int qty=Integer.parseInt(request.getParameter("qt"));
	 ses.setAttribute("ma",maxd);
    ses.setAttribute("qt",qty);
		int pi=Integer.parseInt(pid);
 		int chd=d.check(pi,pname);
		int qt=d.qtcheck(pi);
		int cartqt=d.usercart(userid, pid);
		PrintWriter out=response.getWriter();
		String str=request.getParameter("b1");
        int total=qty+cartqt;
  if(str.equals("cart"))
  {
	  if(d.idcheck(userid, pid))
	  { 
	  if(total<=qt)
	  {
		  if(d.updatecart(userid, pid, total))
		  {
			  RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
			  out.println("added");
			  rd.include(request,response);
		  }
		  
	  }
	  else
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
		  out.println("plz reduce the quantity");
		  rd.include(request, response); 
	  }
	  }
	  else if(total<=qt)
	  {
	  
	  if(d.cart(userid, pid, pname, milege, price, maxd, fileName, qty))
	  {
	 
		  RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
		  out.println("added");
		  rd.include(request,response);
	  }
	  else
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
		  out.println("not added");
		  rd.include(request,response);
	  }
	  } 
	  else
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("showproduct");
		  out.println("plz reduce limit");
		  rd.include(request, response);
	  }
		
  }
  
   if(str.equals("Book"))
  {
	   
	   
	  RequestDispatcher rd=request.getRequestDispatcher("newdetail.jsp");
	  out.println("plz fill this");
	  rd.include(request, response);
  }
	}

}
