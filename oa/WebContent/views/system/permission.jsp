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
<title>菜单设置</title>
<link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
<link href="/oa/assets/ztree/zTreeStyle.css" rel="stylesheet">
<link href="/oa/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<!-- 引入导航栏 -->

	<!-- 修改部门模态框 -->
	<div class="modal fade" id="menu_update_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改菜单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">菜单名称</label>
							<div class="col-sm-10">
								<input type="hidden" name="permId"	id="permId_update" >
								<input type="text" name="permName"  class="form-control"
									id="permName_update" placeholder="请输入菜单名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">父菜单</label>
							<div class="col-sm-10">
								<input id="parentId_update" name="parentId" type="text" hidden="hidden"/>
								
								<input type="text" name="parentName" class="form-control" onclick="selectMenuTree_update()"
									id="parentName_update" placeholder="点击选择"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group menuDiv_update" style="display: none">
				            <label class="col-sm-2 control-label">菜单权限</label>
				            <div class="col-sm-8">
				                <div id="menuTrees_update" class="ztree"></div>
				            </div>
				        </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">请求地址</label>
							<div class="col-sm-10">
								<input type="text" name="url" class="form-control" id="url_update" placeholder="/oa/..."> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">菜单图标</label>
							<div class="col-sm-10">
								<input type="text" name="icon" class="form-control icon" onclick="openIcon_update()"
									id="icon" placeholder="点击选择"/> <span class="help-block"></span>
								<div id="iconDiv_update" style="max-height:150px;overflow-y:auto"></div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_permission">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增员工模态框 -->
	<div class="modal fade" id="menu_add_model" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加菜单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">菜单名称</label>
							<div class="col-sm-10">
								<input type="text" name="permName" class="form-control"
									id="permName" placeholder="请输入菜单名称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">父菜单</label>
							<div class="col-sm-10">
								<input id="parentId" name="parentId" type="text" hidden="hidden"/>
								
								<input type="text" name="parentName" class="form-control" onclick="selectMenuTree()"
									id="parentName" placeholder="点击选择"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group menuDiv" style="display: none">
				            <label class="col-sm-2 control-label">菜单权限</label>
				            <div class="col-sm-8">
				                <div id="menuTrees" class="ztree"></div>
				            </div>
				        </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">请求地址</label>
							<div class="col-sm-10">
								<input type="text" name="url" class="form-control"
									id="url" placeholder="/oa/..."> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">菜单图标</label>
							<div class="col-sm-10">
								<input type="text" name="icon" class="form-control icon" onclick="openIcon()"
									id="icon" placeholder="点击选择"/> <span class="help-block"></span>
									
								<!-- 加载图标框 -->
								<div id="iconDiv" style="max-height:150px;overflow-y:auto"></div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save_permission">保存</button>
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
						<button class="btn btn-primary btn-sm" id="permission_add">
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
							<input type="text" name="queryStr" id="queryStr" class="form-control"  placeholder="输入菜单"/>
						</div>
					</div>
					<section id="unseen">
					<table
						class="table table-hover table-striped"
						style="text-align: center;">
						<thead>
							<tr class="bg-primary">
								<th style="text-align: center;"><input type="checkbox" id="check_all"
									class="list-child"/></th>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">菜单名</th>
								<th style="text-align: center;">请求地址</th>
								<th style="text-align: center;">上级菜单</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody id="permissionData">
							
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
	<script src="/oa/assets/lay/modules/layer.js"></script>
	<script src="/oa/assets/js/bootstrap.min.js"></script>
	<script src="/oa/assets/ztree/jquery.ztree.all-3.5.min.js"></script>
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
				url : "/oa/system/permissionList",
				data : {
					"pageNo=": 1,
					"queryStr":queryStr
				},
				type : "get",
				success : function(result) {
					//alert(result);
					//显示权限信息
					create_permission_table(result);
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
				url : "/oa/system/permissionList",
				data : {
					"pageNo=": 1,
					"queryStr":queryStr
				},
				type : "get",
				success : function(result) {
					//alert(result);
					//显示权限信息
					create_permission_table(result);
					//显示记录数
					create_page_info(result);
					//显示分页导航
					create_nav_area(result);
				}
			});
		});
		
		function to_page(pn) {
			
			$.ajax({
				url : "/oa/system/permissionList",
				data :"pageNo="+pn,
				type : "get",
				success : function(result) {
					//alert(result);
					//显示部门信息
					create_permission_table(result);
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

		//构建权限列表
		function create_permission_table(result) {
			//清空table
			$("#permissionData").empty();
			var permissions = result.extend.pageInfo.list;
			if(permissions !=null){
				$
				.each(
						permissions,
						function(index, item) {
							//alert(item.deptName);
							var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
							var idTd = $("<td></td>").append(index + 1);
							var permNameTd = $("<td></td>").append(
									item.permName);
							/* var deptPIdTd = $("<td></td>").append(
									item.deptPId); */
							var urlTd = $("<td></td>").append(
									item.url);
							var parentIdTd = $("<td></td>").append(
									item.permission == null ? "":item.permission.permName);
							var editBtn = $("<button></button>")
									.addClass(
											"btn btn-primary btn-sm edit_btn")
									.append(
											$("<span></span>")
													.addClass(
															"glyphicon glyphicon-pencil"))
									.append("编辑");
							//为编辑按钮添加一个自定义属性，用于保存部门id	
							editBtn.attr("edit-id", item.permId);
							var delBtn = $("<button></button>")
									.addClass(
											"btn btn-danger btn-sm delete_btn")
									.append(
											$("<li></li>")
													.addClass(
															"fa fa-trash-o"))
									.append("删除");
							//为删除按钮添加一个自定义属性，用于保存部门id
							delBtn.attr("delete-id", item.permId);
							var btnTd = $("<td></td>").append(editBtn)
									.append(" ").append(delBtn);
							$("<tr></tr>").append(checkBoxTd).append(idTd)
									.append(permNameTd)
									.append(urlTd).append(
											parentIdTd).append(btnTd)
									.appendTo("#permissionData");
						});
			}else{
				$("<tr><td colspan='6'></td></tr>").append("没有数据!").appendTo("#permissionData");
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
		
		//添加员工
		$("#permission_add").click(function(){
			//重置表单，清除数据
			clear_form('#menu_add_model form');
			//显示模态框
			$("#menu_add_model").modal({
				backdrop:'static'
			});
		});
		
		//校验表单员工信息
		function validate_perm_form(){
			var permName=$('#permName').val();
			//alert(permName);
			if(permName == ""){
				valate_form_msg("#permName",'error',"菜单名称不能为空");
				return false;
			}else{
				valate_form_msg("#permName",'success',"");
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
		
		/* ----添加--生成树------- */
		var tree = {
			        initMenuTree: function () {
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
			                            //当前节点的父节点id属性 
			                            //pIdKey: "pItemId",
			                            //用于修正根节点父节点数据，即pIdKey指定的属性值
			                            //rootPId: 0
			                        }
			                    },
			            		/* async: {
					    			enable: true,
					    			url:"/oa/system/loadPermission",
					    			autoParam:["permId", "permName=n", "level=lv"]
					    		}, */
			                    view: {
			                        selectedMulti: false
			                    },
			                    callback: {
			                        onClick: tree.zTreeOnClick
			                    }

			                },
			                zTreeNodes = tree.initDeptData();
			            zTreeObj = $.fn.zTree.init($("#menuTrees"), setting,zTreeNodes);

			            //展开所有一级节点
			            var nodes = zTreeObj.getNodes();
			            for (var i = 0; i < nodes.length; i++) { //设置节点展开
			                zTreeObj.expandNode(nodes[i], true, false, true);
			            }
			        },
			        //生成树结构
			        initDeptData: function () {
			            var arr = new Array();
			            $.ajaxSettings.async = false;
			            $.post("/oa/system/loadPermission", {}, function (data) {
			                arr=data;
			           
			            })
			            return arr;
			        },
			        zTreeOnClick: function (event, treeId, treeNode) {
			           //alert(treeNode.permName);-----------------------这就是个坑
			            $("#parentName").val(treeNode.permName);
			            $("#parentId").val(treeNode.permId);
			            //alert(treeNode.permId);
			            //$("#icon").val(treeNode.icon);
			            $(".menuDiv").hide();
			            event.preventDefault();
			        }
		}
			
			/*菜单管理-新增-选择菜单树*/
		function selectMenuTree() {
		        //如果是可见的
		        if ($(".menuDiv").is(":visible"))
		        {
		            $(".menuDiv").hide();
		        }
		        else
		        {
		            $(".menuDiv").show();
		        }
		        tree.initMenuTree();
		}
		
		//----------------获取图标--------------------
		function openIcon(){
			//如果是可见的
	        if ($("#iconDiv").is(":visible"))
	        {
	            $("#iconDiv").hide();
	        }
	        else
	        {	
	        	$("#iconDiv").load("/oa/views/system/icon.html");
	            $("#iconDiv").show();
	        }
			
		}
		
		//------------校验菜单名名是否存在-----------------
		$("#parentName").blur(function(){
			var parentId = 0;
			parentId = $("#parentId").val();
			var permName = "";
			permName = $("#permName").val();
			
			if(permName == ""){
				alert(permName);
				valate_form_msg("#permName",'error',"菜单名称不能为空");
				return false;
				
			}
			if(parentId == null || parentId == ""){
				parentId = 0;
			}
			$.ajax({
				url: "${pageContext.request.contextPath}/system/checkPermName",
				type: "post",
				data: {
					"parentId":parentId,
					"permName":permName
				},
				success:function(result){
					if(result.stateCode==1){
						valate_form_msg("#permName",'success',"菜单名称可用");
						$("#save_permission").attr("ajax-va","success");
					}else if(result.stateCode==0){
						valate_form_msg("#permName",'error',result.message);
						$("#save_permission").attr("ajax-va","error");
					}
				}
			});
		});
		
		//----------------保存菜单操作-----------------
		$("#save_permission").click(function(){
			//1、对表单进行校验
			if(!validate_perm_form()){
				return false;
			}
			//判断菜单名是否可用
			if($(this).attr("ajax-va")=="error"){
				return false;
			}
			//3、发送请求你保存
			$.ajax({
				url: "/oa/system/savePermission",
				type: "get",
				data: $('#menu_add_model form').serialize(),
				success:function(result){
					if(result.stateCode==0){
						//alert(result.message);
					}else if(result.stateCode==1){
						//关闭模态框
						$('#menu_add_model').modal('hide');
						//显示添加的员工，即到最后一页,传一个最大的数就可以保证到最后一页，后台对数做了相应的处理
						to_page(totalRecords);
					}
				}
			});
		});
		
		//菜单添加
		$("#permission_add").click(function() {
			//重置表单，清除数据
			 clear_form('#menu_add_model form');
			//显示模态框
			$("#menu_add_model").modal({
				backdrop : 'static'
			});
		});
		
		/*--------------------修改菜单----------------- */
		/* ----添加--生成树------- */
		var treee = {
		        initMenuTree: function () {
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
		                            //当前节点的父节点id属性 
		                            //pIdKey: "pItemId",
		                            //用于修正根节点父节点数据，即pIdKey指定的属性值
		                            //rootPId: 0
		                        }
		                    },
		                    view: {
		                        selectedMulti: false
		                    },
		                    callback: {
		                        onClick: treee.zTreeOnClick
		                    }

		                },
		                zTreeNodes = treee.initDeptData();
		            zTreeObj = $.fn.zTree.init($("#menuTrees_update"), setting,zTreeNodes);

		            //展开所有一级节点
		            var nodes = zTreeObj.getNodes();
		            for (var i = 0; i < nodes.length; i++) { //设置节点展开
		                zTreeObj.expandNode(nodes[i], true, false, true);
		            }
		        },
		        //生成树结构
		        initDeptData: function () {
		            var arr = new Array();
		            $.ajaxSettings.async = false;
		            $.post("/oa/system/loadPermission", {}, function (data) {
		                arr=data;
		           
		            })
		            return arr;
		        },
		        zTreeOnClick: function (event, treeId, treeNode) {
		           //alert(treeNode.permName);-----------------------这就是个坑
		            $("#parentName_update").val(treeNode.permName);
		            $("#parentId_update").val(treeNode.permId);
		            //alert(treeNode.permId);
		            //$("#icon").val(treeNode.icon);
		            $(".menuDiv_update").hide();
		            event.preventDefault();
		        }
		    }
		
		/*菜单管理-新增-选择菜单树*/
	    function selectMenuTree_update() {
	        //如果是可见的
	        if ($(".menuDiv_update").is(":visible"))
	        {
	            $(".menuDiv_update").hide();
	        }
	        else
	        {
	            $(".menuDiv_update").show();
	        }
	        treee.initMenuTree();
	    }
		
		//----------------获取图标--------------------
		function openIcon_update(){
			//如果是可见的
	        if ($("#iconDiv_update").is(":visible"))
	        {
	            $("#iconDiv_update").hide();
	        }
	        else
	        {	
	        	$("#iconDiv_update").load("/oa/views/system/icon.html");
	            $("#iconDiv_update").show();
	        }
			
		}
		//通过这个方法才能找到后添加的元素
		$(document).on("click",".edit_btn",function(){
			//1.得到部门
			getPermission($(this).attr("edit-id"));
			//把菜单id传给更新按钮
			$("#update_permission").attr("edit-id",$(this).attr("edit-id"));
			//打开更新模态框
			$("#menu_update_model").modal({
				backdrop:'static'
			});
		});
		//通过id获取菜单
		function getPermission(id){
			$.ajax({
				url: "/oa/system/getPermission?id="+id,
				type: "GET",
				success:function(result){
					var permission=result.extend.permission;
					$("#permId_update").val(permission.permId);
					$('#permName_update').val(permission.permName);
					$('#parentId_update').val(permission.parentId);
					$('#parentName_update').val(permission.permission == null ? "":permission.permission.permName);
					$('#url_update').val(permission.url);
					$('#icon').val(permission.icon);
				}
			});
		}
		
		//--------------更新菜单-----------------------------
		$('#update_permission').click(function(){
			var permName=$('#permName_update').val();
			//alert(permName);
			if(permName == ""){
				valate_form_msg("#permName_update",'error',"菜单名称不能为空");
				return false;
			}else{
				valate_form_msg("#permName_update",'success',"");
			}
			$.ajax({
				url: "/oa/system/updatePermission",
				type: "post",
				data: $("#menu_update_model form").serialize(),			
				success:function(result){
					//关闭对话框
					$("#menu_update_model").modal('hide');
					//回到当前页
					to_page(currentPage);
				}
			});
		});
		
		//删除部门
		$(document).on("click",".delete_btn",function(){
			//1、获得当前菜单的名字
			var permName=$(this).parents('tr').find('td:eq(2)').text();
			var parentId = $(this).attr("delete-id");
			//alert(deptId);
			layer.alert('酷毙了', {icon: 1});
			if(confirm("确定删除【"+permName+"】吗")){
				//发送请求删除
				$.ajax({
					url: "/oa/system/deleterPermission/"+parentId,
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
		$("#perm_delete_all").click(function(){
			var permNames="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				permNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id') + "-";
			});
			if(del_id_strs == ""){
				alert("请选择要删除的菜单");
				return false;
			}
			//去除最后的那个,
			permNames=permNames.substring(0,permNames.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			//alert(del_id_strs);
			
			if(confirm("确定删除【"+permNames+"】吗?")){
				$.ajax({
					url: "/oa/system/deleterPermission/"+del_id_strs,
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
	</script>
</body>
</html>