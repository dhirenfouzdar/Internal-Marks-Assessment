<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance and internal management system</title>
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
			<li><s:url action="empgen" var="generemp"/>
			<s:a href="%{generemp}"><span>Generate Employees</span></s:a></li>
			
			<li class="active"><s:url action="stugen" var="generstu"/>
			<s:a href="%{generstu}"><span>Generate Students</span></s:a></li>
			
			<li ><s:url action="addsubject" var="addsub"/>
			<s:a href="%{addsub}"><span>Add Subjects</span></s:a></li>			
			
			<li><s:url action="logout" var="adminlogout"/>
			<s:a href="%{adminlogout}">Logout <i class="fa fa-sign-out"></i></s:a></li>
									  
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
 <div class="visible-sm-12" style="margin-top:100px;"> </div>
  <div class="col-sm-4">
       <div class="panel panel-default">
                <div class="panel-body">
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>                
                    <form class="form form-signup" action="addStudent" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-code"></i></span>
                            <input name="branch" type="text" class="form-control" value="MCA" readonly/>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                            <select id="year" name="yearOfJoining" class="form-control">
                                  <script>
                                  var myDate = new Date();
                                  var year = myDate.getFullYear();
                                  for(var i = 2010; i < year+1; i++){
	                              document.write('<option value="'+i+'">'+i+'</option>');
                                 }
                               </script>
                           </select>  
                        </div>
                    </div> 
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-calendar-o"></i></span>
                            <select id="year" name="yearOfPassing" class="form-control">
                                  <script>
                                  var myDate = new Date();
                                  var year = myDate.getFullYear();
                                  for(var i = 2013; i < year+4; i++){
	                              document.write('<option value="'+i+'">'+i+'</option>');
                                 }
                               </script>
                           </select>  
                        </div>
                    </div>                                       
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input name="strength" type="text" class="form-control" placeholder="Strength" required/>
                        </div>
                    </div>                                   
                    
                     <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
               </form>
                </div>
               
       </div>
  
  </div>
   <div class="col-sm-8">
  <s:url id="remoteurl" action="studentCredentialsList.action"  escapeAmp="false">
    <s:param name="yearOfPassing"><s:property value="yearOfPassing" /></s:param> 
    </s:url> 
      <s:url id="editurl" action="updateStudentCredentials.action"/>  
	<sjg:grid
	    id="gridtable" 
	    caption="Student List"
	  	dataType="json"
		href="%{remoteurl}"
		pager="true" 
		gridModel="userList" 
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
		autowidth="true"
		height="350">
		<sjg:gridColumn name="id" hidden="true"  search="false" key="true" index="Id" title="Student ID" sortable="true" />
		<sjg:gridColumn name="usn" align="left" width="50" index="USN" title="USN"  sortable="true" editable="true" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		<sjg:gridColumn name="password" align="left" width="50" index="Password" title="Password"  sortable="false" editable="false" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		<sjg:gridColumn name="yearOfJoining" align="left" width="50" index="YearOfJoining" title="YearOfJoining"  sortable="false" editable="false" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		
	</sjg:grid>
   
   </div>
 </div>
 </div>   
    

  </body>
</html> 