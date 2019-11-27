<%@page import="java.util.List"%>
<%@page import="lti.onlineshopping.service.ProductServiceImpl"%>
<%@page import="lti.onlineshopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  float:left;
  width:75%;
}

.price {
 
  color: grey;
  font-size: 22px;
  
  border: none;
  outline: 0;
  padding: 12px;
  color: black;
  background-color: #a1887f ;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button {
  
}

.footer-distributedsip{
	position:absolute;
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: normal 16px sans-serif;

	padding: 0px -10px;
	margin-top: -950px;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .card {
    width: 100%;
    display: table;
    margin-bottom: 20px;
  }
}


}

body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}
/*magnify  */
.img-magnifier-container {
  position:relative;
}

.img-magnifier-glass {
  position: absolute;
  border: 2px solid #000;
  border-radius: 50%;
  cursor: none;
  /*Set the size of the magnifier glass:*/
  width: 100px;
  height: 100px;
}
</style>
<script>
</script>
</head>
<body>
<div><%@ include file="/shared/navbar.jsp"%></div>
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
</div>
	 
	 <%
	 String url = "addtocart.do";
	 %>
	 
	 <div class="card">
	   <div class="price">

		<div class="w3-third w3-container w3-margin-bottom">
		<div class="img-magnifier-container">
<img src="http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}" height="410" width="320"><br>
	  
			<div class="w3-container w3-white">
		</div>
			
			<script>
				magnify("myimage", 3);
			</script>
			</div>
			</div>
	  <div class="card">
	  <div class="price">
	  <%  //String urls = "http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}" ;
	  
	  String urls="http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}";
	  %>
	  
	  
	<h2>Product Name: <c:out value="${products.product_name }"/></h2>
	<h2><label name="price">Price: <c:out value="${products.unit_price }"/></label></h2>
	Product Description: <c:out value="${products.product_description }"></c:out><br> <br>
	Category: <c:out value="${products.category.category_name}"/><br><br>
	Sub Category: <c:out value="${products.subcategory.sub_name}"/><br> <br>
	Brand: <c:out value="${products.brand}"/><br><br>
	<form action="addtocart.do" method="post">
	<input type="hidden" name="prodid" id="prodid" value="${prodid}"/>

	<label>Quantity:</label>

	<input type="hidden" name="pname" id="pname" value="${products.product_name }"/>
	<input type="hidden" name="unitprice" id="unitprice" value="${products.unit_price }"/>

	Quantity:

	


	<input type="number" name="qty" min="0" step="1" id="qty" required
	title="Please enter the quantity"><br><br>
	<input type="submit" value="Add to cart">
	</form><br>
	<form action="singleproductforcompare.do">
		<input style="margin-left: 33%"  type="submit" value="Add to compare">
	</form>
			</div>
		</div>
	
		</div>
		</div>
	 
	  		</body>

		
		
		<div class="footer-distributedsip"><%@ include file="../../shared/footer.jsp"%></div> 	
	
</body>
</html>