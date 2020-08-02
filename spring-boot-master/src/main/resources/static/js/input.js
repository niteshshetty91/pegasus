$( document ).ready(function() {
	
	alert("Welcome to Mathematics Calculator");

	$('#errMsg').text("");
	$('#errMsg').hide("");

	$('#form').submit(function(){


		if($('#expressionQuestion').val()==''){
			$('#errMsg').show();
			$('#errMsg').text("Please enter the expression");
			

			return false;

		}else{

			$('#errMsg').text("");
			$('#errMsg').hide("");
			return true;

		}


	});

});
