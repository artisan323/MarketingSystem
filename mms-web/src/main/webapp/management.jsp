<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
application.setAttribute("APP_PATH", request.getContextPath());
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>
		商户门店宣传
	</title>
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/block.css">
	<link rel="stylesheet" href="css/goods.css">
	<link rel="stylesheet" href="css/luntan.css">
	<link rel="stylesheet" href="css/app.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/white-hide.css">
	<link rel="stylesheet" href="css/nav.css">
	<link rel="stylesheet" type="text/css" href="css/nav_card.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<!---->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<%--引入jQuery支持的form--%>
	<style type="text/css">
		.car_hidden{ background: #f8f8f8; position: relative; } .car_hidden .car_total{
																	position: absolute; bottom: 20px; left: 0; right: 0; margin: auto; }
	</style>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById("goto_car").addEventListener("click",
					function(e) {
						window.location.href = "../Items_list/Smartisan_shop.html";
					},
					true);
		}

		$(function () {
			$('#student-import-form').ajaxForm(function (data) {
				console.log(data+"123");
				if (data.success == "true") {
					alert(data.message)
					window.location.reload();
				} else {
					alert(data.message);
					window.location.reload();
				}
			});
		});

	</script>
</head>
<body>
<div class="header">
	<div class="black">
		<div class="black-main">
			<h1>
				<div>
				</div>
			</h1>
			<ul class="customer">
				<li>
					<i aria-hidden="true">
						<a href="login.jsp" class="person_a">
							<img class="customer_logo" src="img\person_mini.png">
						</a>
					</i>
				</li>
				<li>
					<i aria-hidden="true">
					</i>
				</li>
			</ul>
			<ul class="page-top-list" id="fix-show">
				<li>
					<a href="index.jsp" class="a-active">
						首页
					</a>
				</li>
				<li>
					<a href="forum.jsp">
						论坛
					</a>
				</li>
				<li>
					<a href="lottery.jsp">
						每日抽奖
					</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="white">

	</div>
</div>
<div class="main">
	<section class="t-block">
		<h5>
			海报生成
		</h5>
		<ul>
			<li class="width-2">
			</li>
			<li class="width-2">
				<form id="imgform" action="${APP_PATH}/poster/uploadPoster" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<p class="title">选择一张图片: </p>
						<input type="file" name="uploadPoster" id="exampleInputFile" style="width:100px;height:100px;">
					</div>
					<div class="form-group">
						<p class="title">输入Slogan: </p>
						<input type="text" name="slogan" class="form-control" placeholder="Text input" >
					</div>
					<div class="form-group">
					</div>
					<input type="submit" id="ajaxSubmit" class="btn btn-default">生成</input>
				</form>
			</li>
		</ul>

	</section>
	<section class="t-block">
		<h5>
			选择展示商品图片
		</h5>
		<ul>
			<li class="width-2">

			</li>
			<li class="width-2">

			</li>
		</ul>

	</section>
</div>



<script src="js/goods-item.js">
</script>
<script src="js/shouji.js">
</script>
<script src="js/scroll.js">
</script>
<script type="text/javascript" src="js/change_index.js">
</script>
</body>

</html>