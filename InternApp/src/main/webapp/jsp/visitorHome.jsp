<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Home</title>
</head>
<body>
	<div class="container">
		<h2>Candidates assigned</h2>
		<hr>
		<c:if test="${ empty usersOnTheJob }">
			<center>No content to display</center>
		</c:if>
		<c:if test="${ not empty usersOnTheJob }">
			<table class="table table-bordered table-hover table-condensed table-responsive">
				<thead>
					<tr>
						<th>User Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Role</th>
						<th>Position</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ requestScope.usersOnTheJob }" var="user">
					<tr>
						<td>${ user.getUesrId() }</td>
						<td>${ user.getFirstName() }${ user.getLastName() }</td>
						<td>${ user.getEmail() }</td>
						<td>${ user.getRole() }</td>
						<td>${ user.getPosition() }</td>
						<td class="text-success">Assigned</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


	<script src="../../assests/js/jquery-2.2.0.min.js" type="text/javascript"></script>
	<script src="../../assests/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../../assests/js/bootstrap-show-password.min.js" type="text/javascript"></script>
</body>
</html>