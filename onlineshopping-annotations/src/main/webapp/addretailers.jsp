<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

.container{
position:absolute;
top:25%;
left:17%;
width:55%;
height:85%;

font-family:arial;
z-index:100;
background-color:#F1F1F1;
}

.addretailer{
position:relative;


padding-left: 176px;
color:black;

font-size:20px;
font-weight:bold;


line-height:35px;

}


input[type=submit] {
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
input,
.btn {
  width: 100%;
  padding: 12px;
  border: none;
  border-radius: 4px;
  margin: 5px 0;
  opacity: 0.85;
  display: inline-block;
  font-size: 17px;
  line-height: 20px;
  text-decoration: none; /* remove underline from anchors */
}


input:hover,
.btn:hover {
  opacity: 1;
}

@media screen and (max-width: 600px) {
  .col-25, .col-75, .container, .product, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

</style>
</head>
<body>

 <header><%@ include file="shared/navbar.jsp"%></header> 

<div class="container">

<div class="addretailer">Add Retailer<br> </div>

<div class="col" style="position:absolute;top:65px;left:175px;width:50%;z-index:105">

	<form action="addretailers.do" method="post">

			<label> Enter Retailer's Id :</label>
			<input type="text"  name="t1" pattern= "[0-9]+" placeholder="Retailer id" autofocus required  
			title="Please enter the Numeric Values.."/>
			<br><br>
			
			<label> Enter Retailer's Name :</label>
			<input type="text"  name="t2" pattern="[A-Za-z]+" placeholder="Retailer Name" autofocus required 
				title="Name should not contain Numeric Values.."/>
				<br><br>
		
		<label>Enter Retailer's Email :</label>
		<input type="email" name="t3" placeholder="aaa@xyz.com" autofocus required />
		<br><br>
		
		<label> Enter Mobile No :</label>
		<input type="text" name="t4" pattern="[789][0-9]{9}" placeholder="Mobile no" autofocus required
				title="Values should be Numeric and It should be of 10 digits only"/>
				<br><br>
			<input type ="submit" value="Add Retailer" />
	

	
</div>
</form>
</div>
<div class="footer" style="position:absolute;top:-235px;left:0px;width:100%;z-index:105">
 <div><%@ include file="shared/footer.jsp"%></div>
 </div>
</body>
</html>