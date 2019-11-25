<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single Product</title>
</head>
<body>

<form action="addtocart.do" method="post"  >
<input type="hidden" name="prodid" id="prodid" value="${prodid}"/>
Quantity 
<input type="text" name="qty" id="qty"/>
<input type="submit" value="submit">
</form>
</body>
</html>