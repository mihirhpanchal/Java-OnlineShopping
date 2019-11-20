<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hello</h2>
	<c:forEach items =  "${retailerlist}" var="retailer">
	<table>
	<div>
	<tr>
	<th> Retailer Id</th>
	<th> Retailer name</th>
	<th> product_name</th>
	<th> product_category</th>
	<th> product_subcategory</th>
	<th>quantity</th>
	<th>products_left</th>
	<th>products_sold</th>
	</tr>
	
	<tr>
	<td><c:out value="${retailer.id}"/></td>
	<td><c:out value="${retailer.retailer_name}"/></td>
	<td><c:out value="${retailer.product_name}"/></td>
	<td><c:out value="${retailer.product_category}"/></td>
	<td><c:out value="${retailer. product_subcategory}"/></td>
	<td><c:out value="${retailer.quantity}"/></td>
	<td><c:out value="${retailer. products_left}"/></td>
	<td><c:out value="${retailer.products_sold}"/></td>
	
	<td><a href="${pageContext.request.contextPath}/removeretailer.do?id=${retailer.id}">Remove</a> </td>
	</tr>
	
	</table>
	
	</div>
	</c:forEach>
	

</body>
</html>
