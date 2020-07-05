<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.nik.main.model.Job" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="links.jsp"></jsp:include>
<title>Edit Job</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12" id="content">
					<h1><strong>Edit Job</strong></h1>
					<hr>
				</div>
			</div>
			
			<form class="row" action="../../admin/updateJob" method="post">
				<c:if test="${not empty status }">
				<div id="myAlert" class="alert alert-success">${ status }</div>
				</c:if>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="jobId">Job Id</label> 
						<select class="form-control" name="jobId" id="jobId">
							<option>Select Job Id</option>
						<c:forEach items="${ requestScope.jobs }" var="particularJob">
						<c:choose>
							<c:when test="${ job.getJobId() == particularJob.getJobId() }">
								<option value="${ job.getJobId() }" selected="selected">${ job.getJobId() }</option>
							</c:when>
							<c:otherwise>
								<option value="${ particularJob.getJobId() }">${ particularJob.getJobId() }</option>
							</c:otherwise>
						</c:choose>
						</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="jobTitle">Job title</label> 
						<input type="text" class="form-control" value="${ job.getJobTitle() }" name="jobTitle" id="jobTitle" placeholder="Enter Job title" autofocus=""/> 
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="department">Department</label> 
						<input type="text" class="form-control" value="${ job.getDepartment() }" name="department" id="department" placeholder="Enter Department Name" /> 
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" id="update" name="update" value="Update">
					</div>
				</div>
			</form>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	$(function(){
	      $('#jobId').on('change', function () {
	          var url = '../../admin/job/'+$(this).val();
	          if (url) { 
	              window.location = url;
	          }
	          return false;
	      });
	    });
	</script>
</body>
</html>