<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>个人日程</title>
	<!-- Bootstrap core CSS -->
   <link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/oa/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="/oa/assets/css/style.css" rel="stylesheet">
    <link href="/oa/assets/css/style-responsive.css" rel="stylesheet">
    <link href="/oa/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> 

   
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
	          		<div class="col-md-12">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
                      		 <div class="panel">
						  		<div class="panel-title" style="margin-left:10px;padding-bottom:5px;font-size:15px;"><b>个人办公--工作日程添加</b></div>
							</div>
                      			<div class="panel panel-default" style="border:none;margin-top:0px;height:60px;">
		    						<div class="panel-body" style="border:none;height:70px;">
			                          	<div class="col-xs-6 col-sm-3" style="border:none;float:left;">
					                  	  	 <a href="${pageContext.request.contextPath}/schedule/schedulelist">
					                  	  	  <button type="button" class="btn btn-round btn-default">
									               <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									              	返回上一级</span>
							                  </button>
					                  	  	 </a>
				                  	  	</div>
		                            </div>	
	                            </div>
	                            <form id="add-form" action="${pageContext.request.contextPath}/schedule/addSchedule" class="form-horizontal style-form" method="post" style="margin-top:5px;">
			                          <div class="form-group" style="border:none;margin-top:5px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">标题:</span>
				                              <div class="col-sm-6">
				                                  <input type="text" id="title" name="title" class="form-control" style="width:800px;"><font id="showResult1"></font>
				                              </div>
			                          </div>
			                          <div class="col-xs-6 col-sm-6" style="float:left;margin-left:9%;">
		                  	  	  <span style="font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;color:#000;font-size:15px;float:left;">日程时间：</span>
				                  	  	  <input type="text" name="startTime" id="startTime" class="form-control round-form" placeholder="起始时间" style="width:30%;height:28px;color:#000;font-size:15px;float:left;">
				                  	  	 
				                  	  	  <span  style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 24px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  -
										  </span>
				                  	  	  <input type="text" name="endTime" id="startTime" class="form-control round-form" placeholder="终止时间" style="width:30%;height:28px;color:#000;font-size:15px;float:left;">
	                  	  			</div>
			                          <div class="form-group" style="border:none;margin-top:60px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">描述:</span>
				                              <div class="col-sm-6">
				                                  <textarea id="editor" name="descr" style="height:300px;width:800px;"></textarea><font id="showResult2"></font>
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-5" style="float:left; text-align:right;margin-left:10px;">
					                              
							                  	  	  <button type="submit" id="add-but" class="btn btn-round btn-default" >
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;完成&nbsp;&nbsp;&nbsp;&nbsp;</span>
							                  	  	  </button>
						                  	  	  
				                              </div>
				                              <div class="col-sm-4" style="float:left;text-align:center;">
					                              <a href="${pageContext.request.contextPath}/schedule/schedulelist">
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
 	 <script src="/oa/assets/jquery-2.1.0.min.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
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
	</script>
	<script>
	$("#title").blur(function(){
        var data = $("#title").val();
        if (data == null || data == "") {
            $("#showResult1").text("标题不能为空！");
            $("#showResult1").css("color","red");
            return false;
        }else{
    	$("#showResult1").text("");
        }
	 });
	
	 
</script>
<script>
$("#editor").blur(function(){
    var data = $("#editor").val();
    alert(data);
    if (data == null || data == "") {
        $("#showResult2").text("内容不能为空！");
        $("#showResult2").css("color","red");
        return false;
    }else{
    	$("#showResult2").text("");
        }
 });
</script>
 <!--  时间插件js -->
	    <script type="text/javascript">
	    	$("input[id='startTime']").datetimepicker({
	    		todayBtn:1,
	    		todayHighlight:1,
	            format: 'yyyy-mm-dd',
	            minView: "2",//
	            language:  'zh-CN',
	            autoclose:true //选择一个日期之后是否立即关闭此日期选择器
	        });
	    </script>
</body>
</html>