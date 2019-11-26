<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmation</title>
</head>
<body>
<body>
  <jsp:include page="/shared/navbar.jsp" />
 
<form action="placeorder.do">
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
<%-- 				<td align="center"><a
					href="${pageContext.request.contextPath }/cart/remove/${item.product.id }"
					onclick="return confirm('Are you sure?')">Remove</a></td> --%>
				<td>${cartItem.product_id }</td>
				<td>${cartItem.product_name }</td>
				<td>product photo</td>
				<td>${cartItem.price }</td>
				<td>${cartItem.quantity }</td>
				<td>${cartItem.price * cartItem.quantity }</td>
			</tr>
<%-- <c:out value="${cartItem.product_id}"/> &nbsp;<c:out value="${cartItem.quantity}"/>  &nbsp;<c:out value="${cartItem.price}"/><br>  --%>

</c:forEach>

		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total } Rupees</td>
			<td><input type="hidden" name="total" id="total" value="${total}"/></td>
		</tr>
		

	</table>
	
	<input type="submit" value="Confirm order">

</form>
<%-- <c:forEach items="${myorder.orderItem}" var="orderItem">
<c:out value="${orderItem.prodid}"/> &nbsp;<c:out value="${orderItem.quantity}"/>  &nbsp;<c:out value="${orderItem.price}"/><br> 
<hr>
</c:forEach> --%>


<%-- <center><a href="${pageContext.request.contextPath }/placeorder.do" class="btn btn-default">Place Order</a></center> --%>
</body>
</html>