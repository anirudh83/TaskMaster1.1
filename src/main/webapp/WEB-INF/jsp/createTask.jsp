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
<li>Enter Task :<form:input path="task.name"/></li>
<li>Description :<form:input path="task.description"/></li>
<li>Enter Last Date (dd/mm/yyyy):<form:input path="task.date"/></li>
<li><input type="submit" value="Submit"><input type="button" value="Back" onclick="javascript:backPage()"></li>
</div>
</form>
</body>
</html>