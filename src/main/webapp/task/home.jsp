<html>
<%@ page import="com.example.model.User"%>
<script type="text/javascript">
function openViewTasks(){
	window.open('/taskMaster1.1/task/viewTasks','_self',false);
}

function openCreateTaskForm(){
	window.open('/taskMaster1.1/task/createTask.jsp','_self',false);
}

function logout(){
	window.open('/taskMaster1.1/logout','_self',false);
}
</script>
<body>
<h2>Welcome to Task Master, <%=((User)session.getAttribute("user")).getFirstName()%></h2>
<input type="button" value="my Tasks" onclick="javascript:openViewTasks()">
<input type="button" value="create Task" onclick="javascript:openCreateTaskForm();">
<input type="button" value="logout" onClick="javascript:logout();">
</body>
</html>
