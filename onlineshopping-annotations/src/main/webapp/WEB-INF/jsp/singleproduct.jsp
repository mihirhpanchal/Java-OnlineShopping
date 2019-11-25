<%@page import="java.util.List"%>
<%@page import="lti.onlineshopping.service.ProductServiceImpl"%>
<%@page import="lti.onlineshopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="security" --%>
<%-- 	uri="http://www.springframework.org/security/tags"%> --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}
</style>
</head>
<body>
<div><%@ include file="/shared/navbar.jsp"%></div>
<%-- <%
int prodid;
Product products = null;
 products = new ProductServiceImpl().compareProduct(products.getProduct_id());
%> --%>
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
	<%-- <c:forEach items="${products}" var="product"> --%>
	 <%-- <%
	    for( Object[] product :products){
	         String url = "singleproduct.do?prodid="+product[0]; 		    
	 %> --%>
	 
	 
	 <%
	 String url = "addtocart.do";
	 %>
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<h1>Product Name: <c:out value="${products.product_name }"/></h1><br>
	<h2>Price: <c:out value="${products.unit_price }"/></h2><br>
	Product Description:<c:out value="${products.product_description }"></c:out><br>
	Category<c:out value="${products.category.category_name}"/><br>
	Sub Category<c:out value="${products.subcategory.sub_name}"/><br> 
	Brand:<c:out value="${products.brand}"/><br>
	<button><a href="<%=url%>">Add to Cart</a></button>
			</div>
		</div>
	<%-- <hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<h1>Product Name: <c:out value="${products.product_name }"/></h1><br>
	<h2>Price: <c:out value="${products.unit_price }"/></h2><br>
	Product Description:<c:out value="${products.product_description }"></c:out><br>
	Category<c:out value="${products.category.category_name}"/><br>
	Sub Category<c:out value="${products.subcategory.sub_name}"/><br> 
	Brand:<c:out value="${products.brand}"/><br>
			</div>
		</div> --%>
	<!-- </div> -->
	<div><%@ include file="../../shared/footer.jsp"%></div> 
</body>
</html>