package com;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
		maxFileSize= 1024*1024*5,
		fileSizeThreshold=1024*1024*5,
		maxRequestSize=1024*1024*5
		)

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

		public String extractFileName(Part part)
		{
		
			String d="flag";
			 String c = part.getHeader("content-disposition");
			 //c= form-data; name="file"; filename="IMG-20161006-WA0027.jpg"
			 System.out.println(c+"\n");
		            if (c.contains("filename")) {
		                return c.substring(c.lastIndexOf("\\") + 1, c.length()-1);
			}
		
		return d;
		}

           
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao da=new Dao();
	
		int pid=Integer.parseInt(request.getParameter("pr1"));
		
	  String pname=request.getParameter("pname");
	
	  String milege=request.getParameter("ml1");
	  
	  String price=request.getParameter("pr");
	  
	  String maxd=request.getParameter("max");
	  
	  String qty=request.getParameter("qt");
	  
	  String savePath = "C:\\Users\\Dikshant\\eclipse-workspace\\cp\\WebContent\\image";
	  String savepath1= "C:\\Users\\Dikshant\\eclipse-workspace\\cp\\WebContent";
	  System.out.println("hiiiiii7");
		String fileName="";
		  System.out.println("hiiiiii8");
      File fileSaveDir = new File(savePath);
      File fileSaveDir1 = new File(savepath1);
      System.out.println("hiiiiii9");
      for (Part part : request.getParts()) {
    	  System.out.println("hiiiiii**");
      	 fileName = extractFileName(part);  // photo
      	  
          if(fileName!="flag") 
          {
        	  System.out.println("suc.");
       	System.out.println(fileName);
          part.write(fileSaveDir + File.separator + fileName);
          part.write(fileSaveDir1 + File.separator + fileName);
         
		
	}
   
//System.out.println(" "+name+" "+fileName);


      }
      PrintWriter out=response.getWriter();
      System.out.println(milege+" "+pname+" "+fileName+" "+pid);
    if(da.addimage(pid, pname, milege, price, maxd, fileName, qty))
    {
    	RequestDispatcher rs=request.getRequestDispatcher("edit.jsp");
    	out.println("product added");
        rs.include(request, response);    	
    }
    else
    {
    	out.println("not uploaded");
    }
	}
	}
