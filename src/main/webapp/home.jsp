<html>
<%@ page import="com.example.model.User"%>
<script type="text/javascript">
function openViewTasks(){
	window.open('viewTasks','_self',false);
}

function openCreateTaskForm(){
	window.open('createTask.jsp','_self',false);
}
</script>
<body>
<h2>Welcome to Task Master, <%=((User)session.getAttribute("user")).getFirstName()%></h2>
<input type="button" value="my Tasks" onclick="javascript:openViewTasks()">
<input type="button" value="create Task" onclick="javascript:openCreateTaskForm();">
</body>
</html>
