<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
  <jsp:include page="/shared/navbar.jsp" />
 <c:if test="${empty mycart or empty mycart.cartItem}">
       <h2>There is no items in Cart</h2>
       <a href="${pageContext.request.contextPath}/viewallprod.do">Show
           Product List</a>
 </c:if>
 <c:if test="${not empty mycart and not empty mycart.cartItem}">
 <form action="orderconfirm.do">
 <c:set var="total" value="0"></c:set>
 <table align="center" cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
</tr>

<c:forEach items="${mycart.cartItem}" var="cartItem">
<c:set var="total" value="${total + cartItem.price * cartItem.quantity }"></c:set>
<tr>
				<td>${cartItem.product_id }</td>
				<td>${cartItem.product_name }</td>
				<td>product photo</td>
				<td>${cartItem.price }</td>
				<td>${cartItem.quantity }</td>
				<td>${cartItem.price * cartItem.quantity }</td>
			</tr>

</c:forEach>



		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total } Rupees</td>
			<td><input type="hidden" name="total" id="total" value="${total}"/></td>
		</tr>	
	</table>
	<input type="submit" value="Confirm order">
</form>
</c:if>
  <jsp:include page="/shared/footer.jsp" />
</body>
</html>