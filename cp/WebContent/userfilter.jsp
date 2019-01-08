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
<form action="UserS" method="get">
<input type="text" name="sear">
<input type="submit" value="search">
</form>
<table cellspacing="3px" cellpadding="10px">
<tr>
<c:set var="i" value="${0}"/>
<c:forEach var="x" items="${items}">
<c:if test="${i==4}">
<tr></tr>
</c:if>

<td>
<a href="Show?a=${x.pid}&b=${x.pname}&c=${milege}&d=${price}&e=${x.fileName}">
<img alt="hii" style="width:50px;height:120px;" src="${x.fileName}"><br>
&nbsp;&nbsp; ${x.pname}<br>
&nbsp;&nbsp;${x.price}
</a>
</td>
<c:set var="i" value="${i+1}"></c:set>
</c:forEach>
</tr>
</table>
</body>
</html>