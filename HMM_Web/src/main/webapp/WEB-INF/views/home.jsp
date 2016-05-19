<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>HMM Web Application</title>
<jsp:include page="css.jsp" />
<% 
	User userName=(User)session.getAttribute("loginUser");
	String redirectURL= request.getContextPath()+"/login";
	if(userName ==null)
		response.sendRedirect(redirectURL);

%>
<script
	src="<%=request.getContextPath()%>/resources/jtable/jquery.jtable.js"
	type="text/javascript"></script>

<link
	href="<%=request.getContextPath()%>/resources/date-picker/css/bootstrap-datepicker.css"
	rel="stylesheet" type="text/css" />	
<script
	src="<%=request.getContextPath()%>/resources/date-picker/js/bootstrap-datepicker.js"
	type="text/javascript"></script>	
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
<jsp:include page="navTab.jsp" />
<spring:url value="/home" var="CalculationActionUrl" />
<form:form class="form-horizontal" method="post" action="${CalculationActionUrl}">
	<div class="input-group date" data-provide="datepicker">
		<input name="month" id="month" type="text" class="form-control"/>
	    <div class="input-group-addon">
	        <span class="glyphicon glyphicon-th"></span>
	    </div>
	</div>	
	<button class="btn-lg btn-primary " style="margin-right:20px;">Calculation</button>	 
</form:form>

<%
// 	String isCalculated= (String)session.getAttribute("isCalculated");
	
%>
	<c:choose>
			<c:when test="${isCalculated=='true'}">
				<h3>Bill for ${monthCalculate}</h3>			
				 <c:forEach items="${personInHouse}" var="itemPerson">
					<div class="person" style="border:1px groove;">
						<p>Person: ${itemPerson.personName}</p>
						<p>TotalAmountEach: ${itemPerson.amountMoneyTotalinAMonth}</p>
						<p>TotalAmountAlreadyPaid: ${itemPerson.amountMoneyAlreayPaid}</p>
						<p>TotalAmountMustPaid: ${itemPerson.amountMoneyMustPay}</p>
					</div>		        
				 </c:forEach>
				
			</c:when>
			<c:otherwise>				
			</c:otherwise>
		</c:choose>
	
</body>
</html>
