<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.container{
position:absolute;
top:12%;
left:28%;
width:45%;
height:75%;
font-family:arial;
z-index:100;
background-color:#F1F1F1;
}
.signup{
position:relative;
width:40%;
height:100%;
color:white;
font-size:30px;
font-weight:bold;
z-index:101;
background-color:#2874F0;
line-height:180px;
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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<div class="col" style="position:absolute;top:90px;left:275px;width:50%;z-index:105">
	<form name="myForm" action="home.jsp">
        <input type="text" name="username" placeholder="Username" autofoccus required>

	 <input type="tel" pattern="[789][0-9]{9}" name="Mobile Number" placeholder="Mobile Number" autofoccus required
		title="Values should be Numeric and It should be of 10 digits only">

	 <input type="email" name="email" placeholder="email" autofoccus required
		title="The required format is aa@bb.cc">

        <input type="password" name="password" placeholder="Password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;"  required>



	 <input type="password" name="confirmpassword" placeholder="Confirm Password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');"  required>
        <input type="submit" value="Signup" >
</form>
	</div>
<div class="signup">&nbsp;&nbsp;&nbsp;&nbsp;Signup<br>
<span style="position:absolute;top:120px;left:30px;font-size:21px;line-height:22px;width:200px">We do not share your personal details with anyone
</span></div>

</div>
</body>
</html>