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

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("pragma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("id")==null)
{
	response.sendRedirect("userlogin.jsp");
}
%>
<form action="usersearch.jsp" method="post">
<input type="text" name="sear" placeholder="search here">
<input type="submit" value="search">

</form>
<form action="logout" method="post">
<input type="submit" value="logout">
</form>
<table cellspacing="3px" cellpadding="10px">
<tr>
<%
Dao d=new Dao();
ResultSet rs=null;
rs=(ResultSet)d.showall();
int i=0;
while(rs.next())
{
	if(i==4)
	{
		out.println("<tr><tr>");
		i=0;
	}
i++;
%>

<td>
<a href="showdetail.jsp?u=<%= rs.getInt(1)%>">
<img alt="hii" style="width:50px;height:120px;" src="<%= rs.getString(6)  %>">
<br>
<%= rs.getString(2) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>price/day:<%= rs.getString(4) %>
<br>
</a>
</td>
<%
}
%>
</tr>
</table>
</body>
</html>