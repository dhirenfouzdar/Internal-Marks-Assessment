<!DOCTYPE html>
<html lang="en">
 <%@ taglib prefix="s" uri="/struts-tags"%>  
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
    <script src="pages/js/script.js"></script>
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
                <li>
                         <s:url action="studentattend" var="studatt"/>
			 	         <s:a href="%{studatt}">Internals</s:a> 
			 	 </li>                 

                 <li class="dropdown active">
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
                <li>
                         <s:url action="resetstud" var="reset"/>
			 	         <s:a href="%{reset}">Reset Password</s:a> 
			 	 </li>                
              <li>
              <s:url action="logout" var="stulogout"/>
			  <s:a href="%{stulogout}">Logout <i class="fa fa-sign-out"></i></s:a>
			  </li>            
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
                    <form class="form form-signup" action="addStuProfile" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" name="firstName" class="form-control" placeholder="FirstName" required/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" name="lastName" class="form-control" placeholder="lastName" required/>
                        </div>
                    </div>
                    
                                      
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                            <input type="email" name="emailId" class="form-control" placeholder="E-mail" required/>
                        </div>
                    </div>
                    
 		 		  	<div class="form-group">
                        <div class="input-group">
                         <span class="input-group-addon">Gender</span>
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
                            <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                            <input type="text" name="alternateNumber" class="form-control" placeholder="AltMobile" />
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
                            <span class="input-group-addon"><i class="fa fa-code"></i></span>
                            <input type="text" name="yearofjoining" class="form-control" placeholder="year of joining" required />
                        </div>
                    </div> 
					
                   <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-code"></i></span>
                            <input type="text" name="yearofpassing" class="form-control" placeholder="year of passing" required />
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

  </body>
</html>