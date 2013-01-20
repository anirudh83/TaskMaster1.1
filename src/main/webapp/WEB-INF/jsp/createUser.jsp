<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register New User</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="css/bootstrap.css"/>"/>
</head>
<body>
<div align="center">
<form method="post" modelAttribute="user">
<table>
<tr><td>First Name :</td><td><form:input path="user.firstName"/></td></tr>
<tr><td>Last Name :</td><td><form:input path="user.lastName"/></td></tr>
<tr><td>Email Address(will be used as userName to login) :</td><td><form:input path="user.email"/></td></tr>
<tr><td>Password :</td><td><form:input path="user.password"/></td></tr>
<tr><td>Mobile Number : </td><td><form:input path="user.mobileNum"/></td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</div>
</body>
</html>