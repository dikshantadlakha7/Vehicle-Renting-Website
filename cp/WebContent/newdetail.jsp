<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="test.jsp"><input type="button" value="home"></a>

<form action="New" method="Get"> 
user id<input type="text" name="t1" readonly="readonly" value="${sessionScope.userid}"><br>
name<input type="text" name="t2"><br>
phone no<input type="text" name="t3"><br>
Email<input type="text" name="t4"><br>
Address<input type="text" name="t5"><br>
<input type="submit" value="continue">
</form>
</body>
</html>