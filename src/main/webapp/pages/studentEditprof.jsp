<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>    <head>
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
<sj:head jqueryui="true" 
         jquerytheme="customTheme" 
         customBasepath="pages/template"/>
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
    <s:url id="remoteurl" action="studentProfileDetails.action"  escapeAmp="false"/>
      <s:url id="editurl" action="updatestudent.action"/>  
	<sjg:grid
	    id="gridtable" 
	    caption="Lecturer Details"
	  	dataType="json"
		href="%{remoteurl}"
		pager="true" 
		gridModel="studentProfileList" 
		loadonce="false"
		rowNum="10"
		navigator="true" 
		navigatorAdd="false" 
		navigatorDelete="true"
		navigatorEdit="true" 
		navigatorEditOptions="{addCaption:'EDIT',height:480,reloadAfterSubmit:false,closeAfterEdit:true}"
		navigatorRefresh="true" 
		navigatorSearch="false"
		navigatorView="false" 
		rownumbers="true" 
		rowList="1"
		viewrecords="true" 
		onSelectRowTopics="rowselect" 
		editurl="%{editurl}"
		editinline="false" 
   		sortable="true"
   		sortname="id" 
   		sortorder="asc"
		autowidth="true"
		height="75">
		<sjg:gridColumn name="id" hidden="true"  search="false" key="true" index="Id" title="Student ID" sortable="true" />
		<sjg:gridColumn name="firstName" align="left" width="50" index="Firstname" title="Firstname"  sortable="true" edittype="text" editable="true" editrules="{
																																				required: true
																																																																																																										
																																				}"/>
		<sjg:gridColumn name="lastName" align="left"  index="Lastname" title="Lastname" sortable="true" editable="true" edittype="text" editrules="{
																																				required: true
																																																																																																										
																																				}"/>
        <sjg:gridColumn name="usn" align="left"  index="emailId" title="USN" sortable="true" editable="false" />
        <sjg:gridColumn name="emailId" align="left"  index="emailId" title="EmailId" sortable="true" editable="true" />
		<sjg:gridColumn name="gender" align="left"  index="Gender" title="Gender" sortable="true" editable="true" edittype="select" editoptions="{value:'Male:Male;Female:Female'}" editrules="{
																																				required: true																																																																						
																																				}"/>
		
		 <sjg:gridColumn name="mobileNumber" align="left" index="Mobile Number" title="Mobile Number" sortable="false" editable="true" editoptions="{maxlength:'10'}" editrules="{
																																				required: true,
																																				number:true,
																																				minlength:10																																																																																																										
																																				}"/>	
		<sjg:gridColumn name="alternateNumber" align="left" index="Alternate Number" title="Alternate Mobile Number" sortable="false" editable="true" editoptions="{maxlength:'10'}" editrules="{
																																				required: true,
																																				number:true,
																																				minlength:10																																																																																																										
																																				}"/>																		
		<sjg:gridColumn name="yearofjoining" align="left" index="Yearofjoining" title="Yearofjoining" sortable="false" editable="true" />	
		<sjg:gridColumn name="yearofpassing" align="left" index="Yearofpassing" title="Yearofpassing" sortable="false" editable="true" />	
		<sjg:gridColumn name="address" align="left" index="address" title="address" sortable="false" editable="true" />	
		


	</sjg:grid>
</div>
          
   </div>
  </div>

  </body>
</html>