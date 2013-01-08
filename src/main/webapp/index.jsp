<html>
<script type="text/javascript">

function openHomePage(){
	window.open('login','_self',false);
}

function openCreateUserPage(){
	window.open('registerUser.jsp','_self',false);
}
</script>


<form method="post" action="login">
<h2>Welcome to Task Master</h2>
<input type="button" value="register" onclick="javascript:openCreateUserPage()">
</br>
<h3>Login</h3>
<div>
<ul>
<li>Email Address: <input type="text" name="emailAddress"></li>
<li>Password: <input type="password" name="password"></li>
<li><input type="submit" value="Login"><p><font color="red">${error}</font></p></li>
</ul>
</div>
</form>
</html>
