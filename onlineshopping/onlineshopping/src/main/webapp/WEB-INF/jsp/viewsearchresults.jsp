<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<div><%@ include file="/shared/navbar.jsp"%></div>
<c:forEach items="${searchList}" var="product">
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
	
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 30%; height: 30%;"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<h1>Product Name: <c:out value="${product.product_name }"/></h1><br>
	<h2>Price: <c:out value="${product.unit_price }"/></h2><br>
	Product Description:<c:out value="${product.product_description }"></c:out><br>
	Category:<c:out value="${product.category.category_name}"/><br>
	Sub Category:<c:out value="${product.subcategory.sub_name}"/><br> 
	Brand:<c:out value="${product.brand}"/><br>
			</div>
		</div>
	</div>
</c:forEach>
<div><%@ include file="../../shared/footer.jsp"%></div>
</body>
</html>