<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	
	<form:form method="post" action="update"  modelAttribute="userRegistration">
                    <div class="5grid">
                      <div >
                      	<div class="6u">
                          <input type="text" class="text" name="userRegId" disabled="disabled" id="contact-id" value="${validUser.userRegId}">
                        </div>
                        <div class="6u">
                          <input type="text" class="text" name="userRegFullname" disabled="disabled" id="contact-name" placeholder="UserName" value="${validUser.userRegFullname}">
                        </div>
                        <div class="6u">
                          <input type="text" class="text" name="userRegEmail" disabled="disabled" id="contact-email" placeholder="email"  value="${validUser.userRegEmail}">
                        </div>
                        <div class="6u">
                          <input type="password" class="text" name="userRegPass" disabled="disabled" id="contact-pswd" placeholder="password"  value="${validUser.userRegPass}">
                        </div>
                        <div class="6u">
                          <input type="text" class="text" name="userRegPhone" disabled="disabled" id="contact-phone" placeholder="phone" value="${validUser.userRegPhone}">
                        </div>
                        <div class="6u">
                          <input type="text" class="text" name="userRegAddress" disabled="disabled" id="contact-addess" placeholder="address" value="${validUser.userRegAddress}">
                        </div>
                        <div class="6u">
                         <input type="text" class="text" name="location"  disabled="disabled" id="contact-location" placeholder="UserName" value="${validUser.centerLocation.centerAddress}">
                        </div>
                      </div>
                      
                      <div class="row">
                        <div class="12u">
                          <ul class="actions">
                            <li>
                              <input type="submit" class="button button-style1" value="UPDATE">
                            </li>
                            <li>
                              <input type="button" class="button button-style2" value="EdIT" onclick="enableField()">
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </form:form>
	
	
	
	</div>
    </div>
 <script type="text/javascript">
  function enableField() {
	  
	  
	    document.getElementById("contact-name").disabled = false; 
	    document.getElementById("contact-email").disabled = false; 
	    document.getElementById("contact-pswd").disabled = false;
	    document.getElementById("contact-phone").disabled = false;
	    document.getElementById("contact-addess").disabled = false;
	    document.getElementById("contact-location").disabled = false;
	  
	}
</script> 
</body>
</html>