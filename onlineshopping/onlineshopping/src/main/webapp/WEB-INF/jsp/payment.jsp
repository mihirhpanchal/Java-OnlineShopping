<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<form id ="payform"  action="payment.do" method="post" >

<tr>
<td> Select Payment option</td>
	<td><select name="category">
	<td><option value="Card">Card</option>
  <option value="COD">COD</option></td>
  </select>
	</tr>

<tr>
<td> Card Number:</td>
<td><input type="text" name="card_number"id="card_number"/></td>
</tr>
<tr>
<td></td>
</tr> 
<tr>
	<td><input type="radio" name="card_type"id="debit" value="debit" checked/>Debit Card</td>
		<td><input type="radio" name="card_type"id="credit" value="credit" checked/>Credit Card
</td>
</tr>
<tr>
<td></td>
</tr> 

<tr>
<td></td>
</tr> 
<tr>
	<td>Cvv</td>
	<td><input type="password" name="cvv" id="cvv"/></td>
</tr>
<tr>
<td></td>
</tr> 
<tr>
<td></td>
</tr> 

<tr>
<td> Expiry Date</td>
<td><input type="date" name="expirydate" id="expirydate"/></td>
</tr>
<tr>
<td></td>
</tr> 
<input type="Submit" value="Make Payment"/>	
	


</form>
</table>

</body>
</html>