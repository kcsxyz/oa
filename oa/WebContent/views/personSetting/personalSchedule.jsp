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
                          
                          <!-- 上部放按钮的地方开始 -->
                          <form class="form-horizontal style-form" method="get" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <button type="button" class="btn btn-info" style="background:#fff;" onclick="window.location.href='/oa/schedule/toAddSchedule'">
			                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  增加</span>
		                  	  	  </button>
		                  	  	  <button type="button" class="btn btn-danger" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  删除</span>
		                  	  	  </button>
	                  	  	</div>
	                  	  	<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text" class="form-control round-form" placeholder="起始时间" style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span  style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 24px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  -
										  </span>
				                  	  	  <input type="text" class="form-control round-form" placeholder="终止时间" style="width:30%;height:28px;">
	                  	  	</div>
	                  	  	  <div class="col-xs-6 col-sm-3" style="float:left;">
                              		<input type="text" class="form-control" style="width:60%;height:28px;float:left;">
                              		
                              		<button type="button" class="btn btn-round btn-warning" style="height:28px;text-align:center;line-height:28px;">
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
                                  <th style="text-align:center;">序号</th>
                                  <th style="text-align:center;">标题</th>
                                  <th style="text-align:center;">内容描述</th>
                                  <th style="text-align:center;">开始时间</th>
                                  <th style="text-align:center;">结束时间</th>
                                  <th style="text-align:center;">创建时间</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                              <c:forEach items="${schedulelist}" var="schedule" varStatus="status">
                              <tbody>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">${ status.index + 1 + (pageInfo.pageNum-1)*10}</td>
                                  <td style="text-align:center;">${schedule.title}</td>
                                  <td style="text-align:center;">${schedule.descr}</td>
                                  <td style="text-align:center;"><fmt:formatDate  pattern="yyyy-MM-dd" value="${schedule.startTime}" type="date"/></td>
                                  <td style="text-align:center;"><fmt:formatDate  pattern="yyyy-MM-dd" value="${schedule.endTime}" type="date"/></td>
                                  <td style="text-align:center;"><fmt:formatDate  pattern="yyyy-MM-dd" value="${schedule.createTime}" type="date"/></td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i>编辑</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                          <!-- 表格部分结束-->
                          <!-- 显示分页条	 -->
					<div class="row">
						<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
						<div class="col-md-6">
							<nav aria-label="Page navigation">
								  <ul class="pagination">
								  	<li><a href="schedulelist?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="schedulelist?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="schedulelist?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="schedulelist?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="schedulelist?pageNo=${pageInfo.pages}">末页</a></li>
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
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>
</body>
</html>