<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/plan/plan_history_list.js"></script>
<%!
	public static final String PLAN_DETAILS_URL = "pages/back/admin/plan/plan_details_pre.action" ;
	public static final String PLAN_PUBLIC_URL = "" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="52"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;历史任务</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">任务名称</th>
							<th class="text-center">任务发起人</th>
							<th class="text-center">任务类型</th>
							<th class="text-center">开始日期时间</th>
							<th class="text-center">结束日期时间</th>
							<th class="text-center">任务人数</th>
							<th class="text-center">任务状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allPlans}" var="plan">
							<tr id="${plan.pid}" status="${plan.status}">
							<td class="text-center"><input type="checkbox" id="pid-${plan.pid}" value="${plan.pid}"></td>
							<td class="text-center"><span id="re-1" style="cursor:pointer;">${plan.title }</span></td>
							<td class="text-center">${plan.eid} </td>
							<td class="text-center">${plan.item} </td>
							<td class="text-center"><fmt:formatDate value="${plan.starttime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
							<td class="text-center"><fmt:formatDate value="${plan.endtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
							<td class="text-center">${plan.amount }</td>
							<td class="text-center" id="status">${plan.status == 0?"草稿":"发布"}</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" id="detail-${plan.pid}" href="<%=PLAN_DETAILS_URL%>?pid=${plan.pid}" ${plan.status==0?"disabled":""}>
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a>
								<button type="button" class="btn btn-primary btn-xs" id="pub-${plan.pid}" ${plan.status==1?"disabled":""}>
										<span class="glyphicon glyphicon-edit"></span>&nbsp;任务发布</button>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除未开始任务</button>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
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
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
