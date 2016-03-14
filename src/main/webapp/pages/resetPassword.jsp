<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="s" uri="/struts-tags"%>  

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>internal management system</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <link href="pages/css/bootstrap.min.css" rel="stylesheet">
    <link href="pages/font-awesome/css/font-awesome.min.css" rel="stylesheet">
   <link href="pages/css/style.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="pages/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="pages/js/bootstrap.min.js"></script>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
          <div class="col-sm-3"> </div>
           <div class="col-sm-6 padding0"> 
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="">
                         <s:url action="studentattend" var="studatt"/>
			 	         <s:a href="%{studatt}">Internals</s:a> 
			 	 </li>                 

                 <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Profile<b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                         <li>
                         <s:url action="studentProf" var="studprof"/>
			 	         <s:a href="%{studprof}">Add Profile</s:a>
			 	         </li>
                        <li class="divider"></li>
                        <li>
                         <s:url action="studenteditpro" var="studedit"/>
			 	         <s:a href="%{studedit}">Edit Profile</s:a>                        
                        </li>
                    </ul>
                </li>
                <li class="active">
                         <s:url action="resetstud" var="reset"/>
			 	         <s:a href="%{reset}">Reset Password</s:a> 
			 	 </li>                  
              <li>
              <s:url action="logout" var="stulogout"/>
			  <s:a href="%{stulogout}">Logout <i class="fa fa-sign-out"></i></s:a>  </li>              
            </ul>
        </div>
        </div>
         <div class="col-sm-3"> 
  <p class="text-success" style="margin-top: 15px;">Welcome:&nbsp<s:property value="#session.usn "/></p>          
         </div>
        </div>
        </div>
    </nav> 
    <div class="container">
   <div class="row">
    <div class="visible-sm-12" style="margin-top:40px;"> </div>
<div class="col-sm-12">
<div class="col-sm-3"></div>
<div class="col-sm-6">
     <div class="panel panel-default">
                <div class="panel-body">
  
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>   
            <form class="form form-signup" action="updatePassword" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input name="currentPassword" id="currentPassword" type="password" placeholder="Current Password" class="form-control" maxlength="25" required/>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input name="newPassword" id="newPassword"  type="password" placeholder="New Password" class="form-control" maxlength="25" onKeyUp="checkPasswordStrength();" required/>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input name="confirmPassword" id="confirmPassword"  type="password" placeholder="Confirm Password" class="form-control" maxlength="25" required/>
                        </div>
                    </div>   
                    
 <button type="submit" class="btn btn-primary formtop" name="Update">Reset Password</button>                                     
               </form> 
          </div>  
 </div>      
<div class="col-sm-3"></div>       

</div>
          
   </div>
   </div>
  </div>   
</body>
</html>