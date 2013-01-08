<html>
<script type="text/javascript">
function openIndexPage(){
	window.open('/index.jsp','_self',false);
}
</script>
<h2>Register User</h2>
<form action="createUser" method="post">
First Name : <input type="text" name="firstName">
Last Name :<input type="text" name="lastName">
Email Address(will be used as userName to login) : <input type="email" name="email">
Password : <input type="password" name="password">
Mobile Number : <input type="tel" name="mobileNumber">
<input type="submit" value="Submit">
<input type="button" value="back" onclick="javascript:openIndexPage();">
</form>
</html>
