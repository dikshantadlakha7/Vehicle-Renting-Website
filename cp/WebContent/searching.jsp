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
<form action="UserFilter" method="get">
<input type="hidden" name="fil" value="${sessionScope.pro}">
<input type="radio" name="r1" value="500">under 500<br>
<input type="radio" name="r1" value="1500">under 1500<br>
<input type="radio" name="r1" value="2000">under 2000<br>
<input type="radio" name="r1" value="2500">under 2500<br>
<input type="submit" value="filter">
</form>
<c:forEach var="x" items="${search}">
<table>
<tr>
<td>
<a href="Show?a=${x.pid}&b=${x.pname}&c=${x.milege}&d=${x.price}&e=${x.fileName}">
<img alt="hii" style="width:50px;height:120px;" src="${x.fileName}"><br>
&nbsp;&nbsp; ${x.pname}<br>
&nbsp;&nbsp;${x.price}
</a>
</td>
</table>

</c:forEach>
</body>
</html>