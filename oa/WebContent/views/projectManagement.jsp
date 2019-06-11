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
	<title>项目管理</title>
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
    <link href="/oa/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
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
                         <form class="form-horizontal style-form" action="${ pageContext.request.contextPath }/project/selectByParams" method="get" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;">
                          		<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  增加</span>
		                  	  	  </button> 
		                  	  	  <a href=""></a>
		                  	  	  <button type="button" class="btn btn-danger" id="project_delete_all" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  删除</span>
		                  	  	  </button> 
	                  	  	</div>
	                  	  	
	                  	  	
	                  	  	
	                  	  	<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text" class="form-control round-form" name="dateStart" id="startTime" placeholder="起始时间" style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 24px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  -
										  </span> 
										  
				                  	  	  <input type="text" class="form-control round-form" name="finalTime" id="startTime" placeholder="终止时间" style="width:30%;height:28px;">
	                  	  	</div>
	                  	  	
	                  	  	
	                  	  	
	                  	  	 
						      
	                  	  	  <div class="col-xs-6 col-sm-3" style="float:left;">
                              		<input type="text" class="form-control" style="width:60%;height:28px;float:left;">
                              		
                              		<button type="submit" class="btn btn-round btn-warning" style="height:28px;text-align:center;line-height:28px;">
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
											新建项目
										</h4>
									</div>
									<form class="form-horizontal style-form" action="${pageContext.request.contextPath }/project/pushProject" method="get" >
									<div class="modal-body">
					                          
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">项目名称:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" name="projectName" class="form-control">
						                              </div>
					                          </div>
					                          
									</div>
									<div class="modal-footer">
										
										<button type="submit" class="btn btn-round btn-primary">
											确认
										</button>
										<button type="button" class="btn btn-round btn-default" data-dismiss="modal">取消
										</button>
									</div>
									</form>
								</div><!-- /.modal-content -->
							</div><!-- /.modal -->
                           </div>
                           
                           <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header" style="text-align:center;">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
											&times;
										</button>
										<h4 class="modal-title" id="myModalLabel">
											修改项目
										</h4>
									</div>
									<form class="form-horizontal style-form" action="${pageContext.request.contextPath }/project/updateProject" method="get" >
									<div class="modal-body">
					                          <input type="hidden" name="projectId"  id="update_project_id"/>
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">项目名称:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" name="projectName"  id= "update_project" class="form-control">
						                              </div>
					                          </div>
					                          
									</div>
									<div class="modal-footer">
										
										<button type="submit" class="btn btn-round btn-primary">
											确认
										</button>
										<button type="button" class="btn btn-round btn-default" data-dismiss="modal">取消
										</button>
									</div>
									</form>
								</div><!-- /.modal-content -->
							</div><!-- /.modal -->
                           </div>
                            <!-- 模态框（Modal）结束 -->
                           
                           
                           <!-- 表格部分开始-->
                           <table class="table table-striped table-advance table-hover">
                              <thead>
                              <tr >
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" value="" id="check_all" /></th>
                                  <th style="text-align:center;">ID</th>
                                  <th style="text-align:center;">项目名</th>
                                  <th style="text-align:center;">创建人</th>
                                  <th style="text-align:center;">创建时间</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${pageInfo.list }" var="page">
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox"  class="list-child check_item" value=""  /></td>
                                  <td style="text-align:center;" id="mytd">${page.projectId }</td>
                                  <td style="text-align:center;">${page.projectName }</td>
                                  <td style="text-align:center;">${page.createName }</td>
                                  <td style="text-align:center;"><fmt:formatDate value='${page.createTime }' type='date' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <a href="${pageContext.request.contextPath }/project/findByid/${page.projectId }"></a><button  class="btn btn-primary btn-xs editProject" p-id="${page.projectId }"><i class="fa fa-pencil"></i>编辑</button>
                                      <a href="${pageContext.request.contextPath }/project/deleteProject/${page.projectId }"> <button class="btn btn-danger btn-xs"  ><i class="fa fa-trash-o "></i>删除</button></a>
                               
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
								  	<li><a href="${ pageContext.request.contextPath }/project/selectByParams?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="${ pageContext.request.contextPath }/project/selectByParams?pageNo==${pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="${ pageContext.request.contextPath }/project/selectByParams?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="${ pageContext.request.contextPath }/project/selectByParams?pageNo=${pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="${ pageContext.request.contextPath }/project/selectByParams?pageNo=${pageInfo.pages}">末页</a></li>
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
    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });
      
      //完成全选/全部选
		$("#check_all").click(function(){
			//attr获取checked是undefined
			//一般用attr获取自定义的属性，用prop获取dom原生的属性
			$('.check_item').prop("checked",$(this).prop("checked"));
		});
		$(document).on("click",".check_item",function(){
			var flag=($(".check_item:checked").length == $(".check_item").length);
			$("#check_all").prop("checked",flag);
		});
		
		//批量删除
		$("#project_delete_all").click(function(){
			var projectNames="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				projectNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('p-id') + "-";
			});
			
			//去除最后的那个,
			projectNames=projectNames.substring(0,projectNames.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			if(del_id_strs == ""){
				alert("请选择要删除的公告");
				return false;
			}
			alert(del_id_strs);
			if(confirm("确定删除【"+projectNames+"】吗?")){
				$.ajax({
					url: "${pageContext.request.contextPath }/project/deleteProject/"+del_id_strs,
					type: "post",		
					success:function(result){
						//关闭对话框
						//alert(result.stateCode);
						//回到当前页
						window.location.href="${pageContext.request.contextPath }/project/selectByParams";
					}
				});
			}

		});

		$(".editProject").click(function(){
			//获得项目名
			projectNames = $(this).parents("tr").find("td:eq(2)").text();
			var projectId = $(this).attr("p-id");
			//放到文本框
			$("#update_project").val(projectNames);
			$("#update_project_id").val(projectId);
			//打开模态框
			$("#updateModal").modal({
				backdrop:"static"
			});
		});
		
		
		
  </script>
</body>
</html>