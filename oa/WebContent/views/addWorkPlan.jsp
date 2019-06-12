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
	<title>添加工作计划</title>
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
            <%@include file="nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
	          <div class="row mt">
	          		<div class="col-md-12"style="margin-top:40px;">
                  		<div style="background:#fff; height:900px;">
                      		<div class="content-panel"style="box-shadow:0px 3px 2px #fff">
                      			<div class="panel panel-default" style="border:none;margin-top:20px;height:70px;">
		    						<div class="panel-body" style="border:none;height:80px;">
			                          	<div class="col-xs-6 col-sm-3" style="border:none;float:left;">
					                  	  	 <a href="bulletinManage.jsp">
					                  	  	  <button type="button" class="btn btn-info"  style="background:#fff;">
							                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
							                  	  	  返回上一级</span>
					                  	  	  </button>
					                  	  	 </a>
				                  	  	</div>
		                            </div>	
	                            </div>
	                            <form class="form-horizontal style-form" method="get" style="margin-top:20px;">
	                            	
	                            	
	                            	
	                            	<div class="form-group" style="border:none;margin-top:30px;">
			                              <label class="col-sm-3 col-sm-3 control-label" style="color: rgb(0, 0, 0);text-align:right;font-size: 18px;">类型:</label>
				                          <div class="col-sm-7" style="margin-top:7px;text-align:center;"> 
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="0" checked>日计划
				                              	</label>
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="1">周计划
				                              	</label>	
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="2">月计划
				                              	</label>
				                              </div>
				                              <div class="col-sm-2" style="margin-top:7px;text-align:center;">
				                              	<label style="font-size:15px;color: rgb(0, 0, 0);">
				                                   <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="2">年计划
				                              	</label>
				                              </div>
				                           </div>
			                         </div>
			                        
			                        
			                        
			                        
			                         <div class="form-group" style="border:none;">
			                              <label class="col-sm-3 col-sm-3 control-label" style="color: rgb(0, 0, 0);text-align:right;font-size: 18px;">内容:</label>
				                              <div class="col-sm-6">
				                                  <textarea class="form-control" rows="18"></textarea>
				                              </div>
			                         </div>
			                         
			                         
			                         
			                         
			                         
			                         <div class="form-group" style="border:none;margin-top:30px;">
				                              <div class="col-sm-4" style="float:left; text-align:right;">
					                              <a href="bulletinManage.jsp">
							                  	  	  <button type="button" class="btn btn-info"  style="background:#fff;">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  完成</span>
							                  	  	  </button>
						                  	  	  </a>
				                              </div>
				                              <div class="col-sm-6" style="float:left;text-align:center;">
					                              <a href="bulletinManage.jsp">
							                  	  	  <button type="button" class="btn btn-info"  style="background:#fff;">
									                  	  <span style="color: rgb(0, 0, 0); font-size: 14px; text-shadow: rgb(255, 0, 0) 0px 0px 0px;"> 
									                  	  	  取消</span>
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
</body>
</html>