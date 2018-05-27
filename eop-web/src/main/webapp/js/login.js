$(function() {

	
	
	$.backstretch("images/login_back.jpg");
	
	$("#imageCode").on("click",function(){
		$("#imageCode").attr("src","ImageCode?p=" + Math.random()) ;
	}) ;
	
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());  
			//$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
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
			"eid" : {
				required : true 
			},
			"password" : { 
				required : true
			} ,
			"code" : {
				required : true ,
				minlength : 4 ,
				maxlength : 4 ,
				remote : {
					url : "login/validatecode.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "text", // 接受数据格式
					data : { // 要传递的数据
						code : function() {
							return $("#code").val();
						}
					},
					dataFilter : function(data, type) {
						if(data.trim() == "true") {
							return true ;
						} else {
							$("#imageCode").attr("src","ImageCode?p=" + Math.random()) ;
							return false ;
						}
					}
				}
			}
		}
	});
//	$('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea')
//			.on('focus', function() {
//				$(this).removeClass('input-error');
//			});
//
//	$('.login-form').on(
//			'submit',
//			function(e) {
//				$(this).find(
//						'input[type="text"], input[type="password"], textarea')
//						.each(function() {
//							if ($(this).val() == "") {
//								e.preventDefault();
//								$(this).addClass('input-error');
//							} else {
//								$(this).removeClass('input-error');
//							}
//						});
	//
	//			});
})