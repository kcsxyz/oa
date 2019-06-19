<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤记录</title>
<link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
	.content-panel{
		padding-bottom:0px;
	}
</style>
</head>
<body>
	<!-- 引入导航栏 -->
	<section id="container"> 
		<%@include file="/nav.jsp"%>
	
		<!--main content start--> 
		<section id="main-content"> 
			<section class="wrapper">
		<div class="row mt">
			<div class="col-lg-12">
				<div class="content-panel">
					<div class="panel">
				  		<div class="panel-title" style="margin-left:10px;padding-bottom:5px;"><b>系统设置--考勤统计</b></div>
					</div>
					<section id="unseen">
					<table
						class="table table-hover "
						style="text-align: center;">
						<thead>
							<tr class="bg-primary">
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">姓名</th>
								<th style="text-align: center;">缺勤次数</th>
								<th style="text-align: center;">年</th>
								<th style="text-align: center;">月</th>
								<th style="text-align: center;">请假时长</th>
								<th style="text-align: center;">迟到时长</th>
								<th style="text-align: center;">统计时间</th>
							</tr>
						</thead>
						<tbody id="attendData">
							
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
	<script src="/oa/assets/layui.js"></script>
	<script src="/oa/assets/js/bootstrap.min.js"></script>
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
				url : "/oa/attendCount/attendCountList",
				data : "pageNo=" + pn,
				type : "get",
				success : function(result) {
					//alert(result);
					//显示部门信息
					create_dept_table(result);
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
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
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

		//构建部门列表
		function create_dept_table(result) {
			//清空table
			$("#attendData").empty();
			var attendCount = result.extend.pageInfo.list;
			if(attendCount!=""){
				$.each(attendCount,function(index, item) {
							//alert(item.deptName);
							//var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
							var idTd = $("<td></td>").append(index + 1);
							var userNameTd = $("<td></td>").append(
									item.user.name);
							/* var deptTd = $("<td></td>").append(
									item.dept.deptName); */
							var absenceCountTd = $("<td></td>").append(
									item.absenceCount);
							var dateYearTd = $("<td></td>").append(
									item.dateYear);
							var dateMothTd = $("<td></td>").append(
									item.dateMoth);
							var leaveTimeLengthTd = $("<td></td>").append(
									item.leaveTimeLength);
							var lateTimeLengthTd = $("<td></td>").append(
									item.lateTimeLength);
							var createTimeTd = $("<td></td>").append(
									timestampToTime(item.createTime));
							/* var editBtn = $("<button></button>")
									.addClass(
											"btn btn-primary btn-sm edit_btn")
									.append(
											$("<span></span>")
													.addClass(
															"glyphicon glyphicon-pencil"))
									.append("编辑");
							//为编辑按钮添加一个自定义属性，用于保存部门id	
							editBtn.attr("edit-id", item.deptId);
							var btnTd = $("<td></td>").append(editBtn) */
							$("<tr></tr>").append(idTd)
									.append(userNameTd).append(absenceCountTd).append(dateYearTd).append(dateMothTd)
									.append(leaveTimeLengthTd)
									.append(lateTimeLengthTd).append(createTimeTd)
									.appendTo("#attendData");
						});
			}else{
				$("<tr></tr>").append("<td colspan='8'>没有匹配的数据</td>").appendTo("#attendData");
			}
			
		}
		
	/* -------------------部门添加---------------------- */
		//重置表单，清除数据
		function clear_form(ele){
			//重置内容
			$(ele)[0].reset();
			//移除添加的雷和文本
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		//创建部门下拉列表
		function create_dept(ele){
			
			$(ele).empty();
			//获取部门
			$.ajax({
				url: "${pageContext.request.contextPath}/system/getDeptList",
				type: "get",
				success:function(result){
					var optionEl1=$("<option></option>").append('———-—').attr("value","0");
					optionEl1.appendTo(ele);
					$.each(result.extend.pageInfo.list,function(){
						var optionEl=$("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEl.appendTo(ele);
					});
				}
			});
		}
		//添加员工
		$("#dept_add").click(function(){
			//重置表单，清除数据
			clear_form('#dept_add_model form');
			//获取部门
			create_dept("#select_add_dept");
			//显示模态框
			$("#dept_add_model").modal({
				backdrop:'static'
			});
		});
		
		//校验表单员工信息
		function validate_dept_form(){
			var deptName=$('#deptName').val();
			alert(deptName);
			if(deptName == ""){
				valate_form_msg("#deptName",'error',"部门名称不能空");
				return false;
			}else{
				valate_form_msg("#deptName",'success',"");
			}
			
			var remark=$('#remark').val();
			if(remark == ""){
				valate_form_msg("#remark",'error',"描述不能为空");
				return false;
			}else{
				valate_form_msg("#remark",'success',"");
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
		
		//校验用户名是否存在
		$("#deptName").change(function(){
			var deptName=this.value;
			$.ajax({
				url: "${pageContext.request.contextPath}/system/checkDeptName",
				type: "post",
				data: "deptName="+deptName,
				success:function(result){
					if(result.stateCode==1){
						valate_form_msg("#deptName",'success',"用户名可用");
						$("#save_dept").attr("ajax-va","success");
					}else if(result.stateCode==0){
						valate_form_msg("#deptName",'error',result.message);
						$("#save_dept").attr("ajax-va","error");
					}
				}
			});
		});
		//保存员工操作
		$("#save_dept").click(function(){
			//1、对表单进行校验
			if(!validate_dept_form()){
				return false;
			}
			//判断用户名是否可用
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//3、发送请求你保存
			$.ajax({
				url: "/oa/system/saveDept",
				type: "get",
				data: $('#dept_add_model form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						//alert(result.message);
					}else if(result.stateCode==1){
						//关闭模态框
						$('#dept_add_model').modal('hide');
						//显示添加的员工，即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						to_page(totalRecords);
					}
				}
			});
		});
		
		//添加部门
		$("#dept_add").click(function() {
			//重置表单，清除数据
			 clear_form('#dept_add_model form');
			//获取部门
			create_dept("#select_add_dept");
			//显示模态框
			$("#dept_add_model").modal({
				backdrop : 'static'
			});
		});
		
		/*--------------------修改部门----------------- */
		//通过这个方法才能找到后添加的元素
		$(document).on("click",".edit_btn",function(){
			//1、查出部门
			create_dept("#select_update_dept");
			//2.得到员工
			getDept($(this).attr("edit-id"));
			//把员工id传给更新按钮
			$("#update_dept").attr("edit-id",$(this).attr("edit-id"));
			//打开更新模态框
			$("#dept_update_model").modal({
				backdrop:'static'
			});
		});
		//通过id获取员工
		function getDept(id){
			$.ajax({
				url: "/oa/system/getDeptById?id="+id,
				type: "GET",
				success:function(result){
					var dept=result.extend.dept;
					$('#deptId').val(dept.deptId);
					$('#deptName_update').val(dept.deptName);
					$('#remark_update').val(dept.remark);
					$('#dept_update_model select').val([dept.deptPId]);
				}
			});
		}
		
		//--------------更新部门-----------------------------
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
				data: $("#dept_update_model form").serialize(),			
				success:function(result){
					//关闭对话框
					$("#dept_update_model").modal('hide');
					//回到当前页
					to_page(currentPage);
				}
			});
		});
		
		//删除部门
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
			//alert(timestamp);
			if(timestamp==null){
				return "";
			}
			   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
			   Y = date.getFullYear() + '-';
			   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			   D = date.getDate() + ' ';
			   h = date.getHours() + ':';
			   m = date.getMinutes() + ':';
			   s = date.getSeconds();
			   return h+m+s;
		}
		function timeToTime(timestamp) {
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
</html></html>