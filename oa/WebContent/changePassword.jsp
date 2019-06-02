<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<title>修改密码</title>
</head>
<body class="layui-layout-body gray-bg">
	<%@include file="nav.jsp"%>
	<div class="layui-body">
		<div class="layui-tab app-container" lay-allowClose="true"
			lay-filter="tabs">
			<ul id="appTabs" class="layui-tab-title custom-tab"></ul>
			<div
				class="wrapper wrapper-content animated fadeInright ibox-content"
				style="margin: 0 50px 0 50px; height: 90%;">
				<form id="form-user-resetPWD" class="form-horizontal m"
					style="height: 50%; margin-top: 100px;">
					<div class="form-group"
						style="height: 40px; width: 90%; text-align: center; font-size: 24px;">

						修改密码</div>
					<div class="form-group" style="height: 40px;">
						<label class="col-sm-3 control-label"
							style="height: 90%; font-size: 18px; font-family: 宋体;">旧密码：</label>
						<div class="col-sm-8" style="height: 40px; width: 50%">
							<input id="oldPassword" class="form-contral"
								style="height: 90%; width: 90%" type="password" name="password">
						</div>
					</div>
					<div class="form-group" style="height: 40px;">
						<label class="col-sm-3 control-label"
							style="height: 90%; font-size: 18px; font-family: 宋体;">新密码：</label>
						<div class="col-sm-8" style="height: 40px; width: 50%">
							<input id="password" class="form-contral"
								style="height: 90%; width: 90%" type="password" name="password">
						</div>
					</div>
					<div class="form-group" style="height: 40px;">
						<label class="col-sm-3 control-label"
							style="height: 90%; font-size: 18px; font-family: 宋体;">再次确认：</label>
						<div class="col-sm-8" style="height: 40px; width: 50%">
							<input id="confirm" class="form-contral"
								style="height: 90%; width: 90%" type="password" name="confirm">
						</div>
					</div>
					<div class="form-group" style="width: 50%; margin-top: 20px;">
						<div class="form-control-static col-sm-offset-9">
							<button class="btn btn-primary" type="submit">提交</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger" type="button">关闭</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>