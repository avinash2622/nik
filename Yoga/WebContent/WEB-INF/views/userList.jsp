<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>DivineYOGA</title>
<meta charset="utf-8">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400italic,700,900" rel="stylesheet">
<script src="resource/js/jquery-1.9.1.min.js"></script>
<script src="resource/css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none&amp;mobileUI.titleBarHeight=0"></script>
<script src="resource/js/jquery.dropotron-1.2.js"></script>
<script src="resource/js/init.js"></script>
<!-- 

<!--[if lte IE 8]>
<link rel="stylesheet" href="css/ie8.css">
<![endif]-->
</head>
<body class="homepage">
<div id="header-wrapper" class="wrapper">
  <div class="5grid-layout">
    <div class="row">
      <div class="12u">
        <div id="header">
          <div id="logo">
            <h1><a href="#" class="mobileUI-site-name">DivineYOGA</a></h1>
            <span class="byline"> </span></div>
          <nav id="nav" class="mobileUI-site-nav">
            <ul>
              <li class="current_page_item"><a href="home">Home</a></li>
              
              <li><a href="registerPage">Registration</a></li>
              <li><a href="logout">Logout</a></li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="intro-wrapper" class="wrapper wrapper-style1">
  <div class="title">User Details</div>
  <div class="5grid-layout">
    
	
	<!--myCode-->
	<form action="deleteUser">
	<table  style="border-color: black; border=5">
	<thead>
		<tr>
			<th>UserName</th>
			<th>UserEmail</th>
			<th>Password</th>
			<th>Phone</th>
			<th>User Address</th>
			<th>Center Location</th>
			<th></th>
		</tr>
	</thead>
	
	<!--here var="used" is use to print the value and items="${userList}" is used to send it to the controller -->
	<c:forEach var="used" items="${userList}">
	<tr>
		
		<td>${used.userRegFullname }</td>
		<td>${used.userRegEmail }</td>
		<td>${used.userRegPass }</td>
		<td>${used.userRegPhone }</td>
		<td>${used.userRegAddress }</td>
		<td>${used.centerLocation.centerAddress }</td>
		<td><input type="radio" name="deleteId" value="${used.userRegId}"> </td>
		<td><input type="submit" value="delete"></td>
	</tr>
	
	
	
	</c:forEach>
	
	</table>
			
	</form>
	
	<form action="userList">
		<select name="selectCity">
			<option value="all">ALL</option>
		<c:forEach var="center" items="${centerList}">
	
		<option value="${center.centerAddress}"> ${center.centerAddress}</option>
	
		</c:forEach>
		</select>
			<input type="submit" value="search">
	</form>
	</div>
    </div>
 
</body>
</html>