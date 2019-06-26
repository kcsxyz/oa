<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		background:url(/oa/images/auth.jpg) no-repeat center fixed ;
		background-size:100%;
	}
</style>
<script>
	function reloadyemian()
	{
		window.history.go(-2);       
	} 
	 window.setTimeout("reloadyemian();",1000); 
</script>
</head>
<body>
	<div>
		<a href="/oa/user/showIndex">返回首页</a>
	</div>
</body>
<script src="/oa/assets/jquery-2.1.0.min.js"></script>
</html>