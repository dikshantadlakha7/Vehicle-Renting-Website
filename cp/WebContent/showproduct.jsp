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
<a href="test.jsp"><input type="button" value="home"></a>
<form action="UserS" method="get">
<input type="text" name="sear">
<input type="submit" value="search">
</form>
<c:forEach var="x" items="${sessionScope.detail}">
<table>
<img alt="hii" style="width:200px;height:150px;" src="${x.fileName}">
<tr><td>${x.pid}</td></tr>
<tr><td>name: ${x.pname}</td></tr>
<tr><td>price: ${x.price} per day</td></tr>
<tr><td>${x.milege} km/litre</td></tr>
</table>
</c:forEach>
<c:forEach var="x" items="${detail}">


<form action="Addcart" method="get">
days    <input type="range" name="max" min="0" max="${x.maxd}" required="required"><br>
<br>

quantity<input type="range" name="qt" min="0" max="${x.qty}" required="required"><br>
<br>
<input type="submit" value="Book" name="b1">
<input type="submit" value="cart" name="b1">
</form>
</c:forEach>
</body>
</html>