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
            <%@include file="nav.jsp" %>
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
	                            <form class="form-horizontal style-form" method="post" action="${pageContext.request.contextPath }/notice/saveNotice" style="margin-top:80px;">
	                            
	                            
	                            
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">标题:</span>
				                              <div class="col-sm-6">
				                                  <input type="text" id="title" name="title" class="form-control"><font id="showResult"  style="color:red;width:10%;" ></font>
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
				                                   <textarea  name="content" id="editor" style="height:300px" rows="8"></textarea><font id="showResult"  style="color:red;width:10%;" ></font>
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
							                  	  	  <button type="submit" class="btn btn-info" id="fabu"  style="background:#fff;">
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
		/* $("#fabu").click(function(){
			// alert($("#browsePower").val());
			alert("发布成功");
		}); */
		
	    $("#title").blur(function(){
	        var data = $("#title").val();
	        $("#showResult").text("");
	        if (data == null || data == "") {
	            $("#showResult").text("标题不能为空！");
	            /* $("#showResult").css("color","red"); */
	            return false;
	        }
	    
	        $.ajax({
	            /* type:"POST",
	            url:"eckUsername.html",
	            data:"username="+data,
	            beforeSend:function(XMLHttpRequest)
	            {
	                $("#showResult").text("正在查询");

	            }, */
	            success:function(msg)
	            {
	                /* if(msg ==="yes"){
	                    $("#showResult").text("该用户名可以被使用");
	                }else if(msg === 'no'){
	                    $("#showResult").text("该用户名不存在");
	                    $("#showResult").css("color","red");
	                }else {
	                    $("#showResult").text("系统异常！");
	                    $("#showResult").css("color","red");
	                } */
	            },
	            error:function()
	            {
	                //错误处理
	            }
	        });
	    });
		$("#editor").blur(function(){ 
	        var content = UE.getEditor('editor').getContent();
	        $("#showResult").text("");
			alert("content");
            alert("UE.getEditor('editor').hasContents()");
        if (UE.getEditor('editor').hasContents()==false) {
            $("#showResult").text("内容不能为空！");
            /* $("#showResult").css("color","red"); */
            return false;
        }
        
		 });
        
		
	</script>
</body>
</html>