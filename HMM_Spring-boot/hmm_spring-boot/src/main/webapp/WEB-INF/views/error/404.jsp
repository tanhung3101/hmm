<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 Error Page</title>
<style type="text/css">
body{
	font-family: 'Love Ya Like A Sister', cursive;
}
body{
	background:#eaeaea;
}	
.wrap{
	margin:0 auto;
	width:1000px;
}
.logo{
	text-align:center;
	margin-top:200px;
}
.logo img{
	width:350px;
}
.logo p{
	color:#272727;
	font-size:40px;
	margin-top:1px;
}	
.logo p span{
	color:lightgreen;
}	
.sub a{
	color:#fff;
	background:#272727;
	text-decoration:none;
	padding:10px 20px;
	font-size:13px;
	font-family: arial, serif;
	font-weight:bold;
	-webkit-border-radius:.5em;
	-moz-border-radius:.5em;
	-border-radius:.5em;
}	
.footer{
	color:black;
	position:absolute;
	right:10px;
	bottom:10px;
}	
.footer a{
	color:rgb(114, 173, 38);
}	
</style>
</head>
<body>
 
 <div class="wrap">
	<div class="logo">
			<p>OOPS! - Could not Find it</p>
			<img src="<%=request.getContextPath() %>/resources/images/404-1.png"/>
			<div class="sub">
<!-- 			  <p><a href="#">Back </a></p> -->
			</div>
	</div>
 </div>	
	
 
</body>
</html>