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
	<title>添加公告</title>
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
	<link href="/oa/assets/css/bootstrap-select.min.css" rel="stylesheet">
	
    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    <script src="/oa/assets/js/bootstrap-select.min.js"></script>
    
    <!-- 富文本编辑器 -->
 	<script src="/oa/ueditor/ueditor.config.js"></script>
 	<script src="/oa/ueditor/ueditor.parse.js"></script>
 	<script src="/oa/ueditor/ueditor.all.js"></script>
 	<script type="text/javascript">
 		window.onload=function(){
 			UE.getEditor('editor');
 		}
 	</script>
    
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
                      			<div class="panel panel-default" style="border:none;margin-top:20px;height:70px;">
		    						<div class="panel-body" style="border:none;height:80px;">
			                          	<div class="col-xs-6 col-sm-3" style="border:none;float:left;">
					                  	  	 <a href="${pageContext.request.contextPath }/notice/selectByParams">
					                  	  	 <button type="button" class="btn btn-round btn-default">
							                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
							                  	  	  返回上一级</span>
					                  	  	  </button>
					                  	  	 </a>
				                  	  	</div>
		                            </div>	
	                            </div>
	                            <div id="pushNotice">
	                            <form class="form-horizontal style-form" method="get" action="" style="margin-top:80px;">

			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">标题:</span>
				                              <div class="col-sm-6">
				                                  <input type="text" id="title" name="title" class="form-control"><!-- <font id="showResult"  style="color:red;width:10%;" ></font> -->
				                                   <span class="help-block"></span>
				                              </div>
			                          </div> 
			                          
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">类型:</span>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios3" value="0" checked="checked">通知
				                              	</label>
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios4"  value="1">公告
				                              	</label>	
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios4"  value="2">任务
				                              	</label>
				                              </div>
			                          </div>
			                          
			                          
			                          <div class="form-group" style="border:none;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">内容:</span>
				                              <div class="col-sm-9">
				                                   <textarea  name="content" id="editor" style="height:300px" rows="8"></textarea>
				                                   <font id="showResult"  style="color:red;width:10%;" >*</font>  
				                                     <!--<span class="help-block"></span> -->
				                              </div>
			                          </div>
			                          
			                          
			                          
			                          
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">谁可见:</span>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              		<select id="browsePower" name="browsePower" class="selectpicker show-tick form-control" multiple data-live-search="false">
													<option value="所有部门" selected="selected">所有部门</option>
													<c:forEach items="${noticeDept }" var="n" >
												         <option value="${n.deptName }">
		                                                           ${n.deptName }
		                                                  </option>
												     </c:forEach>	
												</select>	
				                              		
				                              </div>
				                          <!--   <div class="col-sm-2" >
													<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="browsePower" id="myradio" value="所有部门">所有部门
				                              	</label>
										    </div> -->
			                          </div>
			                          
			                          
			                          
			                          
			                          <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-4" style="float:left; text-align:right;">
							                  	  	  <button type="button" class="btn btn-info" id="btn_push_notice"  style="background:#fff;">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  发布</span>
							                  	  	  </button>
						                  	  
				                              </div>
				                              <div class="col-sm-4" style="float:left;text-align:center;">
					                            
							                  	  	  <button type="reset" class="btn btn-info"  style="background:#fff;">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  重置</span>
							                  	  	  </button>
						                  	  	
				                              </div>
				                              <div class="col-sm-2" style="float:left;">
					                              <a href="${pageContext.request.contextPath }/notice/selectByParams">
							                  	  	  <button type="button" class="btn btn-info"  style="background:#fff;">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  取消</span>
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
		
		$(window).on('load', function () {
		    $('#browsePower').selectpicker({
		        'selectedText': 'cat'
		    });
		   
		});
	
	  
	   
//--------------发布公告-----------------
  $("#editor").blur(function(){
	    	var content=UE.getEditor('editor').getContent();
	        $("#showResult").text("");
	        if (content == null || content == "") {
	          //  $("#showResult").text("标题不能为空！");
	            valate_form_msg("#editor",'error',"标题不能空");
	             $("#showResult").css("color","red"); 
	            return false;
	       }
	        });
		//创建项目操作
			//校验表单
		function validate_notice_form(){
			var title=$('#title').val();
			var content=UE.getEditor('editor').getContent();
			//document.getElementById("editor").value;
			if(title == "" || title == null){
				valate_form_msg("#title",'error',"标题不能空");
				return false;
			}else{
				valate_form_msg("#title",'success',"");
			}
			if(content == "" || content == null){
				$("#showResult").text("内容不能为空！");
				valate_form_msg("#content",'error',"内容不能空");
				return false;
			}else{
				valate_form_msg("#content",'success',"");
			}
			return true;
		}
		//显示校验信息
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
		//保存操作
		$("#btn_push_notice").click(function(){
			//1、对表单进行校验
		   if(!validate_notice_form()){
				return false;
			} 
			//3、发送请求你保存
			$.ajax({
				url: "${pageContext.request.contextPath }/notice/saveNotice",
				type: "get",
				data: $('#pushNotice form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						alert(result.message);
						to_page(currentPage);
					}else if(result.stateCode==1){
						//即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						alert(result.message);
						location.href='${pageContext.request.contextPath }/notice/selectByParams';
					}
				}
			});
		});
		
		
        
		
	</script>
</body>
</html>