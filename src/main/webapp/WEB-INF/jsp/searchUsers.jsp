<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >
<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript">
function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}


	function addAsFriend(id) {

		jQuery.ajax({
			type : "POST",
			url : "/TaskMaster/myFriends/friend/"+id,
			success : function(response) {
				// we have the response
				var rowId = 'row'+id;
				jQuery('#'+rowId).find('a').html("Friend Request Sent")
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}


	function removeFriend(id) {
		jQuery.ajax({
			type : "PUT",
			url : "/TaskMaster/task/"+id,
			success : function(response){
				var rowId = 'row'+id;
				if(response=="true"){
				jQuery('#'+rowId).find("img").attr('src','<c:url value="/img/checkbox_checked.jpg"/>')
				}else{
					jQuery('#'+rowId).find("img").attr('src','<c:url value="/img/check_box.jpg"/>')
				}
			},
			error : function(e){
                  alert('Error : '+e);				
			}
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Users</title>
</head>
<body>
<h1>All Users</h1>
 
<div class="container-fluid">
	<table class="table table-striped">
<th>first Name</th>
<th>last Name</th>
<th>&nbsp</th>
<c:forEach items="${users}" var="user">
<tr id="row${user.id}">
<td>
${user.firstName}
</td>
<td>
${user.lastName}
</td>
<td><a href="javascript:addAsFriend(${user.id})">Add as Friend
</a></td>
</tr>
</c:forEach>
</table>
</div>
<br><p id="info"><font color="red">${sucessmsg}</font></p>
<br>
<input type="button" class="btn btn-success btn-small" value="Back" onclick="javascript:backPage()">
</body>
</html>