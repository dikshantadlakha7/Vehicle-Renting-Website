<%@page import="java.sql.ResultSet"%>
<%@page import="com.Dao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="edit.jsp"><input type="button" value="home"></a>
<form action="admsearch.jsp" >
<input type="text" placeholder="search items" name="ser">
<input type="submit" value="search">
</form>
<%
String pname=request.getParameter("ser");
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
<td><%=rs.getString(5)%></td>
<td><%=rs.getString(7)%></td>
<td><a href="delete.jsp?u=<%=rs.getInt(1)%>">remove</a>
<td><a href="update.jsp?u=<%= rs.getInt(1)%>&v=<%= rs.getString(2) %>&w=<%= rs.getString(3) %>&x=<%= rs.getString(4) %>&y=<%= rs.getString(5) %>&z=<%= rs.getString(6) %>">update</a>
</table>
<%
}
%>
</body>
</html>