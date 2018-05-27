<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_details_list.js"></script>
<%!
	public static final String SUPPLY_EDIT_URL = "pages/back/admin/supply/supply_goods_edit_pre.action" ;
	public static final String SUPPLY_GOODS_ADD_URL = "pages/back/admin/supply/supply_goods_add.jsp" ;
	public static final String SUPPLY_APPLY_LIST = "pages/back/admin/supply/supply_apply_list.jsp" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="8"/>
			<jsp:param name="msi" value="82"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;资源采购申请单详情</strong>
				<input type="text" name="spid" id="spid" value="${param.spid}" style="display:none">
			</div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selectAll"></th>
							<th class="text-center">图片</th>
							<th class="text-center">办公用品名称</th>
							<th class="text-center">单价</th>
							<th class="text-center">数量</th>
							<th class="text-center">操作</th> 
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${allResource}" var="resource">
						<tr id="resource-${resource.resid}">
							<td class="text-center"><input type="checkbox" id="resid" name="resid" value="${resource.resid}"></td>
							<td class="text-center"><img src="upload/resource/${resource.photo}" style="width:30px;"></td>
							<td class="text-center">${resource.title}</td>
							<td class="text-center">${resource.price}</td>
							<td class="text-center">${resource.amount}</td>
							<td class="text-center">
								<a type="button"  id="editbut" class="btn btn-primary btn-xs" href="<%=SUPPLY_EDIT_URL%>?resid=${resource.resid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-success" id="addBtn"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;追加待采购商品</a>
				<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除待采购商品</button>
				<button class="btn btn-success" id="submitBtn" ><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;提交申请</button>
				<div id="splitBarDiv" style="float:right">
				</div>
			</div>
			<div class="panel-footer">
				<jsp:include page="/pages/plugins/include_alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<jsp:include page="/pages/plugins/back/admin/supply/supply_modal.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
