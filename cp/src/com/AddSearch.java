package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("ser"); 
PrintWriter out=response.getWriter();
		Dao d=new Dao();
		ResultSet rs=null;
		rs=(ResultSet)(d.search(pname));
		
		try {
			while(rs.next())
			{
				int a=rs.getInt(1);
				String b=rs.getString(2);
				String c=rs.getString(3);
				String e=rs.getString(4);
				String f=rs.getString(5);
				String g=rs.getString(6);
			out.println("<html><body>");
			out.println("<tr><td><img src="+g+" style=\"width:50px;height:120px;\"></td>");
			out.println("<tr><td>"+a+"</td>");
			out.println("<tr><td>"+b+"</td>");
			out.println("<tr><td>"+c+"</td>");
			out.println("<tr><td>"+e+"</td>");
			out.println("<tr><td>"+f+"</td>");
			out.println("<tr><td>"+g+"</td>");
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
