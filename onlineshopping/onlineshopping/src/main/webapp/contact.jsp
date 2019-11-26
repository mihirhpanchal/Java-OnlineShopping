<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact</title>
  <style>
     ::-webkit-scrollbar {
    display: none;
}
     * {
        box-sizing: border-box;
        text-align: center;
      
        font-family: Verdana, Geneva, Tahoma, sans-serif;
       }
       
      
      p,h4{
        color: black;
      }

      li {
        float: left;
        margin-left:15px ;
        margin-right: 15px;
      }

      li a {
        display: block;
        color: white;
        padding: 14px 16px;
        text-decoration: none;
        
      }

      li a:hover {
       
        background-color: #111;
      }

      
      div{
        
        text-align: center;
        
      }
      
      tr{
        text-align:center;
      }
      
      a{
        text-decoration :none;
      }
      #login{
        padding-left: 15px;
        padding-right: 15px;
      }
      footer{
        text-align: center;
        font-size: 15px;
      }
      .cardc {
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
        transition: 0.3s;
	background:#E5E5E5;
        width: 30%;
        
        float:left;
        margin-left:3.5cm;
        margin-right:3.5cm;
        margin-bottom:1cm; 
        margin-top:1.5cm;
        }

        .cardc:hover {
        box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }
        #logo{
        padding:15px;
        margin-left:300px;
        margin-right:350px;
      }

        .containerc {
        padding: 2px 8px;
        }
        
        .footer-distributedcon{
	position:absolute;
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: normal 16px sans-serif;

	padding: 0px 0px;
	margin-top: 1000px;
}
        
        
   </style>
</head>
<body>
<div><%@ include file="/shared/navbar.jsp"%></div>
 
<div class="cardc">

        <img src="assets/images/mihir1.png" alt="Avatar" style="width:70%">
        <div class="containerc">
          <h4><b>Mihir Panchal</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 
 <div class="cardc">
        <img src="assets/images/prachi.png" alt="Avatar" style="width:70%">
        <div class="containerc">
          <h4><b>Prachi Sharma</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <div style="margin:2px"></div>
 <div class="cardc">
        <img src="assets/images/prachi.png" alt="Avatar" style="width:70%">
        <div class="containerc">
          <h4><b>Vaibhavi Chavan</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <div class="cardc">
        <img src="assets/images/prachi.png" alt="Avatar" style="width:70%">
        <div class="containerc">
          <h4><b>Lavina Budhwani</b></h4> 
          <p>Developer</p> 
        </div>       
 </div class=".footer-distributedcon">
 <%@ include file="shared/footer.jsp"%> 
 </div>
</body>
</html>