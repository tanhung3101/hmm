<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page import="com.nop.entity.*"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% String url=request.getContextPath(); %>
<% //User userName=(User)session.getAttribute("loginUser"); %>

</head>

<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">HMM Web App</a>
		</div>
		<ul class="nav navbar-nav">
			<li class=""><a href="<%=url%>/home">Home</a></li>
			<c:choose>
				<c:when test="${pageContext.request.userPrincipal!=Null}">
						<li><a href="<%=url%>/calculate">Calculation</a></li>
						<li><a href="<%=url%>/bill">Bill</a></li>
						<li><a href="<%=url%>/user">User</a></li>
						<li class="dropdown">
							<a class="dropdown-toggle"	data-toggle="dropdown" href="#">Settings 
								<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="<%=url%>/profile">Profile</a></li>
									<li><a href="<%=url%>/templateBill">Template Bill</a></li>
								</ul>
						</li>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${pageContext.request.userPrincipal==Null}">
					<li><a href="<%=url%>/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<br />
				</c:when>
				<c:otherwise>
<!-- 					<li><a href=""> Welcom -->
<%-- 							${sessionScope.loginUser.getUserName()}</a></li> --%>
					<li class="dropdown">
							<a class="dropdown-toggle"	data-toggle="dropdown" href="#">Welcome
							${pageContext.request.userPrincipal.name}
								<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="<%=url%>/login/logout">Log out</a></li>
								</ul>
						</li>		
				</c:otherwise>
			</c:choose>


		</ul>
	</div>
	</nav>



	<!-- 		Way 1 to use session Attribute -->
	<%-- 	<c:out value="<%=  --%>
	<!-- //		userName.getUserName() -->
	<%-- 		%>"> --%>
	<%-- 		/>%>
<!-- 		Way 2 to use session Attribute -->
<%--    <c:out value="${sessionScope.loginUser.getUserName()}"/> --%>
	</div>
</body>
</html>