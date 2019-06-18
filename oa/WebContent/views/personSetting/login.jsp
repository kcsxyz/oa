<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录页面</title>

    <!-- ================= Favicon ================== -->
    <!-- Styles -->
    <link href="/oa/css/login.css" rel="stylesheet">
    <link href="<%=basePath%>assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="<%=basePath%>assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>assets/css/lib/helper.css" rel="stylesheet">
    <link href="<%=basePath%>assets/css/style.css" rel="stylesheet">
    <script src="<%=basePath%>assets/jquery-2.1.0.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>assets/jquery.validate.min.js" type="text/javascript"></script>
</head>

<body style="background-image:url(/oa/images/bodybackground.jpg); background-size:100%;">
    <div class="unix-login">
        <div class="container-fluid" >
            <div class="row justify-content-center" style="background:url("/oa/images/bodybackground.jpg"),background-size:contain;">
                <div class="login-exterior">
                    <div class="login-content">
                        <!-- <div class="login-logo">
                            <a href="index.html"><span>Focus</span></a>
                        </div> -->
                        <div class="login-interior text-center" style="/* filter:alpha(Opacity=80);-moz-opacity:0.5;opacity: 0.8; */">
                            <div class="login-title">
                            	OA系统 Login
                            </div>
                            
                            <form id="login-form" method="post" style="margin-top:20px;">
                                <div class="login-uid">
                                    <pd style="float:left;padding-left:10px;">工号</pd>
                                </div>
                                <div>
                                	<input type="text" name="uid" id="uid" class="uid-password" required placeholder="工号" style="width:300px; padding-left:5px;">
                                	
                                	<label id="showResult" style="width:350px;height:10px;display:block;text-align:right;padding:0px;margin:5px 0 0 0;"></label>
                                </div>
                                <div class="login-password">
                                    <pd style="float:left;padding-left:10px;">密码</pd><font id="error2" style="color:red;"></font>
                                </div>
                                <div>
                                	<input type="password" name="password" id="password" class="uid-password" required placeholder="密码" style="width:300px; padding-left:5px;">
                                </div>
	                            <div class="login-verifyCode">
	                                <input type="text" name="code" id="code" placeholder="验证码" style="width:150px;margin-left:40px; padding-left:5px;">
	        						<img id="imgs" src="/oa/getVerify" onclick="changeImage()" alt="verifycodes" src="verifyCodeAction" width="80px" height="30px" />
                                </div>
                                <div class="remember text-center">
                                    <pd>
										<input type="checkbox" id="ck_rmbUser" value="0"> 记住我
									</pd>
                                </div>
                                <Button type="button" class="btn" id="bt-login"><div>登录</div></Button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<script>
		function changeImage(){
			$("#imgs")[0].src="${pageContext.request.contextPath}/getVerify?time="+new Date();
		}
	  
	</script>
<script src="/oa/assets/js/jquery-3.1.1.min.js"></script>
<script src="/oa/assets/js/jquery.cookie.js"></script>
<script>
    $("#uid").blur(function(){
        var data = $("#uid").val();
        if (data == null || data == "") {
            $("#showResult").text("工号不能为空！");
            $("#showResult").css("color","red");
            return false;
        }
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/getUser",
            data:"uid="+data,
            beforeSend:function(XMLHttpRequest)
            {
                $("#showResult").text("正在查询");

            },
            success:function(obj)
            {
                if(obj.stateCode == 1){
                    $("#showResult").text("工号可以使用");
                    $("#showResult").css("color","green");
                }else if(obj.stateCode == 0){
                    $("#showResult").text("工号不存在");
                    $("#showResult").css("color","red");
                }else {
                    $("#showResult").text("系统异常！");
                    $("#showResult").css("color","red");
                }
            },
            error:function()
            {
                //错误处理
            }
        });
    });
</script>
<script>
    $('#bt-login').click(function(){
        //读取用户的输入——表单序列化
        var inputData = $('#login-form').serialize();
       
        //异步提交请求，进行验证
        
		$.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/login',
            data: inputData,
            success: function(xhr){
                if(xhr.stateCode==1){  //登录成功
                	Save();
                    var loginName = $('[name="uid"]').val();
                    sessionStorage['loginName']=loginName;
                    $('#showResult').html(xhr.message);
                    $("#showResult").css("color","green");
                    window.location.href="${pageContext.request.contextPath}/user/showIndex";
                    console.log(loginName);
                }else if(xhr.stateCode==0){ //登录失败
                    alert(xhr.message);
                    window.location.href="${pageContext.request.contextPath}/user/toLogin";
                }
            }
        });
    });
</script>
<script type="text/javascript">

    $(document).ready(function () {
        if ($.cookie("rmbUser") == "true") {
            $("#ck_rmbUser").attr("checked", true);
            $("#uid").val($.cookie("uid"));
            $("#password").val($.cookie("password"));
        }
    });

    //记住用户名密码
    function Save() {
        if ($("#ck_rmbUser").prop("checked")) {
            var str_uid = $("#uid").val();
            console.log(str_uid);
            var str_password = $("#password").val();
            $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
            $.cookie("uid", str_uid, { expires: 7 });
            $.cookie("password", str_password, { expires: 7 });
        }
        else {
            $.cookie("rmbUser", "false", { expire: -1 });
            $.cookie("uid", "", { expires: -1 });
            $.cookie("password", "", { expires: -1 });
        }
    };
</script>
</body>

</html>