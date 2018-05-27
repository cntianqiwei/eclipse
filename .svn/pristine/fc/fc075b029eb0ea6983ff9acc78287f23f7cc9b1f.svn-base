$(function() {
	$("a[id^=addBtn]")
			.on("click",
					function() {
						spid = $("#spid").val();
						console.log("办公用品编号，spid = " + spid);
						window.location = "/eop/pages/back/admin/supply/supply_goods_add.jsp?spid="
								+ spid + "";
					});
	$("#selectAll").on("click", function() {
		checkboxSelectAll('resid', this.checked);
	});
	$("button[id^=rmBtn]").on("click", function() {
		ids = "";// 要删除的数据
		$("#resid:checked").each(function() {
			ids += $(this).val() + ";";
			console.log("要移除的清单=" + ids);
		})
		if (ids == "") { // 没有要移除的商品
			operateAlert(false, "", "请先选择要移除的商品！");
		} else {
			$.post("/eop/pages/back/admin/supply/supply_goods_remove.action", {
				"ids" : ids
			}, function(data) {
				console.log(data);
				if (data.flag) {// 存的就是一个flag
					$("#resid:checked").each(function() {
						$("#resource-" + $(this).val()).remove();
					})
				}
				operateAlert(data.flag, "商品移除成功！", "商品移除失败！");
			}, "json");
		}
	})
	$("button[id^=submitBtn]").on("click", function() {
		if (window.confirm("确定要提交吗？一旦提交申请单将无法更改！")) {
			spid=$("#spid").val();
//			console.log(spid);
			ids = "";// 要提交的清单编号
			$("#resid:checked").each(function() {
				ids += $(this).val() + ";";
				console.log("要提交的清单=" + ids);
			})
			if(ids==""){
				operateAlert(false,"","请选择要提交的清单");
			}else{
				$.post("/eop/pages/back/admin/supply/supply_apply_edit.action", {
					"ids" : ids,
					"spid": spid
				}, function(data) {
					window.location="/eop/pages/back/admin/supply/supply_apply_list.action";
				}, "text");
			}
		}
	})
});
