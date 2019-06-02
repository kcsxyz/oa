<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>首页</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
            <%@include file="nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row" style="margin-top:40px; ">   
                      <div class="row mt" style=" height:380px;">
                       <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb" style=" height:400px;margin-left:10px;">
                      		<div class="white-panel pn donut-chart" style="height:80%;">
                      			<div class="white-header" >
						  			<h5 >考勤管理</h5>
                      			</div>
                      			<div class="row">
									
	                      		</div>
	                      		<div class="centered">
									
	                      		</div>
	                      	</div> <!--/grey-panel -->
                      	</div>
                      	<div class="col-md-4 col-sm-4 mb" style="height:400px;margin-right:5px;">
                      		<div class="white-panel pn" style="height:80%;">
                      			<div class="white-header">
						  			<h5>日程表</h5>
                      			</div>
								<div class="row">
									
	                      		</div>
	                      		<div class="centered">
									
	                      		</div>
                      		</div>
                      	</div>
                      	
						<div class="col-md-4 col-md-4 mb" style="width:420px; height:400px;margin-right:5px;">
							<!--  WHITE PANEL - TOP USER  -->
							<div class="white-panel pn" style="height:80%;">
								<div class="white-header">
									<h5>公告内容</h5>
								</div>
								<div class="row">
									
								</div>
							</div>
						</div>
                    </div> 
                    </div>
                                        
                    <div class="row" style="height:420px;">   
                      <div class="row mt">
                       <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb" style=" height:400px;margin-left:10px;">
                      		<div class="white-panel pn donut-chart" style="height:80%;">
                      			<div class="white-header" >
						  			<h5 >我的待办</h5>
                      			</div>
                      			<div class="row">
									
	                      		</div>
	                      		<div class="centered">
									
	                      		</div>
	                      	</div> <!--/grey-panel -->
                      	</div>
                      	<div class="col-md-4 col-sm-4 mb" style="height:400px;margin-right:5px;">
                      		<div class="white-panel pn" style="height:80%;">
                      			<div class="white-header">
						  			<h5></h5>
                      			</div>
								<div class="row">
									
	                      		</div>
	                      		<div class="centered">
									<img src="/oa/images/extent1.jpg"/>
	                      		</div>
                      		</div>
                      	</div>
                     </div>
                     </div>
					
					
					
                        <!-- CALENDAR-->
                        <!-- <div id="firstrow" >
                        	<div id="left1"></div>
                        </div> -->
                        <div id="calendar" class="mb">
                            <div class="panel green-panel no-margin">
                                <div class="panel-body">
                                    <div id="date-popover" class="popover top" style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                                        <div class="arrow"></div>
                                        <h3 class="popover-title" style="disadding: none;"></h3>
                                        <div id="date-popover-content" class="popover-content"></div>
                                    </div>
                                    <div id="my-calendar"></div>
                                </div>
                            </div>
                        </div><!-- / calendar 
                      
                  </div><!-- /col-lg-3 -->
          </section>
      </section>

      <!--main content end-->
      <!--footer start
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	<!-- <script type="text/javascript">
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
	</script> -->
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>
