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
	<title>修改信息</title>
	<!-- Bootstrap core CSS -->
    <link href="/oa/assets/css/bootstrap.css" rel="stylesheet"/>
    <!--external css-->
    <link href="/oa/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/css/zabuto_calendar.css"/>
    <link rel="stylesheet" type="text/css" href="/oa/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/lineicons/style.css"/>    
    
   
    <!-- Custom styles for this template -->
    <link href="/oa/assets/css/style.css" rel="stylesheet"/>
    <link href="/oa/assets/css/style-responsive.css" rel="stylesheet"/>
    <link href="/oa/assets/css/bootstrap-select.min.css" rel="stylesheet">
     <link href="/oa/assets/css/bootstrapValidator.css" rel="stylesheet">
    
    <script  src="/oa/assets/jquery-2.1.0.min.js"></script>
    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    <script src="/oa/assets/js/bootstrap-select.min.js"></script>
    <script src="/oa/assets/js/bootstrapValidator.js"></script>
    <!-- js placed at the end of the document so the pages load faster --> 
 	
    <script class="include" type="text/javascript" src="/oa/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/oa/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/oa/assets/js/jquery.nicescroll.js" type="text/javascript"></script>

    <!--common script for all pages-->
    <script src="/oa/assets/js/common-scripts.js"></script>
      <!-- 富文本编辑器 -->
 	<script src="/oa/ueditor/ueditor.config.js"></script>
 	<script src="/oa/ueditor/ueditor.parse.js"></script>
 	<script src="/oa/ueditor/ueditor.all.js"></script>
 	<script type="text/javascript">
 		window.onload=function(){
 			UE.getEditor('editor');
 			UE.getEditor('editor').getContentTxt();
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
				  		                   <div class="panel-title" style="margin-left:10px;padding-bottom:5px;"><b>信息更新--信息管理--修改信息</b></div>
				                  	</div>
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
	                            <form class="form-horizontal style-form" method="post" id="form-test"  action="${pageContext.request.contextPath }/notice/updateNotice" onSubmit="return myCheck(this)" style="margin-top:80px;">
			                           <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">标题:</span>
				                              <div class="col-sm-6">
				                                  <input type="text" name="title" id="title" class="form-control"  value="${noticeFindById.title }" >
				                                   <font id="showResult1"  style="color:red;width:10%;" ></font>
				                              </div>
			                          </div>
				                             
			                          
			                         <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">类型:</span>
				                             
				                                <c:if test="${noticeFindById.type==0}">
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
				                              	</c:if>
				                              
				                               <c:if test="${noticeFindById.type==1}">
				                                      <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios3" value="0" >通知
				                              	</label>
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios4" checked="checked" value="1">公告
				                              	</label>	
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="type" id="optionsRadios4"  value="2">任务
				                              	</label>
				                              </div>
				                              	</c:if>	
				                             
				                               <c:if test="${noticeFindById.type==2}">
						                             <div class="col-sm-2" style="margin-top:7px;text-align:center;">
						                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
						                                   <input type="radio" name="type" id="optionsRadios3" value="0" >通知
						                              	</label>
						                              </div>
						                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
						                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
						                                   <input type="radio" name="type" id="optionsRadios4"  value="1">公告
						                              	</label>	
						                              </div>
						                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
						                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
						                                   <input type="radio" name="type" id="optionsRadios4" checked="checked" value="2">任务
						                              	</label>
						                              </div>
				                              	</c:if>
				                              
			                          </div>
			                          
			                          <input type="hidden" name="noticeId" value="${noticeFindById.noticeId }">
			                          <%-- <div class="form-group" style="border:none;">
			                              <label class="col-sm-3 col-sm-3 control-label" style="color: rgb(0, 0, 0);text-align:right;font-size: 18px;">内容:</label>
				                              <div class="col-sm-6">
				                                  <textarea class="form-control" name="content" id="scontent"  rows="8">${noticeFindById.content }</textarea>
				                                            <div id="editor" style="height:400px"></div>
				                              </div>
				                                <span id="s_error_content_info" style="color:red;"></span>
			                          </div> --%>
			                           <div class="form-group" style="border:none;">
			                              <span style="width:15%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">内容:</span>
				                              <div class="col-sm-9">
				                                  <textarea  name="content" id="editor" style="height:300px" rows="8">${noticeFindById.content }</textarea>
				                                   <font id="showResult2"  style="color:red;width:10%;" ></font>
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
				                              
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-4" style="float:left; text-align:right;">
					                               <a href="./saveNotice"></a> 
							                  	  	 <button type="submit" id="s_submit"  class="btn btn-round btn-default" onclick="checkUpdate();" >
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  修改</span>
							                  	  	  </button>
						                  	  	  
						                  	  	  
				                              </div>
				                              <div class="col-sm-3" style="float:left;text-align:center;">
					                              <a href="bulletinManage.jsp"></a>
							                  	  	  <button type="reset" class="btn btn-round btn-default">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  重置</span>
							                  	  	  </button>
						                  	  	  
				                              </div>
				                              <div class="col-sm-2" style="float:left;">
					                              <a href="bulletinManage.jsp">
							                  	  	  <button type="button" class="btn btn-round btn-default">
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
		$(function clasp(){
			var items = new Array();
			items = $("#ventilationParameters option:selected");
		    //此处取到了每个item，items[i].text则取到的是option中的文字，下面取到的是value属性
			for(var i = 0;i<items.length;i++){
				itemTitle = items[i].value;
				console.log(itemTitle);
			}
		});
		

		
		$(window).on('load', function () {
		    $('#browsePower').selectpicker({
		        'selectedText': 'cat'
		    });
		   
		});
		$("#fabu").click(function(){
			 alert($("#browsePower").val());
		})
	
	  function myCheck(form){
		var content=UE.getEditor('editor').getContent();
		  if(form.title.value==''|| form.title.value==null){
			  $("#showResult1").text("标题不能为空!");
		  form.title.focus();
		  return false;
		  }
		  if(content==''|| content==null){
			  $("#showResult2").text("内容不能为空!");
			  form.content.focus();
			  return false;
			  }
		 else{
			  alert("修改成功");
			  return true;
		  }
	  }
	  

	</script>
</body>
</html>