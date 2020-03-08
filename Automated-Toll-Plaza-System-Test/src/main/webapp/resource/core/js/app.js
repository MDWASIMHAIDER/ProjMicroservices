
$(document).ready(function(){
	$('#email').blur(function(){
		$('#emailErrorMsg').html('');
		var emailEntered=$("#email").val();
		$.ajax({
			url : '/signupcontroller/emailcheck',
			data :{
				email: emailEntered
			},
			success : function(result){
				if(result== 'Duplicate'){
					var errMsg='Email Id Allready Exist'
						$("#emailErrorMsg").html(errMsg);
				}
			}
		})
	})
});


$(document).ready(function(){
	$('#email1').blur(function(){
		$('#emailErrorMsg1').html('');
		var emailEntered=$("#email1").val();
		$.ajax({
			url : '/signupcontroller/emailcheck1',
			data :{
				email: emailEntered
			},
			success : function(result){
				if(result== 'Duplicate'){
					var errMsg='Email Id Allready Exist'
						$("#emailErrorMsg1").html(errMsg);
				}
			}
		})
	})
});


$(document).ready(function(){
	$('#role').blur(function(){
		var emailEntered=$("#role").val();
		$.ajax({
			url : '/admincontroller/filteragency//to doo',
			data :{
				email: emailEntered
			},
			success : function(result){
				if(result== 'Duplicate'){
					var errMsg='Email Id Allready Exist'
						$("#emailErrorMsg1").html(errMsg);
				}
			}
		})
	})
});