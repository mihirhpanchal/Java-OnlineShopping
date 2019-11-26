<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AboutUs</title>
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/css/aboutus.css"/>">
<link rel="icon" type="image/x-icon" href="<c:url value="/assets/images/favicon1.png"/>" />
</head>

<body>

<!-- importing navigation bar -->
<div><%@ include file="/shared/navbar.jsp"%></div>

<!-- Content -->
	<div class="row" style="margin-top:4px; margin-right:0px; margin-left:0px;margin-bottom:19px ">
		<div class="col-sm-4" style="margin-top:0px">
			<div class="container-fluid bg-1 text-center">
				
				
				<h3>VPShop.ML a WorldWide E-Commerce Site</h3>
			</div>

		</div>

		<div class="container-fluid bg-2 text-center">
			
			<div id="para"><p>We have developed this Online Shopping Website for easy Buying...</p>
	
			</div>
			<div id="para"><p>We are trying to provide the Best Service in our Website.. Customers are our First Priority...!!!</p>
		</div></div>
	</div>
	
<!-- 	importing footer  -->
<%@ include file="/shared/footer.jsp"%> 

</body>
</html>