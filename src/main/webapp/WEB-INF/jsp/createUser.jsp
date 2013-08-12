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
<form:form  method="post" commandName="user" action="/TaskMaster/users">
<table>
<tr><td>First Name :</td>
<td><form:input path="firstName" placeholder="Enter your first name" required="true" />
<form:errors class="text-error" path="firstName"/>
</td></tr>
<tr><td>Last Name :</td>
<td><form:input path="lastName" placeholder="Enter your last name" />
<form:errors class="text-error" path="lastName"/>
</td></tr>
<tr><td>Email Address(will be used as userName to login) :</td>
<td><form:input path="email" placeholder="Enter your mail" type="email" required="true" />
<form:errors class="text-error" path="email"/>
</td></tr>
<tr><td>Password :</td>
<td><form:input path="password" type="password" required="true" />
<form:errors class="text-error" path="password"/>
</td></tr>
<tr><td>Mobile Number : </td>
<td><form:input path="mobileNum" type="number" required="true" />
<form:errors class="text-error" path="mobileNum" />
</td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form:form>
</div>
</body>
</html>