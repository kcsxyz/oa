<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="/oa/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/oa/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
    <style type="text/css">
    	#notice li{
    		text-align:none;
    		list-style:disc;
    		margin-top:5px;
    		font-size: 15px;
    	}
    	#noticeBody{
    		position: relative;
    	}
    	#notice>li>div{
    		float:right;
    		margin-right:25px;
    		font-family: "Microsoft YaHei";
			
    	}
    	#notice>li>div>span{
    		text-align:left;
    	}
    </style>
  </head>
  <body>
	<!-- 公告模态框 -->
	<div class="modal fade" id="noticeContent" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">信息详情</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">标题
							</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="noticeTitle"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">发布时间</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="noticeTime"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">发布人</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="noticeName"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="noContent"></p>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
  <section id="container" >
            <%@include file="../nav.jsp" %>
       <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row" style="margin-top:40px; ">   
                      <!-- <div class="row mt" style=" height:380px;"> -->
                       <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb" style=" height:400px;">
                      		<div class="white-panel pn donut-chart" style="height:80%;">
                      			<div class="white-header">
						  			<h5 >考勤管理</h5>
                      			</div>
                      					<div class="">
                      					<div id="currentDate"></div>
			                            <div class="WorkTime" align="left"><br>
			                                                                                                                 上午上班打卡时间：<br><span id="morStart"></span><br>
			
			                               	上午下班打卡时间：<br><span id="morEnd"></span><br>
			
			                                                                                                                 下午上班打卡时间：<br><span id="noonStart"></span><br>
			                                                                                                                下午 下班打卡时间：<br><span id="noonEnd"></span><br>
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
								<div class="row" id="noticeBody" style="text-align: justify;margin-left:40px;">
									<ul id="notice">
										<li ><a>yuyu</a><div><span>2019-10-18</span></div></li>
									</ul>
								</div>
							</div>
						</div>
                    </div> 
                                        
                    <div class="row" style="height:420px;">   
                      	<!-- <div class="col-md-4 col-sm-4 mb" style=" height:400px;">
                      		<div class="white-panel pn donut-chart" style="height:80%;">
                      			<div class="white-header" >
						  			<h5 >我的待办</h5>
                      			</div>
                      			<div class="row">
									
	                      		</div>
	                      		<div class="centered">
									
	                      		</div>
	                      	</div>
                      	</div> -->
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

	<script>
	$(function(){
		$.ajax({
			url : "/oa/attend/worktime",
			type : "post",
			success : function(result) {
				if(result.stateCode==1){
					var workTime = result.extend.workTime;
					$("#morStart").text(timestamp(workTime.attendMorStartTime)+"-"+timestamp(workTime.attendMorEndTime));
					$("#morEnd").text(timestamp(workTime.attendMorLeaveStartTime)+"-"+timestamp(workTime.attendMorLeaveEndTime));
					$("#noonStart").text(timestamp(workTime.attendAfternoonStartTime)+"-"+timestamp(workTime.attendAfternoonEndTime));
					$("#noonEnd").text(timestamp(workTime.attendAfterLeaveStartTime)+"-"+timestamp(workTime.attendAfterLeaveEndTime));
				}
			}
		});
	})
	
	$(function(){
		$("#notice").empty();
		$.ajax({
			url : "/oa/notice/findByNearTime",
			type : "post",
			success : function(result) {
					var notices = result.extend.findByNearTime;
					var str ="";
					$.each(notices,function(index,item){
						str +="<li><a class='noti' href='#' id='"+item.noticeId+"'>"+item.title+"</a><div><span>"+timestampToTime(item.createTime)+"</span></div></li>";
					})
					$("#notice").append(str);
			}
		});
	})
	
	
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
            	//alert(data);
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
                    	isAttend();
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
            $.post("/oa/schedule/allSchedulelist", {}, function (data) {
                map_ = data;
            })
            return map_;
        }
    });
    
    //查看公告
    $(document).on("click",".noti",function(){
    	var id=$(this).attr("id");
    	$.ajax({
			url : "/oa/notice/findByNearTimeId/"+id,
			type : "post",
			success : function(result) {
					var notice = result.extend.noticeFindById;
					$("#noticeTitle").text(notice.title);
					$("#noticeTime").text(timestampToTime(notice.createTime));
					$("#noticeName").text(notice.createName);
					$("#noContent").html(notice.content);
					$("#noticeContent").modal({
						backdrop:'static'
					});

			}
		});
    	
    })
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
    
    function timestamp(timestamp) {
		   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		   Y = date.getFullYear() + '-';
		   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		   D = date.getDate() + ' ';
		   h = date.getHours() + ':';
		   m = date.getMinutes() + ':';
		   s = date.getSeconds();
		   return h+m+s;
	}
    
</script>
	
  

  </body>
</html>
