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
	<title>计划审核</title>
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
        <!--  时间插件css -->
    <link href="/oa/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    
      <!-- 时间插件js -->
    <script src="/oa/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
 <section id="container" >
            <%@include file="nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          <div class="row mt">
                  <div class="col-md-12"style="margin-top:10px;">
                  	<div style="background:#fff; height:900px;">
                      <div class="content-panel"style="box-shadow:0px 3px 2px #fff">
                          
                          <!-- 上部放按钮的地方开始 -->
                          <form class="form-horizontal style-form" action="${pageContext.request.contextPath }/workplanAudit/selectInfo" method="get" style="margin-top:10px;text-align:center;">
			                 
			                 
			                 <div class="form-group" style="border:none;margin-top:10px;margin-left:50px;">
                          		<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:5px;height:28px;text-align:center;line-height:28px;">类型:</span>
		                  	  	  	<div class="col-sm-7">
		                  	  	  	<select class="form-control" name="type" style="height:31px;">
													<option></option>
													<option value="0">日计划</option>
													<option value="1">周计划</option>
												    <option value="2">月计划</option>
													<option value="3">年计划</option>
									</select>  
									</div>
						    	</div>
						    	
						    	<div class="col-xs-6 col-sm-3" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:5px;height:28px;text-align:center;line-height:28px;">状态:</span>
		                  	  	  	<div class="col-sm-7">
		                  	  	  	<select class="form-control" name="status" style="height:31px;">
													<option></option>
													<option value="0">待审核</option>
													<option value="1">通过</option>
													<option value="2">驳回</option>
									</select>  
									</div>
						    	</div>
						    	
                          	</div>
			                 
			                 
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;margin-left:50px;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text"  name="dateStart" 	 class="form-control round-form" id="startTime" placeholder="起始时间" style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span  style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 26px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  －
										  </span> 
										  
										  
				                  	  	<input type="text"  name="finalTime"   class="form-control round-form" id="startTime" placeholder="终止时间" style="width:30%;height:28px;">
	                  	  	</div>
	                  	  	
	                  	  	  <div class="col-xs-6 col-sm-3" style="float:left;">
                              		<input type="text" name="Info" class="form-control" style="width:60%;height:28px;float:left;">
                              		
                              		<button type="submit" class="btn btn-round btn-warning" style="height:28px;text-align:center;line-height:28px;">
                              		<span class="glyphicon glyphicon-search" style="color: rgb(255,255,255); font-size: 12px;
                              		 text-shadow: rgb(255,255,255) 0px 0px 0px; ">&nbsp;搜索</span>
                              		</button>
                              			
                              </div>
                              </div>
                            </form>
                           <!-- 上部放按钮的地方结束-->
                           <!-- 表格部分开始-->
                           <table class="table table-striped table-advance table-hover">
                              <thead>
                              <tr >
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></th>
                              	  <th style="text-align:center;">索引</th>
                                  <th style="text-align:center;">类型</th>
                                  <th style="text-align:center;">工作内容</th>
                                  <th style="text-align:center;">提交人</th>
                                  <th style="text-align:center;">提交时间</th>
                                  <th style="text-align:center;">审核人</th>
                                  <th style="text-align:center;">状态</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${planAudit }" var="p">
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">${p.id }</td>
                                  <td style="text-align:center;">
                                      <c:if test="${p.type==0 }">日计划</c:if>
                                      <c:if test="${p.type==1 }">周计划</c:if>
                                      <c:if test="${p.type==2 }">月计划</c:if>
                                      <c:if test="${p.type==3 }">年计划</c:if>
                                  </td>
                                  <td style="text-align:center;">${p.content }</td>
                                  <td style="text-align:center;">${p.createName }</td>
                                  <td style="text-align:center;"><fmt:formatDate value='${p.createTime }' type='date' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                                  <td style="text-align:center;"> ${p.checkedName } </td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                    <c:if test="${p.status==1 }">
                                  	<button type="button" class="btn btn-success btn-xs" >通过</button>
                                  	</c:if>
                                  	<c:if test="${p.status==0 }">
                                  	<a href="${pageContext.request.contextPath }/workplanAudit/findById/${p.id}"><button type="button" class="btn btn-warning btn-xs" >待审核</button></a>
                                  	</c:if>
									<c:if test="${p.status==2 }">
									<button type="button" class="btn btn-danger btn-xs" >驳回</button>
									</c:if>
                                  </td>
                              </tr>
                             </c:forEach>
                              </tbody>
                          </table>
                          <!-- 表格部分结束-->
                          <!-- 显示分页条	 -->
                                   <!-- 显示分页条	 -->
					<div class="row">
						<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
						<div class="col-md-6">
							<nav aria-label="Page navigation">
								  <ul class="pagination">
								  	<li><a href="${ pageContext.request.contextPath }/workplanAudit/selectInfo?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="${ pageContext.request.contextPath }/workplanAudit/selectInfo?pageNo=${pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="${ pageContext.request.contextPath }/workplanAudit/selectInfo?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="${ pageContext.request.contextPath }/workplanAudit/selectInfo?pageNo=${pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="${ pageContext.request.contextPath }/workplanAudit/selectInfo?pageNo=${pageInfo.pages}">末页</a></li>
								  </ul>
							</nav>
						</div>
					</div>
                      </div><!-- /content-panel -->
                      </div>
                  </div><!-- /col-md-12 -->                     
              </div><!-- /row -->
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
      //custom select box
$("input[id='startTime']").datetimepicker({
    		todayBtn:1,
    		todayHighlight:1,
            format: 'yyyy-mm-dd',
            minView: "2",//
            language:  'zh-CN',
            autoclose:true //选择一个日期之后是否立即关闭此日期选择器
           
        });
      $(function(){
          $('select.styled').customSelect();
      });

  </script>
</body>
</html>