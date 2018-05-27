$(function(){
	$("button[id^=append-]").each(function(){
		$(this).on("click",function(){
			resid = this.id.split("-")[1] ; 
			console.log("办公用品编号，resid = " + resid) ;
			$("#supplyModal").modal("toggle") ;
		}) ;
	}) ;
//	$("input[id^=resid]").each(function(){
//		resid= this.id.split("-")[1] ; 
//	})
	$("button[type^=submit]").on("click",function(){
//		$("input[id^=resid]").each(function(){
//			resid = this.id.split("-")[1] ; 
//		})
		amount=$("#amount").val();
		console.log("resid="+resid);
		console.log("amount="+amount);
		$.post("/eop/pages/back/admin/supply/supply_resource_editAmout.action", {
			"amount" : amount,
			"resid" : resid
		}, function(data) {
			console.log(data);
			if (data) {// 存的就是一个flag
				operateAlert(data, "库存增加成功！", "库存增加失败！");
				window.location="/eop/pages/back/admin/supply/supply_resource_list.action";
			}
		}, "text");
	})
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$("#supplyModal").modal("toggle") ; 
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
			"amount" : {
				required : true
			} 
		}
	});
})