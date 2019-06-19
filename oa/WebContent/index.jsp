<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Oa, SSM, Admin">

    <title>index</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/oa/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="/oa/assets/css/style.css" rel="stylesheet">
    <link href="/oa/assets/css/style-responsive.css" rel="stylesheet">
    <script src="/oa/assets/jquery-2.1.0.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
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
  <body>

  <section id="container" >
     
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
      
      <!-- ***************************************
      *******************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="/oa/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered" style="margin-bottom:30px;">金咏琪</h5>
              	  	
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
     <!--  <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div> -->
      <!--main content start-->
      <section id="main-content" style="margin-left:210px;">
         <!--  <section class="wrapper" id="bodyContent" >

          </section> -->
      </section>

      <!--main content end-->
      <!--footer start-->
      <!-- <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer> -->
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <!-- <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/js/jquery-1.8.3.min.js"></script> -->
    <script src="/oa/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/oa/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/oa/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/oa/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="/oa/assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="/oa/assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="/oa/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="/oa/assets/js/gritter-conf.js"></script>

    <!--script for this page-->
	<script src="/oa/assets/js/zabuto_calendar.js"></script>	
	
	<script type="text/javascript">
        $(document).ready(function () {
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Welcome to Dashgum!',
            // (string | mandatory) the text inside the notification
            text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
            // (string | optional) the image to display on the left
            image: 'assets/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false;
        });
        
        $(function(){
        	$("#main-content").load("/oa/userpower/findUser");
        	
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
        
        $(document).on("click",".sub>li>a",function(){
      		alert();
      		var url = $(this).attr('href');
      		$("#bodyContent").load("/oa/system/deptPage");
      	})
	</script>
  </body>
</html>
