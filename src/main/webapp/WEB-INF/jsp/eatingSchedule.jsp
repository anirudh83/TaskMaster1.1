<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Eating Schedule</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link href="<c:url value="css/bootstrap-responsive.css"/>" rel="stylesheet">

<script>
function openCreateMealForm(){
	window.open('/TaskMaster/meals/view','_self',false);
}

function backPage(){
	window.open('/TaskMaster/task/home','_self',false);
}

function deleteMeal(id) {

	jQuery.ajax({
		type : "DELETE",
		url : "/TaskMaster/meals/"+id,
		success : function(response) {
			// we have the response
			var rowId = 'row'+id;
			jQuery('#'+rowId).remove();
			$('#info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}
</script>
  </head>
  <body>
    <h1>My Eating Schedule</h1>
	<div class="container-fluid">
	<table class="table table-striped">
  <thead>
    <tr>
      <th>Breakfast</th>
      <th>Lunch</th>
      <th>Dinner</th>
      <th>Date</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${meals}" var="meal">
    <tr id="row${meal.id}">
      <td>${meal.breakfast}</td>
      <td>${meal.lunch}</td>
      <td>${meal.dinner}</td>
      <td>${meal.date}</td>
      <td><input type="button" class="btn btn-danger btn-small"  value="delete" onclick="javascript:deleteMeal(${meal.id});"></td>
    </tr>
    </c:forEach>
  </tbody>
	</table>
	
	<input type="button" class="btn btn-success btn-small"  value="back" onclick="javascript:backPage();">
	<input type="button" class="btn btn-success btn-small"  value="create Meal Plan" onclick="javascript:openCreateMealForm();">
	</div>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    
  </body>
</html>