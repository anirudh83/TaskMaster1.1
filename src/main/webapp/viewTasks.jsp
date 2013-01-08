<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.model.Task" %>
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
<%
	List<Task> allTasks = (List<Task>)request.getAttribute("tasks");
for(Task task : allTasks){
	out.print("<br>"+task.getName());
	out.print("to be done by : "+task.getCreatedBy().getFirstName());
}
%>
<br>
<input type="button" value="Back" onclick="javascript:backPage()">
</body>
</html>