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
<title>Insert title here</title>
<link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<!-- 引入导航栏 -->

	<!-- 修改部门模态框 -->
	<div class="modal fade" id="dept_update_model" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">部门修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">部门名</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="deptName_update"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Salary</label>
							<div class="col-sm-10">
								<input type="text" name="salary" class="form-control"
									id="salary_update" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" name="email" class="form-control"
									id="email_update" placeholder="zcgy@163.com"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender_update" value="1" checked="checked">男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender_update" value="0">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Dept</label>
							<div class="col-sm-3">
								<select class="form-control" name="dId" id="select_update_dept">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_emp">修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增员工模态框 -->
	<div class="modal fade" id="dept_add_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">部门添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">部门名称</label>
							<div class="col-sm-10">
								<input type="text" name="deptName" class="form-control"
									id="deptName" placeholder="部门名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">上级部门</label>
							<div class="col-sm-3">
								<select class="form-control" name="deptId" id="select_add_dept">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">部门描述</label>
							<div class="col-sm-10">
								<textarea name="remark" id="remark" class="form-control" rows="3" ></textarea>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1" value="1" checked="checked">男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2" value="0">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Dept</label>
							<div class="col-sm-3">
								<select class="form-control" name="dId" id="select_add_dept">
								</select>
							</div>
						</div> -->
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save_dept">保存</button>
				</div>
			</div>
		</div>
	</div>
	<section id="container"> 
		<%@include file="/nav.jsp"%>
	
		<!--main content start--> 
		<section id="main-content"> 
			<section class="wrapper">
		<h3>
			<i class="fa fa-angle-right"></i>
		</h3>
		<div class="row mt">
			<div class="col-lg-12">
				<div class="content-panel">
					<h4>
						<button class="btn btn-primary btn-sm" id="dept_add">
							<i class="glyphicon glyphicon-plus"></i>新增
						</button>
					</h4>
					<section id="unseen">
					<table
						class="table table-hover table-striped table-condensed"
						style="text-align: center;">
						<thead>
							<tr>
								<th style="text-align: center;"><input type="checkbox"
									class="list-child"/></th>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">部门名</th>
								<th style="text-align: center;">部门级别</th>
								<th style="text-align: center;">上级部门</th>
								<th style="text-align: center;">描述</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody id="deptData">
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="12">
									<div class="row">
										<div class="col-md-6" id="pageInfo_area"></div>
										<div class="col-md-6" id="nav_area"></div>
									</div>
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
				url : "/oa/system/getDeptList",
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
					$("<a></a>").attr("href", "#").append("&laquo;"));

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
					$("<a></a>").attr("href", "#").append("&raquo;"));
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
				//给li添加click时间
				numli.click(function() {
					to_page(item);
				});
				ul.append(numli);
			});
			ul.append(nexPage).append(lastPage);
			//添加到导航中
			var nav = $("<nav></nav>");
			nav.append(ul);
			nav.appendTo("#nav_area")
		}

		//构建部门列表
		function create_dept_table(result) {
			//清空table
			$("#deptData").empty();
			var depts = result.extend.pageInfo.list;
			$
					.each(
							depts,
							function(index, item) {
								//alert(item.deptName);
								var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
								var idTd = $("<td></td>").append(index + 1);
								var deptNameTd = $("<td></td>").append(
										item.deptName);
								var deptPIdTd = $("<td></td>").append(
										item.deptPId);
								var deptLevelTd = $("<td></td>").append(
										item.deptLevel);
								var deptRemarkTd = $("<td></td>").append(
										item.remark);
								var editBtn = $("<button></button>")
										.addClass(
												"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("编辑");
								//为编辑按钮添加一个自定义属性，用于保存部门id	
								editBtn.attr("edit-id", item.deptId);
								var delBtn = $("<button></button>")
										.addClass(
												"btn btn-danger btn-sm delete_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-trash"))
										.append("删除");
								//为删除按钮添加一个自定义属性，用于保存部门id
								delBtn.attr("delete-id", item.deptId);
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(delBtn);
								$("<tr></tr>").append(checkBoxTd).append(idTd)
										.append(deptNameTd).append(deptPIdTd)
										.append(deptLevelTd).append(
												deptRemarkTd).append(btnTd)
										.appendTo("#deptData");
							});
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
		function validate_emp_form(){
			var deptName=$('#deptName').val();
			alert(deptName);
			if(deptName == ""){
				//alert("用户名可以是2-5位中文或6-9位英文加数字下划线的组合");
				valate_form_msg("#deptName",'error',"部门名称不能空");
				return false;
			}else{
				valate_form_msg("#deptName",'success',"");
			}
			
			var empSalary=$('#remark').val();
			var regSalary=/^[1-9][\d]*\.[\d]{2}$/;
			if(!regSalary.test(empSalary)){
				valate_form_msg("#salary",'error',"工资格式不正确");
				return false;
			}else{
				valate_form_msg("#salary",'success',"");
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
			if(!validate_emp_form()){
				return false;
			}
			//判断用户名是否可用
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//3、发送请求你保存
			$.ajax({
				url: "${pageContext.request.contextPath}/system/insertEmp",
				type: "get",
				data: $('#emp_add_model form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						if(undefined !=result.extend.errorFields.deptName){
							valate_form_msg("#deptName",'error',result.extend.errorFields.deptName);
						}
						if(undefined !=result.extend.errorFields.email){
							valate_form_msg("#email",'error',result.extend.errorFields.email);	
						}
						if(undefined !=result.extend.errorFields.salary){
							valate_form_msg("#salary",'error',result.extend.errorFields.salary);	
						}
					}else if(result.stateCode==1){
						//关闭模态框
						$('#emp_add_model').modal('hide');
						//显示添加的员工，即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						to_page(totalRecords);
					}
				}
			});
		});
		
		//添加部门
		$("#dept_add").click(function() {
			//重置表单，清除数据
			/* clear_form('#dept_add_model form');
			//获取部门
			create_dept("#select_add_dept"); */
			//显示模态框
			$("#dept_add_model").modal({
				backdrop : 'static'
			});
		});
	</script>
</body>
</html>