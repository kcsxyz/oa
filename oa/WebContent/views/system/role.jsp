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
<title>角色设置</title>
<link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
<link href="/oa/assets/ztree/zTreeStyle.css" rel="stylesheet">
<link href="/oa/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<!-- 引入导航栏 -->

	<!-- 修改角色模态框 -->
	<div class="modal fade" id="role_update_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改角色</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">角色名称</label>
							<div class="col-sm-10">
								<input id="roleId_update" name="roleId" type="text" hidden="hidden"/>
								<input type="text" name="roleName"  class="form-control"
									id="roleName_update" placeholder="请输入角色名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">角色描述</label>
							<div class="col-sm-10">
								<textarea name="remark" id="remark_update" class="form-control" rows="3" ></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_role">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增角色模态框 -->
	<div class="modal fade" id="role_add_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加角色</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">角色名称</label>
							<div class="col-sm-10">
								<input type="text" name="roleName" class="form-control"
									id="roleName" placeholder="请输入角色名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">角色描述</label>
							<div class="col-sm-10">
								<textarea name="remark" id="remark" class="form-control" rows="3" ></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save_role">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 授权模态框 -->
	<div class="modal fade" id="grant_permission_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">角色授权</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">角色名称</label>
							<div class="col-sm-10">
								<input id="roleId_grant" name="roleId" type="text" hidden="hidden"/>
								<input type="text" name="roleName" disabled class="form-control"
									id="roleName_grant" placeholder="请输入角色名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
				            <label class="col-sm-2 control-label">菜单权限</label>
				            <div class="col-sm-8">
				                <div id="menuTrees" class="ztree"></div>
				            </div>
				        </div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save_grant">保存</button>
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
					<div class="col-md-5">
						<h4 >
						<button class="btn btn-primary btn-sm" id="role_add">
							<i class="glyphicon glyphicon-plus"></i>新增
						</button>
						<button class="btn btn-danger" id="perm_delete_all">删除</button>
						</h4>
					</div>
					<div class="col-md-7">
						<div class="col-md-2" style="float:right" >
							<button class="btn btn-primary btn-sm" id="search">
							<i class="glyphicon glyphicon-search"></i>搜索
						</button>
						</div>
						<div class="col-md-5" style="float:right">
							<input type="text" name="queryStr" id="queryStr" class="form-control"  placeholder="输入角色"/>
						</div>
					</div>
					<section id="unseen">
					<table class="table table-hover table-striped" style="text-align: center;">
						<thead>
							<tr class="bg-primary">
								<th style="text-align: center;" class="col-md-1"><input type="checkbox" id="check_all"
									class="list-child"/></th>
								<th style="text-align: center;" class="col-md-2">序号</th>
								<th style="text-align: center;" class="col-md-3">角色名</th>
								<th style="text-align: center;" class="col-md-3">角色描述</th>
								<th style="text-align: center;" class="col-md-3">操作</th>
							</tr>
						</thead>
						<tbody id="roleData">
							
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
	<!-- /row --> 
	</section> 
	</section><!-- /MAIN CONTENT --> 
	</section>
	
	<script src="/oa/assets/jquery-2.1.0.min.js"></script>
	<script src="/oa/assets/layer/layer.js"></script>
	<script src="/oa/assets/js/bootstrap.min.js"></script>
	<script src="/oa/assets/ztree/jquery.ztree.all-3.5.min.js"></script>
	<script src="/oa/assets/jquery.validate.min.js"></script>
	<script type="text/javascript">
		//保存一下总记录数
		var totalRecords, currentPage;
		/* 页面加载完后，显示数据 */
		$(function() {
			//显示第一页
			to_page(1);
		});
		
		//查找
		$("#search").click(function(){
			var queryStr = "";
			queryStr = $("#queryStr").val();
			$.ajax({
				url : "/oa/system/getRoleList",
				data : {
					"pageNo=": 1,
					"queryStr":queryStr
				},
				type : "get",
				success : function(result) {
					//alert(result);
					//显示角色信息
					create_role_table(result);
					//显示记录数
					create_page_info(result);
					//显示分页导航
					create_nav_area(result);
				}
			});
		});
		
		//查找
		$("#queryStr").change(function(){
			var queryStr = "";
			queryStr = $("#queryStr").val();
			$.ajax({
				url : "/oa/system/getRoleList",
				data : {
					"pageNo=": 1,
					"queryStr":queryStr
				},
				type : "get",
				success : function(result) {
					//alert(result);
					//显示角色信息
					create_role_table(result);
					//显示记录数
					create_page_info(result);
					//显示分页导航
					create_nav_area(result);
				}
			});
		});
		
		function to_page(pn) {
			
			$.ajax({
				url : "/oa/system/getRoleList",
				data :"pageNo="+pn,
				type : "get",
				success : function(result) {
					//alert(result);
					//显示角色信息
					create_role_table(result);
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

		//构建角色列表
		function create_role_table(result) {
			//清空table
			$("#roleData").empty();
			var permissions = result.extend.pageInfo.list;
			$
					.each(
							permissions,
							function(index, item) {
								//alert(item.deptName);
								var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
								var idTd = $("<td></td>").append(index + 1);
								var roleNameTd = $("<td></td>").append(
										item.roleName);
								var remarkTd = $("<td></td>").append(
										item.remark);
								var editBtn = $("<button></button>")
										.addClass(
												"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("编辑");
								
								//为编辑按钮添加一个自定义属性，用于保存角色id	
								editBtn.attr("edit-id", item.roleId);
								var grantBtn = $("<button></button>")
												.addClass(
												"btn btn-warning btn-sm grant_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-lock"))
										.append("授权");
								grantBtn.attr("grant-id", item.roleId);
								var delBtn = $("<button></button>")
										.addClass(
												"btn btn-danger btn-sm delete_btn")
										.append(
												$("<li></li>")
														.addClass(
																"fa fa-trash-o"))
										.append("删除");
								//为删除按钮添加一个自定义属性，用于保存角色id
								delBtn.attr("delete-id", item.roleId);
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(grantBtn).append(" ").append(delBtn);
								$("<tr></tr>").append(checkBoxTd).append(idTd)
										.append(roleNameTd).append(remarkTd).append(btnTd)
										.appendTo("#roleData");
							});
		}
		
	/* -------------------角色添加---------------------- */
		//重置表单，清除数据
		function clear_form(ele){
			//重置内容
			$(ele)[0].reset();
			//移除添加的雷和文本
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
		//添加角色
		$("#role_add").click(function(){
			//重置表单，清除数据
			clear_form('#role_add_model form');
			//显示模态框
			$("#role_add_model").modal({
				backdrop:'static'
			});
		});
		
		//校验表单角色信息
		function validate_perm_form(){
			var roleName=$('#roleName').val();
			//alert(roleName);
			if(roleName == ""){
				valate_form_msg("#roleName",'error',"角色名称不能为空");
				return false;
			}else{
				valate_form_msg("#roleName",'success',"");
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
		
		
		//------------校验角色名名是否存在-----------------
		$("#roleName").change(function(){
			var roleName = "";
			roleName = $("#roleName").val();
			
			if(roleName == ""){
				//alert(roleName);
				valate_form_msg("#roleName",'error',"角色名称不能为空");
				return false;
				
			}

			$.ajax({
				url: "${pageContext.request.contextPath}/system/checkroleName",
				type: "post",
				data: {
					"roleName":roleName
				},
				success:function(result){
					if(result.stateCode==1){
						valate_form_msg("#roleName",'success',"角色名称可用");
						$("#save_role").attr("ajax-va","success");
					}else if(result.stateCode==0){
						valate_form_msg("#roleName",'error',result.message);
						$("#save_role").attr("ajax-va","error");
					}
				}
			});
		});
		
		//----------------保存角色操作-----------------
		$("#save_role").click(function(){
			//1、对表单进行校验
			if(!validate_perm_form()){
				return false;
			}
			//判断角色名是否可用
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//3、发送请求你保存
			$.ajax({
				url: "/oa/system/saveRole",
				type: "get",
				data: $('#role_add_model form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						//alert(result.message);
					}else if(result.stateCode==1){
						//关闭模态框
						$('#role_add_model').modal('hide');
						//显示添加的角色，即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						to_page(totalRecords);
					}
				}
			});
		});
		
		//角色添加
		$("#role_add").click(function() {
			//重置表单，清除数据
			 clear_form('#role_add_model form');
			//显示模态框
			$("#role_add_model").modal({
				backdrop : 'static'
			});
		});
		
		/*--------------------修改角色----------------- */
		//通过这个方法才能找到后添加的元素
		$(document).on("click",".edit_btn",function(){
			//1.得到角色
			getRole($(this).attr("edit-id"));
			//把角色id传给更新按钮
			$("#update_role").attr("edit-id",$(this).attr("edit-id"));
			//打开更新模态框
			$("#role_update_model").modal({
				backdrop:'static'
			});
		});
		//通过id获取角色
		function getRole(id){
			$.ajax({
				url: "/oa/system/getRoleById?id="+id,
				type: "GET",
				success:function(result){
					var role=result.extend.role;
					$("#roleId_update").val(role.roleId);
					$('#roleName_update').val(role.roleName);
					$('#remark_update').val(role.remark);
					
				}
			});
		}
		
		//--------------更新角色-----------------------------
		$('#update_role').click(function(){
			var roleName=$('#roleName_update').val();
			//alert(roleName);
			if(roleName == ""){
				valate_form_msg("#roleName_update",'error',"角色名称不能为空");
				return false;
			}else{
				valate_form_msg("#roleName_update",'success',"");
			}
			$.ajax({
				url: "/oa/system/updateRole",
				type: "post",
				data: $("#role_update_model form").serialize(),			
				success:function(result){
					//关闭对话框
					$("#role_update_model").modal('hide');
					//回到当前页
					to_page(currentPage);
				}
			});
		});
		
		//删除角色
		$(document).on("click",".delete_btn",function(){
			//1、获得当前角色的名字
			var roleName=$(this).parents('tr').find('td:eq(2)').text();
			var roleId = $(this).attr("delete-id");
			//alert(deptId);
			if(confirm("确定删除【"+roleName+"】吗")){
				//发送请求删除
				$.ajax({
					url: "/oa/system/deleteRole/"+roleId,
					type: "post",		
					success:function(result){
						//关闭对话框
						//alert(result.stateCode);
						if(result.stateCode==0){
							layer.msg(result.message, {time:2000, icon:5, shift:6}, function(){
	                        	
	                        });
						}
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
		$("#perm_delete_all").click(function(){
			var roleNames="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				roleNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id') + "-";
			});
			if(del_id_strs == ""){
				layer.alert("请选择要删除的角色");
				return false;
			}
			//去除最后的那个,
			roleNames=roleNames.substring(0,roleNames.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			//alert(del_id_strs);
			
			if(confirm("确定删除【"+roleNames+"】吗?")){
				$.ajax({
					url: "/oa/system/deleteRole/"+del_id_strs,
					type: "post",		
					success:function(result){
						if(result.stateCode == 0){
							layer.msg(result.message, {time:2000, icon:5, shift:6}, function(){
	                        	
	                        });
						}
						//回到当前页
						to_page(currentPage);
					}
				});
			}

		});
		
		//------------------给角色授权--------------------
		//初始化加载
		$(document).on("click",".grant_btn",function(){
			//1.得到角色
			var id = $(this).attr("grant-id");
			//alert(id);
			$.ajax({
				url: "/oa/system/getRoleById?id="+id,
				type: "GET",
				success:function(result){
					var role=result.extend.role;
					$("#roleId_grant").val(role.roleId);
					$('#roleName_grant').val(role.roleName);
				}
			});
			
			//2.加载权限树
			 btn.treeMenu();
		     btn.selectNodes(id);
		     
		    //打开模态款
		     $("#grant_permission_model").modal({
					backdrop : 'static'
				});
		});
		
		/* // 表单校验
	    $("#grant_permission_model").validate({
	        submitHandler: function (form) {
	            btn.save();
	        }
	    }); */

	    var btn = {
	        treeMenu: function () {
	            var zTreeObj,
	                setting = {
	            		data: {
	                        key: {
	                            //将treeNode的permName属性当做节点名称
	                            name: "permName"        
	                        },
	                        simpleData: {
	                            //是否使用简单数据模式
	                            enable: true,
	                            //当前节点id属性  
	                            idKey: "permId",
	                        }
	                    },
	                    view: {
	                        selectedMulti: false
	                    },
	                    callback: {
	                        beforeCheck: true,
	                        onCheck: btn.onCheck
	                    },
	                    check: {
	                        enable: true,
	                        chkStyle: "checkbox",    //复选框
	                        chkboxType: {"Y": "p", "N": "s"}
	                        // 被勾选时：关联父  关联子√
	                        // 取消勾选时：关联父√  关联子
	                    }
	
	                },
	                zTreeNodes = btn.initDeptData();
	            zTreeObj = $.fn.zTree.init($("#menuTrees"), setting, zTreeNodes);
	          //展开所有一级节点
	            var nodes = zTreeObj.getNodes();
	            for (var i = 0; i < nodes.length; i++) { //设置节点展开
	                zTreeObj.expandNode(nodes[i], true, false, true);
	            }
	        },
	        //点击树状复选框回调
	        onCheck: function (e, treeId, treeNode) {
	            var menuIds = [];
	            var treeObj = $.fn.zTree.getZTreeObj("menuTrees"),
	                nodes = treeObj.getCheckedNodes(true),
	                v = "";
	            for (var i = 0; i < nodes.length; i++) {
	                menuIds.push(nodes[i].permId);
	                //alert(nodes[i].permId);
	            }
	            return menuIds;
	
	        },
	
	        //请求服务端获取数据菜单
	        initDeptData: function () {
	            var array1;
	
	            $.ajaxSettings.async = false;
	            $.post("/oa/system/loadPermission", {}, function (data) {
	                array1 = data;
	            })
	            return array1;
	        },
	
	        //提交表单
	        save: function () {
	            var roleId = $("#roleId_grant").val();
	            var roleName = $("#roleName_grant").val();
	            $.ajax({
	                type: "POST",
	                url: "/oa/system/saveRolePermission",
	                traditional: true,
	                data: {
	                    "roleId": roleId,
	                    "roleName": roleName,
	                    "ids": btn.onCheck()
	                },
	                async: true,
	                error: function (request) {
	                    $.modal.alertError("系统错误");
	                },
	                success: function (data) {
	                    alert("授权成功")
	                }
	            });
	        },
	
	        //遍历所有节点初始化选中
	        selectNodes: function (id) {
	            var treeObj = $.fn.zTree.getZTreeObj("menuTrees");
	            var nodesAll = treeObj.getNodes(); //可以获取所有的节点
	            var nodesArray = treeObj.transformToArray(nodesAll); // 将数据变成简单的 Array 集合
	            $.post("/oa/system/getRoleByIdWithPerm?id=" + id, {}, function (data) {
	                var powers = data.extend.role.permissionList;
	                var node2="";
	                for (var i = 0; i < powers.length; i++) {
	                    for (var j = 0; j < nodesArray.length; j++) {
	                    	 //alert(powers[i].permId+""+nodesArray[j].permId);
	                        if (nodesArray[j].permId != null) {	  
	                            if (powers[i].permId == nodesArray[j].permId) {
	                            	//alert(nodesArray[j].permId);
	                                node2 = treeObj.getNodeByParam("permId", nodesArray[j].permId);//根据ID找到该节点
	                                treeObj.checkNode(node2,true,true);//根据该节点选中
	                                treeObj.expandNode(node2, true, false);//指定选中ID节点展开
	                                treeObj.updateNode(node2);
	                            }
	                        }
	                    }
	                }
	            })
	        }
	    }
	    
	    //保存权限
	    $("#save_grant").click(function(){
			btn.save();
			$('#grant_permission_model').modal('hide');
		});

	</script>
</body>
</html>