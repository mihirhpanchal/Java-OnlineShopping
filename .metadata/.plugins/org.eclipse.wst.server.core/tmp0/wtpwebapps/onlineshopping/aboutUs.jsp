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
<%@ include file="/shared/navbar.jsp"%>

<!-- Content -->
	<div class="row" style="margin-top:4px; margin-right:0px; margin-left:0px;margin-bottom:19px ">
		<div class="col-sm-4" style="margin-top:0px">
			<div class="container-fluid bg-1 text-center">
				<h3>Who Am I?</h3>
				<img src="<c:url value="/assests/images/aboutImage.png"/>" class="img-circle" alt="AboutUs" width="350"
					height="350">
				<h3>ShopIeasy a WorldWide E-Commerce Site</h3>
			</div>

		</div>

		<div class="container-fluid bg-2 text-center">
			<h3>What Am I?</h3>
			<div id="para"><p>ShopIeasy's vision is to create India's most reliable and
				frictionless commerce ecosystem that creates life-changing
				experiences for buyers and sellers.</p>
			</div>
			<div id="para"><p>We have always taken pride in our culture. There are some core
				values that have been inherent and are an integral part of our
				success story. These values are a pure reflection of what is
				important to us as a Team and Business..</p>
		</div></div>
	</div>
	
<!-- 	importing footer  -->
<%@ include file="/shared/footer.jsp"%> 

</body>
</html>