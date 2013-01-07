<html>
<script type="text/javascript">

function openHomePage(){
	window.open('login','_self',false);
}

function openCreateUserPage(){
	alert("work in progress");
}
</script>
<form method="post" action="login">
<body>
<h2>Welcome to Task Master</h2>
<input type="button" value="register" onclick="javascript:openCreateUserPage()">
Enter your Name: <input type="text" name="username">
Password: <input type="text" name="password">
<input type="submit" value="Login">
<input type="button" value="Show" onclick="javascript:openHomePage();">
</body>
</form>
</html>
