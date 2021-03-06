<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假审批</title>
<link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
	.content-panel{
		padding-bottom:0px;
	}
</style>
</head>
<body>
	<!-- 引入导航栏 -->

	<!-- 修改请假模态框 -->
	<div class="modal fade" id="leave_audit_model" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">请假审批</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<input type="hidden" id="leaveId" name="leaveId">
							<input type="hidden" id="currentNo" name="currentNo">
							<input type="hidden" id="processNo" name="processNo">
							<label class="col-sm-2 control-label">请假人：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="userName"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">工号：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="userId"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">类型：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="leaveType"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">起始时间：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="startTime"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">结束时间：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="endTime"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">请假事由：</label>
							<div class="col-sm-10">
									<textarea name="leaveReason" id="leaveReason" class="form-control" rows="3" disabled></textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label">审批意见：</label>
							<div class="col-sm-10">
									<textarea name="auditOpinion" id="auditOpinion" class="form-control" rows="3" ></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger shen" id="reject" >拒绝</button>
					<button type="button" class="btn btn-warning shen" id="reback">驳回</button>
					<button type="button" class="btn btn-primary shen" id="pass">通过</button>
				</div>
			</div>
		</div>
	</div>
	<section id="container"> 
		<%@include file="/nav.jsp"%>
	
		<!--main content start--> 
		<section id="main-content"> 
			<section class="wrapper">
		<div class="row mt">
			<div class="col-lg-12">
				<div class="content-panel">
					<div class="panel">
				  		<div class="panel-title" style="margin-left:10px;padding-bottom:5px;"><b>流程审批--我的待审</b></div>
					</div>
					<!-- <h4>
						<button class="btn btn-primary btn-sm" id="leave_add">
							<i class="glyphicon glyphicon-plus"></i>填写申请
						</button>
					</h4> -->
					<section id="unseen">
					<table
						class="table table-hover "
						style="text-align: center;">
						<thead>
							<tr class="bg-primary">
								<th style="text-align: center;"><input type="checkbox" id="check_all"
									class="list-child"/></th>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">流程编号</th>
								<th style="text-align: center;">请假人</th>
								<th style="text-align: center;">假期类型</th>
								<th style="text-align: center;">申请时间</th>
								<th style="text-align: center;">状态</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody id="processData">
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="12" style="margin-bottom:0px; line-height:75px;">
									<div class="col-md-6" id=""><p id="pageInfo_area"></div>
									<div class="col-md-6" id="nav_area"></div>
								</td>
							</tr>
						</tfoot>
					</table>
					</section>
				</div>
				<!-- /content-panel -->
			</div>
			<!-- /col-lg-4 -->
		</div>
	<!-- /row --> </section> </section><!-- /MAIN CONTENT --> 
	</section>
	
	<script src="/oa/assets/jquery-2.1.0.min.js"></script>
	<script src="/oa/assets/layer/layer.js"></script>
	<script src="/oa/assets/layui/layui.js"></script>
	<script src="/oa/assets/js/bootstrap.min.js"></script>
	<script src="/oa/assets/jquery.validate.min.js"></script>
	<script src="/oa/assets/messages_zh.min.js"></script>
	<!-- <script>
		//注意：导航 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function() {
			var element = layui.element;

		});
	</script> -->
	<script type="text/javascript">
		//保存一下总记录数
		var totalRecords, currentPage;
		/* 页面加载完后，显示数据 */
		$(function() {
			//显示第一页
			to_page(1);
		});

		//去相应的页面
		function to_page(pn) {
			$.ajax({
				url : "/oa/process/getAuditList",
				data : "pageNo=" + pn,
				type : "get",
				success : function(result) {
					//alert(result);
					//显示请假信息
					create_leave_table(result);
					//显示记录数
					create_page_info(result);
					//显示分页导航
					create_nav_area(result);
				}
			});
		}

		//页面记录条数信息
		function create_page_info(result) {
			//清空
			$("#pageInfo_area").empty();

			$("#pageInfo_area").append(
					"当前第" + result.extend.pageInfo.pageNum + "页,共"
							+ result.extend.pageInfo.pages + "页,共"
							+ result.extend.pageInfo.total + "条记录");
			totalRecords = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}

		//构建分页导航条
		function create_nav_area(result) {
			//清空分页导航
			$("#nav_area").empty();

			var ul = $("<ul></ul>").addClass("pagination");
			var firstPage = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePage = $("<li></<li>").append(
					$("<a></a>").attr("href", "#").append("<"));

			//如果没有上一页，则为disabled
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPage.addClass("disabled");
				prePage.addClass("disabled");
			} else {
				firstPage.click(function() {
					to_page(1);
				});
				prePage.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			var nexPage = $("<li></<li>").append(
					$("<a></a>").attr("href", "#").append(">"));
			var lastPage = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));

			if (result.extend.pageInfo.hasNextPage == false) {
				nexPage.addClass("disabled");
				lastPage.addClass("disabled");
			} else {
				nexPage.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPage.click(function() {
					to_page(result.extend.pageInfo.pages);
				});
			}

			//添加首页，上一页
			ul.append(firstPage).append(prePage);
			//遍历导航
			$.each(result.extend.pageInfo.navigatepageNums, function(index,item) {
				var numli = $("<li></li>").append($("<a></a>").append(item));
				//判断如果为当前页，则为active状态
				if (result.extend.pageInfo.pageNum == item) {
					numli.addClass("active");
				}
				//给li添加click事件
				numli.click(function() {
					to_page(item);
				});
				ul.append(numli);
			});
			ul.append(nexPage).append(lastPage);
			//添加到导航中
			var nav = $("<div></div>");
			nav.append(ul);
			nav.appendTo("#nav_area");
		}

		//构建请假列表
		function create_leave_table(result) {
			//清空table
			$("#processData").empty();
			var process = result.extend.pageInfo.list;
			if(process !=""){
				$.each(process,function(index, item) {
					//alert(item.deptName);
					var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
					var idTd = $("<td></td>").append(index + 1);
					var processNoTd = $("<td></td>").append(
							item.processNo);
					var leaveTypeTd = $("<td></td>").append(
							item.leaveType);
					var leaveNameTd = $("<td></td>").append(
							item.userName);
					var createTimeTd = $("<td></td>").append(
							timestampToTime(item.createTime));
					var statusTd;
					if(item.status.indexOf("审核中") != -1){
						statusTd = $("<td></td>").append($("<button></button>").addClass(
						"btn btn-warning btn-xs status").append(
								item.status));
					}else if(item.status =="通过"){
						statusTd = $("<td></td>").append($("<button></button>").addClass(
						"btn btn-success btn-xs status").append(
								item.status));
					}else{
						statusTd = $("<td></td>").append($("<button></button>").addClass(
						"btn btn-danger btn-xs status").append(
								item.status));
					}
					
					var editBtn = $("<button></button>")
							.addClass(
									"btn btn-primary btn-sm edit_btn")
							.append(
									$("<span></span>")
											.addClass(
													"glyphicon glyphicon-check"))
							.append(" ").append("审核");
					//为编辑按钮添加一个自定义属性，用于保存请假id	
					editBtn.attr("edit-id", item.id);
					/* var delBtn = $("<button></button>")
							.addClass(
									"btn btn-danger btn-sm delete_btn")
							.append(
									$("<span></span>")
											.addClass(
													"glyphicon glyphicon-trash"))
							.append("删除");
					//为删除按钮添加一个自定义属性，用于保存请假id
					delBtn.attr("delete-id", item.id); */
					var btnTd = $("<td></td>").append(editBtn)
							.append(" ");
					$("<tr></tr>").append(checkBoxTd).append(idTd)
							.append(processNoTd).append(leaveNameTd)
							.append(leaveTypeTd).append(createTimeTd).append(statusTd)
							.append(btnTd)
							.appendTo("#processData");
				});
			}else{
				$("<tr></tr>").append("<td colspan='7'>没有匹配的数据</td>").appendTo("#processData");
			}
			
		}
	
	/* -------------------请假申请---------------------- */
		
		//重置表单，清除数据
		function clear_form(ele){
			//重置内容
			$(ele)[0].reset();
			//移除添加的雷和文本
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
		//请假申请
		$("#leave_add").click(function(){
			//重置表单，清除数据
			clear_form('#leave_add_model form');
			
			//显示模态框
			$("#leave_add_model").modal({
				backdrop:'static'
			});
		});
		
		//校验表单员工信息
		function validate_leave_form(){
			var leaveType=$('#leaveType').val();
			//alert(leaveType);
			if(leaveType == ""){
				valate_form_msg("#leaveType",'error',"类型不能为空");
				return false;
			}else{
				valate_form_msg("#leaveType",'success',"");
			}
			
			var startTime=$('#startTime').val();
			if(startTime == ""){
				valate_form_msg("#startTime",'error',"起始时间不能为空");
				return false;
			}else{
				valate_form_msg("#startTime",'success',"");
			}
			var endTime=$('#endTime').val();
			if(endTime == ""){
				valate_form_msg("#endTime",'error',"结束时间不能为空");
				return false;
			}else{
				valate_form_msg("#endTime",'success',"");
			}
			var leaveReason=$('#leaveReason').val();
			if(leaveReason == ""){
				valate_form_msg("#leaveReason",'error',"请假事由不能为空");
				return false;
			}else{
				valate_form_msg("#leaveReason",'success',"");
			}
			
			return true;
		}
		//显示校验信息
		function valate_form_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next('span').text("");
			if(status=='success'){
				$(ele).parent().addClass("has-success");
				$(ele).next('span').text(msg);
			}else if(status=='error'){
				$(ele).parent().addClass("has-error");
				$(ele).next('span').text(msg);
			}
		}
		//保存员工操作
		$("#save_leave").click(function(){
			//1、对表单进行校验
			if(!validate_leave_form()){
				return false;
			}
			//判断用户名是否可用
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//3、发送请求你保存
			$.ajax({
				url: "/oa/process/saveLeave",
				type: "post",
				data: $('#leave_add_model form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						//alert(result.message);
					}else if(result.stateCode==1){
						//关闭模态框
						$('#leave_add_model').modal('hide');
						//显示添加的员工，即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						to_page(totalRecords);
					}
				}
			});
		});
		
		//添加请假
		$("#leave_add").click(function() {
			//重置表单，清除数据
			 clear_form('#leave_add_model form');
			//获取请假
			//create_dept("#select_add_dept");
			//显示模态框
			$("#leave_add_model").modal({
				backdrop : 'static'
			});
		});
		
		/*--------------------请假审批----------------- */
		//通过这个方法才能找到后添加的元素
		$(document).on("click",".edit_btn",function(){
			//.得到请假实例员工
			getLeave($(this).attr("edit-id"));
			//把员工id传给更新按钮
			//$("#update_dept").attr("edit-id",$(this).attr("edit-id"));
			//打开更新模态框
			$("#leave_audit_model").modal({
				backdrop:'static'
			});
		});
		//通过id获取请假申请
		function getLeave(id){
			$.ajax({
				url: "/oa/process/getLeaveById?id="+id,
				type: "GET",
				success:function(result){
					var leave=result.extend.leave;
					$("#userName").text(leave.userName);
					$("#userId").text(leave.userId);
					$('#leaveType').text(leave.leaveType);
					$('#startTime').text(timestampToTime(leave.startTime));
					$('#endTime').text(timestampToTime(leave.endTime));
					$('#leaveReason').val(leave.leaveReason);
					$("#currentNo").val(leave.currentNo);
					$("#leaveId").val(leave.id);
					$("#processNo").val(leave.processNo);
					
				}
			});
		}
		
		
		//保存审批信息
		$(document).on("click",".shen",function(){
			var startTime = $("#startTime").text();
			var endTime = $("#endTime").text();
			var isGreaterThree = compareTimeMoreThree(startTime,endTime);
			var leaveId = $("#leaveId").val();
			var currentNo = $("#currentNo").val();
			var opinion = $("#auditOpinion").val();
			var processNo = $("#processNo").val();
			var status = "";
			if($(this).attr("id")=="reject"){
				status = "拒绝";
			}else if($(this).attr("id")=="reback"){
				status = "驳回";
			}else{
				status = "通过";
			}
			//alert(leaveId+currentNo+opinion+status+isGreaterThree);
			
			$.ajax({
				url: "/oa/process/updateProcess",
				type: "post",
				data: {
					"leaveId":leaveId,
					"currentNo":currentNo,
					"opinion":opinion,
					"isGreaterThree":isGreaterThree,
					"processNo":processNo ,
					"status":status
				},			
				success:function(result){
					//关闭对话框
					$("#leave_audit_model").modal('hide');
					//回到当前页
					to_page(currentPage);
				}
			});
			
		});
		
		 function compareTimeMoreThree(startTime,endTime){
			var sdate = new Date(startTime); 
			var now = new Date(endTime); 
			var days = now.getTime() - sdate.getTime(); 
			var day = parseInt(days / (1000 * 60 * 60 * 24)); 
			var greaterThree = day >3 ? true:false;
			return greaterThree; 
		 } 
		 
		//--------------更新审批-----------------------------
		$('#update_dept').click(function(){
			var deptName=$('#deptName_update').val();
			alert(deptName);
			if(deptName == ""){
				valate_form_msg("#deptName_update",'error',"部门名称不能为空");
				return false;
			}else{
				valate_form_msg("#deptName_update",'success',"");
			}
			$.ajax({
				url: "/oa/system/updateDeptById",
				type: "post",
				data: $("#leave_audit_model form").serialize(),			
				success:function(result){
					//关闭对话框
					$("#leave_audit_model").modal('hide');
					//回到当前页
					to_page(currentPage);
				}
			});
		});
		
		//删除请假
		$(document).on("click",".delete_btn",function(){
			//1、获得当前员工的名字
			var deptName=$(this).parents('tr').find('td:eq(2)').text();
			var deptId = $(this).attr("delete-id");
			//alert(deptId);
			if(confirm("确定删除【"+deptName+"】吗")){
				//发送请求删除
				$.ajax({
					url: "/oa/system/deleteDept/"+deptId,
					type: "post",		
					success:function(result){
						//关闭对话框
						alert(result.stateCode);
						//回到当前页
						to_page(currentPage);
					}
				});
			}
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
		$("#dept_delete_all").click(function(){
			var deptNames="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				deptNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id') + "-";
			});
			
			//去除最后的那个,
			deptNames=deptNames.substring(0,deptNames.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			if(del_id_strs == ""){
				alert("请选择要删除的部门");
				return false;
			}
			alert(del_id_strs);
			if(confirm("确定删除【"+deptNames+"】吗?")){
				$.ajax({
					url: "/oa/system/deleteDept/"+del_id_strs,
					type: "post",		
					success:function(result){
						//关闭对话框
						//alert(result.stateCode);
						//回到当前页
						to_page(currentPage);
					}
				});
			}

		});
		

		function timestampToTime(timestamp) {
			   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
			   Y = date.getFullYear() + '-';
			   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			   D = date.getDate() + ' ';
			   h = date.getHours() + ':';
			   m = date.getMinutes() + ':';
			   s = date.getSeconds();
			   return Y+M+D+h+m+s;
	}
	</script>
</body>
</html>