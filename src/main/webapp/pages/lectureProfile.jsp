<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <%@ taglib prefix="s" uri="/struts-tags"%>
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
                    <li >
                        <s:url action="lecturecalavg" var="letuavg"/>
			 	         <s:a href="%{letuavg}">Generate Average Marks</s:a>                
                     </li>
                <li>
                        <s:url action="lectureInternl" var="letuint"/>
			 	         <s:a href="%{letuint}">Internals</s:a>                 
                </li>

                 <li class="dropdown active">
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
<div class="col-sm-3"></div>
<div class="col-sm-6">
     <div class="panel panel-default">
                <div class="panel-body">
                <s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>    
                    <form class="form form-signup" action="addlectureProfile" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" name="firstName" class="form-control" placeholder="firstName" required/>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" name="lastName" class="form-control" placeholder="lastName" required/>
                        </div>
                    </div>
                    
                <!--     <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                            <input type="text" name="usn" class="form-control" placeholder="usn" required/>
                        </div>
                    </div> -->  
                    
                      <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                            <input type="email" name="emailId" class="form-control" placeholder="emailId" required/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
					<div class="radio">
  						<label><input type="radio" name="gender" value="male" required>Male</label>

 						 <label><input type="radio" name="gender" value="female" required>Female</label>
					</div>
                        </div>
                    </div>  
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                            <input type="text" name="mobileNumber" class="form-control" placeholder="Mobile" required/>
                        </div>
                    </div>   
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                            <input type="text" name="alternateNumber" class="form-control" placeholder="AltMobile" required/>
                        </div>
                    </div>  
                    
                     <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-star-half-o"></i></span>
                            <input type="text" name="designation" class="form-control" placeholder="Designation" required/>
                        </div>
                    </div> 
                                     
                   <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-code"></i></span>
                            <input type="text" class="form-control" placeholder="MCA" readonly="true" />
                        </div>
                    </div> 
					                  
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
                            <textarea class="form-control" name="address" rows="3" placeholder="Address" required></textarea>
                        </div>
                    </div>                                   
                                         
                 <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
                </div>
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