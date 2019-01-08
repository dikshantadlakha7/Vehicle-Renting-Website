<%@page import="java.sql.ResultSet"%>
<%@page import="com.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="usersearch.jsp" method="post">
<input type="text" name="sear" placeholder="search here">
<input type="submit" value="search">
</form>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("pragma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("id")==null)
{
	response.sendRedirect("userlogin.jsp");
}
%>

<form action="logout" method="post">
<input type="submit" value="logout">
</form>
<form action="filter.jsp" method="post">
<input type="hidden" value="<%request.getParameter("sear");%>" name="name">
<input type="text" name="range">
<input type="submit" value="filter">

</form>
<%
String pname=request.getParameter("sear");
Dao d=new Dao();
ResultSet rs=null;
rs=(ResultSet)(d.search(pname));
while(rs.next())
{
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
</body>
</html>