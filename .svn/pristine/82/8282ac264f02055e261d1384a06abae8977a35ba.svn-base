$(function(){
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
			"eid" : {
				required : true,
				remote : {
				url : "/eop/pages/back/admin/emp/emp_check_eid.action", // 后台处理程序
				type : "post", // 数据发送方式
				dataType : "text", // 接受数据格式
				data : { // 要传递的数据
					"eid" : function() {
						console.log($("input[id=eid]").val());
						return $("input[id=eid]").val();
					}
				},
				dataFilter : function(data, type) {
					if (data.trim() == "true"){
						return true;
					}else{
						return false;
					}
				}
				} 
			},
			"password" : {
				required : true
			},
			"ename" : {
				required : true
			} ,
			"phone" : {
				required : true 
			},
			"lid" : {
				required : true 
			},
			"did" : {
				required : true 
			},
			"salary" : {
				required : true ,
				number : true ,
				remote : {
					url : "/eop/pages/back/admin/emp/emp_check_salary.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "text", // 接受数据格式
					data : { // 要传递的数据
						"lid" : function() {
							console.log("lid");
							return $("select[id=lid]").val();
							
						},
						"salary":function(){
							return $("#salary").val();
						}
					},
					dataFilter : function(data, type) {
						if (data.trim() == "true")
							return true;
						else
							return false;
					}
				}
			},
			"photo" : {
				required : true ,
				accept : ["jpg","png","gif","bmp"]
			},
			"note" : {
				required : true
			}
		}
	});
})