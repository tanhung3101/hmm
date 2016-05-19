<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../css.jsp"></jsp:include>
<% String url=request.getContextPath(); %>
<link href="<%=url %>/resources/jtable/themes/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->


<script type="text/javascript">
   jQuery( document ).ready(function( $ ) {
        //initialize jTable
    });
</script>

</head>
<!-- Navigation Tab -->
<jsp:include page="../navTab.jsp"></jsp:include>
<body>


<div class="main_container">
	<h1>Bills</h1>
	
		
</div>

<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		
		<spring:url value="/bill/add" var="urlAddUser" />
		<div class="active"><a href="${urlAddUser}">Add New Bill</a></div>

		<h1>All Bills</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Bill Description</th>
					<th>Month</th>
					<th>Amount Money</th>
					<th>Payer</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="bill" items="${lstBills}">
				<tr>
					<td>
						${bill.billID}
					</td>
					<td>${bill.description}</td>
					<td>${bill.getMonth()}</td>
					<td>${bill.getAmountMoney()}</td>
					<td>${bill.payer.personName}</td>
					<td>
						<spring:url value="/bill/${bill.billID}" var="billUrl" />
						<spring:url value="/bill/${bill.billID}/delete" var="deleteUrl" /> 
						<spring:url value="/bill/${bill.billID}/update" var="updateUrl" />
						
						
						<button class="btn btn-info" onclick="location.href='${billUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>