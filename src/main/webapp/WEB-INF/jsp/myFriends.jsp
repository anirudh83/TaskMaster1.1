<!DOCTYPE html>
<html lang="en">
  <head>
    <title>My Friends</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link href="<c:url value="css/bootstrap-responsive.css"/>" rel="stylesheet">

<script>

function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}

function openSearchUsersPage(){
	window.open('/TaskMaster/users','_self',false);
}

function openPendingRequestsPage(){
	window.open('/TaskMaster/myFriends/pending','_self',false);
}
</script>
  </head>
  <body>
    <h1>My Friends Page</h1>
	<div class="container-fluid">
<ul class="nav nav-tabs">
  <li class="active"><a href="#">MyFriends</a></li>
  <li><a href="javascript:openSearchUsersPage()">Search Users</a></li>
  <li><a href="javascript:openPendingRequestsPage()">Pending Requests</a></li>
</ul>
<div class="container-fluid">
	<table class="table table-striped">
<th>first Name</th>
<th>last Name</th>
<th>email</th>
<c:forEach items="${friends}" var="friend">
<tr id="row${friend.id}">
<td>
${friend.firstName}</td><td> ${friend.lastName}
</td>
<td>
${friend.email}
</td>
</tr>
</c:forEach>
  </table>
	<input type="button" class="btn btn-success btn-small"  value="back" onclick="javascript:backPage();">
	</div>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    
  </body>
</html>