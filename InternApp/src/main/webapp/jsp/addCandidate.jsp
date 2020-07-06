<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Register candidate</title>
</head>
<body>
	<div class="container center">
		<div class="row" id="main">
			<div class="col-sm-12 col-md-12 well" id="content">
				<h1>Register candidate</h1>
			</div>
		</div>
		<form class="row" action="../../candidate/addUser" method="post">
			<c:if test="${not empty status }">
				<div id="myAlert" class="alert alert-success">${ status }</div>
			</c:if>
			<div class="col-sm-6">
				<div class="form-group">
					<label for="firstName">First name</label> 
					<input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter First Name" autofocus="autofocus" required="required">
				</div>
				<div class="form-group">
					<label for="lastName">Last Name</label> 
					<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter Last Name" required="required" />
				</div>
				<div class="form-group">
					<label for="email">Email</label> 
					<input type="text" class="form-control" name="email" id="email" placeholder="Enter Email address" required="required" />
				</div>
				<div class="form-group">
					<label for="role">Role</label> 
					<input type="text" class="form-control" name="role" id="role" placeholder="Enter Candidate role" required="required" />
				</div>
				<div class="form-group">
					<label for="password">Password</label> 
					<input type="password" class="form-control" name="password" id="password" placeholder="Enter Password" required="required" data-toggle="password" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-info" value="Register">
				</div>
			</div>
		</form>
	</div>
</body>
</html>