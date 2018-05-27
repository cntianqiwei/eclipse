$(function(){
	 item=$("input[id^=selectItem]").val();
   $("select[id^=item]>option:gt(0)").each(function(){
	   option = $(this).val();
	   if(item==option){
		   $(this).attr("selected",true);
	   }
   })
	
	
	
//$("select>option").each(function(){
//	$(this).attr("selected",false);
//	if($(this).val()==data.degree){
//		$(this).attr("selected",true);
//	}
//})
	
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
			"name" : {
				required : true
			} ,
			"price" : {
				required : true ,
				number : true
			},
			"amount" : {
				required : true ,
				number : true
			},
			"photo" : {
				required : false ,
				accept : ["jpg","png","gif","bmp"] 
			} ,
			"item" : {
				required : true 
			},
			"note" : {
				required : true 
			}
		}
	});
})