<%@page import="com.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String pname=request.getParameter("name");
String price=request.getParameter("range");
System.out.println(" hiiiiiiiii"+pname);
int pr=Integer.parseInt(price);
System.out.println("hiiii2");
Dao d=new Dao();
System.out.println("hiiii13");
ResultSet rs=null;
System.out.println("hiiii4");
rs=(ResultSet)(d.search(pname));
System.out.println("hiiii5");
while(rs.next())
{
	String a=rs.getString(4);
	int b=Integer.parseInt(a);
	System.out.println(b);
	System.out.println(pr);
	
	
	
%>
<table>
<tr>
<td><img alt="hiii" style="width:50px;height:120px;" src="<%= rs.getString(6)%>"></img></td>
<td><%= rs.getInt(1)%></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getString(4)%></td>
<td><%=  rs.getString(5)%></td>
<td>
</table>
<%
}

%>
<%

%>

</body>
</html>