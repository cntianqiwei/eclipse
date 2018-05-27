$(function(){
	removeTR();
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
	
	//异步查询所有能调度的人员
	$("#did").on("change",function(){
		if($("#did").val() != "") {
			did = $("#did").val() ;
			$.post("pages/back/admin/plan/plan_details_modal_pre.action",
					{
						"did" : did
					},
					function(data){
						removeTR();
						//将返回的lid数组进行map处理 
						var obj = {};
						data.allLevels.forEach(function(level){
							obj[level.lid] = level.title ;
						});
						
						for(x = 0; x < data.allEmps.length; x++) {
							addTR(data.allEmps[x].photo,data.allEmps[x].eid,data.allEmps[x].ename,obj[data.allEmps[x].lid]) ;
							//添加按钮后还需要与前端页面id比较，如果包含了该人员，就禁止按钮
							$("button[id^=remove-]").each(function(){
								eid = this.id.substring(this.id.indexOf("-") + 1,this.id.length) ;
								if(data.allEmps[x].eid == eid) {
									$("#add-"+data.allEmps[x].eid).attr("disabled",true);
								}

							})
							//为添加的按钮绑定鉴定
							$("#add-"+data.allEmps[x].eid).on("click",function() {
								//异步添加监听事件
								eid = this.id.substring(this.id.indexOf("-") + 1,this.id.length) ;
								pid = $("#pid").text();
								$.post("pages/back/admin/plan/plan_details_modal_add.action",
										{
											"eid" : eid ,
											"pid" : pid 
										},
										function(data){
											//增加失败返回false
											if(data.flag == false) {
												
												//$(".glyphicon glyphicon-plus-sign")
											}else {
												
											}
											$("#add-"+ eid).attr("disabled",true);
											operateAlert1(data.flag,data.msg,data.msg) ;
								},"json");
							}) ;
						}
					},"json");
		}
	});
	$("#closeBtn_head,#closeBtn_foot").on("click",function(){
		url = "pages/back/admin/plan/plan_details_pre.action?pid="+ $("#pid").text();
		window.location=url;
	});
	
	
	function removeTR(){
		$("#tbody").children().remove();
	}
	function addTR(photo,eid,ename,level_title) {
		msg = "" ;
		msg = msg + "<tr id=\""+eid+"\">" ;
		msg = msg + "<td class=\"text-center\">" ;
		msg = msg + "<img src=\"upload/emp/"+photo+"\" style=\"width:20px;\"/>" ;
		msg = msg + "</td>" ;
		msg = msg + "<td class=\"text-center\">"+eid+"</td>" ;
		msg = msg + "<td class=\"text-center\">"+ename+"</td>" ;
		msg = msg + "<td class=\"text-center\">"+level_title+"</td>";
		msg = msg + "<td class=\"text-center\">" +
						"<button class=\"btn btn-danger btn-xs\" id=\"add-"+eid+"\">" +
							"<span class=\"glyphicon glyphicon-plus-sign\"></span>&nbsp;增加" +
						"</button></td>" ;
		$("#tbody").append(msg) ;
	}
	
	
	//增加雇员按钮 弹出界面
	$("#addEmpBut").on("click",function(){
		$("#planEmpInfo").modal("toggle") ;
	}) ;
	
	function operateAlert1(flag,suctext,faltext) {
		if (flag) {
			$("#alert1Div").attr("class","alert alert-success") ;
			$("#alert1Text").text(suctext) ;
		} else {
			$("#alert1Div").attr("class","alert alert-danger") ;
			$("#alert1Text").text(faltext) ;
		}
		$("#alert1Div").fadeIn(1000,function(){
	        $("#alert1Div").fadeOut(1000) ;
	    }) ;
	}
	
	
	//删除一个雇员
	$("button[id^=remove-]").each(function(){
		$(this).on("click",function() {
			eid = this.id.substring(this.id.indexOf("-") + 1,this.id.length) ;
			pid = $("#pid").text();
			$.post("pages/back/admin/plan/plan_details_delete.action",
					{
						"eid" : eid ,
						"pid" : pid 
					},
					function(data){
						if(data.flag) {
							$("#"+eid).remove() ;
							$("#amount").text(Number($("#amount").text()) - 1) ;
							$("#currentAmount").text(Number($("#currentAmount").text()) - 1) ;
						}
						operateAlert(data.flag,"删除成功！","删除失败！") ;
					},"json");
			
		}) ;
	}) ;
})