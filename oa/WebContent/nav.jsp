<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/style.min862f.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="icon" href="/favicon.ico">
    <title>培志OA系统</title>
</head>
<body class="layui-layout-body gray-bg">
	    <div class="layui-layout layui-layout-admin">
	        <div class="layui-header custom-header">
	            
	            <ul class="layui-nav layui-layout-left">
	                <li class="layui-nav-item slide-sidebar" lay-unselect>
	                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
	                </li>
	            </ul>
	
	            <ul class="layui-nav layui-layout-right">
	            	<div class="lagout">
	            		<button class="layui-btn layui-btn-radius layui-btn-primary"><a href="login.html">退出</a></button>
	            	</div>
	                <!-- <li class="layui-nav-item">
	                    <a href="javascript:;">BieJun</a>
	                    <dl class="layui-nav-child">
	                        <dd><a href="">帮助中心</a></dd>
	                        <dd><a href="login.html">退出</a></dd>
	                    </dl>
	                </li> -->
	            </ul>
	        </div>
			<div class="layui-side custom-admin">
			            <div class="layui-side-scroll">
			
			                <div class="custom-logo">
			                    <img src="assets/images/logo.png" alt=""/>
			                    <h1>OA系统</h1>
			                </div>
			                <ul id="Nav" class="layui-nav layui-nav-tree">
			                <div class="avatar">
			                	<p class="centered">
			                		<a href="profile.html"><img src="assets/images/ui-sam.jpg" class="img-circle" width="60"></a>
			                		<dl class="layui-nav-child">
			                        	<dd><a href="">个人设置</a></dd>
			                        	<dd><a href="login.html">修改密码</a></dd>
			                    	</dl>
			                	</p>
			                
			                    <h5 class="centered">金咏琪</h5>
			                    </div>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon">&#xe609;</i>
			                            <em>主页</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/console.html">主页</a></dd>
			                        </dl>
			                    </li>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon">&#xe612;</i>
			                            <em>个人办公</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/form.html">工作日志</a></dd>
			                            <dd><a href="views/form.html">工作计划</a></dd>
			                            <dd><a href="views/form.html">个人日程</a></dd>
			                            <dd><a href="addressPersonalList.jsp">个人通讯录</a></dd>
			                            <!-- <dd>
			                                <a href="javascript:;">页面</a>
			                                <dl class="layui-nav-child">
			                                    <dd>
			                                        <a href="login.html">登录页</a>
			                                    </dd>
			                                </dl>
			                            </dd> -->
			                        </dl>
			                    </li>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon layui-icon-group">&#xe613;</i>
			                            <em>部门办公</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/users.html">考勤系统</a></dd>
			                            <dd><a href="views/operaterule.html">人力资源管理</a></dd>
			                            <dd><a href="views/operaterule.html">项目管理</a></dd>
			                        </dl>
			                    </li>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon layui-icon-reply-fill">&#xe611;</i>
			                            <em>信息更新</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/users.html">公告管理</a></dd>
			                            <dd><a href="views/operaterule.html">计划审核</a></dd>
			                            <dd><a href="views/operaterule.html">任务下达</a></dd>
			                        </dl>
			                    </li>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon layui-icon-set-fill">&#xe614;</i>
			                            <em>系统设置</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/users.html">部门设置</a></dd>
			                            <dd><a href="views/operaterule.html">用户设置</a></dd>
			                            <dd><a href="views/operaterule.html">菜单设置</a></dd>
			                        </dl>
			                    </li>
			                    <li class="layui-nav-item">
			                        <a href="javascript:;">
			                            <i class="layui-icon template-1">&#xe656;</i>
			                            <em>流程审批</em>
			                        </a>
			                        <dl class="layui-nav-child">
			                            <dd><a href="views/users.html">审批记录</a></dd>
			                        </dl>
			                    </li>
			                </ul>
			
			            </div>
			        </div>
	<script src="assets/layui.js"></script>
    <script src="js/index.js" data-main="home"></script>
    <script src="js/home.js" ></script>
</body>
</html>