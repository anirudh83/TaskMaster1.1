<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript">
function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Exercise Schedule</title>
</head>
<body>
<h1>My Exercise Schedule</h1>
<h3>Under Construction</h3>
<input type="button" value="Back" onclick="javascript:backPage()">
</body>
</html>