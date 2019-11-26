<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.container1{
position:absolute;
top:22%;
left:28%;
width:52%;
height:75%;
font-family:arial;
z-index:100;
background-color:#F1F1F1;
}
.signup{
position:relative;
width:35%;
right:2%;
height:100%;
color:white;
font-size:30px;
font-weight:bold;
z-index:101;
background-color:#211935;
line-height:180px;
}
input[type=submit] {
  background-color: #263238 ;
  color: white;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #263238 ;
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

.footer-distributed1{
	position:absolute;
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: normal 16px sans-serif;

	padding: 0px 0px;
	margin-top: -400px;
}


</style>
</head>
<body>
 <header><%@ include file="../../shared/navbar.jsp"%></header> 
<div class="container1">

<div class="col" style="position:absolute;top:150px;left:315px;width:50%;z-index:105">
<form action="loginProcess.do">
        <input type="text" name="username" placeholder="Username" required> <br><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        <input type="submit" value="Login">
</form>
	<p style="font-style: italic; color: red;">${message}</p>
	</div>
<div class="signup">&nbsp;&nbsp;&nbsp;&nbsp;Login<br>
<span style="position:absolute;top:120px;left:30px;font-size:21px;line-height:22px;width:150px">Get access to your Orders, Wishlist and Recommendations
</span></div>

</div>

 <div class="footer-distributed1"><%@ include file="../../shared/footer.jsp"%></div>
</body>
</html>