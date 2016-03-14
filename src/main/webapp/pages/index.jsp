
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@taglib uri="/struts-tags" prefix="s"%>	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Attendance and internal management system</title>
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
  
  <div class="container-fluied">
   <div class="row">
    <div class="visible-sm-12" style="margin-top:100px;"> </div>
    <div class="col-sm-1"></div>
   <div class="col-sm-7">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Carousel indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
            <li data-target="#myCarousel" data-slide-to="4"></li>
        </ol>   
        <!-- Wrapper for carousel items -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="pages/images/banner1.jpg" alt="First Slide">
            </div>
            <div class="item">
                <img src="pages/images/banner2.jpg" alt="second Slide">
            </div>
            <div class="item">
                <img src="pages/images/banner3.jpg" alt="third Slide">
            </div>
            <div class="item">
                <img src="pages/images/banner4.jpg" alt="fourth Slide">
            </div>
            <div class="item">
                <img src="pages/images/banner5.jpg" alt="fifth Slide">
            </div>                        
        </div>
        <!-- Carousel controls -->
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
   </div>

   <div class="col-sm-3">

     <div class="panel panel-default">
                <div class="panel-body">
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>                
                     <s:form class="form form-signup" action="login" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input name="usn" type="text" class="form-control" placeholder="Usn" required/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input name="password" type="password" class="form-control" placeholder="Password" required/>
                        </div>
                    </div>
                     <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
                
               </s:form>
               </div>
       </div>           

 
    </div>

    <div class="col-sm-1"></div>  
   </div>
  </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="pages/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="pages/js/bootstrap.min.js"></script>
  </body>
</html> 