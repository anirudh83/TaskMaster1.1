<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<script type="text/javascript">

function openCreateUserPage(){
	window.open('users','_self',false);
}
</script>
    <form class="form-horizontal" method="post" action="login">
    <div class="control-group">
    <label class="control-label" for="inputEmail">Email</label>
    <div class="controls">
    <input type="text" id="inputEmail" placeholder="Email" name="emailAddress">
    </div>
    </div>
    <div class="control-group">
    <label class="control-label" for="inputPassword">Password</label>
    <div class="controls">
    <input type="password" id="inputPassword" placeholder="Password" name="password">
    </div>
    </div>
    <div class="control-group">
    <div class="controls">
    <label class="checkbox">
    <input type="checkbox"> Remember me
    </label>
    <button type="submit" class="btn">Sign in</button>
    <p><font color="red">${error}</font></p>
    </div>
    </div>
    </form>
</body>
</html>
