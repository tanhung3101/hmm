<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="com.nop.entity.*" %>
<%@ page import="com.nop.ultilities.*" %>
<%@ page session="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
// 	if (userName == null)
// 		response.sendRedirect(redirectURL);
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
		//init Charts
		var data = '${jsonListBill}';
// 		data=data.substring(, data.length-1);
		doInitChart(data);
		console.log(data);
		
	});
	
	function doInitChart(data){
		$('#bill_chart').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: true,
	            type: 'pie'
	        },
	        title: {
	            text: ''
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        }
// 	        ,"series":[{"data":[{"name":"Nước","y":100000},{"name":"Tiền Nhà","y":4200000},{"name":"Điện","y":300000}],"colorByPint":true,"name":"Brands"}]
	        ,"series":[${jsonListBill}] //just leave the code like this
// 	        ,"series":data
	    });
	}
<!-- </script> -->



</head>
<body>
	<div class="wrap">
		<!-- Navigation Top menu -->
		<div class="header">
			<jsp:include page="../navTab.jsp" />
			<div class="main_container">
				<!-- content -->
				<div class="main_content">
						<spring:url value="/calculate" var="CalculationActionUrl" />
						<!-- Start Page: Select Month and press Calculate  -->
						<form:form class="form-horizontal" method="post"
							action="${CalculationActionUrl}">
							<div class="col-sm-12">
							
							
							<h3>Please select month to calculate bills</h3>
							</div>
							<div class="row">
							<label class="col-sm-2 control-label">Month</label>
								<div class="col-sm-4">
									<div class="input-group date" data-provide="datepicker">
										<input name="month" id="month" type="text" class="form-control" />
										<div class="input-group-addon">
											<span class="glyphicon glyphicon-th"></span>
										</div>
									</div>
								</div>
							</div>	
								<div class="row">
								<div class="col-sm-2"></div>
								<div class ="col-sm-2" style="margin-top:20px;">
								<button class="btn-lg btn-primary " style="">Calculation</button>
								</div>
								</div>	
							
						</form:form>
						
							<!-- End Form : Select Month and press Calculate  -->
						<div class="row line_breaker">
						<br>
						</div>
						<!-- Start Show Bill Part after Calculation -->
						<c:choose>
							<c:when test="${isCalculated==true}">
								<c:if test="${isHasRecord =='true'}">
								<h3 class="header_Title">Bill for ${monthCalculate}</h3>
								
								<!-- Show list Bill in selected Month -->
								<div class="row " style="margin-bottom:20px;">
								<div class="total_bills_in_month col-md-6">
									<table>
<%-- 									  <caption>Camping Costs</caption> --%>
									  <thead>
									    <tr>
									      <th>Bill Name</th>
									      <th>Month</th>
									      <th>Payer</th>
   								          <th>Amount Money</th>
									    </tr>
									  </thead>
									  <tbody>
									  </tbody>
									 
									  
									  <c:forEach var="bill" items="${lstBills}">
										<tr>
											<td>${bill.description}</td>
											<td>${bill.getMonth()}</td>
											<td>${bill.payer.personName}</td>
											<td>${bill.amountMoneyStringValue} VND</td>
										</tr>
									</c:forEach>
									
									
									   <tfoot>
									    <tr>
									      <th colspan="3">Total</th>
									      <th>${totalAmountInMonth} VND</th>
									    </tr>
									  </tfoot>
									  
									</table>
									</div>
									
									<div class="col-md-6">
								<div id="bill_chart" style="min-width: 400px; height: 300px; max-width: 400px; margin: 0 auto"></div>
								</div>
								</div> <!-- end row -->
								<!--End Show list Bill in selected Month -->
								
								
								
								<div class="row">
								<c:forEach items="${personInHouse}" var="itemPerson" varStatus="loop">
									<div class="person_info col-md-6" style="">
									<table class="calcu_person_detail_form">
										<tr>
											<td class="label_form">Person Name:</td>
											<td class="value_form">${itemPerson.personName}</td>
										</tr>
										<tr>
											<td class="label_form">Total Amount Each:</td>
											<td class="value_form">${itemPerson.amountMoneyTotalinAMonthStringValue} VND</td>
										</tr>
										<tr>
											<td class="label_form">Total Already Paid:</td>
											<td class="value_form">${itemPerson.amountMoneyAlreayPaidStringValue} VND</td>
										</tr>
										<tr>
											<td class="label_form">Total Must Pay:</td>
											<td class="value_form" style="background-color:SeaGreen; color: white;"> ${itemPerson.amountMoneyMustPayStringValue} VND</td>
										</tr>
									</table>
<%-- 										<p>Person: ${itemPerson.personName}</p> --%>
<%-- 										<p>TotalAmountEach: ${itemPerson.amountMoneyTotalinAMonth}</p> --%>
<!-- 										<p>TotalAmountAlreadyPaid: -->
<%-- 											${itemPerson.amountMoneyAlreayPaid}</p> --%>
<%-- 										<p>TotalAmountMustPaid: ${itemPerson.amountMoneyMustPay}</p> --%>
<!-- 									<div class="col-md-2"></div> -->
									</div>
									
								</c:forEach>
								</div><!-- end row -->
								</c:if>
								<c:if test="${isHasRecord =='false'}">
								<h5 class="header_Title_warning">There is no bill records for this ${monthCalculate}.</h5>
								</c:if>
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
					</div>
				</div><!-- content -->
				
			</div>
		</div>
</body>
</html>
