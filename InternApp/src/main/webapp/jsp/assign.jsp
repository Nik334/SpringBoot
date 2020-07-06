<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Assign Job</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<c:if test="${ not empty status }"><center>${ status }</center></c:if>
			<c:if test="${ not empty jobId }">
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content">
					<h1>Assign Candidate to Job Id : ${ jobId }</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-11 col-md-10">
					<h3>Candidate(s) assigned to the job</h3>
				</div>
				<div class="col-sm-11 col-md-10">
					<c:if test="${ empty usersOnTheJob }"><center>No content to display</center></c:if>
					<c:if test="${ not empty usersOnTheJob }">
					<c:if test="${ not empty status }">${ status }</c:if>
					<table class="table table-bordered table-hover table-condensed table-responsive">
						<thead>
							<tr>
								<th>User Id</th>
								<th>Name</th>
								<th>Email</th>
								<th>Role</th>
								<th>Position</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${ requestScope.usersOnTheJob }" var="user">
							<tr>
								<td>${ user.getUesrId() }</td>
								<td>${ user.getFirstName() } ${ user.getLastName() }</td>
								<td>${ user.getEmail() }</td>
								<td>${ user.getRole() }</td>
								<td>${ user.getPosition() }</td>
								<td class="text-success">Assigned</td>
								<td>
									<form action="removeUser" method="get">
										<input id="jobId" name="jobId" value="${ jobId }" hidden="true">
										<input id="userId" name="userId" value="${ user.getUesrId() }" hidden="true">
										<input type="submit" class="btn btn-link" value="Remove">
									</form>
								</td>
							</tr>
						</c:forEach>					
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-11 col-md-10">
					<h3>Candidate(s) not assigned to any job</h3>
				</div>
				<div class="col-sm-11 col-md-10">
					<c:if test="${ empty usersNotHaveJob }"><center>No content to display</center></c:if>
					<c:if test="${ not empty usersNotHaveJob }">
					<c:if test="${ not empty status }">
						${ status }
					</c:if>
					<table class="table table-bordered table-hover table-condensed table-responsive">
						<thead>
							<tr>
								<th>User Id</th>
								<th>Name</th>
								<th>Email</th>
								<th>Role</th>
								<th>Position</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${ requestScope.usersNotHaveJob }" var="user">
							<tr>
								<td>${ user.getUesrId() }</td>
								<td>${ user.getFirstName() } ${ user.getLastName() }</td>
								<td>${ user.getEmail() }</td>
								<td>${ user.getRole() }</td>
								<td>${ user.getPosition() }</td>
								<td class="text-danger">Not Assigned</td>
								<td>
									<form action="assignUser" method="get">
										<input id="jobId" name="jobId" value="${ jobId }" hidden="true">
										<input id="userId" name="userId" value="${ user.getUesrId() }" hidden="true">
										<input type="submit" class="btn btn-link" value="Assign">
									</form>
								</td>
							</tr>
						</c:forEach>					
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
			</c:if>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>