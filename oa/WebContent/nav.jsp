<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	    $(function () {
	    	$.ajax({
					url: "/oa/system/permissionMenu",
					type: "post",		
					success:function(result){
						if(result.extend.permissions != null){
							var permissions = result.extend.permissions;
							var str="";
							$.each(permissions,function(index,item){
								var child = item.children;
								if(child == null){
									str +="<li class='sub-menu'><a href='javascript:;'>";
									str	+="<i class='"+item.icon+"'></i><span>"+item.permName+"</span></a></li>";
								}else if(child!=null){
									str +="<li class='sub-menu'><a href='javascript:;'>";
									str	+="<i class='"+item.icon+"'></i><span>"+item.permName+"</span></a>";
									var permissionChildren = item.children;
									str +="<ul class='sub'>";
									$.each(permissionChildren,function(index,it){
										str +=" <li><a href='"+it.url+"'>"+it.permName+"</a></li>" ;
									})
									str +="</ul></li>";
								}
							})
							//alert("--"+str);
							$("#nav-accordion").append(str);
						}
						
					}
			});
	    });
	</script>
</head>
<body>
<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box" >
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
           <!--  <img alt="" src="/oa/images/logo.png" width=100px height=50px style="margin:5px 0px 0 0;"> -->
            <a href="#" class="logo"><b>OA系统</b></a>
            <!--logo end-->
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu" style="margin-right:30px;">
            		<li style="color:white;font-size: 16px;font-weight: 800;">
            		<h4 class="centered dropdown" >${sessionScope.user.name}  &nbsp; <span class="fa fa-caret-down dropdown-toggle" data-toggle="dropdown"></span>
              	  		<ul class="dropdown-menu">
	              	  		<li><a href="/oa/user/toupdatePassword">修改密码</a></li>
	              	  		<li><a href="/oa/user/changeHead">修改头像</a></li>
	              	  		<li><a href="/oa/user/outLogin">退出</a></li>
              	  		</ul>
              	  </h4>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- MAIN SIDEBAR MENU -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#"><img src="/oa/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered dropdown" >${sessionScope.user.name} </h5>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <script type="text/javascript">
      	$(function(){
      		$(document).on("click",".sub-menu",function(){
      			if ( $(this).find("ul") ) { // 3 li
     				$(this).toggleClass("sub");
     				if ( $(this).hasClass("sub") ) {
     					$("ul", this).hide("normal");
     				} else {
     					$("ul", this).show("fast");
     				}
     			}
      		})
      	});
      	
      	/* $(document).on("click",".sub>li>a",function(){
      		alert();
      		var url = $(this).attr('href')
      		$("").load("");
      	}) */
     </script>
</body>
</html>