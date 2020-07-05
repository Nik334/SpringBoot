<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../../assests/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="../../assests/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
<link href="../../assests/css/font-awesome.min.css" rel="stylesheet">
<title>Visitor Login</title>
</head>
<body>
	<br><br><br><br><br><br>
      <form method="post" action="../../visitor/home">
          <div class="container">
              <div class="row">
                  <div class="col-sm-offset-3 col-sm-6" style="box-shadow: 0px 30px 60px rgba(0,0,0,0.30)">
                      <div class="jumbotron form-group">
                          <div class="h2 text-center"><strong>User Login</strong></div>
                          <div class="form-group">
                              <input type="text" class="form-control" name="email" id="email" placeholder="Username or Email" autofocus=""/>
                              <span class="text-danger"></span>
                          </div>
                          <div class="form-group">
                              <input type="password" class="form-control" name="password" id="password" placeholder="Password" data-toggle="password"/>
                              <span class="text-danger"></span>
                          </div>
                          <div class="form-group">
                              <input type="submit" class="form-control btn " id="login" name="login" value="Login" style="background-color: #cccccc">                        
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </form>
	
	
	<script src="../../assests/js/jquery-2.2.0.min.js" type="text/javascript"></script>
	<script src="../../assests/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../../assests/js/bootstrap-show-password.min.js" type="text/javascript"></script>
</body>
</html>