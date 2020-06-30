<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Delete Job</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12" id="content">
					<h1>
						<strong>Delete Job</strong>
					</h1>
					<hr>
				</div>
			</div>
			<c:if test="${ empty jobs }"><center>No content to display</center></c:if>
			<c:if test="${ not empty jobs }">
			<c:if test="${ not empty status }">
				<div id="myAlert" class="alert alert-success">${ status }</div>
			</c:if>
			<table class="table table-bordered table-hover table-condensed table-responsive">
				<thead>
					<tr>
						<th>Job Id</th>
						<th>Job Title</th>
						<th>Department</th>
						<th>Date of creation</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ requestScope.jobs }" var="job">
					<tr>
						<td>${ job.getJobId() }</td>
						<td>${ job.getJobTitle() }</td>
						<td>${ job.getDepartment() }</td>
						<td>${ job.getDateOfJobCreation() }</td>
						<td>
							<form action="deleteJob" method="post">
								<input id="jobId" name="jobId" value="${ job.getJobId() }" hidden="true">
								<input type="submit" class="btn btn-danger" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>					
				</tbody>
			</table>
			</c:if>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>