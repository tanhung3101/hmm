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
<jsp:include page="../css.jsp" />
<% 
	User userName=(User)session.getAttribute("loginUser");
	String redirectURL= request.getContextPath()+"/login";
	if(userName ==null)
		response.sendRedirect(redirectURL);
%>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#change_password').hide();
	
    $("#change_password_btn").click(function(){
        $("#change_password").slideToggle("slow")
    });
});

function displayChangePasswordDialog(){
	$("#change_password").show(500);
}

function displayDialog(name){
	$('#'+name).show(500);
}

function hideDialog(name){
	$('#'+name).hide(500);
}



</script>
</head>
<body>
<jsp:include page="../navTab.jsp" />
<div class="main_container">
	<div class="">
              <h3>Detail Profile User</h3> 
			<table class="content">
					<tr>
						<td class="td_table">Username:</td>
						<td class="td_table">${sessionScope.loginUser.getUserName()}</td>
						
					</tr>
					<tr>
						<td class="td_table">Password:</td>
						<td class="td_table">${sessionScope.loginUser.getUserPassword()}</td>
					</tr>
					<tr>
					<td  colspan="2" ><button id="change_password_btn">Change Password</button> </td>
					</tr>
					
			</table>	
	
	</div>
	
	
	
	
	
	<div id="change_password">
	
	
	<h3>Change Password</h3>
		<table class="content">
					<tr>
						<td class="td_long_table">New Password:</td>
						<td class="td_table"><input type="password" id="new_password">  </td>
						
					</tr>
					<tr>
						<td class="td_long_table">Confirm New Password:</td>
						<td class="td_table"><input type="password" id="confirm_new_password"></td>
					</tr>
					<tr>
					<td class="td_long_table" align="center"><button>Save</button> </td>
					<td class="td_long_table" align="center"><button>Cancel</button> </td>
					</tr>
					
			</table>
	
	</div>
</div>



	
</body>
</html>