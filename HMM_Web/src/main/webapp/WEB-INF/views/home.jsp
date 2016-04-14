<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page import="com.nop.DTO.*"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HMM Web Application</title>
<jsp:include page="css.jsp" />
<% 
	User userName=(User)session.getAttribute("loginUser");
	String redirectURL= request.getContextPath()+"/login";
	if(userName ==null)
		response.sendRedirect(redirectURL);

%>
</head>
<body>
<jsp:include page="navTab.jsp" />


	
</body>
</html>
