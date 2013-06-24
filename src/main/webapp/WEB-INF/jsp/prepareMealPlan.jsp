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
<title>Create Meal Plan</title>
</head>
 <body>
<script>

function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}

jQuery(function()
		{
			jQuery('.datepicker').datepicker();
		});
</script>

    <h3>Create Meal Plan</h3>
    <form:form method="post" action="/TaskMaster/meals/" commandName="meal">
	<table>

<tr><td>Breakfast :<form:input path="breakfast" required="true"/>
<form:errors class="text-error" path="breakfast" /></td></tr>
<tr><td>Lunch :<form:input path="lunch" required="true"/>
<form:errors class="text-error" path="lunch"/></td></tr>
<tr><td>Dinner :<form:input path="dinner" required="true"/>
<form:errors class="text-error" path="dinner"/></td></tr>
<tr><td>Enter Date (dd/mm/yyyy):
<form:input path="date" class="datepicker" data-date-format="dd/mm/yyyy" readonly="true" type="text" required="true"/>
<form:errors class="text-error" path="date" /></td></tr>
<tr><td><input type="submit" class="btn btn-success btn-small" value="Submit">
<input type="button" class="btn btn-success btn-small" value="Back" onclick="javascript:backPage()"></td></tr>
</table>
</form:form>
  </body>
</html>