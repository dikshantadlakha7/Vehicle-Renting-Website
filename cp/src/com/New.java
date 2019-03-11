package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao d=new Dao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession ses=request.getSession();
	   PrintWriter out=response.getWriter();
		String userid=(String) ses.getAttribute("userid");
		System.out.println("userid"+userid);
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
		System.out.println(fileName);
 int maxd=(int) ses.getAttribute("ma");
	System.out.println("maxd is"+maxd);
     int qty=(int)ses.getAttribute("qt");
     System.out.println(qty);
     	int pi=Integer.parseInt(pid);
		int qt=d.qtcheck(pi);
		String uname=request.getParameter("t2");
		String phone=request.getParameter("t3");
    	String email=request.getParameter("t4");
		String address=request.getParameter("t5");
	
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportdate = df.format(today);

		// Print what date is today!
		System.out.println("Report Date: " + reportdate);
	
	out.println(" "+userid+" "+pid+" "+pname+" "+milege+" "+price+" "+fileName+" "+maxd+" "+qty+" "+uname+" "+phone+" "+email+" "+address);
	if(d.finalybuy(userid, uname, phone, email, address, pid, pname, milege, price, maxd, fileName, qty,reportdate))
		{
		RequestDispatcher rd=request.getRequestDispatcher("abcd");
		rd.forward(request, response);
		}
		else
		{
			out.println("not buy");
		}
		
	}

}
