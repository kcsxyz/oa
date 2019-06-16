<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>个人信息</title>
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
	          		<div class="col-md-12"style="margin-top:40px;">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
	                            <form class="form-horizontal style-form" method="post" style="margin-top:80px;" enctyped="multiple/form-data">
									<div class="form-group" style="border:none;margin-top:10px;">
			                        	<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">头像:</span>
				                        	<div class="col-xs-3 col-sm-4" >
				                            	<img src="${user.headPic}" alt="选择并上传头像" id="avatar_img" style="width: 100px;height: 100px;left:0;top: 0;border-radius: 50%;">
				                            	<input type="file" id="avatar_file" name="avatar_file" accept="image/jpg,image/png,image/gif" style="width: 100%;height:100%;opacity: 0;position: absolute;left:0;top: 0;"/> 
											
											</div>
											
			                        </div>
			              			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">工号:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.uid}"  disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">姓名:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.name}"  disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">性别:</span>
                              				<div class="col-sm-5">
                              					<c:if test="${user.sex==0}">
                                  					<input class="form-control" id="disabledInput" type="text" value="女" disabled>
                                  				</c:if>
                                  				<c:if test="${user.sex==1}">
                                  					<input class="form-control" id="disabledInput" type="text" value="男" disabled>
                                  				</c:if>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;;float:left;height:28px;text-align:right;line-height:28px;">年龄:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.age}"  disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">身份证密码:</span>                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.idCard}" disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">部门:</span>
                              				<div class="col-sm-5">
                              					<c:if test="${user.dept.deptName!=null}">
                                  					<input class="form-control" id="disabledInput" type="text" value="${user.dept.deptName}" disabled>
                              					</c:if>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">电话:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.phone}" disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">邮箱:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.email}" disabled>
                              				</div>
                          			</div>
                          			<div class="form-group" style="border:none;margin-top:10px;">
                              			<span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">地址:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" id="disabledInput" type="text" value="${user.address}" disabled>
                              				</div>
                          			</div>
	                            	<div class="form-group" style="border:none;margin-top:10px;">
				                              <div class="col-sm-12" style="float:left; text-align:center;">
					                              
							                  	  	  <button type="button" id="sub_hed" class="btn btn-round btn-default" style="width:10%;background:#68dff0;">
									                  	  <span style="color: rgb(255,255,255); font-size: 16px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  提交</span>
							                  	  	  </button>
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

    <!--script for this page-->
	<script> 
	// 头像预览
	var file = null;    
	$("#avatar_file").change(function () {       
		// 获取上传文件对象     
		file = $(this)[0].files[0];     
		// 读取文件URL 
		var reader = new FileReader();     
		reader.readAsDataURL(file);   
		// 阅读文件完成后触发的事件   
		reader.onload = function () {    
			// 读取的URL结果：this.result       
			$("#avatar_img").attr("src", this.result);  
			}  
		});
	//ajax调用文件上传方法
	$("#sub_hed").click(function(){
		if(file == null){
			alert("");		
		}
		var formData = new FormData();
		formData.append("file",file);
		$.ajax({
            type:"POST",
            contentType: false,  
            processData: false,
            url:"${pageContext.request.contextPath}/user/fileUpload",
            data:formData,
            success:function(obj)
            {
                
                if(obj.stateCode == 1){
                	window.location.href="${pageContext.request.contextPath}/user/toupdatePassword";
                }else if(obj.stateCode == 0){
                   alert("1");
                }else {
                	 alert("2");
                }
            },
            error:function()
            {
                //错误处理
            }
        });
	});
	 
	</script>

</body>
</html>