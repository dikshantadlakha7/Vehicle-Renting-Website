package com;

import java.io.IOException;
import java.io.PrintWriter;

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
		System.out.println("hhii1");
		String userid=(String) ses.getAttribute("userid");
		System.out.println(userid);
		String pid=(String) ses.getAttribute("pp");
		System.out.println(pid);
		String pname=(String) ses.getAttribute("rr");
		System.out.println(pname);
		String milege=(String) ses.getAttribute("ii");
		System.out.println(milege);
		String p=(String) ses.getAttribute("nn");
		int price=Integer.parseInt(p);
		System.out.println(price);
		String fileName=(String) ses.getAttribute("cc");
		int maxd=Integer.parseInt(request.getParameter("max"));
		int  qty=Integer.parseInt(request.getParameter("qt"));
	PrintWriter out=response.getWriter();
	String str=request.getParameter("b1");
	Dao d=new Dao();

	//out.println(a);
  if(str.equals("cart"))
  {
	  if(d.cart(userid, pid, pname, milege, price, maxd, fileName, qty))
	  {
	 
		  out.println("hello");
	  }
	  else
	  {
		  out.println("byee");
	  }
	 
  }
  else if(str.equals("Book"))
	
  {
	  out.println("byeee");
  }
	}

}
