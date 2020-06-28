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
					<h1>
						<strong>Edit Job</strong>
					</h1>
					<hr>
				</div>
			</div>
			<select class="form-control pull-right" name="selectJob" id="selectJob">
			<c:forEach items="${ requestScope.jobs }" var="job">
				<option value="job/${ job.getJobId() }">${ job.getJobTitle() }</option>
			</c:forEach>
			</select>
			
			<div class="row">
				${ job.getJobTitle() }
				${ job.getJobId() }
				${ job.getJobDepartment() }
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	$(function(){
	      $('#selectJob').on('change', function () {
	          var url = $(this).val();
	          if (url) { 
	              window.location = url;
	          }
	          return false;
	      });
	    });
	</script>
</body>
</html>