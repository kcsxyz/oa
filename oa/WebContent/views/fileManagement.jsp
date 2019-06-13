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
	<title>文件管理</title>
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
                         <form class="form-horizontal style-form" method="get" action="${pageContext.request.contextPath }/files/findAll" style="margin-top:10px;text-align:center;">
			                 <div class="form-group" style="border:none;margin-top:10px;">
                          	<div class="col-xs-6 col-sm-4" style="float:left;">
		                  	  	  <button type="button" class="btn btn-info" id="uploadBtn" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-plus" style="color: rgb(0, 0, 255); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  上传文件</span>
		                  	  	  </button> 	  
		                  	  	  <button type="button" class="btn btn-danger" id="files_delete_all" style="background:#fff;">
			                  	  	  <span class="glyphicon glyphicon-trash" style="color: rgb(255, 0, 0); font-size: 10px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
			                  	  	  删除</span>
		                  	  	  </button>
	                  	  	</div>
	                  	  	
	                  	  	
	                  	  	
	                  	  	<div class="col-xs-6 col-sm-8" style="float:left;">
		                  	  	  <span style="font-weight:bold;font-size:10px;float:left;margin-right:3px;height:28px;text-align:center;line-height:28px;">创建时间：</span>
				                  	  	  <input type="text" class="form-control round-form" name="dateStart" id="startTime" placeholder="起始时间" style="width:30%;height:28px;float:left;">
				                  	  	 
				                  	  	  <span style="color: rgb(0, 0, 0);float:left;height:28px;text-align:center;line-height:28px;
				                  	  	  font-size: 24px; margin-left:3px;margin-right:3px;text-shadow: rgb(255, 0, 0) 0px 0px 0px;">
										  -
										  </span> 
										  
				                  	  	  <input type="text" class="form-control round-form" name="finalTime" id="startTime" placeholder="终止时间" style="width:30%;height:28px;">
	                  	  	</div>
	                  	  	
	                  	  	
	                  	  	
	                  	  	 
						      
	                  	  	  <div class="col-xs-6 col-sm-3" style="float:left;">
                              		<input type="text" class="form-control" name="Info" style="width:60%;height:28px;float:left;">
                              		
                              		<button type="submit" class="btn btn-round btn-warning" style="height:28px;text-align:center;line-height:28px;">
                              		<span class="glyphicon glyphicon-search" style="color: rgb(255,255,255); font-size: 12px;
                              		 text-shadow: rgb(255,255,255) 0px 0px 0px; ">&nbsp;搜索</span>
                              		</button>
                              			
                              </div>
                              
                              
                             </div>	
                           </form>
                           <!-- 上部放按钮的地方结束-->
                           
                           
                           
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="uploadModel" tabindex="-1" role="dialog" aria-labelledby="uploadModelLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header" style="text-align:center;">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
											&times;
										</button>
										<h4 class="modal-title upload" id="uploadModelLabel">
											文件上传
										</h4>
									</div>
									<form class="form-horizontal style-form"  method="post" action="${ pageContext.request.contextPath }/files/upload" enctype="multipart/form-data" onSubmit="return myCheck(this)" >
									<div class="modal-body">
					                           <div class="form-group" style="border:none;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">名称:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" id="fileId" name="fileId" class="form-control">
						                                    <span class="help-block"></span>
						                              </div>
						                              <div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
			                              				  <font id="showResult1" style="color:red">*</font>
			                              			  </div>
			                              			 
			                              			 
					                          </div> 
					                         
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">选择文件:</span>
						                              <div class=" col-sm-8">
									                    <input id="lefile" type="file" name="file"   style="display:none">
															<div class="input-append">
																<input id="photoCover"  readonly="readonly" class="input-large" type="text" style="width:62%;height:30px;">
																	<a class="btn" onclick="$('input[id=lefile]').click();">
																		<span class="btn btn-primary">
												                            <i class="glyphicon glyphicon-folder-open"></i>  
												                            Browse… 
												                        </span>
											                        </a>
											                         <div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
							                              				  <font id="showResult2" style="color:red"></font>
							                              			  </div>
							                              			  
															</div>
									                    </div>
					                          </div>
					                          
					                          <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">文件描述:</span>
						                              <div class="col-sm-8">
						                                  <input type="text" name="descr" class="form-control">
						                              </div>
						                              <div class="col-sm-2" style="text-align:left;padding:0;height:32px;line-height:32px;">
							                              				  <font id="showResult3" style="color:red"></font>
							                              			  </div>
						                             
					                          </div>
					                          
					                           <div class="form-group" style="border:none;margin-top:30px;">
					                              <span class="col-sm-2" style="color:#000;font-size:16px;float:left;height:28px;text-align:right;line-height:28px;">关联项目</span>
						                              <div class="col-sm-8">
						                                  <select class="form-control" name="project" id="select_add_project">
													</select>
						                              </div>
					                          </div>
					                          
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-round btn-default" data-dismiss="modal">取消
										</button>
										<button type="submit" id="btn_push_files" class="btn btn-round btn-primary">
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
                              	  <th style="text-align:center;"><input type="checkbox" class="list-child" value="" id="check_all"  /></th>
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
                              <c:forEach items="${pageInfo.list }" var="page">
                              <tr>
                                  <td style="text-align:center;"><input type="checkbox" class="list-child check_item" value=""  /></td>
                                  <td style="text-align:center;">${page.fileId }</td>
                                  <td style="text-align:center;">${page.fileName }</td>
                                  <td style="text-align:center;">${page.fileType }</td>
                                  <td style="text-align:center;">${page.uploadUser }</td>
                                  <td style="text-align:center;">${page.projects.projectName }</td>
                                  <td style="text-align:center;"><fmt:formatDate value='${page.createTime }' type='date' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                                  <td style="text-align:center;">
                                  <!-- 你根据原型图修改操作的地方 -->
                                      <a href="${ pageContext.request.contextPath }/files/download?file=${page.fileName}.${page.fileType}"><button id="downloadBtn"  p-id="${page.fileId }" class="btn btn-primary btn-xs"><i class="fa fa-download"></i>下载</button></a>
                                      <a href="${pageContext.request.contextPath }/files/deleteFile/${page.fileId }"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i>删除</button></a>
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
								  	<li><a href="${ pageContext.request.contextPath }/files/findAll?pageNo=1">首页</a></li>
								    <li>
								    	<c:if test="${pageInfo.hasPreviousPage}">
								    		<a href="${ pageContext.request.contextPath }/files/findAll?pageNo=${pageNum-1}" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</c:if>
								    </li>
								    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								    	<c:if test="${page_num ==pageInfo.pageNum}">
								    		<li class="active"><a href="#">${page_num}</a></li>
								    	</c:if>
								    	<c:if test="${page_num != pageInfo.pageNum}">
								    		<li><a href="${ pageContext.request.contextPath }/files/findAll?pageNo=${page_num}">${page_num}</a></li>
								    	</c:if>
								    </c:forEach>
								    <li>
								   		<c:if test="${pageInfo.hasNextPage}">
								    		<a href="${ pageContext.request.contextPath }/files/findAll?pageNo=${pageNum+1}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								    	</c:if>
								     
								    </li>
								    <li><a href="${ pageContext.request.contextPath }/files/findAll?pageNo=${pageInfo.pages}">末页</a></li>
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
    	
