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
	<title>文件管理</title>
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
   <!--  时间插件css文件 -->
    <link href="assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> 

    <script src="assets/js/chart-master/Chart.js"></script>
    <!-- 时间插件js文件 -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
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
                         <form class="form-horizontal style-form" method="get" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  增加</span>
		                  	  	  </button> 	  
		                  	  	  <button type="button" class="btn btn-danger" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  删除</span>
		                  	  	  </button>
	                  	  	</div>
	                  	  	
	                  	  	
	                  	  	
	                  	  	<div class="col-xs-6 col-sm-8" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text" class="form-control round-form" id="startTime" placeholder="起始时间" style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 24px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  -
										  </span> 
										  
				                  	  	  <input type="text" class="form-control round-form" id="startTime" placeholder="终止时间" style="width:30%;height:28px;">
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
                           
                           
                           
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header" style="text-align:center;">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
											&times;
										</button>
										<h4 class="modal-title" id="myModalLabel">
											文件上传
										</h4>
									</div>
									<form class="form-horizontal style-form" method="get" >
									<div class="modal-body">
					                          <!-- <div class="form-group" style="border:none;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">名称:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" name="title" class="form-control">
						                              </div>
					                          </div> -->
					                          
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">选择文件:</span>
						                              <div class=" col-sm-8">
									                    <input id="lefile" type="file" style="display:none">
															<div class="input-append">
																<input id="photoCover" class="input-large" type="text" style="width:62%;height:30px;">
																	<a class="btn" onclick="$('input[id=lefile]').click();">
																		<span class="btn btn-primary">
												                            <i class="glyphicon glyphicon-folder-open"></i>  
												                            Browse… 
												                        </span>
											                        </a>
															</div>
									                    </div>
					                          </div>
					                          
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">文件描述:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" name="title" class="form-control">
						                              </div>
					                          </div>
					                          
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-round btn-default" data-dismiss="modal">取消
										</button>
										<button type="button" class="btn btn-round btn-primary">
											上传
										</button>
									</div>
									</form>
								</div><!-- /.modal-content -->
							</div><!-- /.modal -->
                           </div>
                           
                           
                           
                           <!-- 表格部分开始-->
                           <table class="table table-striped table-advance table-hover">
                              <thead>
                              <tr >
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></th>
                                  <th style="text-align:center;">名称</th>
                                  <th style="text-align:center;">文件名</th>
                                  <th style="text-align:center;">文件类型</th>
                                  <th style="text-align:center;">上传用户</th>
                                  <th style="text-align:center;">关联项目</th>
                                  <th style="text-align:center;">上传时间</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">txt</td>
                                  <td style="text-align:center;">张三</td>
                                  <td style="text-align:center;">oa系统</td>
                                  <td style="text-align:center;">2019/6/3</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">java</td>
                                  <td style="text-align:center;">张三</td>
                                  <td style="text-align:center;">oa系统</td>
                                  <td style="text-align:center;">2019/6/3</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">png</td>
                                  <td style="text-align:center;">张三</td>
                                  <td style="text-align:center;">oa系统</td>
                                  <td style="text-align:center;">2019/6/3</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">txt</td>
                                  <td style="text-align:center;">张三</td>
                                  <td style="text-align:center;">oa系统</td>
                                  <td style="text-align:center;">2019/6/3</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child" value=""  /></td>
                                  <td style="text-align:center;">1</td>
                                  <td style="text-align:center;">XXX</td>
                                  <td style="text-align:center;">txt</td>
                                  <td style="text-align:center;">张三</td>
                                  <td style="text-align:center;">oa系统</td>
                                  <td style="text-align:center;">2019/6/3</td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                          <!-- 表格部分结束-->
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
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
    <!-- 文件上传的js -->
    <script type="text/javascript">
		$('input[id=lefile]').change(function() {
		$('#photoCover').val($(this).val());
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