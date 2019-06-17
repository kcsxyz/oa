<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title></title>

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
	<script src="/oa/assets/jquery-2.1.0.min.js"></script>
    <script src="/oa/assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	 <script type="text/javascript">
	    	$(function(){
	    		$.ajax({
					url: "/oa/system/permissionMenu",
					type: "post",		
					success:function(result){
						if(result.extend.permissions != null){
							var permissions = result.extend.permissions;
							var str="";
							$.each(permissions,function(index,item){
								var child = item.children;
								//alert(child);
								if(child == null){
									str +="<li class='sub-menu'><a href='javascript:;'>";
									str	+="<i class='"+item.icon+"'></i><span>"+item.permName+"</span></a></li>";
									//alert(str);
								}else if(child!=null){
									str +="<li class='sub-menu'><a href='javascript:;'>";
									str	+="<i class='"+item.icon+"'></i><span>"+item.permName+"</span></a>";
									var permissionChildren = item.children;
									//alert(permissionChildren);
									str +="<ul class='sub'>";
									$.each(permissionChildren,function(index,it){
										str +=" <li><a  href='"+it.url+"'>"+it.permName+"</a></li>" ;
									})
									str +="</ul></li>";
									
								}
							})
							alert("--"+str);
							$("#nav-accordion").append(str);
						}
						
					}
				});
	    	})
	   </script>
</head>
<body>
<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box" >
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>OA系统</b></a>
            <!--logo end-->
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="/oa/user/outLogin">logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="images/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">金咏琪</h5>
              	  
                  <li class="sub-menu"><!-- mt -->
                      <a href="index.jsp">
                          <i class="fa fa-dashboard"></i>
                          <span>主页</span>
                      </a>
                  </li>

                  <!-- <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>个人办公</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="workLog.jsp">工作日志</a></li>
                          <li><a  href="workPlan.jsp">工作计划</a></li>
                          <li><a  href="personalDiary.jsp">个人日程</a></li>
                          <li><a  href="personalMailList">个人通讯录</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>部门办公</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="calendar.html">考勤管理</a></li>
                          <li><a  href="calendar.html">人力资源管理</a></li>
                          <li><a  href="calendar.html">项目管理</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>信息更新</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="bulletinManage.jsp">信息管理</a></li>
                          <li><a  href="planAudit.jsp">计划审核</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>系统设置</span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a  href="basic_table.html">部门设置</a></li>
                          <li><a  href="responsive_table.html">用户设置</a></li>
                          <li><a  href="form_component.html">菜单设置</a></li>
                    
                      </ul>
                  </li>
                   <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>流程审批</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris.html">审批记录</a></li>
                      </ul>
                  </li> 

              </ul> -->
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      
</body>
</html>