<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Add Job</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12" id="content">
					<h1>
						<strong>Add Job</strong>
					</h1>
					<hr>
				</div>
			</div>
			<form action="addJob" method="post" class="row">
				<c:if test="${not empty status }">
					<div id="myAlert" class="alert alert-success">${ status }</div>
				</c:if>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="jobTitle">Job title</label> 
						<input type="text" class="form-control" name="jobTitle" id="jobTitle" placeholder="Enter Job title" autofocus="" /> 
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="department">Department</label> 
						<input type="text" class="form-control" name="department" id="department" placeholder="Enter Department Name" /> 
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" id="login" name="login" value="Add Job">
					</div>
				</div>
			</form>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>