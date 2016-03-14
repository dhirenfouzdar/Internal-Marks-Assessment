<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
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
          <div class="col-sm-2"> </div>
           <div class="col-sm-8 padding0"> 
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                    <li >
                        <s:url action="lecturecalavg" var="letuavg"/>
			 	         <s:a href="%{letuavg}">Generate Average Marks</s:a>                
                     </li>           
                <li class="active">
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
   <div class="col-sm-12"><h3 style="text-align: center;">Internals Details</h3></div>
    <div class="visible-sm-12" style="margin-top:40px;"> </div>
    <div class="col-sm-12">
<div class="col-sm-12">
<div class="col-sm-4">
     <div class="panel panel-default">
                <div class="panel-body">
								<s:if test="hasActionMessages()">
									<div class="welcome">
										<s:actionmessage />
									</div>
								</s:if>
								<s:form class="form form-signup" action="addMarks" role="form" method="post">
                    <div class="form-group">
                             <select id="year" name="yearOfPassing" class="form-control" required>
                                  <script>
                                  var myDate = new Date();
                                  var year = myDate.getFullYear();
                                  for(var i = 2013; i < year+4; i++){
	                              document.write('<option value="'+i+'">'+i+'</option>');
                                 }
                               </script>
                           </select> 
                    </div>
                    <div class="form-group">
 									<select name="subject" id="subject" class="form-control" required>
									<script>
							   var eid= ["Select subject"];
                              <s:iterator value="lectureSubjectEntities" >
                              eid.push('<s:property value="subject" />');
                              console.log(eid);
                              </s:iterator> 
                                  for(var i=0; i < eid.length; i++){
	                              document.write('<option value="'+eid[i]+'">'+eid[i]+'</option>');
                                 }
                                  </script>
                                  </select>        
                        </div>                 
                 <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
                 </s:form>
                </div>
              
       </div>  
 </div>      
<%--  <s:form action="calculateAverage">
 <s:submit value="CalculateAverage"></s:submit>
 </s:form> --%>
<div class="col-sm-8">
        
 <s:url id="remoteurl" action="IAEntityData.action"  escapeAmp="false">
 <s:param name="subject"><s:property value="subject" /></s:param>
    <s:param name="yearOfPassing"><s:property value="yearOfPassing" /></s:param>   	
   </s:url> 
      <s:url id="editurl" action="updateInternals.action"/>  
	<sjg:grid

	    id="gridtable" 
	    caption="Student List"
	  	dataType="json"
		href="%{remoteurl}"
		pager="true" 
		gridModel="iAEntityList" 
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
		rowList="10,20,30"
		viewrecords="true" 
		onSelectRowTopics="rowselect" 
		editurl="%{editurl}"
		editinline="false" 
   		sortable="true"
   		sortname="id" 
   		sortorder="asc"
		autowidth="false"
		height="150">
		<sjg:gridColumn name="id" hidden="true"  search="false" key="true" index="Id" title="Student ID" sortable="true" />
		<sjg:gridColumn name="usn" align="left" width="100" index="USN" title="USN"  sortable="true" editable="true" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		<sjg:gridColumn name="sem" align="left" width="100" index="Sem" title="Sem"  sortable="false" editable="false" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
	    <sjg:gridColumn name="subject" align="left" width="100" index="Subject" title="Subject"  sortable="false" editable="false" editoptions="{maxlength:'60'}" editrules="{number: true}"/>
	    <sjg:gridColumn name="test1" align="left" width="100" index="Test1" title="Test1"  sortable="false" editable="true" editoptions="{maxlength:'60'}" editrules="{number: true}"/>
	    <sjg:gridColumn name="test2" align="left" width="100" index="Test2" title="Test2"  sortable="false" editable="true" editoptions="{maxlength:'60'}" editrules="{number: true}"/>
	    <sjg:gridColumn name="test3" align="left" width="100" index="Test3" title="Test3"  sortable="false" editable="true" editoptions="{maxlength:'60'}" editrules="{number: true}"/>
	    <sjg:gridColumn name="averageMarks" align="left" width="100" index="AverageMarks" title="AverageMarks"  sortable="false" editable="false" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
	    
	</sjg:grid>
     </div>         

</div>
    </div>
          
   </div>
  </div>


  </body>
</html>