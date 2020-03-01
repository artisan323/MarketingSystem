<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
application.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<!---->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="js/bootstrap.min.js"></script>
	<script>
		// function testUserName(){
		// 	//步骤1：取值
		// 	var userName = document.getElementById("username").value.trim();//trim()方法，去掉字符串两端的空格。
		// 	//步骤2：判断是否为空
		// 	if(userName.length!=11){
		// 		document.getElementById("span1").innerHTML="手机号格式不正确!";
		// 	}else{
		// 		document.getElementById("span1").innerHTML="";
		// 	}
		// }
		// var a;
		// function testPSW(){
		// 	//步骤1：取值
		// 	var psww = document.getElementById("psw").value.trim();
		// 	a=psww;
		// 	//步骤2：判断是否小于6位
		// 	if(psww.length < 6){
		// 		document.getElementById("span2").innerHTML="密码不能小于6位!";
		// 	}else{
		// 		document.getElementById("span2").innerHTML="";
		// 	}
		// }
		// function testPSW2(){
		// 	var psww = document.getElementById("psw2").value.trim();
		// 	if(psww!=a){
		// 		document.getElementById("span3").innerHTML="两次输入密码不一致!";
		// 	}else{
		// 		document.getElementById("span3").innerHTML="";
		// 	}
		// }
	</script>
	<link href="css/zhuce.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="background_con">
	<div id="mainbody">
		<div  id="area1" >
			<b>注册Smartisan ID</b>
		</div>
		<form action="${APP_PATH}/usr/register" method="post">
			<div id="area2">
				<div id="sousuo1" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span  class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
					<input style="width: 300px;height:45px;" id="usrTel" name="usrTel" class="form-control" placeholder="+86  手机号                                            中国" aria-describedby="basic-addon1" onblur="testUserName()"/> <span id="span1" style="color: red;"></span>
				</div>
				<div id="sousuo2" class="input-group">
					<span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></span>
					<input style="width: 300px;height:45px;" name="usrEmail"  class="form-control" placeholder="邮箱" aria-describedby="basic-addon2"/>
				</div>
				<div id="sousuo3" class="input-group">
					<span class="input-group-addon" id="basic-addon4"><span  class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
					<input style="width: 300px;height: 45px;" id="usrLoginName" name="usrLoginName" class="form-control" placeholder="登陆用户名" aria-describedby="basic-addon4"                       onblur="testPSW2()"/><span id="span3" style="color: red;"></span>
				</div>
				<div id="sousuo4" class="input-group">
					<span class="input-group-addon" id="basic-addon3"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
					<input style="width: 300px;height: 45px;" id="usrPassword" name="usrPassword" class="form-control" placeholder="密码" aria-describedby="basic-addon3"                          onblur="testPSW()"/><span  id="span2"  style="color: red;"></span>
				</div>

			</div>
			<div id="area3">
				<input type="checkbox"> 我已阅读并同意遵守<a href="#">法律声明</a>和<a href="#">隐私条款</a>
			</div>
			<div id="area4">
				<div id="submit">
					<input style="width: 340px;height: 45px;" class="btn btn-large btn-block btn-primary" style="width: 420px;height: 50px;" type="submit"></input>
				</div>
			</div>
		</form>

		<div id="hr">
			<hr style="border : 1px solid  #DADADA;" />
		</div>
		<div  id="vvvvv">
			如果您已有Smartisan ID，则可在此<a href="login.jsp">登录</a>
		</div>
	</div>

</div>
</body>
</html>
