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
int pid=Integer.parseInt(request.getParameter("u"));
ResultSet rs=null;
Dao d=new Dao();
rs=(d.userclick(pid));
if(rs.next())
	{
	%>	
   <table>
<tr>
<td><img alt="hiii" style="width:50px;height:120px;" src="<%= rs.getString(6)%>"></img></td>
<td><%= rs.getInt(1)%></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
   
   </table>
	<%
	}

%>



</body>
</html>