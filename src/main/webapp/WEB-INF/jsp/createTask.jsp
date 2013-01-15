<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function backPage(){
	window.open('home','_self',false);
}
</script>
<form method="post" action="create" ModelAttribute="task">
<div>
<ul>
<li>Enter Task :<form:input path="task.name"/></li>
<li>Description :<form:input path="task.description"/></li>
<li>Enter Last Date (dd/mm/yyyy):<form:input path="task.createdDate"/></li>
<li><input type="submit" value="Submit"><input type="button" value="Back" onclick="javascript:backPage()"></li>
</div>
</form>
</body>
</html>