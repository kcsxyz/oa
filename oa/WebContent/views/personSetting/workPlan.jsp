<%@page import="com.oa.bean.User"%>
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
	<title>工作计划</title>
	<!-- Bootstrap core CSS -->
    <link href="oa/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    
    <link href="/oa/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/oa/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="oa/assets/css/style.css" rel="stylesheet">
    <link href="oa/assets/css/style-responsive.css" rel="stylesheet">
	<!--  时间插件css文件 -->
    <link href="/oa/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> 

    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    <!-- 时间插件js文件 -->
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
		$(function(){
			$(".del").click(function(){
				var href = $(this).attr("href");
				$("#form").attr("action", href).submit();
				return false;
			});
		});
	</script>
</head>
<%
	User user=(User)session.getAttribute("user");	
%>
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
                         <form action="selectLikeWorkPlan" class="form-horizontal style-form" method="get" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
	                          	<div class=" col-sm-5" style="float:left;">
	                          		
			                  	  	  <button type="button" class="btn btn-info" style="background:#fff;" onclick="window.location.href='/oa/workPlan/addWorkPlan'">
				                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
				                  	  	  增加</span>
			                  	  	  </button>
			                  	  	  <button type="button" class="btn btn-danger" style="background:#fff;" id="workPlan_delete_all">
				                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
				                  	  	  删除</span>
			                  	  	  </button>
		                  	  	</div>
	                  	  	 
	                  	  	<div class=" col-sm-4" style="float:left;">
		                  	  	  <lable style="font-weight:bold;font-size:12px;"><div class="col-sm-3" style="margin-top:8px;">类型</div></lable>
		                  	  	  	<div class="col-sm-6">
		                  	  	  	<select class="form-control" id="planType" onchange = "planTypeChange()">
		                  	  	  					<option>全部</option>
													<option value="0">日计划</option>
													<option value="1">周计划</option>
													<option value="2">月计划</option>
													<option value="3">年计划</option>
									</select>  
									</div>
						    </div>
						    </div> 
						    
						    <div class="form-group" style="border:none;">
	                  	  	<div class=" col-sm-4" style="float:left;margin-left:8%;">
		                  	  	 <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text" class="form-control round-form" id="startTime" name="startTime" placeholder="起始时间"  style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span class="glyphicon glyphicon-resize-horizontal" style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 15px; margin-left:3px;margin-right:7px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  </span> 
										  
				                  	  	  <input type="text" class="form-control round-form" id="startTime" name="endTime" placeholder="终止时间"  style="width:30%;height:28px;">
	                  	  	</div>
	                  	  	 
						    <div class=" col-sm-4" style="float:left;">
		                  	  	  <lable style="font-weight:bold;font-size:12px;"><div class="col-sm-3" style="float:left;margin-top:8px;">状态</div></lable>
		                  	  	  	<div class="col-sm-6"style="float:left;">
		                  	  	  	<select class="form-control" id="planStatus" onchange = "planStatusChange()">
													<option>全部</option>
													<option value="0">待审核</option>
													<option value="1">已审核</option>
													<option value="2">驳回</option>
									</select>  
									</div>
						    </div> 
						      
	                  	  	  <div class=" col-sm-3" style="float:left;">
                              		<input type="text" name="Info" class="form-control" style="width:55%;height:28px;float:left;">
                              		
                              		<button type="submit" class="btn btn-round btn-warning" style="height:28px;text-align:center;line-height:28px;"
                              			>
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
                              
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" id="check_all" value=""  /></th>
                                  <th style="text-align:center;">序号</th>
                                  <th style="text-align:center;">类型</th>
                                  <th style="text-align:center;">内容</th>
                                  <th style="text-align:center;">审批员</th>
                                  <th style="text-align:center;">审批意见</th>
                                  <th style="text-align:center;">创建人</th>
                                  <th style="text-align:center;">创建时间</th>                                  
                                  <th style="text-align:center;" >状态</th>
                                  <th style="text-align:center;">操作</th>
                              </tr>
                              </thead>
                               <c:forEach items="${workPlanlist }" var="workPlan" varStatus="status">
                              <tbody>                              
                              <tr>   
                              	<c:if test="${sessionScope.user.uid == workPlan.user.uid }">                          
                                  	<td style="text-align:center;"><input type="checkbox" class="list-child check_item" value=""  /></td>
                                  </c:if>
                                  <c:if test="${sessionScope.user.uid != workPlan.user.uid }">                          
                                  	<td style="text-align:center;"></td>
                                  </c:if>
                                  <input type="hidden" name="id" value="${workPlan.id }">
                                  <td style="text-align:center;">${ status.index + 1 + (pageInfo.pageNum-1)*10}</td>
                                  <c:if test="${workPlan.type==0 }">
                                 	 <td style="text-align:center;">日计划</td>
                                  </c:if>
                                  <c:if test="${workPlan.type==1 }">
                                 	 <td style="text-align:center;">周计划</td>
                                  </c:if>
                                  <c:if test="${workPlan.type==2 }">
                                 	 <td style="text-align:center;">月计划</td>
                                  </c:if>
                                  <c:if test="${workPlan.type==3 }">
                                 	 <td style="text-align:center;">年计划</td>
                                  </c:if>
                                  <td style="text-align:center;width:30%;text-overflow:ellipsis">${workPlan.content }</td>
                                  
                                  <th style="text-align:center;">${workPlan.checkedName }</th>
                                  <th style="text-align:center;">${workPlan.opinion }</th>
                                  <td style="text-align:center;">${workPlan.user.name }</td>
                                  <td style="text-align:center;"><fmt:formatDate  pattern="yyyy-MM-dd" value="${workPlan.createTime }" type="date"/></td>
                                  <td style="text-align:center;">
                                  	<c:if test="${workPlan.status==1 }">
                                  	<button type="button" class="btn btn-success btn-xs" >通过</button>
                                  	</c:if>
                                  	<c:if test="${workPlan.status==0 }">
                                  	<button type="button" class="btn btn-warning btn-xs" >待审核</button>
                                  	</c:if>
									<c:if test="${workPlan.status==2 }">
									<button type="button" class="btn btn-danger btn-xs" >驳回</button>
									</c:if>
                                  </td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->  
                                  <c:if test="${sessionScope.user.uid !=workPlan.user.uid && workPlan.status==0}"> 
                                  		<button class="btn btn-primary btn-xs" edit-id="${workPlan.id}" onclick="window.location.href='/oa/workPlan/toCheckedWorkPlan/${workPlan.id }'"><i class="fa fa-pencil"></i>审核</button>                               	
                                  </c:if>
                                  <c:if test="${sessionScope.user.uid==workPlan.user.uid && workPlan.status!=1}">
                                      <button class="btn btn-primary btn-xs" edit-id="${workPlan.id}" onclick="window.location.href='/oa/workPlan/updateWorkPlan/${workPlan.id }'"><i class="fa fa-pencil"></i>编辑</button>
                                     <button class="btn btn-danger btn-xs" onclick="window.location.href='/oa/workPlan/deleteWorkPlan/${workPlan.id }'"><i class="fa fa-trash-o "></i>删除</button>
                                 </c:if>
                                  </td>
                              </tr>                                                        
                              </tbody>
                              </c:forEach>
                          </table>
                           <form action="" method="post" id="form">
					    	<!-- post请求转换为DELETE或者PUT -->
					    	<input type="hidden" name="_method" value="DELETE">
					    </form>
                          <!-- 表格部分结束-->
                          <!-- 显示分页条	 -->
					<div class="row">
						<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
						<div class="col-md-6">
							<nav aria-label="Page navigation">
								  <ul class="pagination">
								  	<li><a href="workPlanlist?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="workPlanlist?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="workPlanlist?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="workPlanlist?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="workPlanlist?pageNo=${pageInfo.pages}">末页</a></li>
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
    <script src="oa/assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script>
    function planTypeChange(){
    	var type = $("select option:selected").val();
    	window.location.href="/oa/workPlan/getWorkPlanByType?type="+type;
    }
    function planStatusChange(){
    	var status = $("#planStatus").val();
    	window.location.href="/oa/workPlan/getWorkPlanByStatus?status="+status;
    }
    function displaycolor(value,row,index) {  
        var a = "";  
            if(value == "已完成") {  
                var a = '<span style="color:#00ff00">'+value+'</span>';  
            }else if(value == "已分派"){  
                var a = '<span style="color:#0000ff">'+value+'</span>';  
            }else if(value == "待办") {  
                var a = '<span style="color:#FF0000">'+value+'</span>';  
            }else{  
                var a = '<span>'+value+'</span>';  
            }  
            return a;  
        }  
	</script>  
    
  <script>
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
		$("#workPlan_delete_all").click(function(){
			var planNames="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				planNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id') + "-";
			});
			
			//去除最后的那个,
			planNames=planNames.substring(0,planNames.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			if(del_id_strs == ""){
				//alert("请选择要删除的工作计划");
				return false;
			}
			//alert(del_id_strs);
			if(confirm("确定删除吗?")){
				$.ajax({
					url: "/oa/workPlan/deleteWorkPlan/"+del_id_strs,
					type: "post",		
					success:function(result){
						window.location.href="workPlanlist";
					}
				});
			}
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