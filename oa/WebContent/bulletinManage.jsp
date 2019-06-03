<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>公告管理</title>
	<!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link rel="stylesheet" type="text/css" href="css/address.css">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
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
                          <table class="table table-striped table-advance table-hover">
                          	<div style="margin-left:50px;margin-top:20px;margin-bottom:80px;">
                          	<div class="" style="width:167px;height:40px;float:left;">
		                  	  	  <button type="button" class="btn btn-info" style="background:#fff;">
		                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
		                  	  	  增加</span></button>
		                  	  	  <button type="button" class="btn btn-danger" style="background:#fff;">
		                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
		                  	  	  删除</span>
		                  	  	  </button>
	                  	  	</div>
	                  	  	<div class="" style="width:300px;height:40px;float:left;margin-left:40px;">
		                  	  	  <input type="text" class="form-control round-form" style="width:120px;float:left;">
		                  	  	  <span class="glyphicon glyphicon-resize-horizontal" style="color: rgb(0, 0, 0);float:left;height:35px;text-align:center;line-height:35px;
		                  	  	  font-size: 20px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
								  </span> 
								  
		                  	  	  <input type="text" class="form-control round-form" style="width:120px;">
	                  	  	</div>
	                  	  	<div class="" style="width:150px;height:40px;float:left;margin-left:40px;">
		                  	  	  <lable style="font-weight:bold;font-size:15px; margin-right:5px;">类型</lable>
		                  	  	  <button type="button" class="btn dropdown-toggle open" id="dropdownMenu1" data-toggle="dropdown">通知
										        <span class="caret"></span>
										    </button>
										    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
										        <li role="presentation">
										            <a role="menuitem" tabindex="-1" href="#">任务</a>
										        </li>
										        <li role="presentation">
										            <a role="menuitem" tabindex="-1" href="#">公告</a>
										        </li>
										    </ul>
		                  	  	  <!-- <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							      	Dropdown
							      	<span class="caret"></span>
						      </button> -->
						      </div>
	                  	  	  <div class="" style="width:100px;height:40px;float:left;margin-left:40px;">
                              		<button type="button" class="btn btn-info" style="background:#fff">
                              		<span class="glyphicon glyphicon-search" style="color: rgb(234, 146, 75); font-size: 15px;
                              		 text-shadow: rgb(255, 0, 0) 0px 0px 0px;">搜索</span>
                              		</button>	
                              </div>
                              	</div>	
                              <thead>
                              <tr >
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></th>
                                  <th style="text-align:center;">ID</th>
                                  <th style="text-align:center;">标题</th>
                                  <th style="text-align:center;">类型</th>
                                  <th style="text-align:center;">创建时间</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">通知</td>
                                  <td style="text-align:center;">2019/5/30</td>
                                  <td style="text-align:center;">
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i>编辑</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">通知</td>
                                  <td style="text-align:center;">2019/5/30</td>
                                  <td style="text-align:center;">
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i>编辑</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">通知</td>
                                  <td style="text-align:center;">2019/5/30</td>
                                  <td style="text-align:center;">
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i>编辑</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                          <!-- 显示分页条	 -->
					<div class="row">
						<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
						<div class="col-md-6">
							<nav aria-label="Page navigation">
								  <ul class="pagination">
								  	<li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="${APP_PATH}/emps?pn=${pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="${APP_PATH}/emps?pn=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="${APP_PATH}/emps?pn=${pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
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
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
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