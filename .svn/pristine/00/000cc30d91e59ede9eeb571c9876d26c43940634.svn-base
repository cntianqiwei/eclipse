$(function() {
	$("button[id^=pub-]").each(function(){
		$(this).on("click",function() {
			pid = this.id.split("-")[1] ;
			$.post("pages/back/admin/plan/plan_history_publish.action",
					{
						"pid" : pid
					},
					function(data){
						//异步任务发布
						if(data.flag) {
							//update success show "发布"
							$("#"+pid).find("#status").text("发布") ;
							$("#pub-"+ pid).attr("disabled",true);
							$("#detail-" + pid).attr("disabled",false);
						}
						operateAlert(data.flag,"任务发布成功，点击详情安排人员！","任务发布失败，请修改后重新发布！") ;
					},"json");
		}) ;
	}) ;
	
	//阻止a标记跳转
	$("a[id^=detail-]").each(function(){
		$(this).on("click",function(){
			pid = this.id.split("-")[1] ;
			if(!$("#pub-"+pid).prop("disabled")) {
				return false ;
			}
		}) ;
		
	});
	
	$(selall).on("click",function(){
		$("input[id^=pid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	
	$("#rmBtn").on("click",function(){
		ids = "" ;
		$("input[id^=pid-").each(function(){
			if($(this).prop("checked")) {
				ids = ids + $(this).val() + ";" ;
			}
		});
		if(ids != "") {
			if(confirm("确实要删除该任务?")){
				$.post("pages/back/admin/plan/plan_history_delete.action",
						{
							"ids" : ids
						},
						function(data){
							if(data.flag) {
								$("input[id^=pid-").each(function(){
									if($(this).prop("checked")) {
										//only status=0 can be remove
										if($("#" + $(this).val()).attr("status") == 0) {
											$("#" + $(this).val()).remove() ;
										}
									}
								}) ;
							}
							operateAlert(data.flag,"删除成功！","任务已经发布，删除失败！") ;
						},"json");
			}
		} else {
			operateAlert(false,"","未选择删除的数据") ;
		}
	});
	
	

		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        	}) ;

	
	
	
