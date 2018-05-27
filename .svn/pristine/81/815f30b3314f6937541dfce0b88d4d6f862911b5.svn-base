$(function(){
	
	$("a[type=button]").each(function(){
		if(!($(this).attr("disable"))){
			$(this).removeAttr("href");
		}
	})
	
	$(selall).on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = $(this).attr("id").split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_compelete_details.action",
				data:{
					"eid":eid,
				},
				dataType:"json",
				success:function(data){
					console.log(data);
					$("table span[id=ename]").text(data.emp.ename);
					$("#level").text(data.level.title);
					$("#salary").text(data.emp.salary);
					$("#dname").text(data.dept.dname);
					$("#phone").text(data.emp.phone);
					$("#hiredate").text(data.emp.hiredate);
					$("#note").text(data.emp.note);
					photo="upload/emp/"+data.emp.photo;
					$("img").attr("src",photo);
					did=data.operate.did;
					if(did==2){
						allEmpCareers=data.allEmpCareers;
						for(empCareer in allEmpCareers){
							trElement=$('<tr></tr>');
							companyElement=$('<td class="text-center"></td>');
							positionElement=$('<td class="text-center"></td>');
							salaryElement=$('<td class="text-center"></td>');
							entryElement=$('<td class="text-center"></td>');
							quitElement=$('<td class="text-center"></td>');
							companyElement.text(allEmpCareers[empCareer].company);
							positionElement.text(allEmpCareers[empCareer].position);
							salaryElement.text(allEmpCareers[empCareer].salary);
							entryElement.text(allEmpCareers[empCareer].entry);
							quitElement.text(allEmpCareers[empCareer].quit);
							trElement.append(companyElement);
							trElement.append(positionElement);
							trElement.append(salaryElement);
							trElement.append(entryElement);
							trElement.append(quitElement);
							$("#career-area").append(trElement);
						}
						allEmpEducations=data.allEmpEducations;
						for(empEducation in allEmpEducations){
							trElement=$('<tr></tr>');
							schoolElement=$('<td class="text-center"></td>');
							degreeElement=$('<td class="text-center"></td>');
							majorElement=$('<td class="text-center"></td>');
							entranceElement=$('<td class="text-center"></td>');
							graduationElement=$('<td class="text-center"></td>');
							schoolElement.text(allEmpEducations[empEducation].school);
							degreeElement.text(allEmpEducations[empEducation].degree);
							majorElement.text(allEmpEducations[empEducation].major);
							entranceElement.text(allEmpEducations[empEducation].entrance);
							graduationElement.text(allEmpEducations[empEducation].graduation);
							trElement.append(schoolElement);
							trElement.append(degreeElement);
							trElement.append(majorElement);
							trElement.append(entranceElement);
							trElement.append(graduationElement);
							$("#edu-area").append(trElement);
						}
					}
				}
			}),
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
	$("#rmBtn").on("click",function(){
		if(!($(this).attr("disabled"))){
			ids="";
			$("input[id^=eid-]").each(function(){
				id=$(this).attr("id").split("-")[1];
				if(this.checked){
					ids=ids+id+",";
				}
			})
			ids=ids.substring(0,ids.length-1);
			console.log(ids);
			$.ajax({
				url:"/eop/pages/back/admin/emp/emp_remove.action",
				data:{"ids":ids},
				type:"post",
				dataType:"text",
				success:function(data){
					if(data.trim()=="true"){
						window.alert("雇员删除成功！");
						window.location="/eop/pages/back/admin/emp/emp_list.action";
					}else{
						operateAlert(false,"","雇员删除失败") ;
					}
				},
				error:function(data){
					operateAlert(false,data,"雇员删除失败") ;
				}
			})
		}
	})
})