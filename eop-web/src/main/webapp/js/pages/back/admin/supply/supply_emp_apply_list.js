$(function(){
	$("td[id^=status]").each(function(){
		status=$(this).text();
		console.log(status);
		if(status==1){
			$(this).text("未审核");
		}
	})
	$("span[id^=eid]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("+")[1] ;
			console.log("雇员编号：" + eid) ;
			$.ajax({
				url:"/eop/pages/back/admin/supply/supply_EmpResource_modal.action",
				data:{
					"eid":eid,
				},
				dataType:"json",
				success:function(data){
					$("#ename").text(data.emp.ename);
					$("#title").text(data.level.title);
					$("#dname").text(data.dept.dname);
					$("#phone").text(data.emp.phone);
				},
				error:function(data){
					alert("程序出现错误！");
				}
			})
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
})