<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Template Bill</title>
<jsp:include page="../css.jsp"></jsp:include>
<% String url=request.getContextPath(); %>
<link href="<%=request.getContextPath() %>/resources/jtable/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=request.getContextPath() %>/resources/jtable/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize jTable
        $('#PersonTableContainer').jtable({
            title: 'Table of Template Bill',
            actions: {
                listAction:'<%=url%>'+'/templateBill/list',
                createAction:'<%=url%>'+'/templateBill/create',
                updateAction: '<%=url%>'+'/templateBill/update',
                deleteAction: '<%=url%>'+'/templateBill/delete'
            },
            fields: {
                billID: {
					 title: 'ID',
	                    width: '30%',
                    key: true,
					list : true,
					edit : false,
					create : false
                },				
                description: {
                    title: 'Description',
                    width: '30%',
					edit : true,
					create : true
                }
                 
            }
        });        
        $('#PersonTableContainer').jtable('load');

    });
</script>

</head>
<!-- Navigation Tab -->
<jsp:include page="../navTab.jsp"></jsp:include>
<body>


<div class="main_container">
	<h1>Template Bill</h1>
</div>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<div id="PersonTableContainer"></div>
</div>

</body>
</html>