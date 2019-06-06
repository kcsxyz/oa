<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>修改密码</title>
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
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>
<body>
<section id="container" >
            <%@include file="/nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
	          <div class="row mt">
	          		<div class="col-md-12"style="margin-top:40px;">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
	                            <form class="form-horizontal style-form" method="get" style="margin-top:80px;">
	                            
	                            
	                            
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">旧密码:</span>
				                              <div class="col-sm-3">
				                                  <input type="text" name="title" class="form-control">
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">新密码:</span>
				                              <div class="col-sm-3">
				                                  <input type="text" name="title" class="form-control">
				                              </div>
			                          </div>
			                          <div class="form-group" style="border:none;margin-top:30px;">
			                              <span style="width:38%;color:#000;font-size:15px;float:left;height:28px;text-align:right;line-height:28px;">确认密码:</span>
				                              <div class="col-sm-3">
				                                  <input type="text" name="title" class="form-control">
				                              </div>
			                          </div>
			                          
			                          
			                          
			                          
			                          <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-4" style="float:left; text-align:right;margin-left:30px;">
					                              
					                              <a href="">
							                  	  	  
							                  	  	  <button type="button" class="btn btn-round btn-default">
								                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
								                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;确认&nbsp;&nbsp;&nbsp;&nbsp;</span>
					                  	  	  	 	  </button>
						                  	  	  </a>
				                              </div>
				                              <div class="col-sm-2" style="float:left; text-align:center;margin-left:30px;">
					                              <a href="bulletinManage.jsp">
							                  	  	  <button type="button" class="btn btn-round btn-default">
								                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
								                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp;</span>
					                  	  	  	 	  </button>
						                  	  	  </a>
				                              </div>
				                              <div class="col-sm-2" style="float:left; text-align:center;">
					                              <a href="bulletinManage.jsp">
							                  	  	  <button type="button" class="btn btn-round btn-default">
								                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
								                  	  	  &nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;</span>
					                  	  	  	 	  </button>
						                  	  	  </a>
				                              </div>
			                          </div>
			                    
			                    
			                    
			                    
			                    
			                    </form>
                      		</div>
                      	</div>
                    </div>
	          </div>
          </section>
      </section>
</section>
 	<!-- js placed at the end of the document so the pages load faster --> 
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
	<script type="text/javascript">
		$(function(){
		
		    /*鼠标点击下去的时候，决定是否选中*/
		    $("#myradio").bind("mousedown",function(event){
		         var radioChecked = $(this).prop("checked");
		         $(this).prop('checked', !radioChecked);
		        return false;
		    });
		
		    /*阻止click事件默认行为*/
		    $("#myradio").click(function(event){
		        return false;
		    });
		
		});
	</script>
</body>
</html>