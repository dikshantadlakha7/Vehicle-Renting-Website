<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ page import="com.Dao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int pid=Integer.parseInt(request.getParameter("u"));
 Dao d=new Dao();
 if(d.delete(pid))
	{
	RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
	rd.forward(request, response);
	}
 else
 {
	 out.println(pid);
 }
	%>
</body>
</html>