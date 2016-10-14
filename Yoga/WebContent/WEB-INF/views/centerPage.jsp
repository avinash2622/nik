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
	<table  style="border-color: black; border=5">
	<thead>
		<tr>
			<th>CenterName</th>
			<th>CenterAddress</th>
		</tr>
	</thead>
	<c:forEach var="cent" items="${centList}">
	<tr>
		<td>${cent.centerName }</td>
		<td>${cent.centerAddress }</td>
	</tr>
	
	</c:forEach>
	</table>
	<div class="row">
           <div class="12u">
             <ul class="actions">
               <li>
                 <input type="button" class="button button-style1" value="add center" onclick="enableField()">
               </li>
               
             </ul>
           </div>
         </div>
	
	<form:form method="post" action="addCenter" modelAttribute="centerLocation">
					<!--this id=form is used in fucncion enableform  and style="display: none is used to hidden the form"-->
       <div class="5grid" id="form" style="display: none;">
         <div >
           <div class="6u">
             <input type="text" class="text" name="centerName" id="contact-name" placeholder="CenterName">
           </div>
           <div class="6u">
             <input type="text" class="text" name="centerAddress" id="contact-email" placeholder="CenterAddress">
           </div>
         </div>
         
         <div class="row">
           <div class="12u">
             <ul class="actions">
               <li>
                 <input type="submit" class="button button-style1" value="Add">
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
 <script type="text/javascript">
  function enableField() {
	  /*this is used to enable the form for adding center  */
	  document.getElementById("form").style.display = "inline";
	  						/* this "form" is the ID of above div=form */
	}
</script>
</body>
</html>