<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="<c:url value="/assets/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/css/overall.css"/>">

</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<div class="nav navbar">
		</div>

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">VPshop.ML</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href=" <c:url value="/" />">Home</a></li>
				<li><a href=" <c:url value="viewallprod.do" />">Product
						List</a></li>
				<li><a href=" <c:url value="/aboutUs.jsp" />">About Us</a></li>
				
<!-- 				<security:authorize access="hasRole('ROLE_USER')"> -->
				<li><a href=" <c:url value="/contact.jsp" />">Contact Us</a></li>
<!-- 				</security:authorize> -->
				
				<!-- 			Only admin can view this link -->
<!-- 				<security:authorize access="hasRole('ROLE_ADMIN')"> -->
					<li><a href=" <c:url value="regproduct.jsp" />">Add
							Product</a></li>
<!-- 				</security:authorize> -->
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<c:if test="${!empty pageContext.request.userPrincipal.name}">
					<li><a href="<c:url value="/index" />"><span
							class="glyphicon glyphicon-shopping-user"></span>Welcome..${pageContext.request.userPrincipal.name}</a></li>

<!-- 					<security:authorize access="hasRole('ROLE_USER')"> -->
						<li><a href="<c:url value="/viewmycart.do" />"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
<!-- 					</security:authorize> -->
					<li><a href="<c:url value="/logout" />"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
			</ul>


			<ul class="nav navbar-nav navbar-right">

				<c:if test="${pageContext.request.userPrincipal.name==null}">
					<li><a href="<c:url value="/viewmycart.do" />"><span
							class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li>
					<li><a href="<c:url value="/signup.do" />"><span
							class="glyphicon glyphicon-log-user"></span> SignUp</a></li>
					<li><a href="<c:url value="/login.do" />"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>



</body>
</html>