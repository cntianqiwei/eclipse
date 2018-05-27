$(function(){
	$("button[id^=rmBtn-]").on("click",function(){
		eid=$(this).attr("id").split("-")[1];
		ids="";
		$("input[type=checkbox]").each(function(){
			if($(this).prop("checked")){
				ids=ids+$(this).val()+",";
			}
		})
		if(ids==""){
			
		}else{
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_edu_delete.action",
				data:{"ids":ids},
				dataType:"text",
				success:function(data){
					if(data.trim()=="true"){
						alert("教育经历删除成功！");
						window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
					}else{
						alert("教育经历删除失败！");
						window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
					}
				},
				error:function(data){
					alert("教育经历删除失败！");
					window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
				}
			})
		}
		
	})
	
	
	$("button[id^=edit-]").each(function() {
		$(this).on("click",function() {
			eeduid=$(this).attr("id").split("-")[1];
			console.log(eeduid);
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_edu_edit_pre.action",
				data:{"eeduid":eeduid},
				dataType:"json",
				success:function(data){
					entrance=data.entrance;
					entrance=new Date(entrance).format("yyyy-MM-dd");
					graduation=data.graduation;
					graduation=new Date(graduation).format("yyyy-MM-dd");
					$("form input[id=school]").val(data.school);
					$("#major").val(data.major);
					$("#entrance").val(entrance);
					$("#graduation").val(graduation);
					$("#note").val(data.note);
					$("select>option").each(function(){
						$(this).attr("selected",false);
						if($(this).val()==data.degree){
							$(this).attr("selected",true);
						}
					})
				},
				error:function(data){
					alert("程序发生错误！");
				}
			})
			$("#empEduModal").modal("toggle") ; 
			$("span[id=modalAddBut]").on("click",function(){
				eid=$("button[id^=addEdu-]").attr("id").split("-")[1];
				$.ajax({
					url:"/eop/pages/back/admin/emp/emp_edu_edit.action",
					data:{
						"eeduid":eeduid,
						"degree":$("#degree").val(),
						"school":$("#school").val(),
						"major":$("#major").val(),
						"entrance":$("#entrance").val(),
						"graduation":$("#graduation").val(),
						"note":$("#note").val()
					},
					dataType:"text",
					success:function(data){
						if(data.trim()=="true"){
							alert("教育经历修改成功！");
							window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
						}else{
							alert("教育经历修改失败！");
							window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
						}
					},
					error:function(date){
						alert("教育经历修改失败！");
						window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
					}
				})
			})
		}) ;
	}) ;
	$(selall).on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("button[id^=addEdu-]").on("click",function(){
		$("form input[id=school]").val("");
		$("#major").val("");
		$("#entrance").val("");
		$("#graduation").val("");
		$("#note").val("");
		$("select>option").each(function(){
			if($(this).val()==""){
				$(this).attr("selected",true);
			}
		});
		console.log($(this).attr("id"));
		eid=$(this).attr("id").split("-")[1];
		console.log(eid);
		$("#empEduModal").modal("toggle") ;
		$("#modalAddBut").on("click",function(){
			school=$("#school").val();
			major=$("#major").val();
			degree=$("#degree").val();
			entrance=$("#entrance").val();
			graduation=$("#graduation").val();
			note=$("#note").val();
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_edu_add.action",
				data:{
					"eid":eid,
					"school":school,
					"major":major,
					"degree":degree,
					"entrance":entrance,
					"graduation":graduation,
					"note":note
				},
				dataType:"text",
				success:function(data){
					if(data.trim()=="true"){
						alert("教育经历添加成功！");
						window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
					}else{
						alert("教育经历添加失败！");
						window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
					}
				},
				error:function(date){
					alert("教育经历添加失败！");
					window.location="/eop/pages/back/admin/emp/emp_edu_list.action?eid="+eid;
				}
			})
		})
	}) ;
	$("#entrance").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
	    todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
	    autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
	    todayHighlight: 1,	// 如果为true, 高亮当前日期
	    startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
	    forceParse: 1,		// 当选择器关闭的时候，是否强制解析输入框中的值。
	    showMeridian: 1 , 	// 选项里是否有天或小时
	    minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
	    format: 'yyyy-mm-dd' 
    });
	$("#graduation").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
	    todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
	    autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
	    todayHighlight: 1,	// 如果为true, 高亮当前日期
	    startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
	    forceParse: 1,		// 当选择器关闭的时候，是否强制解析输入框中的值。
	    showMeridian: 1 , 	// 选项里是否有天或小时
	    minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
	    format: 'yyyy-mm-dd' 
    });
	
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$("#empEduModal").modal("toggle") ; 
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
			"school" : {
				required : true
			} ,
			"major" : {
				required : true
			},
			"degree" : {
				required : true
			},
			"entrance" : {
				required : true ,
				dateISO : true
			},
			"graduation" : {
				required : true ,
				dateISO : true
			}, 
			"note" : {
				required : true
			}
		}
	});
})