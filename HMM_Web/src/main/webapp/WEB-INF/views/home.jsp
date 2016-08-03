<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.nop.DTO.*"%>
<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>HMM Web Application</title>
<jsp:include page="css.jsp" />

<% 
	User userName=(User)session.getAttribute("loginUser");
	String redirectURL= request.getContextPath()+"/login";
	if(userName ==null)
		response.sendRedirect(redirectURL);
	String url=request.getContextPath();
	String flatThemeResource=url+"/resources/flatTheme/";
%>

<script>
$(document).ready(function () {
	        //initialize jTable
	$('.input-group.date').datepicker({	   
		format: "mm/yyyy",
		 startView: 1,
	    minViewMode: 1	  
	});
});
</script>
</head>
<body>
	<div class="wrap">
		<!-- Navigation Top menu -->
		<div class="header">
			<!-- header -->
			<jsp:include page="navTab.jsp" />

			<h1>Welcome to HMM application</h1>

		</div>
		<!-- header -->
	</div>
	<!-- Navigation Top menu -->
</body>
</html>
