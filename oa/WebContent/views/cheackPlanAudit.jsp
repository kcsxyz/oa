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
	<title>审核工作计划</title>
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
                      			<div class="panel panel-default" style="border:none;margin-top:20px;height:70px;">
		    						<div class="panel-body" style="border:none;height:80px;">
			                          	<div class="col-xs-6 col-sm-3" style="border:none;float:left;">
					                  	  	 <a href="${pageContext.request.contextPath }/workplanAudit/selectInfo">
					                  	  	  <button type="button" class="btn btn-round btn-default">
							                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
							                  	  	  返回上一级</span>
					                  	  	  </button>
					                  	  	 </a>
				                  	  	</div>
		                            </div>	
	                            </div>
	                            <form class="form-horizontal style-form" method="get" style="margin-top:80px;">
	                            	<div class="form-group" style="border:none;margin-top:30px;">
			                             <span style="width:30%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">计划内容:</span>
				                              <div class="col-sm-6">
				                                  <textarea class="form-control" name="content" overflow-y="scroll" rows="6" readonly>${planAuditById.content }</textarea>
				                              </div>
			                        </div>
			                        <div class="form-group" style="border:none;margin-top:30px;">
			                             <span style="width:30%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">类型:</span>
				                          <div class="col-sm-7" style="margin-top:7px;text-align:center;"> 
				                          	<c:if test="${planAuditById.type==0 }">
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   日计划
				                              	</label>
				                              </div>
				                            </c:if>
				                            <c:if test="${planAuditById.type==1 }">
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   周计划
				                              	</label>	
				                              </div>
				                           </c:if>
				                           <c:if test="${planAuditById.type==2 }">
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                  月计划
				                              	</label>
				                              </div>
				                           </c:if>
				                           <c:if test="${planAuditById.type==3 }">
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   年计划
				                              	</label>
				                              </div>
				                           </c:if>
				                           </div>
			                         </div>
			                         <div class="form-group" style="border:none;margin-top:30px;">
			                        <input type="hidden" id="status" name="status" value="1">
			                        <input type="hidden" id="status1" name="status" value="2">
			                              <span style="width:30%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">状态:</span>
				                              <div class="col-sm-6">
												<c:if test="${planAuditById.status==0 }">
			                                  	<button type="button" class="btn btn-warning btn-xs" >待审核</button>
			                                  	</c:if>
			                                  	<c:if test="${planAuditById.status==1 }">
			                                  	<button type="button" class="btn btn-success btn-xs" >通过</button>
			                                  	</c:if>
												<c:if test="${planAuditById.status==2 }">
												<button type="button" class="btn btn-danger btn-xs" >驳回</button>
												</c:if>				                              
					                  	  	  </div>
			                        </div>
			                         <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:30%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">审核意见:</span>
				                              <div class="col-sm-6">
				                                  <textarea class="form-control" id="opinion" overflow-y="scroll" rows="6"></textarea>
				                              </div>
			                         </div>
			                         <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-5" style="float:left; text-align:right;">
							                  	  	  <button type="button" onclick="agree()"  value="1" class="btn btn-round btn-success">&nbsp;&nbsp;通过&nbsp;&nbsp;</button>
				                              </div>
				                              <div class="col-sm-5" style="float:left;text-align:center;">
							                  	  	  <button type="button" onclick="disagree()"   class="btn btn-round btn-danger">&nbsp;&nbsp;驳回&nbsp;&nbsp;</button>
						                  	  	 
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
    function agree() {
    	  var status = document.getElementById("status").value; //取得文本框的值
    	  var opinion = document.getElementById('opinion').value;
    	  // alert("");//网页提示框
    	  var myurl = "${pageContext.request.contextPath }/workplanAudit/updateWorkPlanStatus" + "?" + "id=" + ${planAuditById.id }+ "&status=" + status+"&opinion=" + opinion;
    	  window.location.assign(encodeURI(myurl))
    	  }
    function disagree() {
  	  var status = document.getElementById("status1").value; //取得文本框的值
  	 // var opinion = document.getElementById("opinion").text(); //取得文本框的值
  	  var opinion = document.getElementById('opinion').value;
  	  var myurl = "${pageContext.request.contextPath }/workplanAudit/updateWorkPlanStatus" + "?"  + "id=" + ${planAuditById.id }+ "&status=" + status+"&opinion=" + opinion;
  	  window.location.assign(encodeURI(myurl))
  	  }
    </script>
	
</body>
</html>