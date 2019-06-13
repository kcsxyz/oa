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
	<title>通讯录添加</title>
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
</head>
<body>
 <section id="container" >
            <%@include file="/nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          <div class="row mt">
                  <div class="col-md-12"style="margin-top:10px;">
                  	<div style="background:#fff; height:900px;">
                      <div class="content-panel"style="box-shadow:0px 3px 2px #fff">
                          
                          <!-- 上部放按钮的地方开始 -->
                          <form class="form-horizontal style-form" method="get" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;">
	                  	  	</div>
	                  	  	<div class=" col-sm-4" style="float:left;">
		                  	  	  <span style="width:35%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">部门:</span>
		                  	  	  	<div class="col-sm-7">
		                  	  	  	<select class="form-control">
		                  	  	  		<option>请选择部门</option>
										<option>办公室</option>
										<option>开发部</option>
									</select>  
									</div>
						    </div>						    
						    <div class=" col-sm-3" style="float:left;">
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
                              	  <th style="text-align:center;">序号</th>
                                  <th style="text-align:center;">员工编号</th>
                                  <th style="text-align:center;">姓名</th>
                                  <th style="text-align:center;">性别</th>
                                  <th style="text-align:center;">部门</th>
                                  <th style="text-align:center;">职称</th>
                                  <th style="text-align:center;">联系方式</th>
                                  <th style="text-align:center;">邮箱</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                              <c:forEach items="${userlist}" var="user" varStatus="status">
                              <tbody>
                              <tr>                                  
                                  <td style="text-align:center;">${ status.index + 1 + (pageInfo.pageNum-1)*10}</td>
                                  <td style="text-align:center;">${user.uid}</td>
                                  <td style="text-align:center;">${user.name }</td>
                                  <c:if test="${user.sex==0 }">
                                  <td style="text-align:center;">女</td>
                                  </c:if>
                                  <c:if test="${user.sex==1 }">
                                  <td style="text-align:center;">男</td>
                                  </c:if>
                                  <td style="text-align:center;">${user.dept.deptName }</td>
                                  <td style="text-align:center;">${user.role.roleName }</td>
                                  <td style="text-align:center;">${user.phone }</td>
                                  <td style="text-align:center;">${user.email }</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                  		  <button class="btn btn-primary btn-xs"onclick="window.location.href='/oa/personTel/"><i class="fa fa-pencil"></i>添加</button>
                                      
                                  </td>
                              </tr>
                              </tbody>
                              </c:forEach>
                          </table>
                          <!-- 表格部分结束-->
                          <!-- 显示分页条	 -->
					<div class="row">
						<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
						<div class="col-md-6">
							<nav aria-label="Page navigation">
								  <ul class="pagination">
								  	<li><a href="getPersonTel?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="getPersonTel?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="getPersonTel?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="getPersonTel?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="getPersonTel?pageNo=${pageInfo.pages}">末页</a></li>
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
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


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