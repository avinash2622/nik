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
              <li><a href="logout">LOGOUT</a></li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="intro-wrapper" class="wrapper wrapper-style1">
  <div class="title">ADMIN PAGE</div>
  <div class="5grid-layout">
    
	
	<!--myCode-->
	
	<form:form method="post" action="centerPage">
                    <div class="5grid">
                      <div >
                        
                      </div>
                      
                      <div class="row">
                        <div class="12u">
                          <ul class="actions">
                            <li>
                           
                              <input type="submit" class="button button-style1" value="CENTER">
                            </li>
                            <li>
                              <input type="submit" class="button button-style2" value="USERS" formaction="userList">
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