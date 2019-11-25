<%@page import="lti.onlineshopping.service.ProductServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to cart</title>
</head>
<body>
<%
List<Object[]> products = new ProductServiceImpl().getmyUsers();
System.out.println(products.size());
%>	
	 		<h3>Products Page</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Buy</th>
		</tr>
		<%
		 for( Object[] product :products){ 
		%>
			<tr>
				<td><%=product[0]%></td>
				<td><%=product[1]%></td>
				<td><%=product[2]%></td>
				<td align="center">
				<%int product_id = Integer.parseInt(product[0].toString()) ;%>
					<a href="${pageContext.request.contextPath }/buy/${product_id}">Buy Now</a>
				</td>
			</tr>
<%
	    }
%>
</table>
</body>
</html>