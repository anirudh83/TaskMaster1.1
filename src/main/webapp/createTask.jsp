<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function backPage(){
	window.open('home.jsp','_self',false);
}
</script>
<form method="post" action="task/create">
<div>
<ul>
<li>Enter Task :<input type="text" name="name"></li>
<li>Description :<input type="text" name="description"></li>
<li>Enter Date (dd/mm/yyyy):<input type="text" name="date"></li>
<li>Enter the person who has to do it : <input type="text" name="personName"></li>
<li><input type="submit" value="Submit"><input type="button" value="Back" onclick="javascript:backPage()"></li>
</div>
</form>
</body>
</html>