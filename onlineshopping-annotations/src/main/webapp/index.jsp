<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
  </style>
</head>
<body>
<h2>Online Shopping</h2>
<a href="viewretailers.do">Retailers Details</a><br>
<a href ="addretailers.do">Add Retailers</a></br>
<a href="regproduct.html">Register Product</a><br>
<a href="viewallprod.do">View All Products</a><br>
<a href="userdetails.do">User Details</a><br>
<a href="signup.do">Register User</a><br>
<a href="login.do">Login</a><br>
<div class="search-container">
    <form action="search.do">
      <input type="text" name="search" placeholder="Search..">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</body>
</html>
