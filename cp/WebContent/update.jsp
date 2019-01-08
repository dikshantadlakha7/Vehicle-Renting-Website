<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int pid=Integer.parseInt(request.getParameter("u")); 
//request.setAttribute("pid", pid);
String pname=request.getParameter("v"); 
String milege=request.getParameter("w");
String price =request.getParameter("x"); 
String maxd=request.getParameter("y"); 
String fileName=request.getParameter("z");
String qty=request.getParameter("a");
%>
<img alt="hi" style="width:50px;height:120px;"  src="<% out.println(fileName);  %>">
<form action="hi" method="post">
  product id<input type="text" name="pr1" value="<%=pid%>">
  product name<input type="text" name="pname" value="<%= pname %>" ><br>
  milege<input type="text" name="ml1" value="<% out.println(milege); %>">  km/liter<br>
  price <input type="text" name="pr" value="<% out.println(price); %>">  /day<br>
  maxd <input type="text" name="max" value="7" readonly="readonly">
  qty<input type="text" name="qt" value="<%=qty%>">
  
  <input type="submit" value="update">
  </form>
</body>
</html>