//---------------------打开模态框--------------------
    function clear_form(ele){
			//重置内容
			$(ele)[0].reset();
			//移除添加的雷和文本
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}

	 function create_dept(ele){
			$(ele).empty();
			//获取部门
			$.ajax({
				url: "${pageContext.request.contextPath}/files/projectList",
				type: "get",
				success:function(result){
					$.each(result.extend.projects,function(){
						var optionEl=$("<option></option>").append(this.projectName).attr("value",this.projectId);
						optionEl.appendTo("#select_add_project");
					});
				}
			});
		}
			$("#uploadBtn").click(function(){
				//重置表单，清除数据
				clear_form('#uploadModel form');
				//获取部门
				create_dept("#select_add_project");
				//显示模态框
				$("#uploadModel").modal({
					backdrop:'static'
				});
			});
		  		
    	/* $("#uploadBtn").click(function(){
    		$("#select_add_project").empty();
			//获取项目
			$.ajax({
				url: "${pageContext.request.contextPath}/files/projectList",
				type: "get",
				success:function(result){
					$.each(result.extend.projects,function(){
						var optionEl=$("<option></option>").append(this.projectName).attr("value",this.projectId);
						optionEl.appendTo("#select_add_project");
					});
				}
			}); 
		$("#uploadModel").modal({
				backdrop:"static"
			});
		}); */
