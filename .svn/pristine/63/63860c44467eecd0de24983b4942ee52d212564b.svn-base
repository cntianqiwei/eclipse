$(function(){
	$("button[id^=edit-]").each(function() {
		$(this).on("click",function() {
			ecarid=$(this).attr("id").split("-")[1];
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_career_edit_pre.action",
				data:{
					"ecarid":ecarid,
				},
				dataType:"json",
				success:function(data){
					company=data.company;
					salary=data.salary;
					position=data.position;
					entry=data.entry;
					entry=new Date(entry).format("yyyy-MM-dd");
					quit=data.quit;
					quit=new Date(quit).format("yyyy-MM-dd");
					reason=data.reason;
					note=data.note;
					eid=data.eid;
					$("#company").val(company);
					$("#salary").val(salary);
					$("select>option").each(function(){
						if($(this).val()==position){
							$(this).attr("selected",true);
						}
					});
					$("#entry").val(entry);
					$("#quit").val(quit);
					$("#reason").val(reason);
					$("#note").val(note);
				},
				error:function(data){
					alert("程序出现错误！");
				}
			})
			
			
			$("#empCareerModal").modal("toggle") ; 
			$("span[id=modalAddBut]").on("click",function(){
				company=$("#company").val();
				salary=$("#salary").val();
				position=$("#position").val();
				entry=$("#entry").val();
				quit=$("#quit").val();
				reason=$("#reason").val();
				note=$("#note").val();
				$.ajax({
					url:"/eop/pages/back/admin/emp/emp_career_edit.action",
					data:{
						"company":company,
						"salary":salary,
						"position":position,
						"entry":entry,
						"quit":quit,
						"reason":reason,
						"note":note,
						"ecarid":ecarid,
					},
					dataType:"text",
					success:function(data){
						if(data.trim()=="true"){
							console.log("zhixing");
							alert("雇员工作经历修改成功！");
							window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
						}else{
							alert("雇员工作经历修改失败！");
							window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
						}
					},
					error:function(data){
						alert("程序发生错误，雇员工作经历修改失败！");
						window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
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
	$("#addCareer").on("click",function(){
		$("#company").val="";
		$("#salary").val="";
		$("select>option").each(function(){
			if($(this).val()==""){
				$(this).attr("selected",true);
			}
		});
		$("#entry").val="";
		$("#quit").val="";
		$("#reason").val="";
		$("#note").val="";
		$("#empCareerModal").modal("toggle") ;
		$("span[id=modalAddBut]").on("click",function(){
			company=$("#company").val();
			salary=$("#salary").val();
			position=$("#position").val();
			entry=$("#entry").val();
			quit=$("#quit").val();
			reason=$("#reason").val();
			note=$("#note").val();
			eid=$("input[id=eid]").val();
			console.log(eid);
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_career_add.action",
				data:{
					"company":company,
					"salary":salary,
					"position":position,
					"entry":entry,
					"quit":quit,
					"reason":reason,
					"note":note,
					"eid":eid
				},
				dataType:"text",
				success:function(data){
					if(data.trim()=="true"){
						alert("雇员工作经历增加成功！");
						window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
					}else{
						alert("雇员工作经历增加失败！");
						window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
					}
				},
				error:function(data){
					alert("程序发生错误，雇员工作经历增加失败！");
					window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
				}
			})
		})
	}) ;
	$("#entry").datetimepicker({
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
	$("#quit").datetimepicker({
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
			$("#empCareerModal").modal("toggle") ; 
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
			"company" : {
				required : true
			} ,
			"salary" : {
				required : true ,
				number : true
			},
			"position" : {
				required : true
			},
			"reason" : {
				required : true
			},
			"entry" : {
				required : true ,
				dateISO : true
			},
			"quit" : {
				required : true ,
				dateISO : true
			}, 
			"note" : {
				required : true
			}
		}
	});
	$("button[id^=rmBtn-]").on("click",function(){
		eid=$("button[id^=rmBtn-]").attr("id").split("-")[1];
		ecarids="";
		$("input[type=checkbox]").each(function(){
			if($(this).prop("checked")){
				ecarids=ecarids+$(this).attr("id").split("-")[1]+",";
			}
		})
		$.ajax({
			url:"/eop/pages/back/admin/emp/emp_career_delete.action",
			data:{
				"ecarids":ecarids,
			},
			dataType:"text",
			success:function(data){
				if(data.trim()=="true"){
					alert("雇员工作经历删除成功！");
					window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
				}else{
					alert("雇员工作经历删除失败！");
					window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
				}
			},
			error:function(data){
				alert("程序发生错误，雇员工作经历删除失败！");
				window.location="/eop/pages/back/admin/emp/emp_career_list.action?eid="+eid;
			}
		})
	})
})