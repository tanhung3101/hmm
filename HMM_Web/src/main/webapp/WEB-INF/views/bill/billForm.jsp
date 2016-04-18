<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Form</title>
<jsp:include page="../css.jsp"></jsp:include>
<%
	String url = request.getContextPath();
%>
<link
	href="<%=request.getContextPath()%>/resources/jtable/themes/metro/crimson/jtable.css"
	rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script
	src="<%=request.getContextPath()%>/resources/jtable/jquery.jtable.js"
	type="text/javascript"></script>
</head>
<body>

	<div class="container">
		<c:choose>
			<c:when test="${userForm['new']}">
				<h1>Add User</h1>
			</c:when>
			<c:otherwise>
				<h1>Update User</h1>
			</c:otherwise>
		</c:choose>

		<spring:url value="<%=url %>/bill" var="billActionUrl" />

		<form:form class="form-horizontal" method="post"
			modelAttribute="userForm" action="${billActionUrl}">

			<form:hidden path="id" />

			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control "
							id="description" placeholder="Description" />
						<form:errors path="name" class="control-label" />
					</div>
				</div>
			</spring:bind>

		</form:form>

	</div>

</body>
</html>