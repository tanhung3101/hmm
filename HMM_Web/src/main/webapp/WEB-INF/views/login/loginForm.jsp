<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HMM Web Application</title>
<link type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>HMM Web Application</legend>
				<form class="form-horizontal" method="post" action='login/submitLoginForm' name="userForm" id="userForm">
					<div class="control-group">
						<label class="control-label">UserName</label>
						<div class="controls">
							<input type="text" name="userName" id="userName" title="User Name" value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Last Name</label>
						<div class="controls">
							<input type="password" name="userPassword" id="userPassword" title="Password" value="">
						</div>
					</div>
<!-- 					<div class="control-group"> -->
<!-- 						<label class="control-label">Email</label> -->
<!-- 						<div class="controls"> -->
<!-- 							<input type="text" name="email" id="email" title="Email" value=""> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Login</button>
						<button type="button" class="btn">Cancel</button>
					</div>
				</form>
				</fieldset>
			</div>
		</div>
	</div>		
</body>
</html>