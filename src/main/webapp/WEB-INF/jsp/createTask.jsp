<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/datepicker.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap-datepicker.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Task</title>
</head>
<body>
<script type="text/javascript">
function backPage(){
	if('${fromPage}'=='view'){
		window.open('/TaskMaster/task/view','_self',false);
	}else{
	 window.open('/TaskMaster/task/home','_self',false);
	}
}
    
jQuery(function()
{
	jQuery('.datepicker').datepicker();
});
</script>
<form:form method="post" action="/TaskMaster/task/create?fromPage=${fromPage}" commandName="task">
<div class="container-fluid">
	<table class="table">

<form:hidden path="id"/>
<tr><td>Enter Task :<form:input path="name" required="true"/>
<form:errors class="text-error" path="name" /></td></tr>
<tr><td>Description :<form:input path="description" required="true"/>
<form:errors class="text-error" path="description"/></td></tr>
<tr><td>Enter Last Date (dd/mm/yyyy):
<form:input path="date" class="datepicker" data-date-format="dd/mm/yyyy" readonly="true" type="text" required="true"/>
<form:errors class="text-error" path="date" /></td></tr>
<tr><td>Assign Task to :<select name="userId">
<option value="0">Self</option>
<c:forEach items="${users}" var="user"> 
<option value="${user.id}">${user.firstName}</option>
</c:forEach>
</select></tr>
<tr><td><input type="submit" class="btn btn-success btn-small" value="Submit">
<input type="button" class="btn btn-success btn-small" value="Back" onclick="javascript:backPage()"></td></tr>
</table>
</div>
</form:form>
</body>
</html>