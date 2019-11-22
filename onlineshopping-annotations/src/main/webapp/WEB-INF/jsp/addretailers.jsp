<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addretailers.do" method="post" modelattribute="adminretailers">
	<table>
		
		<tr>
			<td> Enter Retailer's Name :<input type="text" name="retailername" placeholder="name" required/></td>
			</tr>
			<tr></tr>
		<tr>
			<td> Enter Retailer's Email :<input type="email" name="email" placeholder="aaa@xyz.com" required/></td>
			</tr>
		<tr>      </tr>
		
		<tr>
			<td> Enter Mobile No :<input type="text" name="mobileno" placeholder="mobile no" required/></td>
			</tr>
		<tr></tr>
			<tr><td><input type ="submit" value="Add" required/><td></tr>
	
	</table>
	

</form>
</body>
</html>