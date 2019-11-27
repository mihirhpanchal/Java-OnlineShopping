<%@page import="java.util.List"%>
<%@page import="lti.onlineshopping.service.ProductServiceImpl"%>
<%@page import="lti.onlineshopping.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="security" --%>
<%-- 	uri="http://www.springframework.org/security/tags"%> --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/assets/js/jquery.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>

<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  float:left;
  width:75%;
}

.price {
 
  color: grey;
  font-size: 22px;
  
  border: none;
  outline: 0;
  padding: 12px;
  color: black;
  background-color: #a1887f ;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button {
  
}

/* .card button:hover {
  opacity: 0.7;
} */

.footer-distributedsip{
	position:absolute;
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: normal 16px sans-serif;

	padding: 0px -10px;
	margin-top: -950px;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .card {
    width: 100%;
    display: table;
    margin-bottom: 20px;
  }
}


}

body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}
/*magnify  */
.img-magnifier-container {
  position:relative;
}

.img-magnifier-glass {
  position: absolute;
  border: 2px solid #000;
  border-radius: 50%;
  cursor: none;
  /*Set the size of the magnifier glass:*/
  width: 100px;
  height: 100px;
}
</style>
<script>
function magnify(imgID, zoom) {
  var img, glass, w, h, bw;
  img = document.getElementById(imgID);
  /*create magnifier glass:*/
  glass = document.createElement("DIV");
  glass.setAttribute("class", "img-magnifier-glass");
  /*insert magnifier glass:*/
  img.parentElement.insertBefore(glass, img);
  /*set background properties for the magnifier glass:*/
  glass.style.backgroundImage = "url('" + img.src + "')";
  glass.style.backgroundRepeat = "no-repeat";
  glass.style.backgroundSize = (img.width * zoom) + "px " + (img.height * zoom) + "px";
  bw = 3;
  w = glass.offsetWidth / 2;
  h = glass.offsetHeight / 2;
  /*execute a function when someone moves the magnifier glass over the image:*/
  glass.addEventListener("mousemove", moveMagnifier);
  img.addEventListener("mousemove", moveMagnifier);
  /*and also for touch screens:*/
  glass.addEventListener("touchmove", moveMagnifier);
  img.addEventListener("touchmove", moveMagnifier);
  function moveMagnifier(e) {
    var pos, x, y;
    /*prevent any other actions that may occur when moving over the image*/
    e.preventDefault();
    /*get the cursor's x and y positions:*/
    pos = getCursorPos(e);
    x = pos.x;
    y = pos.y;
    /*prevent the magnifier glass from being positioned outside the image:*/
    if (x > img.width - (w / zoom)) {x = img.width - (w / zoom);}
    if (x < w / zoom) {x = w / zoom;}
    if (y > img.height - (h / zoom)) {y = img.height - (h / zoom);}
    if (y < h / zoom) {y = h / zoom;}
    /*set the position of the magnifier glass:*/
    glass.style.left = (x - w) + "px";
    glass.style.top = (y - h) + "px";
    /*display what the magnifier glass "sees":*/
    glass.style.backgroundPosition = "-" + ((x * zoom) - w + bw) + "px -" + ((y * zoom) - h + bw) + "px";
  }
  function getCursorPos(e) {
    var a, x = 0, y = 0;
    e = e || window.event;
    /*get the x and y positions of the image:*/
    a = img.getBoundingClientRect();
    /*calculate the cursor's x and y coordinates, relative to the image:*/
    x = e.pageX - a.left;
    y = e.pageY - a.top;
    /*consider any page scrolling:*/
    x = x - window.pageXOffset;
    y = y - window.pageYOffset;
    return {x : x, y : y};
  }
}
</script>
</head>
<body>
<div><%@ include file="/shared/navbar.jsp"%></div>
<%-- <%
int prodid;
Product products = null;
 products = new ProductServiceImpl().compareProduct(products.getProduct_id());
%> --%>
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
	<%-- <c:forEach items="${products}" var="product"> --%>
	 <%-- <%
	    for( Object[] product :products){
	         String url = "singleproduct.do?prodid="+product[0]; 		    
	 %> --%>
	 
</div>
	 
	 <%
	 String url = "addtocart.do";
	 %>
	 
	 <div class="card">
	   <div class="price">

		<div class="w3-third w3-container w3-margin-bottom">

			<%-- <img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity"> --%>
				
				
=
		<div class="img-magnifier-container">
<img src="http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}" height="410" width="320"><br>
	  
			<div class="w3-container w3-white">
		</div>
			
			<script>
				magnify("myimage", 3);
			</script>
			</div>
			</div>
	  <div class="card">
	  <div class="price">
	  <%  //String urls = "http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}" ;
	  
	  String urls="http://localhost:8084/onlineshopping/download/image.do?fileName=${products.filename}";
	   System.out.println("url:"+urls);
	  %>
	  
	  
	<h2>Product Name: <c:out value="${products.product_name }"/></h2>
	<h2><label name="price">Price: <c:out value="${products.unit_price }"/></label></h2>
	Product Description: <c:out value="${products.product_description }"></c:out><br> <br>
	Category: <c:out value="${products.category.category_name}"/><br><br>
	Sub Category: <c:out value="${products.subcategory.sub_name}"/><br> <br>
	Brand: <c:out value="${products.brand}"/><br><br>
	<form action="addtocart.do" method="post">
	<input type="hidden" name="prodid" id="prodid" value="${prodid}"/>

	<label>Quantity:</label>

	<input type="hidden" name="pname" id="pname" value="${products.product_name }"/>
	<input type="hidden" name="unitprice" id="unitprice" value="${products.unit_price }"/>

	Quantity:

	


	<input type="number" name="qty" min="0" step="1" id="qty" required
	title="Please enter the quantity"><br><br>
	<input type="submit" value="Add to cart">
	</form><br>
	<form action="singleproductforcompare.do">
		<input style="margin-left: 33%"  type="submit" value="Add to compare">
	</form>
			</div>
		</div>
	
		</div>
		</div>

	<%-- 	<div><%@ include file="../../shared/footer.jsp"%></div> 	
	<hr><div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/assets/images/products/two.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<h1>Product Name: <c:out value="${products.product_name }"/></h1><br>
	<h2>Price: <c:out value="${products.unit_price }"/></h2><br>
	Product Description:<c:out value="${products.product_description }"></c:out><br>
	Category<c:out value="${products.category.category_name}"/><br>
	Sub Category<c:out value="${products.subcategory.sub_name}"/><br> 
	Brand:<c:out value="${products.brand}"/><br>
			</div>
		</div>
	<!-- </div> --> --%>
	 
	  		</body>

		
		
		<div class="footer-distributedsip"><%@ include file="../../shared/footer.jsp"%></div> 	
	
</body>
</html>