//--------------------提交表单信息----------------------
  $("#fileId").blur(function(){
        var data = $("#fileId").val();
        if (data == null || data == "") {
            $("#showResult1").text("此项必填!");
            /* $("#showResult1").css("color","red"); */
            return false;
        }else{
        	 $("#showResult1").text("");
        }
    });
  $("#photoCover").blur(function(){
      var data = $("#photoCover").val();
      if (data == null || data == "") {
          $("#showResult2").text("此项必填!");
          /* $("#showResult1").css("color","red"); */
          return false;
      }else{
      	 $("#showResult2").text("");
      }
  });
  
  $("#descr").blur(function(){
      var data = $("#descr").val();
      if (data == null || data == "") {
          $("#showResult3").text("此项必填!");
          /* $("#showResult1").css("color","red"); */
          return false;
      }else{
      	 $("#showResult3").text("");
      }
  });

 
  function myCheck(form){
	  if(form.fileId.value==''|| form.fileId.value==null){
	  alert('名称不能为空!');
	  form.fileId.focus();
	  return false;
	  }
	  if(form.photoCover.value==''||form.photoCover.value==null){
	  alert('文件为空!');
	  form.photoCover.focus();
	  return false;
	  }
	  if(form.descr.value=='' || form.descr.value==null){
	  alert('请输入文件描述');
	  form.descr.focus();
	  return false;
	  }if($("#fileId").attr("ajax-va")=='error'){
		  alert('请输入正确格式');
		 // form.descr.focus();
		  return false;
	  } else{
		  alert("上传成功");
		  return true;
	  }
	 
   
    
  }
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
	

	//校验名是否存在
	$("#fileId").change(function(){
		var fileId=this.value;
		$.ajax({
			url: "${pageContext.request.contextPath}/files/checkfileId",
			type: "post",
			data: "fileId="+fileId,
			success:function(result){
				if(result.stateCode==1){
					valate_form_msg("#fileId",'success',result.message);
					$("#fileId").attr("ajax-va","success");
				}else if(result.stateCode==0){
					valate_form_msg("#fileId",'error',result.message);
					$("#fileId").attr("ajax-va","error");
				}
			}
		});
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
		$("#files_delete_all").click(function(){
			var files="";
			var del_id_strs="";
			$.each($(".check_item:checked"),function(){
				//alert(del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('edit-id'));
				files += $(this).parents("tr").find("td:eq(2)").text() + ",";
				del_id_strs += del_id_strs = $(this).parents("tr").find("td:last").find("button").attr('p-id') + "-";
			});
			
			//去除最后的那个,
			files=files.substring(0,files.length-1);
			del_id_strs=del_id_strs.substring(0,del_id_strs.length-1);
			if(del_id_strs == ""){
				alert("请选择要删除的公告");
				return false;
			}
			alert(del_id_strs);
			if(confirm("确定删除【"+files+"】吗?")){
				$.ajax({
					url: "${pageContext.request.contextPath }/files/deleteFile/"+del_id_strs,
					type: "post",		
					success:function(result){
						//关闭对话框
						//alert(result.stateCode);
						//回到当前页
						window.location.href="${pageContext.request.contextPath }/files/findAll";
					}
				});
			}

		});
		
	</script>
</body>
</html>