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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
 <div class="wrap"> <!-- Navigation Top menu -->	 
	<div class="header">
	
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
	  
	      	  <div class="header_top">
					  <div class="menu">
						  <a class="toggleMenu" href="#"><img src="<%=flatThemeResource %>images/nav.png" alt="" /></a>
							<ul class="nav">
								<li><a href="#"><i><img src="<%=flatThemeResource %>images/settings.png" alt="" /></i>Settings</a></li>
								<li class="active"><a href="#"><i><img src="<%=flatThemeResource %>images/user.png" alt="" /></i>Account</a></li>
								<li><a href="#"><i><img src="<%=flatThemeResource %>images/mail.png" alt="" /></i>Messages <span class="messages">5</span></a></li>
								<li><a href="#"><i><img src="<%=flatThemeResource %>images/favourite.png" alt="" /></i>Favorites</a></li>
							<div class="clear"></div>
						    </ul>
							<script type="text/javascript" src="<%=flatThemeResource %>js/responsive-nav.js"></script>
				        </div>	
					  <div class="profile_details">
				    		   <div id="loginContainer">
				                  <a id="loginButton" class=""><span>Me</span></a>   
				                    <div id="loginBox">                
				                      <form id="loginForm">
				                        <fieldset id="body">
				                            <div class="user-info">
							        			<h4>Hello,<a href="#"> Username</a></h4>
							        			<ul>
							        				<li class="profile active"><a href="#">Profile </a></li>
							        				<li class="logout"><a href="#"> Logout</a></li>
							        				<div class="clear"></div>		
							        			</ul>
							        		</div>			                            
				                        </fieldset>
				                    </form>
				                </div>
				            </div>
				             <div class="profile_img">	
				             	<a href="#"><img src="<%=flatThemeResource %>images/profile_img40x40.jpg" alt="" />	</a>
				             </div>		
				             <div class="clear"></div>		  	
					    </div>	
		 		      <div class="clear"></div>				 
				   </div>
			</div>	  					     
	</div>
</body>
</html>
