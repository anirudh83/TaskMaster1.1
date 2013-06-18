<!DOCTYPE HTML>
<html>
<head>
<%@ page import="com.example.form.UserForm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<script type="text/javascript">
function openViewTasks(){
	window.open('/TaskMaster/task/view','_self',false);
}

function openCreateTaskForm(){
	window.open('/TaskMaster/task/showCreate','_self',false);
}

function logout(){
	window.open('/TaskMaster/logout','_self',false);
}
</script>
    <form class="bs-docs-example form-inline">
    <fieldset>
    <legend>Welcome to Task Master, ${user.firstName}</legend>
    <span class="help-block">Make your task or view your tasks</span>
   
 
<input type="button" class="btn btn-primary btn-large" value="my Tasks" onclick="javascript:openViewTasks()">
<input type="button" class="btn btn-success btn-large"  value="create Task" onclick="javascript:openCreateTaskForm();">
<input type="button" class="btn btn-danger btn-large" value="logout" onClick="javascript:logout();">
<br><p><font color="red">${sucessmsg}</font></p>
 </fieldset>
</form>
</body>
</html>
