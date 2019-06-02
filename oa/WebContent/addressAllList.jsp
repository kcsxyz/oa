<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=basePath%>css/address.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/admin.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/style.min862f.css">
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=basePath%>bootstrap/css/bootstrap.min.css">
<link rel="icon" href="<%=basePath%>/favicon.ico">
<script src="assets/jquery-1.9.1.js"></script>
<script src="bootstrap/bootstrap.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<title>通讯录</title>
</head>
<%
	List list = new ArrayList();
	for (int i = 0; i < 10; i++) {
		list.add(i);
		session.setAttribute("list", list);
	}
%>
<body class="layui-layout-body gray-bg">
	<%@include file="nav.jsp"%>
	<div class="layui-body">
		<div class="layui-tab app-container" lay-allowClose="true"
			lay-filter="tabs">
			<ul id="appTabs" class="layui-tab-title custom-tab"></ul>
			<div class="wrapper wrapper-content">
				<section class="panel"> <header class="panel-heading">
				<div class="select-exterior">
					<div class="select-interior-left">
						<input type="text" name="title" style="height: 30px;"
							placeholder="请输入姓名" class="layui-input">
					</div>
					<div class="select-interior-right">
						<button class="layui-btn layui-btn-sm layui-btn-warm">
							<i class="layui-icon -search">&#xe615;</i>
						</button>
					</div>
				</div>
				<div class="dropdown">
					<button type="button" class="btn dropdown-toggle"
						id="dropdownMenu1" data-toggle="dropdown">
						部门 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">办公室</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">开发部</a></li>
					</ul>
				</div>
				</header>
				<div class="panel-body table-responsive">
					<table class="table table-hover"
						style="margin: 0 auto; text-align: center;">
						<thead>
							<tr>
								<th style="text-align: center;">#</th>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">部门</th>
								<th style="text-align: center;">姓名</th>
								<th style="text-align: center;">联系方式</th>
								<th style="text-align: center;">邮箱</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" varStatus="status" var="item">
								<tr>
									<td>
										<div class="task-checkbox">
											<!-- <input type="checkbox" class="list-child" value=""  /> -->
											<input type="checkbox" class="flat-grey list-child" />
											<!-- <input type="checkbox" class="square-grey"/> -->
										</div>
									</td>
									<td>${status.index+1}</td>
									<td>办公室</td>
									<td>金咏琪</td>
									<!-- <td>Steve</td> -->
									<td>13699551360</td>
									<!-- <td>$1500</td> -->
									<td>1790435361@qq.com</td>
									<td><button class="layui-btn layui-btn-sm">
											<i class="layui-icon">&#xe654;</i>
										</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="clearfix">
						<div class="pagination-left">
							<div class="pull-left pagination-detail">
								<span class="pagination-info">第1到第8条，共16条记录。</span> <span
									class="page-list"> 每页 <span class="btn-group group">
										<button class="btn btn-default btn-outline dropdown-toggle"
											type="button" data-toggle="dropdow">
											<span class="page-size">8</span>&nbsp; <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li class="active"><a href="javascript:void(0)">8</a></li>
											<li class="active"><a href="javascript:void(0)">25</a></li>
										</ul>
								</span>条记录
								</span>
							</div>
						</div>
						<div class="pagination-right">
							<ul class="pagination">
								<li class="page-pre"><a href="javascript:void(0)">&lt;</a>
								</li>
								<li class="page-number"><a href="javascript:void(0)">1</a>
								</li>
								<li class="page-number active"><a href="javascript:void(0)">2</a>
								</li>
								<li class="page-next"><a href="javascript:void(0)">&gt;</a>
								</li>
							</ul>
						</div>
				</section>


			</div>
			<script src="assets/layui.js"></script>
			<script src="js/index.js" data-main="home"></script>
			<script src="js/home.js"></script>
</body>
</html>