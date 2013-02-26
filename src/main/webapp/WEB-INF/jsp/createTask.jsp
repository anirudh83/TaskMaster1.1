<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}
</script>
<form method="post" action="/TaskMaster/task/create" ModelAttribute="task">
<div class="content1">
<ul>
<form:hidden path="task.id"/>
<li><label for="task.name">Enter Task : </label><form:input path="task.name"/><p><font color="red"><form:errors path="task.name"/></font></p></li>
<li><label for="task.description">Description :</label><form:input path="task.description"/><p><font color="red"><form:errors path="task.description"/></font></p></li>
<li><label for="task.date">Enter Last Date (dd/mm/yyyy):</label><form:input path="task.date"/><p><font color="red"><form:errors path="task.date"/></font></p></li>
<li><input type="submit" value="Submit"><input type="button" value="Back" onclick="javascript:backPage()"></li>
</div>
</form>
</body>
</html>