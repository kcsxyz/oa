<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>录入个人信息</title>
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
            <%@include file="nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
	          <div class="row mt">
	          		<div class="col-md-12"style="margin-top:40px;" id="user_add">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
	                            <form class="form-horizontal style-form" method="post" action="" style="margin-top:80px;">
	                            	 <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">头像:</span>
				                        	<div class="col-xs-3 col-sm-4" >
				                            	<img src="/oa/images/ui-sam.jpg" alt="选择并上传头像" id="avatar_img" style="width: 100px;height: 100px;left:0;top: 0;border-radius: 50%;">
				                            	<input type="file" id="avatar_file" name="headPic" value="ui-sam.jpg" accept="image/jpg,image/png,image/gif" style="width: 100%;height:100%;opacity: 0;position: absolute;left:0;top: 0;"/> 
											</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">工号:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" type="text" id="uid" name="uid"  >
                                  				<span class="help-block"></span>
                              				</div>
                              				<div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
                              				<font id="showResult1" style="color:red">*</font>
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">姓名:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" type="text" id="uname" name="name"  >
                                  				<span class="help-block"></span>
                                  				
                              				</div>
                              				<div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
                              					<font id="showResult2" style="color:red">*</font>
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                          	<div class="col-sm-3" style="margin-left:31%;float:left;">
			                             <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">性别:</span>
                              				  <div class="col-sm-4" style="margin-top:7px;text-align:center;">
				                              	<span style="font-size:15px;color: rgb(0, 0, 0);">
				                                  <input value="0"  id="myradio" type="radio" name="sex" checked="checked" >男
				                              	</span>
				                              	</div>
				                              	<div class="col-sm-4" style="margin-top:7px;text-align:left;">
				                              	<span style="font-size:15px;color: rgb(0, 0, 0);">
				                                  <input value="1"  id="myradio" type="radio" name="sex" >女
				                              	</span>
				                              </div>
				                          </div> 
				                          <div class="col-sm-4" style="float:left;">
				                          <span style="color:#000;font-size:15px;;float:left;height:28px;text-align:right;line-height:28px;">年龄:</span>
                              				<div class="col-sm-6">
                                  				<%-- <select name="deptId" class="selectpicker show-tick form-control" >
                                  				    <option  selected="selected"></option>
													<c:forEach items="${userDept }" var="u" >
												         <option value="${u.deptId }">
		                                                           ${u.deptName }
		                                                  </option>
		                                                
												     </c:forEach>	
                                  				</select> --%>
                                  				<select id="years" name="age" class="selectpicker show-tick form-control">
			                          				<option value="16">---请选择---</option>
			                          			</select>
                                  				
                              				</div>  
				                          </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                          	<div class="col-sm-3" style="float:left;margin-left:31%;">
			                              <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">部门:</span>
                              				<div class="col-sm-8">
                                  				<select name="deptId" class="selectpicker show-tick form-control" >
                                  				    <option value="1" selected="selected">---请选择---</option>
													<c:forEach items="${userDept }" var="u" >
												         <option value="${u.deptId }">
		                                                           ${u.deptName }
		                                                  </option>
		                                                
												     </c:forEach>	
                                  				</select>
                              				</div>
                              				</div>
                              			 <div class="col-sm-4" style="float:left;">
			                              <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">角色:</span>
                              				<div class="col-sm-6">
                                  				<select name="roleId" class="selectpicker show-tick form-control" >
                                  				    <option value="0" selected="selected">---请选择---</option>
													 <c:forEach items="${userRole }" var="r" >
												         <option value="${r.roleId }">
		                                                           ${r.roleName }
		                                                  </option>
		                                                
												     </c:forEach>	
                                  				</select>
                              				</div>
                              				</div> 
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">身份证号码:</span>                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" id="idCard" name="idCard" >
                                  				<span class="help-block"></span>
                              				</div>
                              				<div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
                              					<font id="showResult3" style="color:red">*</font>
                              				</div>
			                          </div>
			                          
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">电话:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" id="phone" name="phone" >
                                  				<span class="help-block"></span>
                              				</div>
                              				<div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
                              					<font id="showResult4" style="color:red">*</font>
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">邮箱:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" id="email" name="email" >
                                  				<span class="help-block"></span>
                              				</div>
                              				<div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
                              					<font id="showResult5" style="color:red">*</font>
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
				                          <div class="col-sm-2" style="float:left;margin-left:32%;padding:0;">
				                          		<span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">省份:</span>
									            <div class="col-sm-8">
									            <select id="province" class="province selectpicker show-tick form-control">
									            </select>
									            </div>
				                          </div>
				                          <div class="col-sm-2" style="float:left;padding:0;">
				                          		<span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">城市:</span>
				                          		<div class="col-sm-9">
								            	<select id="city" class="city selectpicker show-tick form-control">	
									            </select>
									            </div>
				                          </div>
				                          <div class="col-sm-2" style="float:left;padding:0;">
				                          		<span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">县区:</span>
				                          		<div class="col-sm-8">
								                <select id="area" class="area selectpicker show-tick form-control">
									            </select>
									            </div>
				                          </div>
				                          
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">详细地址:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" name="dizhi" >
                                  				<span class="help-block"></span>
                              				</div>
			                          </div>
	                            		<div class="form-group" style="border:none;margin-top:10px;">
				                              <div class="col-sm-10" style="float:left; text-align:center;">
					                              
							                  	  	  <button type="button" class="btn btn-round btn-default" id="save_user" style="width:10%;background:#68dff0;">
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
	<script src="/oa/js/method4.js"></script>
	
	 <script type="text/javascript">
    $("#uid").blur(function(){
        var data = $("#uid").val();
        if (data == null || data == "") {
            $("#showResult1").text("此项为必填项！");
            return false;
        }else if(data.length>10){
        	$("#showResult1").text("工号长度有误,不能超过10个字符！");
        }else{
        	 $("#showResult1").text("");
        }
    });
    $("#uname").blur(function(){
        var data = $("#uname").val();
        if (data == null || data == "") {
            $("#showResult2").text("此项为必填项！");
            return false;
        }else if(data.length>10){
        	$("#showResult2").text("姓名长度有误,不能超过10个字符！");
        }else if(!(new RegExp(/^([\u4E00-\u9FA5]+|[a-zA-Z]+)$/)).test(data)){
        	$("#showResult2").text("姓名只能为中文或英文且不能出现连续空格！");
        }else{
        	 $("#showResult2").text("");
        }
    });
    $("#idCard").blur(function(){
        var data = $("#idCard").val();
        if (data == null || data == "") {
            $("#showResult3").text("此项为必填项!");
            return false;
        }else if(data.length<18 ||data.length>18){
        	$("#showResult3").text("身份证长度有误!");
        }else if(!(new RegExp(/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/)).test(data)){
        	$("#showResult3").text("身份证格式有误!");
        }else{
        	 $("#showResult3").text("");
        }
    });
    $("#phone").blur(function(){
        var data = $("#phone").val();
        if (data == null || data == "") {
            $("#showResult4").text("此项为必填项!");
            return false;
        }else if(!(new RegExp(/^1[3|4|5|7|8][0-9]{9}$/)).test(data)){
        	$("#showResult4").text("电话格式或长度有误！");
        }else{
        	 $("#showResult4").text("");
        }
    });
    $("#email").blur(function(){
        var data = $("#email").val();
        if (data == null || data == "") {
            $("#showResult5").text("此项为必填项！");
            return false;
        }else if(!(new RegExp(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)).test(data)){
        	$("#showResult5").text("邮箱格式有误！");
        }else{
        	 $("#showResult5").text("");
        }
    }); 
    $(function(){                 
    	for(var i = 16;i<100;i++){ 
    		var age=i;
			$("#years").append($("<option value="+age+">"+age+"岁"+"</option>"));
    		}   
    }); 
    
    //异步校验
    //校验工号是否存在
	$("#uid").change(function(){
		var uid=this.value;
		$.ajax({
			url: "${pageContext.request.contextPath}/userpower/checkUserByUid",
			type: "post",
			data: "uid="+uid,
			success:function(result){
				if(result.stateCode==1){
					valate_form_msg("#uid",'success',result.message);
					$("#uid").attr("ajax-va","success");
				}else if(result.stateCode==0){
					valate_form_msg("#uid",'error',result.message);
					$("#uid").attr("ajax-va","error");
				}
			}
		});
	});
    //校验idCard
	$("#idCard").change(function(){
		var idCard=this.value;
		$.ajax({
			url: "${pageContext.request.contextPath}/userpower/checkUserByIdCard",
			type: "post",
			data: "idCard="+idCard,
			success:function(result){
				if(result.stateCode==1){
					valate_form_msg("#idCard",'success',result.message);
					$("#idCard").attr("ajax-va","success");
				}else if(result.stateCode==0){
					valate_form_msg("#idCard",'error',result.message);
					$("#idCard").attr("ajax-va","error");
				}
			}
		});
	});
    
	  function valate_form_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next('span').text("");
			if(status=='success'){
				$(ele).parent().addClass("has-success");
				$(ele).next('span').text(msg);
			}else if(status=='error'){
				$(ele).parent().addClass("has-error");
				$(ele).next('span').text(msg);
			}
		}
	  
	  
    </script> 

	
</body>

</html>