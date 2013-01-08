<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.model.Task" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function backPage(){
	window.open('/taskMaster1.1/home.jsp','_self',false);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Tasks</title>
</head>
<body>
<h1>All Tasks</h1>
<table border="1">
<th>Task</th>
<th>Person Name</th>
<c:forEach items="${tasks}" var="task">
<tr>
<td>
${task.name}
</td>
<td>
${task.createdBy.firstName}
</td>
<td><a href="viewTasks?action=delete&id=${task.id}">delete</a></td>
</tr>
</c:forEach>
</table>
<br>
<input type="button" value="Back" onclick="javascript:backPage()">
</body>
</html>