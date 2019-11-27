<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Added</title>
</head>
<body>
 <header><%@ include file="../../shared/retailernavbar.jsp"%></header> 
<h1> ${product_name}</h1>
<b> added</b>
<br>
<b> ${unit_price}</b>
<br>
Status: ${status} 

 <div class="footer-distributed1"><%@ include file="../../shared/footer.jsp"%></div>
</body>
</html>