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
	<title>修改个人日程</title>
	<!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
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
					                  	  	 <a href="${pageContext.request.contextPath}/schedule/schedulelist">
					                  	  	  <button type="button" class="btn btn-round btn-default">
									               <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									              	返回上一级</span>
							                  </button>
					                  	  	 </a>
				                  	  	</div>
		                            </div>	
	                            </div>
	                            <form id="add-form" action="${pageContext.request.contextPath}/schedule/updateSchedule/${schedule}" class="form-horizontal style-form" method="post" style="margin-top:80px;">
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:28%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">标题:</span>
				                              <div class="col-sm-6">
				                              	<input type="hidden" name="id" value="${schedule.id }">
				                                  <input type="text" name="title" class="form-control" value="${schedule.title }">
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;">
			                              <span style="width:28%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">描述:</span>
				                              <div class="col-sm-6">
				                                  <textarea id="editor" name="descr" style="height:400px">${schedule.descr}</textarea>
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
	</script>
	<!-- <script>
	 $('#add-but').click(function(){
        //读取用户的输入——表单序列化
        var inputData = $('#add-form').serialize(); 
		$.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/schedule/addSchedule',
            data: inputData,
            success: function(xhr){
                alert("inputData");
                if(xhr.stateCode==1){  //成功
                    window.location.href="${pageContext.request.contextPath}/schedule/schedulelist";
                }else if(xhr.stateCode==0){ //失败
                    alert(xhr.message);
                }
            }
        });
    });
</script> -->
</body>
</html>