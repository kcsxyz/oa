<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>修改密码</title>
	<!-- Bootstrap core CSS -->
    <link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    
    <link href="/oa/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/oa/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="/oa/assets/css/style.css" rel="stylesheet">
    <link href="/oa/assets/css/style-responsive.css" rel="stylesheet">

    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
</head>
<body>
<section id="container" >
            <%@include file="/nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
	          <div class="row mt">
	          		<div class="col-md-12">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
                      		<div class="panel">
						  		<div class="panel-title" style="margin-left:10px;padding-bottom:5px;font-size:15px;"><b>个人设置--修改密码</b></div>
							</div>
	                            <form class="form-horizontal style-form" method="post" style="margin-top:10px;">
	                            
	                            
	                            	<div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;margin-left:55px;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">&nbsp;&nbsp;&nbsp;&nbsp;工号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.uid}</span>
				                              <div class="col-sm-3">
				                              	<input type="hidden" name="uid" id="uid" value="${user.uid}">
				                                 <input type="hidden" name="pwd" id="pwd" value="${user.password}">
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">旧密码:</span>
				                              <div class="col-sm-3">				                              	
				                                  <input type="password" name="password" id="password" class="form-control"><font id="showResult1"></font>
				                              </div>
				                              <span class="oldPassword change_hint"></span>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">新密码:</span>
				                              <div class="col-sm-3">
				                                  <input type="password" name="repassword" id="newPassword" class="form-control"><font id="showResult2"></font>
				                              	<span class="newPassword change_hint"></span>
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">确认密码:</span>
				                              <div class="col-sm-3">
				                                  <input type="password" name="repwd" id="confirm_password" class="form-control"><font id="showResult3"></font>
				                              	<span class="confirmPassword change_hint"></span>
				                              </div>
			                          </div>
			                          
			                          <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-5" style="float:left; text-align:right;margin-left:30px;">
							                  	  	  <button id="save_password" type="button" class="btn btn-round btn-default" >
								                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
								                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;确认&nbsp;&nbsp;&nbsp;&nbsp;</span>
					                  	  	  	 	  </button>
				                              </div>
				                              
				                              <div class="col-sm-3" style="float:left; text-align:center;">
					                              <a href="${pageContext.request.contextPath}/index.jsp">
							                  	  	  <button type="button" class="btn btn-round btn-default">
								                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
								                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp;</span>
					                  	  	  	 	  </button>
						                  	  	  </a>
				                              </div>
			                          </div>
			                    </form>
                      		</div>
                      	</div>
                    </div>
	          </div>
          </section>
      </section>
</section>
 	<!-- js placed at the end of the document so the pages load faster --> 
    <script class="include" type="text/javascript" src="/oa/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/oa/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/oa/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="/oa/assets/js/common-scripts.js"></script>
	<script type="text/javascript" src="/oa/assets/js/jquery-3.1.1.min.js"></script>
	<script src="/oa/assets/js/index.js"></script>
	<script src="/oa/assets/js/jquery.page.js"></script>
	<script type="text/javascript" src="/oa/assets/js/orders.js"></script>
    <!--script for this page-->
	<script type="text/javascript">
		$(function(){
		
		    /*鼠标点击下去的时候，决定是否选中*/
		    $("#myradio").bind("mousedown",function(event){
		         var radioChecked = $(this).prop("checked");
		         $(this).prop('checked', !radioChecked);
		        return false;
		    });
		
		    /*阻止click事件默认行为*/
		    $("#myradio").click(function(event){
		        return false;
		    });
		
		});
	</script>
	<script>
	$("#password").blur(function(){
        var data = $("#password").val();
        if (data == null || data == "") {
            $("#showResult1").text("旧密码不能为空！");
            $("#showResult1").css("color","red");
            return false;
        }else{
        	$("#showResult1").text("");
            }       
    });
	$("#newPassword").blur(function(){
        var data = $("#newPassword").val();
        if (data == null || data == "") {
            $("#showResult2").text("新密码不能为空！");
            $("#showResult2").css("color","red");
            return false;
        }else if(data.lenght<6 || data.lenght>16){
        	$("#showResult2").text("新密码长度为6-16个字符！");
            $("#showResult2").css("color","red");
        }else if(!(new RegExp(/^\w{6,16}$/g).test(data))){
        	$("#showResult2").text("只允许6-16位英文字母、数字和下画线！");
            $("#showResult2").css("color","red");
        }else{
        	$("#showResult2").text("");
        }      
    });
	
	$("#confirm_password").blur(function(){
        var data = $("#confirm_password").val();
        if (data == null || data == "") {
            $("#showResult3").text("请确认新密码！");
            $("#showResult3").css("color","red");
            return false;
        }else if(data!=$("#newPassword").val()){
        	$("#showResult3").text("确认密码与新密码不一致！");
            $("#showResult3").css("color","red");
        }else{
        	$("#showResult3").text("");
        }
    });
	$("#save_password").click(function(){
		var uid=$("#uid").val;
		var oldPassword=$("#password").val();
		var newPassword=$("#new_password").val();
		$.ajax({
			url :"${pageContext.request.contextPath}/user/updatePassword",
			data : "password="+oldPassword+"&repassword="+newPassword,
			type :"post",
			dataType : "json",			
			success : function(data){
				if(data.stateCode==1){
					alert("01");
					location.href="${pageContext.request.contextPath}/user/toLogin";
				}else if(data.stateCode==0){
					$(".retu").html(data.message);
					alert(data.message);
				}
			}
		});
	});
	
</script>
</body>
</html>