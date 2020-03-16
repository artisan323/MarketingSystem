<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	application.setAttribute("APP_PATH", request.getContextPath());
%>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>
			Document
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
								<a href="..\Personal\Personal.html" class="person_a">
									<img class="customer_logo" src="img\person_mini.png">
								</a>
							</i>
						</li>
						<li>
							<i aria-hidden="true">
							</i>
							<!-- 购物车图 -->
							<!-- <div id="count">
								<a>
									<img class="customer_logo" src="img\car.png">
									<span style="color: white;" id="totalNum">
										0
									</span>
									<div class="car_hidden">
										
						
									</div>
								</a>
							</div> -->
						</li>
					</ul>
					<ul class="page-top-list" id="fix-show">
						<li>
							<a href="index.jsp" class="a-active">
								首页管理
							</a>
						</li>
<%--						<li>--%>
<%--							<a href="forum.jsp">--%>
<%--								论坛--%>
<%--							</a>--%>
<%--						</li>--%>
<%--						<li>--%>
<%--							<a href="lottery.jsp">--%>
<%--								每日抽奖--%>
<%--							</a>--%>
<%--						</li>--%>
					</ul>
				</div>
			</div>
			<div class="white">
				
			</div>
		</div>
		<div class="main">
			<!-- 主体栏 -->
			<div class="container">
				<div class="row">

					<%--左侧栏--%>
					<div class="col-sm-2">
						<div class="list-group">
							<a onclick="searchFile(6)" style="width: 120px" class="list-group-item">海报管理</a>
							<a onclick="searchFile(0)" style="width: 120px" class="list-group-item">商品管理</a>
							<a onclick="searchFile(1)" style="width: 120px" class="list-group-item">活动管理</a>
							<a onclick="searchFile(2)" style="width: 120px" class="list-group-item">论坛管理</a>
							<a onclick="searchFile(3)" style="width: 120px" class="list-group-item">粉丝管理</a>
							<a onclick="searchFile(4)" style="width: 120px" class="list-group-item">动态管理</a>
							<a onclick="searchFile(5)" style="width: 120px" class="list-group-item">抽奖管理</a>
							<a onclick="searchFile(5)" style="width: 120px" class="list-group-item">历史图片</a>

						</div>
					</div>

					<div class="col-sm-4">
						<section class="t-block">
							<h5>
								选择展示商品图片
							</h5>
							<ul>
								<li class="width-2">

								</li>
							</ul>

						</section>
					</div>

				</div>

			</div>
			
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