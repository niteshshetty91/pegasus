$( document ).ready(function() {

	$('#button').click(function(e){
		e.preventDefault() 
		var hiddenValue = $('#expressionContent').val();

		alert("The hidden value is "+hiddenValue);

	});

	$('#checkbox').click(function(){

		if($(this).is(':checked')){

			alert("CheckBox is checked");

		}else{

			alert("CheckBox is unchecked");

		}


	});






});
