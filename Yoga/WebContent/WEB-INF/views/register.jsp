<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
              <li><a href="left-sidebar.html">About</a></li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="intro-wrapper" class="wrapper wrapper-style1">
  <div class="title">Registration</div>
  <div class="5grid-layout">
    
	
	<!--myCode-->
	
	<form:form method="post" action="reg"  modelAttribute="userRegistration">
                    <div class="5grid">
                      <div >
                        <div class="6u">
                          <input type="text" class="text" name="userRegFullname" id="contact-name" placeholder="UserName">
                        <div class="showerror">
                            ${requestScope.uname}
                            </div>
                        </div>
                        
                        <div class="6u">
                          <input type="text" class="text" name="userRegEmail" id="contact-email" placeholder="email">
                        	<div class="showerror">
                            ${requestScope.email}
                            </div>
                        </div>
                        
                        <div class="6u">
                          <input type="password" class="text" name="userRegPass" id="contact-pswd" placeholder="password">
                        	 <div class="showerror">
                            ${requestScope.password}
                            </div>
                        </div>
                       
                        <div class="6u">
                          <input type="text" class="text" name="userRegPhone" id="contact-phone" placeholder="phone">
                        	<div class="showerror">
                            ${requestScope.phone}
                            </div>
                        </div>
                        
                        <div class="6u">
                          <input type="text" class="text" name="userRegAddress" id="contact-addess" placeholder="address">
                       <div class="showerror">
                            ${requestScope.userAddress}
                            </div>
                        </div>
                        
                        <div class="6u">
                           <select name="centerLocation.centerAddress">
								<option disabled selected="selected" value="CenterList">Center Location</option>
								
										<c:forEach var="center" items="${centerList}">
	
											<option value="${center.centerAddress}"> ${center.centerAddress}</option>
	
										</c:forEach>
						  </select>
                        </div>
                      </div>
                      
                      <div class="row">
                        <div class="12u">
                          <ul class="actions">
                            <li>
                              <input type="submit" class="button button-style1" value="register">
                            </li>
                            <li>
                              <input type="reset" class="button button-style2" value="Cancel">
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </form:form>
	
	</div>
    </div>

</body>
</html>