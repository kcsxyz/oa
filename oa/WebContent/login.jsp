<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录页面</title>

    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

    <!-- Styles -->
    <link href="css/login.css" rel="stylesheet">
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body style="background-image:url(images/bodybackground.jpg); background-size:100%;">
    <div class="unix-login">
        <div class="container-fluid" >
            <div class="row justify-content-center" style="background:url("images/bodybackground.jpg"),background-size:contain;">
                <div class="login-exterior">
                    <div class="login-content">
                        <!-- <div class="login-logo">
                            <a href="index.html"><span>Focus</span></a>
                        </div> -->
                        <div class="login-interior text-center">
                            <div class="login-title">
                            	培志OA系统 Login
                            </div>
                            
                            <form style="margin-top:20px;">
                                <div class="login-uid">
                                    <pd>工号</pd>
                                </div>
                                <div>
                                	<input type="uid" class="uid-password" placeholder="工号" style="width:300px;">
                                </div>
                                <div class="login-password">
                                    <pd>密码</pd>
                                </div>
                                <div>
                                	<input type="password" class="uid-password" placeholder="密码" style="width:300px;">
                                </div>
	                            <div class="login-verifyCode">
	                                <input type="text" name="verifyCode" id="verifyCode" placeholder="验证码" style="width:150px;">
	        						<img id="imgs" src="/shopping1/vcode" onclick="javascript:_change()" alt="verifycodes" src="verifyCodeAction" width="80px" height="30px"/>
                                </div>
                                <div class="remember text-center">
                                    <pd>
										<input type="checkbox"> 记住我
									</pd>
                                </div>
                                <Button type="submit" class="btn"><div>登&nbsp;&nbsp;&nbsp;&nbsp;录</div></Button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>