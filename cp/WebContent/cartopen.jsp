<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="x" items="${sessionScope.items}">
<tr>
<td><img alt="hii" style="width:50px;height:120px;" src="${x.fileName}"></td>
<td>${x.pname}</td>
<td>${x.milege}</td>
<td>${x.price}</td>
<td>${x.maxd}</td>
<td>${x.qty}</td>
<td><a href="Cdelete?a=${x.pid}">delete</a></td>
<td><a href="Cbuy?a=${x.pid}&b=${x.pname}&c=${x.milege}&d=${x.price}&e=${x.maxd}&f=${x.fileName}&g=${x.qty}">book</a>
</tr>
</c:forEach>
</table>



</body>
</html>