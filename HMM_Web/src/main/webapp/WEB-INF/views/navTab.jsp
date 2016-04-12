<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% String url=request.getContextPath(); %>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">HMM Web App</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="<%=url%>/home">Home</a></li>
			<li><a href="#">Bill</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Settings 
				<span class="caret"></span>
				</a>
				<ul class="dropdown-menu" role = "menu">
					<li><a href="#">Profile</a></li>
					<li><a href="#">Template Bill</a></li>
				</ul>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="<%=url%>/login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
	</nav>
	
	
   
</div>
</body>
</html>