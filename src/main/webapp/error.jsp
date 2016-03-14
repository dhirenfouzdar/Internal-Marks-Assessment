<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Not Found</title>
	<link rel="shortcut icon" href="pages/pimages/titlelogo.png"/>
<!-- Bootstrap Core CSS -->
    <link href="pages/pcss/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="pages/pcss/modern-business.css" rel="stylesheet">
        <link href="pages/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
     <script src="pages/pjs/jquery.js"></script>
    <script src="pages/pjs/bootstrap.min.js"></script>
      <script src="pages/pjs/googleanalytics.js"></script>
      <style type="text/css">
.error-template {padding: 40px 15px;text-align: center;}
.error-actions {margin-top:15px;margin-bottom:15px;}
.error-actions .btn { margin-right:10px; }
      </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    404 Not Found</h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
                <div class="error-actions">
                 <!--  Stage server path -->
                <!--  <a href="http://52.24.66.2:8080/PlacementPortal" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="http://52.24.66.2:8080/PlacementPortal/loginportal" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-user"></span> User Login Page </a> -->
                   <!--  Production path -->
                 <!--  <a href="http://52.10.214.226:8080/PlacementPortal" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="http://52.10.214.226:8080/PlacementPortal/loginportal" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-user"></span> User Login Page </a>
 -->                        <!--  Local path -->
                    <a href="http://localhost:8080/PlacementPortal" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="http://localhost:8080/AIMS" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-user"></span> User Login Page </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>