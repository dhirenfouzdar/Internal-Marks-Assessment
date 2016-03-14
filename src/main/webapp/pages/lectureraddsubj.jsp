<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>AIMS|Tjohncollege.</title>

    <!-- Bootstrap -->
    <link href="pages/css/bootstrap.min.css" rel="stylesheet">
    <link href="pages/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="pages/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="pages/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="pages/js/bootstrap.min.js"></script>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
  <div class="container">
   <div class="row">
     <div class="col-sm-3"> </div>
   <div class="col-sm-6">

    <h3>Attendance & Internals Management System </h3>

   </div>
     <div class="col-sm-3"> </div>
   </div>
   </div>
   
  </nav>  
<nav role="navigation" class="navbar navbar-default">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- Collection of nav links, forms, and other content for toggling -->
          <div class="container">
          <div class="row">
          <div class="col-sm-2"> </div>
           <div class="col-sm-8 padding0"> 
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                        <s:url action="lectureAttendence" var="letuatnd"/>
			 	         <s:a href="%{letuatnd}">Attendance</s:a>                
                </li>
                <li>
                        <s:url action="lectureInternl" var="letuint"/>
			 	         <s:a href="%{letuint}">Internals</s:a>                 
                </li>
 
                 <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Profile<b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                        <li>
                        <s:url action="lectureProf" var="letuprof"/>
			 	         <s:a href="%{letuprof}">Add Profile</s:a>
			 	         </li>
                        <li class="divider"></li>
                        <li>
                        <s:url action="lectureeditprof" var="letueditp"/>
			 	         <s:a href="%{letueditp}">Edit Profile</s:a>                         
                        </li>
                    </ul>
                </li>
              <li>
              <s:url action="resetletur" var="reset"/>
			  <s:a href="%{reset}">Reset Password</s:a>    
			  </li>                  
              <li>
              <s:url action="logout" var="lectlogout"/>
			  <s:a href="%{lectlogout}">Logout <i class="fa fa-sign-out"></i></s:a>    
			  </li>   
            </ul>
        </div>
        </div>
         <div class="col-sm-2">
         <p class="text-success" style="margin-top: 15px;">Welcome:&nbsp<s:property value="#session.usn "/></p> 
         </div>
        </div>
        </div>
    </nav>      
  
  <div class="container">
   <div class="row">
    <div class="visible-sm-12" style="margin-top:40px;"> </div>
    <div class="col-sm-12">
<div class="col-sm-12">

lecture add sub
</div>
    </div>
          
   </div>
  </div>


  </body>
</html>