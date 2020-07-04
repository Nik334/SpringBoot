<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Assigning Candidate</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content">
					<h1>Assign Candidate</h1>
					<p>By clicking on an arrow</p>
				</div>
			</div>
				<div class="panel-group" id="accordion">
				<c:forEach items="${ requestScope.jobs }" var="job">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
									${ job.getJobId() }. ${ job.getJobTitle() }
								</a>
							</h4>
							<form action="assign" method="get" class="pull-right">
								<input id="jobId" name="jobId" value="${ job.getJobId() }" hidden="true">
								<button type="submit"><span class="fa fa-arrow-right"></span></button>
							</form>
						</div>
						<%-- <div id="collapse1" class="panel-collapse collapse in">
							<table class="table table-bordered table-hover table-condensed table-responsive panel-body">
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
												<form action="assigningCandidate" method="post">
													<input id="jobId" name="jobId" value="${ job.getJobId() }"
														hidden="true">
													<button type="submit">
														<span class="fa fa-arrow-right"></span>
													</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div> --%>
					</div>
					<br>
				</c:forEach>
				</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>