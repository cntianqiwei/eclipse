

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
			"title" : {
				required : true
			} ,
			"note" : {
				required : true
			}
		}
	});
})
//用js实现的话会出现问题，暂时无法解决
//$(function(){
//	$("button[id=addbut]").on("click",function(){
//		title=$("#title").val();
//		note= $("#note").val();
//		console.log(title);
//		console.log(note);
//		$.ajax({
//			method : "post",
//			url : "pages/back/admin/supply/supply_apply_add.action",
//			data : {
//				"title":title,
//				"note":note
//			},
//			dataType : "text",
//			success : function(data) {
//				console.log(data);
//				operateAlert(true,"部门添加成功！","部门添加失败！") ;
//			},
//			error : function() {
//				console.log("error");
//			}
//		});
//	})
//})