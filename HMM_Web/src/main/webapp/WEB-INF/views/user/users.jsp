<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../css.jsp"></jsp:include>
<% String url=request.getContextPath(); %>
<link href="<%=request.getContextPath() %>/resources/jtable/themes/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=request.getContextPath() %>/resources/jtable/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize jTable
        $('#UserTableContainer').jtable({
            title: 'Users in Home',
            actions: {
                listAction:'<%=url%>'+'/user/list',
                createAction:'<%=url%>'+'/user/create',
                updateAction: '<%=url%>'+'/user/update',
                deleteAction: '<%=url%>'+'/user/delete'
            },
            fields: {
                personID: {
					 title: 'ID',
	                    width: '30%',
                    key: true,
					list : true,
					edit : false,
					create : false
                },				
                personName: {
                    title: 'User Name',
                    width: '30%',
					edit : true,
					create : true
                }
                 
            }
        });        
        $('#UserTableContainer').jtable('load');

    });
</script>

</head>
<!-- Navigation Tab -->
<jsp:include page="../navTab.jsp"></jsp:include>
<body>


<div class="main_container">
	<h1>Users</h1>

<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<div id="UserTableContainer"></div>
</div>
</div>
</body>
</html>