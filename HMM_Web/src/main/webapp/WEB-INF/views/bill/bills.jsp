<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../css.jsp"></jsp:include>
<% String url=request.getContextPath(); %>
<link href="<%=url %>/resources/jtable/themes/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=url %>/resources/jtable/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize jTable

    });
</script>

</head>
<!-- Navigation Tab -->
<jsp:include page="../navTab.jsp"></jsp:include>
<body>


<div class="main_container">
	<h1>Bills</h1>
	
	<div id="create_bill">
		<form:form method="post" modelAttribute="userForm" action="${userActionUrl}">
		<form:input path="name" type="text" /> <!-- bind to user.name-->
		<form:errors path="name" />
	</form:form>
	</div>

	<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
	<div id="BillTableContainer"></div>
	</div>
</div>
</body>
</html>