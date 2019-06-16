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
    <link rel="stylesheet" type="text/css" href="/oa/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/oa/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/oa/assets/lineicons/style.css">    
    <link rel="stylesheet" type="text/css" href="/oa/css/index.css">
    <!-- Custom styles for this template -->
    <link href="/oa/assets/css/style.css" rel="stylesheet">
    <link href="/oa/assets/css/style-responsive.css" rel="stylesheet">
	<link href="/oa/assets/layui/css/layui.css" rel="stylesheet">
	<link href="/oa/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="/oa/css/index.css">
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
                      <!-- <div class="row mt" style=" height:380px;"> -->
                       <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb" style=" height:400px;">
                      		<div class="white-panel pn donut-chart" style="height:80%;">
                      			<div class="white-header" >
						  			<h5 >考勤管理</h5>
                      			</div>
                      					<div class="">
                      					<div id="currentDate"></div>
			                            <div class="WorkTime" align="left"><br>
			                                                                                                                 上午上班打卡时间：<br><span>7:00-8:00</span><br>
			
			                               	上午下班打卡时间：<br><span>11:40-12:30</span><br>
			
			                                                                                                                 下午上班打卡时间：<br><span>13:00-12:00</span><br>
			                                                                                                                下午 下班打卡时间：<br><span>15:30-6:00</span><br>
			                            </div>
			                        </div>
			                         <div class="lock">
			                            <img onclick="attend()" src="/oa/images/lock.png" class="img-circle">
			                           
			                            <div align="center" class="Attendtips">
			                                	签到时间：<span  id="attendTime">无</span>
			                            </div>
			                            <div align="center" id="isAttend" class="Attendtips">未签</div>
			                        </div>
	                      	</div>
                      	</div>
                      	<div class="col-md-4 col-sm-4 mb" style="height:400px;">
                      		<div class="white-panel pn" style="height:80%;">
                      			<div class="white-header" id="clander">
						  			<p>日程表</p>
                      			</div>
								<!-- <div class="row">
									
	                      		</div> -->
	                      		<div class="centered">
									<div class="calendar">
                    					<div id="calendar"></div>
                					</div>
	                      		</div>
                      		</div>
                      	</div>
                      	
						<div class="col-md-4 col-md-4 mb" style="height:400px;">
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
                                        
                    <div class="row" style="height:420px;">   
                      	<div class="col-md-4 col-sm-4 mb" style=" height:400px;">
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
	<script src="/oa/assets/jquery-2.1.0.min.js"></script>
	<script src="/oa/assets/layer/layer.js"></script>
	<script src="/oa/assets/layui/layui.js"></script>
	<script src="/oa/assets/js/bootstrap.min.js"></script>
	<script src="/oa/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/oa/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
    
    <!-- js placed at the end of the document so the pages load faster -->
    <!-- <script src="/oa/assets/jquery-2.1.0.min.js"></script>
    <script src="/oa/assets/js/jquery.js"></script>
    <script src="/oa/assets/layui/layui.js"></script>
    <script src="/oa/assets/layer/layer.js"></script>
    <script src="/oa/assets/js/bootstrap.min.js"></script> -->
	
    
<!--     <script class="include" type="text/javascript" src="/oa/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/oa/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/oa/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="/oa/assets/js/jquery.sparkline.js"></script> -->


    <!--common script for all pages-->
   <!--  <script src="/oa/assets/js/common-scripts.js"></script>
    <script type="text/javascript" src="/oa/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="/oa/assets/js/gritter-conf.js"></script>

    script for this page
    <script src="/oa/assets/js/sparkline-chart.js"></script>    
	<script src="/oa/assets/js/zabuto_calendar.js"></script>	 -->
	<script>

    //实时时间
    window.onload = function () {
        setInterval(function () {
            var date = new Date();
            var year = date.getFullYear(); //获取当前年份
            var mon = date.getMonth() + 1; //获取当前月份
            var da = date.getDate(); //获取当前日
            var day = date.getDay(); //获取当前星期几
            var h = date.getHours(); //获取小时
            var m = date.getMinutes(); //获取分钟
            var s = date.getSeconds(); //获取秒
            var week =['一','二','三','四','五','六','日'];
            var d = document.getElementById('currentDate');
            d.innerHTML ='当前时间：'+ year + '年' + mon + '月' + da + '日' + '星期 ' + week[day-1] +" " + h + ':' + m + ':' + s;
        }, 1000)
    }


    function isAttend() {
        $.post("/oa/attend/isAttend", {}, function (data) {
        	//alert(data);
            if (data != null && JSON.stringify(data).length > 2) {
            	alert(data);
                var time = timestampToTime(data);
                var date = time.substring(10, time.length);
                $("#attendTime").html(date);
                $("#isAttend").html('已签到');
            }
        })
    }
    isAttend();

    //点击打卡
    function attend() {
        //判断是否已经签到了
        $.post("/oa/attend/isAttend", {}, function (data) {
        	if(data!=null && data!=""){
        		layer.alert('您已签到', {icon: 1});
        		return ;
        	}
        	//layer.alert('酷毙了', {icon: 1});
            layer.confirm("是否签到？", {
                icon: 3,
                title: "系统提示",
                btn: ["确认", "取消"],
                btnclass: ["btn btn-primary", "btn btn-danger"]
            }, function (index) {
                layer.close(index);
                $.post("/oa/attend/addSave", {}, function (data) {
                    if (data.stateCode == 0) {
                      //layer.msg("已签到", {icon: 1, time: 500, shade: [0.1, "#8F8F8F"]});
                      layer.msg(data.message, {icon: 5});
                      isAttend();
                    } else if(data.stateCode == 1){
                    	layer.msg('签到成功！', {icon: 1});
                    }
                }).error(function (data) {
                    //$.modal.alertError("系统错误！");
                })
            })
        })
    }


    //查看通知信息
    function checkMeetMsg(id) {
        $.modal.openFull("会议详情", "/oa/editMeet/" + id);
    }

    //查看公告
    function checkNoticeMsg(id) {
        $.modal.openFull("公告详情", "/oa/editNotice/" + id);
    }

    //查看任务
    function checkTaskMsg(formKey, procInstId, taskId) {
        layer.open({
            type: 2,
            area: ["800px", ($(window).height() - 50) + "px"],
            fix: false,
            maxmin: true,
            shade: 0.3,
            title: "查看申请消息",
            content: "/task/edit/" + formKey + "/" + procInstId + "/" + taskId
        })
    }

    //查看便签
    function checkNoteMsg(id) {
        $.modal.open("修改便签", "/note/edit/" + id);
    }


    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //直接嵌套显示
        laydate.render({
            elem: '#calendar'
            , position: 'static'
            , showBottom: false
            , type: 'datetime'
            , format: 'yyyy-MM-dd HH:mm:ss'
            , calendar: true
            , theme: 'molv'
            , mark: getMapDates()
            , done: function (value, date, enddate) {
                var url = "/schedule/editMore/" + value;
                $.modal.open("日程查看", url);

            }
        });

        function getMapDates() {
            var map_ = new Map();
            $.ajaxSettings.async = false;
            $.post("/schedule/ajaxgetMap", {}, function (data) {
                map_ = data;
            })
            return map_;
        }
    });
    function timestampToTime(timestamp) {
		   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		   Y = date.getFullYear() + '-';
		   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		   D = date.getDate() + ' ';
		   h = date.getHours() + ':';
		   m = date.getMinutes() + ':';
		   s = date.getSeconds();
		   return Y+M+D+h+m+s;
}
</script>
	
  

  </body>
</html>
