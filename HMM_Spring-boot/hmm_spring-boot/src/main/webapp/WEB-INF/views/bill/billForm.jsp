<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<link
	href="<%=request.getContextPath()%>/resources/date-picker/css/bootstrap-datepicker.css"
	rel="stylesheet" type="text/css" />	
<script
	src="<%=request.getContextPath()%>/resources/date-picker/js/bootstrap-datepicker.js"
	type="text/javascript"></script>	
<script type="text/javascript">

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
<!-- Navigation Tab -->
<jsp:include page="../navTab.jsp"></jsp:include>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${status=='create'}">
				<h1>Add Bill</h1>
			</c:when>
			<c:otherwise>
				<h1>Update Bill</h1>
			</c:otherwise>
		</c:choose>
		
		<spring:url value="/bill" var="billActionUrl" />
			
		<form:form class="form-horizontal" method="post"
			modelAttribute="billForm" action="${billActionUrl}">
<%-- 			<c:set var="status" value="${status}" scope="request"/> --%>
<%-- 			<c:out value="${requestScope.status}"></c:out> --%>
			<form:hidden path="billID" />
			<form:hidden path="billID" value="" />
			<spring:bind path="description">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Description</label>
					<div class="col-sm-4">
						<form:input path="description" type="text" class="form-control "						
 							id="description" placeholder="Description" list="lstTempBill"/>
 							<datalist id="lstTempBill">
	 							 <c:forEach items="${templateBillList}" var="tempBillTiem">
						          <option value="${tempBillTiem.description}">${tempBillTiem.description}</option>
						         </c:forEach>
					         </datalist> 
<%-- 							<form:select path="description" class="form-control" disabled="false"> --%>
<%-- 													<form:option value="text"  /> --%>
<%-- 													<form:options items="${templateBillList}" /> --%>
<%-- 												</form:select> --%>
						<form:errors path="description" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="month">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Month</label>
					<div class="col-sm-4">
						<div class="input-group date" data-provide="datepicker">
							<form:input path="month" id="month" type="text" class="form-control"/>
												
						    <div class="input-group-addon">
						        <span class="glyphicon glyphicon-th"></span>
						    </div>
						</div>
								<form:errors path="month" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="amountMoney">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Amount Money</label>
						<div class="col-sm-4">
					   	<form:input path="amountMoney" id="amountMoney" type="number" class="form-control"/>
						<form:errors path="amountMoney" class="control-label" />
						</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="payer">
			<div class="form-group ">
				<label class="col-sm-2 control-label">Payer</label>
				<div class="col-sm-5">
					<form:select path="payer" class="form-control">
					<c:choose>
						<c:when test="${personID==0}">
							<form:option value="0" label="--- Select ---" />
						</c:when>
						<c:otherwise>
						<form:option value="0" label="--- Select ---" />
						<form:options itemValue="personID" itemLabel="personName" items="${personList}" />
						</c:otherwise>
					</c:choose>
					</form:select>
<%-- 					<form:errors path="payer" class="control-label" /> --%>
				</div>
			</div>
		</spring:bind>
			
			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
			
				<c:choose>
					<c:when test="${status=='create'}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
						<button class="btn-lg btn-primary pull-right" style="margin-right:20px;" onclick="location.href='/bill'">Cancel</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					    <button class="btn-lg btn-primary pull-right" style="margin-right:20px;" onclick="location.href='${billUrl}'">Cancel</button>								
					</c:otherwise>
				</c:choose>
				<spring:url value="/bill" var="billUrl" />
<%-- 				<button class="btn-lg btn-primary pull-right" style="margin-right:20px;" onclick="location.href='${billUrl}'">Back</button>	 --%>
			</div>
		</div>

		</form:form>

	</div>

</body>
</html>