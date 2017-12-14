<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="com.nop.entity.*" %>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="UTF-8">
<title>HMM Web Application</title>
<jsp:include page="../css.jsp" />
</head>
<body>
<% User userName=(User)session.getAttribute("loginUser");
	String redirectURL= request.getContextPath()+"/home";
// 	if(userName !=null)
// 		response.sendRedirect(redirectURL);
	String url=request.getContextPath(); 
%>

<jsp:include page="../navTab.jsp" />

	<div class="container-fluid wrap">
		<div class="row-fluid">
			<div class="col-md-4 col-md-offset-4">
				<fieldset>
				<legend>HMM Web Application</legend>
<%-- 				<form class="form-horizontal" method="post" action='${contextPath}/login' name="userForm" id="userForm"> --%>
<!-- 					<div class="control-group"> -->
<!-- 						<label class="control-label">UserName</label> -->
<!-- 						<div class="controls"> -->
<!-- 							<input type="text" name="userName" id="userName" title="User Name" value=""> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="control-group"> -->
<!-- 						<label class="control-label">Last Name</label> -->
<!-- 						<div class="controls"> -->
<!-- 							<input type="password" name="userPassword" id="userPassword" title="Password" value=""> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-actions" style="margin-top:10px;" > -->
<!-- 						<button type="submit" class="btn btn-success" >Login</button>						 -->
<!-- 					</div> -->
<%-- 					<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4> --%>
<%-- 				</form> --%>
					<form method="POST" action="${contextPath}/login"
						class="form-signin">
						<h2 class="form-heading">Log in</h2>
						<div class="form-group ${error != null ? 'has-error' : ''}">
							<span>${message}</span> <input name="username" type="text"
								class="form-control" placeholder="Username" autofocus="true" />
							<input name="password" type="password" class="form-control"
								placeholder="Password" /> <span>${error}</span> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<button class="btn btn-lg btn-primary btn-block" type="submit">Log
								In</button>
							<h4 class="text-center">
								<a href="${contextPath}/registration">Create an account</a>
							</h4>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>		
</body>
</html>