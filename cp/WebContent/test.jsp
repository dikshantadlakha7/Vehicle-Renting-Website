<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


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
<c:forEach var="x" items="${items}">
<c:if test="${i==4}">
<tr></tr>
</c:if>
<td>
<a href="Show?a=${x.pid}&b=${x.pname}&c=${x.milege}&d=${x.price}&e=${x.fileName}">
<img alt="hii" style="width:50px;height:120px;" src="${x.fileName}"><br>
&nbsp;&nbsp; ${x.pname}<br>
&nbsp;&nbsp;${x.price} /day
</a>
</td>
<c:set var="i" value="${i+1}"></c:set>
</c:forEach>
</tr>
</table>
</body>
</html>