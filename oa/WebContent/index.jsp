<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="assets/css/layui.css">
<link rel="stylesheet" href="assets/css/admin.css">
<link rel="stylesheet" href="assets/css/style.min862f.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="icon" href="/favicon.ico">
<title>培志OA系统</title>
</head>
<body class="layui-layout-body gray-bg">
	<%@include file="nav.jsp"%>

	<div class="layui-body">
		<div class="layui-tab app-container" lay-allowClose="true"
			lay-filter="tabs">
			<ul id="appTabs" class="layui-tab-title custom-tab"></ul>
			<div class="gray-bg">
				<%@include file="main.jsp"%>
			</div>
		</div>
	</div>

	<!-- <div class="layui-footer">
            <p>© 2018 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
        </div> -->

	<div class="mobile-mask"></div>
	</div>
	<script src="assets/layui.js"></script>
	<script src="js/index.js" data-main="home"></script>
	<script src="js/home.js"></script>
</body>
</html>