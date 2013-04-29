<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}
function openCreateTaskForm(){
	window.open('/TaskMaster/task/showCreate?from=view','_self',false);
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Tasks</title>
</head>
<body>
<h1>All Tasks</h1>
 <c:set var="numOfTasks" value="${fn:length(tasks)}"/>
<c:choose>
<c:when test="{numOfTasks = 0}">
No Tasks pending!! Enjoy buddy! PAARRRRTTYYYYY~~~!!
</c:when>
<c:otherwise>
<table border="1">
<th>Task</th>
<th>Description</th>
<th>Person Name</th>
<th>Date</th>
<c:forEach items="${tasks}" var="task">
<tr>
<td>
${task.name}
</td>
<td>
${task.description}
</td>
<td>
${task.createdBy}
</td>
<td>
${task.date}
</td>
<td><a href="/TaskMaster/task/delete/${task.id}">Done</a></td>
<td><a href="/TaskMaster/task/showEdit/${task.id }">Edit</a></td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
<br><p><font color="red">${sucessmsg}</font></p>
<br>
<input type="button" value="Back" onclick="javascript:backPage()">
<input type="button" value="Create Task" onclick="javascript:openCreateTaskForm()">
</body>
</html>