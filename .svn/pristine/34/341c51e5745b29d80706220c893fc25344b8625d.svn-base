<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="planEmpInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true"  id="closeBtn_head">&times;</button>
				<div class="form-group" id="didDiv">
					<!-- 定义表单提示文字 -->
					<div class="alert alert-success" id="alert1Div" style="display:none;">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<span id="alert1Text"></span>
					</div>
					<label class="col-md-2 control-label" for="did">员工所在部门：</label>
					<div class="col-md-5">
						<select id="did" name="did" class="form-control">
							<option value="">====== 请选择雇员所在部门 ======</option>
							<c:forEach items="${allDepts}" var="entry">
								<option id="${entry.key }" value="${entry.key }">${entry.value }</option>
							</c:forEach>
						</select>
					</div>
					
					
					
				</div>
			</div>
			<div class="modal-body">
				<div id="memberBasicInfo">
					<table class="table table-condensed table-hover" id="empTable">
						<thead>
							<tr>
								<th class="text-center"><strong>照片</strong></th>
								<th class="text-center"><strong>雇员编号</strong></th>
								<th class="text-center"><strong>姓名</strong></th>
								<th class="text-center"><strong>级别</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody id="tbody">
							<tr id="travel-1">
								<td class="text-center">
									<img src="upload/emp/nophoto.png" style="width:20px;"/> 
								</td>
								<td class="text-center">7369</td>
								<td class="text-center">老李</td>
								<td class="text-center">部门员工</td>
								<td class="text-center">
									<button class="btn btn-danger btn-xs" id="add-1">
										<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;增加</button>
								</td>
							</tr> 
						</tbody>
					</table>
				</div>
			</div>
			
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="closeBtn_foot">关闭窗口</button>
			</div>
		</div>
	</div>
</div>