$(document).ready(function() {

$('#sub1').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);
$('#sub2').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);
$('#sub3').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);
$('#sub4').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);
$('#sub5').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);
$('#sub6').multiselect(
{
 includeSelectAllOption: true,
 enableFiltering: true
}
);

    var $sem = $('select.semester');


    $sem.change(function() {
	    if($('select.semester').val() =="1")
		   {
		   $('#sdiv1').show();
		   $('#sdiv2').hide();
		   $('#sdiv3').hide();
		   $('#sdiv4').hide();
		   $('#sdiv5').hide();
		   $('#sdiv6').hide();
		   }

           if($('select.semester').val() =="2")
		   {
		   $('#sdiv2').show();
		   $('#sdiv1').hide();
		   $('#sdiv3').hide();
		   $('#sdiv4').hide();
		   $('#sdiv5').hide();
		   $('#sdiv6').hide();
		   }
           if($('select.semester').val() =="3")
		   {
		   $('#sdiv3').show();
		   $('#sdiv1').hide();
		   $('#sdiv2').hide();
		   $('#sdiv4').hide();
		   $('#sdiv5').hide();
		   $('#sdiv6').hide();
		   }
           if($('select.semester').val() =="4")
		   {
		   $('#sdiv4').show();
		   $('#sdiv1').hide();
		   $('#sdiv3').hide();
		   $('#sdiv2').hide();
		   $('#sdiv5').hide();
		   $('#sdiv6').hide();
		   }
           if($('select.semester').val() =="5")
		   {
		   $('#sdiv5').show();
		   $('#sdiv1').hide();
		   $('#sdiv3').hide();
		   $('#sdiv4').hide();
		   $('#sdiv2').hide();
		   $('#sdiv6').hide();
		   }
           if($('select.semester').val() =="6")
		   {
		   $('#sdiv6').show();
		   $('#sdiv1').hide();
		   $('#sdiv3').hide();
		   $('#sdiv4').hide();
		   $('#sdiv5').hide();
		   $('#sdiv2').hide();
		   }		   
if($('select.semester').val() =="select sem")
{
		   $('#sdiv1').hide();
		   $('#sdiv2').hide();
		   $('#sdiv3').hide();
		   $('#sdiv4').hide();
		   $('#sdiv5').hide();
		   $('#sdiv6').hide();
}		   

    }).change();
});