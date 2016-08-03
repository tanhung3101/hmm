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
<jsp:include page="../css.jsp" />

<%
	User userName = (User) session.getAttribute("loginUser");
	String redirectURL = request.getContextPath() + "/login";
	if (userName == null)
		response.sendRedirect(redirectURL);
	String url = request.getContextPath();
	String flatThemeResource = url + "/resources/flatTheme/";
%>

<script>
	$(document).ready(function() {
		//initialize jTable
		$('.input-group.date').datepicker({
			format : "mm/yyyy",
			startView : 1,
			minViewMode : 1
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<!-- Navigation Top menu -->
		<div class="header">
			<jsp:include page="../navTab.jsp" />
			<div class="main_container">
				<!-- content -->
						<spring:url value="/calculate" var="CalculationActionUrl" />
						<form:form class="form-horizontal" method="post"
							action="${CalculationActionUrl}">
							<div class="input-group date" data-provide="datepicker">
								<input name="month" id="month" type="text" class="form-control" />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-th"></span>
								</div>
							</div>
							<button class="btn-lg btn-primary " style="margin-right: 20px;">Calculation</button>
						</form:form>
		
						<%
							 	String isCalculated= (String)session.getAttribute("isCalculated");
						%>
						<h1>isCalculate1:<%=isCalculated%></h1>
						
							<h1>isCalculate2:${isCalculated}</h1>
						<c:choose>
							<c:when test="${isCalculated==true}">
								<h3>Bill for ${monthCalculate}</h3>
								<c:forEach items="${personInHouse}" var="itemPerson">
									<div class="person_info" style="border: 1px groove;">
										<p>Person: ${itemPerson.personName}</p>
										<p>TotalAmountEach: ${itemPerson.amountMoneyTotalinAMonth}</p>
										<p>TotalAmountAlreadyPaid:
											${itemPerson.amountMoneyAlreayPaid}</p>
										<p>TotalAmountMustPaid: ${itemPerson.amountMoneyMustPay}</p>
									</div>
								</c:forEach>
		
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
		
<!-- 						<div class="person_info" style="border: 1px groove;"> -->
<!-- 							<div class="person_image"></div> -->
<!-- 							<div> -->
<!-- 								<p class="title">Person:</p> -->
<!-- 								<p>No</p> -->
<!-- 								<p class="title">Total Amount Each:</p> -->
<!-- 								<p class="title">TotalAmountAlreadyPaid:</p> -->
<!-- 								<p>$5000</p> -->
<!-- 								<p class="title">TotalAmountMustPaid:</p> -->
<!-- 								<p>$5000</p> -->
<!-- 							</div> -->
<!-- 						</div> -->
				</div><!-- content -->
			</div>
		</div>
</body>
</html>
