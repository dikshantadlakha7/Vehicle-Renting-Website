<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addp" method="post" enctype="multipart/form-data" >
  product id<input type="text" name="pr1">
  product name<input type="text" name="pname"><br>
  milege<input type="text" name="ml1">  km/liter<br>
  price <input type="text" name="pr">  /day<br>
  maxd <input type="text" name="max" value="7" readonly="readonly">
  quantity<input type="text" name="qt">
  <input type="file" name="image">
  <input type="submit">
  </form>
</body>
</html>