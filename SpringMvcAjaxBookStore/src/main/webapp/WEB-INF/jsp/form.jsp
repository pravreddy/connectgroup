<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
<script type="text/javascript">
	var contexPath = "<%=request.getContextPath() %>";
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.js"></script>
<script src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/smoothness/jquery-ui.css" />
<style>
.error{
	color: red;
}

.success{
	color: green;
}
</style>
</head>
<body>
 <div>
<h1>Add Books Details.</h1>
	    <table>
        <form:form id="addBooksForm" action="books/add" method="POST" modelAttribute="bookForm">
                <tr><td colspan="2"><div id="error" class="error"></div></td></tr>
                <tr>
                    <td>BookName: </td>
                    <td><form:input  path="bookName" required="required"/></td>
                </tr>
                <tr>
                    <td>Published Date: </td>
                    <td><form:input path="publishedDate" required="required"/></td>
                </tr>
                <tr>
                    <td>No of copies sold: </td>
                    <td><form:input path="copiesSold" required="required"/></td>
                </tr>
                 <tr>
                    <td>Price per copy: </td>
                    <td><form:input path="pricePerCopy" required="required"/></td>
                </tr>
                <tr>
				<tr><td colspan="2"><input type="button" id="submit" value="Add books"><br/></td></tr>
				<tr><td colspan="2"><div id="info" class="success"></div></td></tr>
        </form:form>
        </table>
</div>
	
<script type="text/javaScript">
function doAjaxPost() {
	  // get the form values  
	  var name = $('#bookName').val();
	  var date = $('#publishedDate').val();
	  var copies = $('#copiesSold').val();
	  var price = $('#pricePerCopy').val();	   
	  $.ajax({  
	    type: "POST",  
	    url: contexPath + "/books/add",  
	    data: "" +
	    		"bookName=" + name + "&publishedDate=" + date +"&copiesSold=" + copies + "&pricePerCopy=" + price ,  
	    success: function(response){
	      // we have the response 
	      if(response.status == "SUCCESS"){
	    	  userInfo = "<ol>";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  userInfo += "<br><li><b>Book Name</b> : " + response.result[i].bookName + 
	    		  ";<b> publishedDate</b> : " + new Date(response.result[i].publishedDate).toDateString() +
	    		  ";<b> copies sold</b> : " + response.result[i].copiesSold+
	    		  ";<b> price</b> : " + response.result[i].pricePerCopy;
	    	  }
	    	  userInfo += "</ol>";
	    	  $('#info').html("Books has been added to the list successfully. " + userInfo);
	    	  $('#bookName').val('');
		      $('#publishedDate').val('');
		      $('#copiesSold').val('');
		      $('#pricePerCopy').val('');
		      $('#error').hide('slow');
		      $('#info').show('slow');
	      }else{
	    	  errorInfo = "";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
	    	  }
	    	  $('#error').html("Please correct following errors: " + errorInfo);
	    	  $('#info').hide('slow');
	    	  $('#error').show('slow');
	      }	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}

$(document).ready(function(){
	 $("#addBooksForm").validate({
		    rules:{
		      bookName:{
		    	  required:true
		    },
		      publishedDate:{
		    	  required:true
		      },
		      copiesSold:{
		    	  required:true
		      },
		      pricePerCopy:{
		    	  required:true
		      }
		    },
		    messages:{
		      bookName:"Please enter book Name",
		      publishedDate:"Please enter published date",
		      copiesSold:"Please enter copies sold",
		      pricePerCopy:"Please enter price per copy"
		    }
		      });
	 $("#publishedDate").datepicker({
		    dateFormat:"yy-mm-dd",
		    changeMonth:true,
		    changeYear:true,
		    yearRange:"-100:"
		  });
	 $("#submit").click(function () {
		    if($("#addBooksForm").valid())
		   {
		    	doAjaxPost();
		   }
		  });
});

</script>
</body>
</html>