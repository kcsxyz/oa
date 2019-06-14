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
	<title>修改个人信息</title>
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
	          		<div class="col-md-12"style="margin-top:40px;">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
	                            <form class="form-horizontal style-form" method="post" action="${pageContext.request.contextPath }/userpower/updateUser" onSubmit="return myCheck(this)" style="margin-top:80px;">
	                            	 <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">头像:</span>
				                        	<div class="col-xs-3 col-sm-4" >
				                            	<img src="/oa/images/ui-sam.jpg" alt="选择并上传头像" id="avatar_img" style="width: 100px;height: 100px;left:0;top: 0;border-radius: 50%;">
				                            	<input type="file" id="avatar_file" name="headPic" accept="image/jpg,image/png,image/gif" style="width: 100%;height:100%;opacity: 0;position: absolute;left:0;top: 0;"/> 
											</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">工号:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" type="text" name="uid" value="${userPower.uid } "  >
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">姓名:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control" type="text" name="name" value="${userPower.name }" >
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                          	<div class="col-sm-3" style="margin-left:31%;float:left;">
			                             <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">性别:</span>
                              				 <c:if test="${userPower.sex==0 }">  
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
				                              </c:if>
				                           <c:if test="${userPower.sex==1 }">  
                              				  <div class="col-sm-4" style="margin-top:7px;text-align:center;">
				                              	<span style="font-size:15px;color: rgb(0, 0, 0);">
				                                  <input value="0"  id="myradio" type="radio" name="sex" >男
				                              	</span>
				                              	</div>
				                              	<div class="col-sm-4" style="margin-top:7px;text-align:left;">
				                              	<span style="font-size:15px;color: rgb(0, 0, 0);">
				                                  <input value="1"  id="myradio" type="radio" name="sex"  checked="checked">女
				                              	</span>
				                              </div>
				                              </c:if>
				                              
				                          </div>  
				                           <div class="col-sm-4" style="float:left;">
				                          <span style="color:#000;font-size:15px;;float:left;height:28px;text-align:right;line-height:28px;">年龄:</span>
                              				<div class="col-sm-3">
                                  				<input class="form-control"  type="text" value="${userPower.age }" name="age"  >
                                  				
                              				</div>  
				                          </div>
			                          </div>
			                          
			                         <div class="form-group" style="border:none;margin-top:10px;">
			                             	<div class="col-sm-3" style="float:left;margin-left:31%;">
			                              <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">部门:</span>
                              				<div class="col-sm-8">
                                  				<select name="deptId" class="selectpicker show-tick form-control" >
                                  				    <option  selected="selected"></option>
													<c:forEach items="${userDept }" var="u" >
												        <c:if test="${userPower.deptId==u.deptId }">
												         <option value="${u.deptId }" selected="selected">
		                                                           ${u.deptName }
		                                                  </option>
		                                                </c:if>
		                                                <c:if test="${userPower.deptId!=u.deptId }">
												         <option value="${u.deptId }">
		                                                           ${u.deptName }
		                                                  </option>
		                                                </c:if>
												     </c:forEach>	
                                  				</select>
                              				</div>
                              				</div>
                              				 <div class="col-sm-4" style="float:left;">
			                              <span style="color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">角色:</span>
                              				<div class="col-sm-6">
                                  				<select name="roleId" class="selectpicker show-tick form-control" >
													 <c:forEach items="${userRole }" var="r" >
													    <c:if test="${userPower.roleId==r.roleId }">
													         <option value="${r.roleId }" selected="selected">
		                                                           ${r.roleName }
		                                                  </option> 
													    </c:if>
													      <c:if test="${userPower.roleId!=r.roleId }">
													         <option value="${r.roleId }">
		                                                           ${r.roleName }
		                                                  </option> 
													    </c:if>
												        <%--  <option value="${r.roleId }">
		                                                           ${r.roleName }
		                                                  </option> --%> 
		                                                
												     </c:forEach>	
                                  				</select>
                              				</div>
                              				</div> 
                              				
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">身份证密码:</span>                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" value="${userPower.idCard }" name="idCard" >
                              				</div>
			                          </div>
			                          
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">电话:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" name="phone" value="${userPower.phone }" >
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">邮箱:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" name="email" value="${userPower.email }" >
                              				</div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:10px;">
			                              <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">地址:</span>
                              				<div class="col-sm-5">
                                  				<input class="form-control"  type="text" name="address" value="${userPower.address }" >
                              				</div>
			                          </div>
	                            		<div class="form-group" style="border:none;margin-top:10px;">
				                              <div class="col-sm-10" style="float:left; text-align:center;">
					                              
							                  	  	  <button type="submit" class="btn btn-round btn-default" style="width:10%;background:#68dff0;">
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
    <script src="assets/js/common-scripts.js"></script>

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
		
		  function myCheck(form){
			  if(form.uid.value==''|| form.uid.value==null){
			  alert('工号不能为空!');
			  form.uid.focus();
			  return false;
			  }
			  if(form.name.value==''||form.name.value==null){
			  alert('姓名不能为空!');
			  form.name.focus();
			  return false;
			  }
			  if(form.idCard.value=='' || form.idCard.value==null ){
			  alert('身份证号码不能为空');
			  form.idCard.focus();
			  return false;
			  }
			  if(form.idCard.value.length<18 ||form.idCard.value.length>18 ){
				  alert('身份证号码格式有误');
				  form.idCard.focus();
				  return false;
			  }
			  if(form.phone.value==''||form.phone.value==null){
				  alert('手机号码不能为空!');
				  form.phone.focus();
				  return false;
				  }
			  if(!(new RegExp(/^1[3|4|5|7|8][0-9]{9}$/)).test(form.phone.value)){
				  alert('输入正确的手机号码格式!');
				  form.phone.focus();
				  return false;
			  }
			  if(form.email.value==''||form.email.value==null){
				  alert('邮箱不能为空!');
				  form.email.focus();
				  return false;
				  }
			  if(!(new RegExp(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)).test(form.email.value)){
				  alert('请输入正确的邮箱!');
				  form.email.focus();
				  return false;
			  }
			  if(form.address.value==''||form.address.value==null){
				  alert('地址不能为空!');
				  form.address.focus();
				  return false;
				  }
			 else{
				  alert("修改个人信息成功");
				  return true;
			  }
		  }
	</script>
</body>
</html>