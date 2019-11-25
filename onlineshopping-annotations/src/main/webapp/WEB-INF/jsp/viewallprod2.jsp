<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
<c:forEach items="${products}" var="product">
<div>
	<%-- <h1>Product Name: <c:out value="${product[0].product_name }"/></h1><br>
	<h2>Price: <c:out value="${product.unit_price }"/></h2><br>
	Product Description:<c:out value="${product.product_description }"></c:out><br>
	Category<c:out value="${product.category_name}"/><br>
	Sub Category<c:out value="${product.sub_name}"/><br> --%>
	<%-- Brand:<c:out value="${product.brand}"/><br> --%>
	<h1>Product Name: <c:out value="${product_name}"/></h1><br>
	//<h2>Price: <c:out value="${product[1]}"/></h2><br>
	Product Description:<c:out value="${product[2] }"></c:out><br>
	Category<c:out value="${product[3]}"/><br>
	Sub Category<c:out value="${product[4]}"/><br> 
	Brand:<c:out value="${product[5]}"/><br> 
</div>
</c:forEach>
</body>
</html>