<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admsearch.jsp" >
<input type="text" placeholder="search items" name="ser">
<input type="submit" value="search">
</form>
<a href="addproduct.jsp"><input type="button"  value="for add"></a>
<s:setDataSource var="db" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/college" user="root" password="12345" />
<s:query var="rs" dataSource="${db}">
   select * from product;
</s:query>
<table>
<c:forEach var="x" items="${rs.rows}">
<tr><td><img alt="hii" src="${x.fileName}" style="width:50px;height:120px;"><td>${x.pid}</td><td>${x.pname}</td>
<td>${x.milege}</td><td>${x.price}</td><td>${x.maxd}</td><td>${x.qty}</td><td><a href='delete.jsp?u=${x.pid }'>remove</a>
</td><td><a href='update.jsp?u=${x.pid}&v=${x.pname}&w=${x.milege}&x=${x.price}&y=${x.maxd}&z=${x.fileName}&a=${x.qty}'>update</a></td>
</c:forEach>



</table>
</body>
</html>