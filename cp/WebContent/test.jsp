<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<script>  
var request;  
function sendInfo()  
{  
var v=document.vinform.sear.value;  
var url="UserS?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('amit').innerHTML=val;  
}  
}  
  
</script>  


</head>
<body>
<center>
<a href="GoCart?">go to cart</a>
</center>
<form action="UserS" name="vinform" method="get">
<input type="text" name="sear" onkeyup="sendInfo()" >
<input type="submit" value="search">
</form>
<span id="amit"> </span>  

<table cellspacing="3px" cellpadding="10px">
<tr>
<c:set var="i" value="${0}"/>

<div class="row">
<c:forEach var="x" items="${sessionScope.items}">
<div class="col-sm-6">
<div class="card" >
<a href="Show?a=${x.pid}&b=${x.pname}&c=${x.milege}&d=${x.price}&e=${x.fileName}">
  <img src="${x.fileName}" class="card-img-top" alt="Image not Found">

  <div class="card-body">
    <h5 class="card-title">${x.pname}</h5>
    <h4 class="card-title">${x.price}</h4>
  </div>
 </a>
 
</div>
</div>
</c:forEach>
</div>

</body>
</html>