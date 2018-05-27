$(function(){
//	$("button[type^=submit]").on("click",function(){
//		note=$("#note").val();
//		status=$("input[id^=radio]:checked").val();
//		console.log(note);
//		console.log(status);
//		
//	})
//	
	$("td[id^=status]").each(function(){
		status=$(this).text();
		console.log(status);
		if(status==1){
			$(this).text("未审核");
		}
	})
	
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) { 
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"audit" : {
				required : true,
			},
			"note" : {
				required : true
			}
		}
	});
})