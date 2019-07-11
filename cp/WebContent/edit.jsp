<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<%


   response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
   response.setHeader("Progress", "no-cache");
   response.setHeader("Expires", "0");

  
if(session.getAttribute("login")==null)
{
	RequestDispatcher rs=request.getRequestDispatcher("adminlogin.html");
	 rs.forward(request, response);
}


%>
<form action="LogoutAdmin" method="get">
<input type="submit" value="logout">
</form>
<h1>check for all bookings</h1>
<a href="Count">click here</a>
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
<div class="row">
<c:forEach var="x" items="${rs.rows}">
<div class="col-sm-6">
<div class="card" style="width: 18rem;">
  <img src="${x.fileName}" class="card-img-top" alt="Image not Found">
  <div class="card-body">
    <h5 class="card-title">${x.pname}</h5>
    
  </div>
  <ul class="list-group list-group-flush">
  	<li class="list-group-item">ID = ${x.pid}</li>
    <li class="list-group-item">Mileage = ${x.milege}</li>
    <li class="list-group-item">Price = ${x.price}</li>
    <li class="list-group-item">Max Days = ${x.maxd}</li>
    <li class="list-group-item">Quantity = ${x.qty}</li>
  </ul>
  <div class="card-body">
    <a href="delete.jsp?u=${x.pid }" class="card-link">Delete Item</a>
    <a href="update.jsp?u=${x.pid}&v=${x.pname}&w=${x.milege}&x=${x.price}&y=${x.maxd}&z=${x.fileName}&a=${x.qty}" class="card-link">Update Item</a>
  </div>
</div>
</div>
</c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>