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
      .card {
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
        transition: 0.3s;
	background:#E5E5E5;
        width: 30%;
        float:left;
        margin-left:3.5cm;
        margin-right:3.5cm;
        margin-bottom:1cm; 
        }

        .card:hover {
        box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }
        #logo{
        padding:15px;
        margin-left:300px;
        margin-right:350px;
      }

        .container {
        padding: 2px 8px;
        }
   </style>
</head>
<body>
 <%@ include file="shared/navbar.jsp"%> 
<div class="card">
        <img src="" alt="Avatar" style="width:70%">
        <div class="container">
          <h4><b>Mihir Panchal</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <div class="card">
        <img src="images/prajwal.jpg" alt="Avatar" style="width:70%">
        <div class="container">
          <h4><b>Prachi Sharma</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <div style="margin:2px"></div>
 <div class="card">
        <img src="images/arpita.jpg" alt="Avatar" style="width:70%">
        <div class="container">
          <h4><b>Vaibhavi Chavan</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <div class="card">
        <img src="images/nikhil.jpg" alt="Avatar" style="width:70%">
        <div class="container">
          <h4><b>Lavina Budhwani</b></h4> 
          <p>Developer</p> 
        </div>       
 </div>
 <%@ include file="shared/footer.jsp"%> 
</body>
</html>