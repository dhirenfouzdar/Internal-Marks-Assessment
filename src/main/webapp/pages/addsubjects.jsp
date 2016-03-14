<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    <script src="pages/js/jquery-2.1.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="pages/js/bootstrap.min.js"></script>
    <link href="pages/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
    <script src="pages/js/bootstrap-multiselect.js"></script> 
    
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
			
			<li><s:url action="stugen" var="generstu"/>
			<s:a href="%{generstu}"><span>Generate Students</span></s:a></li>
			
			<li class="active"><s:url action="addsubject" var="addsub"/>
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
                    <form class="form form-signup" action="lectureSubject" role="form" method="post">
                              
                        <div class="form-group">
                             <div class="input-group">
                            <span class="input-group-addon">Emp Id</span>
                            <select id="eid" name="usn" class="form-control" required>
                              <script>
                              var eid= [];
                              <s:iterator value="lectureProfileList" >
                              eid.push('<s:property value="usn" />');
                              console.log(eid);
                              </s:iterator> 
                                  for(var i=0; i < eid.length; i++){
	                              document.write('<option value="'+eid[i]+'">'+eid[i]+'</option>');
                                 }
                               </script>
                            </select>
                        </div>									
						</div>
							
							
								
                                <div class="form-group">
									<select onchange="print_state('state',this.selectedIndex);"
										id="country" name="sem" class="form-control" required></select>
								</div>
								
								<div class="form-group">
									<select name="subject" id="state" class="form-control" multiple="multiple" required></select>
									<script language="javascript">
										print_country("country");
									</script>
								</div> 
                   <input type="submit" class="btn btn-sm btn-primary btn-block" value="SUBMIT" role="button" />
                   </form>
                </div>
              
       </div>
  
  </div>
   <div class="col-sm-8">
        
      <s:url id="remoteurl" action="lecturerSubjectList.action"  escapeAmp="false"/>
      <s:url id="editurl" action="deleteSubject.action"/>  
	<sjg:grid
	    id="gridtable" 
	    caption="Lecturer List"
	  	dataType="json"
		href="%{remoteurl}"
		pager="true" 
		gridModel="subjectList" 
		loadonce="false"
		rowNum="10"
		navigator="true" 
		navigatorAdd="false" 
		navigatorDelete="true"
		navigatorEdit="false" 
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
		<sjg:gridColumn name="usn" align="left" width="50" index="EmpID" title="EmpID"  sortable="true" editable="true" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		<sjg:gridColumn name="sem" align="left" width="50" index="sem" title="sem"  sortable="true" editable="true" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		<sjg:gridColumn name="subject" align="left" width="50" index="subject" title="sem"  sortable="true" editable="true" editoptions="{maxlength:'60'}" editrules="{required: true}"/>
		
	</sjg:grid>
     </div>      
  </div>
  </div>
     
</body>
</html>

