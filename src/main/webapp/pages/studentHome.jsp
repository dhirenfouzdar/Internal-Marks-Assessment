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
   <script>
$(document).ready(function() {

$('tr').each (function() {
       var i1 = $(this).find('.t1').text();
       var i2 = $(this).find('.t2').text(); 
       var i3 = $(this).find('.t3').text();

          var result = ((parseInt(i1)+ parseInt(i2) + parseInt(i3))/3).toFixed(2);
          console.log(result);
           $(this).find('.res').text(Math.round(result));
   });
});
</script>
<script>
var country_arr = new Array("1", "2", "3", "4", "5", "6");

var s_a = new Array();
s_a[0]="";
s_a[1]="Problem Solving using C|Discrete Mathematics Structure|Fundamentals of Computer Organization|Introduction to Unix|ntroduction to Web Technologies|C Programming Laboratory|Unix Programming Laboratory|Web Programming Laboratory";
s_a[2]="Data Structures Using C|Object Oriented Programming using C++|Operating Systems|System Programming|Database Management Systems|Data Structures Using C Lab|Database Laboratory|OOP Using C++ Laborator";
s_a[3]="Computer Networks|Programming using Java|Software Engineering|Computer Graphics|UNIX system Programming|Advanced Topics in DBMS|Basics of MIS & E-Commerce|Operations Research|Principles of User Interface Design|Probability Statistics & Numerical Methods|Java Programming Lab|Computer Graphics Lab|Computer Networks Lab";
s_a[4]="Analysis & Design of Algorithm|Advanced Java Programming|Advanced Web Programming|Advanced Computer Networks|Data Warehousing & Data Mining|Mobile Computing and Wireless Communications|Software Testing and Practices|Theory of Computation (FAFL)|Digital Image Processing|Cryptography & Network Security|Network Management|NOSQL|Software Architectures|Enterprise Resource Planning (ERP)|Mobile Applications|Algorithms Lab |Advanced Java Lab |Mini Project-I ";
s_a[5]="Object-Oriented Modeling and Design Patterns|System Simulation and Modeling|Programming using C#.& .NET|Mobile and Adhoc Sensor Networks|Parallel Computing|Multimedia systems|Pattern Recognition|Services Oriented Architecture|Compiler Design|Cloud Computing|Web2.0 and Rich Internet Applications|Information Retrieval & Search Engines|Soft Computing|Storage Area Network|Software Project Management|Software Design Laboratory|.Net Laboratory|Mini Project -II";
s_a[6]="Project";
function print_country(country_id){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var option_str = document.getElementById(country_id);
	option_str.length=0;
	option_str.options[0] = new Option('Select Sem','');
	option_str.selectedIndex = 0;
	for (var i=0; i<country_arr.length; i++) {
		option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
	}

}

function print_state(state_id, state_index){
	var option_str = document.getElementById(state_id);
	option_str.length=0;	// Fixed by Julian Woods
	option_str.options[0] = new Option('','');
	//option_str.selectedIndex = 0;
	var state_arr = s_a[state_index].split("|");

	for (var i=1; i<state_arr.length; i++) {
		option_str.options[option_str.length] = new Option(state_arr[i],state_arr[i]);
	}
	
}
</script>
 
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
                <li class="active">
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
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
				<s:if test="hasActionMessages()">
					<div class="welcome">
						<s:actionmessage />
					</div>
				</s:if>
				<form class="form form-signup" action="studentInternal" role="form" method="post">
                                <div class="form-group">
									<select onchange="print_state('state',this.selectedIndex);"
										id="country" name="sem" class="form-control" required></select>
								</div>
								
								<div class="form-group">
									<select name="subject" id="state" class="form-control" required></select>
									<script language="javascript">
										print_country("country");
									</script>
								</div> 
                   <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
                   </form>
   </div>
   <div class="col-sm-3"></div>                
                   
<div class="col-sm-12">
   <div class="panel panel-primary filterable">
            <div class="panel-heading">
                <h3 class="panel-title">Attendance</h3>
                <div class="pull-right">
                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr class="filters">
                        <th><input type="text" class="form-control" placeholder="USN" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Subject" disabled></th>
                        <th><input type="text" class="form-control" placeholder="1st Internals" disabled></th>
                        <th><input type="text" class="form-control" placeholder="2nd Internals" disabled></th>
                        <th><input type="text" class="form-control" placeholder="3rd Internals" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Average" disabled></th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="studentInternalsMarks">
                    <tr>
                        <td><s:property value="usn"/></td>
                        <td><s:property value="subject"/></td>
                        <td class="t1"><s:property value="test1"/></td>
                        <td class="t2"><s:property value="test2"/></td>
                        <td class="t3"><s:property value="test3"/></td>
                        <td ><s:property value="averageMarks"/></td>
                    </tr>
                </s:iterator>    
                    
                </tbody>
            </table>
        </div>
</div>
          
   </div>
  </div>

  </body>
</html>