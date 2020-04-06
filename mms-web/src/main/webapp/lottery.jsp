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
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<style type="text/css">
			body{
				line-height: 1.5;
			}
			.carousel-img {
				min-width: 1446px;
				height: 630px;
				background: url("//sf6-ttcdn-tos.pstatp.com/obj/cc-static/823f63b0-9306-11e9-91ed-1bf52566b03c-1560999177579.png");
				background-size: cover;
			}
			.panel{
				display: flex;
				margin: 32px 0;
				position: relative;
			}

			.panel .title{
				font-size: 24px;
				color: #15151f;
				line-height: 36px;
				text-align: right;
				width: 100px;
				margin-right: 16px;
				font-weight: 500;
			}

			.panel .content{
				padding: 14px 24px;
				position: relative;
				-ms-flex: 1;
				flex: 1;
				border-radius: 4px;
				box-shadow: 0 2px 6px 0 rgba(0,0,0,.08);
				background: #fff;
			}

			.panel .content .wrapper .upload-tip{
				color: #999;
				font-size: 12px;
				margin-bottom: 10px;
			}

			.panel .content .wrapper .upload{
				width: 116px;
				height: 80px;
				border-radius: 4px;
				border: 1px dashed #dadfe3;
				padding: 16px 7px;
				display: -ms-flexbox;
				display: flex;
				-ms-flex-direction: column;
				flex-direction: column;
				-ms-flex-pack: justify;
				justify-content: space-between;
				position: relative;
				cursor: pointer;
			}

			.panel .content .wrapper .upload .bui-btn{
				position: relative;
				display: inline-block;
				font-weight: 400;
				text-align: center;
				white-space: nowrap;
				vertical-align: middle;
				cursor: pointer;
				background-image: none;
				border: 1px solid transparent;
				color: #333;
				background-color: #f8f9fa;
				border-color: #dadfe3;
				user-select: none;
				min-width: 100px;
				padding: 5px 16px;
				font-size: 14px;
				line-height: 22px;
				border-radius: 4px;
			}

			.main-container .panel .content .form-wrapper{
				color: #333;
				position: relative;
			}

			.main-container .panel .content .form-wrapper .form-item.input{
				height: 34px;
			}

			.main-container .panel .content .form-wrapper .form-item:not(:last-child){
				margin-bottom: 24px;
			}

			.main-container .panel .content .form-wrapper .form-item{
				display: -ms-flexbox;
				display: flex;
				-ms-flex-align: center;
				align-items: center;
			}
			.main-container .panel .content .form-wrapper .form-item-label{
				font-size: 14px;
				line-height: 1;
				margin-right: 20px;
				width: 42px;
				text-align: right;
				position: relative;
				color: #333;
			}
			.panel .content .form-wrapper .form-item-wrapper{
				display: -ms-flexbox;
				display: flex;
				-ms-flex-align: center;
				align-items: center;
				position: relative;
			}
			.main-container .panel .content .form-wrapper .form-item-wrapper .text-input{
				width: 438px;
			}
			.byted-input, .byted-input .bui-input {
				position: relative;
				width: 100%;
			}
			.byted-input-suffix .bui-input {
				padding-right: 30px;
			}
			.byted-input .bui-input {
				margin: 0;
				padding: 0;
				list-style: none;
				background-image: none;
				display: inline-block;
				padding: 5px 12px;
				border-radius: 4px;
				color: #333;
				font-size: 14px;
				line-height: 22px;
				font-weight: 400;
				background-color: #fff;
				border: 1px solid #dadfe3;
				outline: none;
				box-sizing: border-box;
			}

			.byted-input, .byted-input .bui-input {
				position: relative;
				width: 100%;
			}

			.options[data-v-0a785b19] {
				list-style: none;
				width: 100%;
				max-height: 114px;
				overflow-y: auto;
				overflow-y: overlay;
				background: #fff;
				box-shadow: 0 2px 6px 0 rgba(0,0,0,.08);
				border-radius: 4px;
				position: absolute;
				top: 40px;
				z-index: 1;
				padding: 6px 0;
			}

			.bui-btn-s {
				position: relative;
				display: inline-block;
				font-weight: 400;
				text-align: center;
				white-space: nowrap;
				vertical-align: middle;
				touch-action: manipulation;
				cursor: pointer;
				background-image: none;
				border: 1px solid transparent;
				color: #333;
				background-color: #f8f9fa;
				border-color: #dadfe3;
				user-select: none;
				min-width: 100px;
				padding: 5px 16px;
				font-size: 14px;
				line-height: 22px;
				border-radius: 4px;
				color: #fff;
				background-color: #2f88ff;
				border-color: #2f88ff;
				margin: 60px auto;
			}
		</style>
		<script type="text/javascript">
			window.onload = function() {
				document.getElementById("goto_car").addEventListener("click",
				function(e) {
					window.location.href = "../Items_list/Smartisan_shop.html";
				},
				true);
			}


			function display(id){
				var traget=document.getElementById(id);
				if(traget.style.display=="none"){
					traget.style.display="";
					for (var i = 0; i < 8; i++){
						if (i != id){
							traget=document.getElementById(i);
							if (traget.style.display!="none"){
								traget.style.display="none";
							}

						}
					}
				}else{
					traget.style.display="none";
				}
			}


			function getFile(){
				$("#getF").click();
			}
			var filename="";
			function clickF(t, img) {
				filename=$("#getF").val();
				var filenames=filename.split("\\");
				filename=filenames[filenames.length-1];
				$("#lb").text(filename);



				var file = t.files[0]

				if(!file.type.match('image/*')){
					alert('上传的图片必修是png,gif,jpg格式的！');
					ev.target.value = ""; //显示文件的值赋值为空
					return;
				}

				var reader = new FileReader();  // 创建FileReader对象

				reader.readAsDataURL(file); // 读取file对象，读取完毕后会返回result 图片base64格式的结果

				reader.onload = function(e){
					document.getElementById('img').src = e.target.result;
				}
			}

			/**
			 * 上传图片的ajax请求
			 */
			function submitGoods() {
				var form = new FormData($("#upGoods")[0]);
				$.ajax({
					url:"${APP_PATH}/goods/uploadGoods",
					type:"post",
					data:form,
					async: false,
					cache: false,
					processData:false,
					contentType:false,
					success:function(data){
						alert("上传商品图片成功");
					},
					error:function (error) {
						alert("上传商品图片失败");
					}
				})
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
							<a onclick="display(0)" style="width: 120px" class="list-group-item">海报管理</a>
							<a onclick="display(1)" style="width: 120px" class="list-group-item">商品管理</a>
							<a onclick="display(2)" style="width: 120px" class="list-group-item">活动管理</a>
							<a onclick="display(3)" style="width: 120px" class="list-group-item">论坛管理</a>
							<a onclick="display(4)" style="width: 120px" class="list-group-item">粉丝管理</a>
							<a onclick="display(5)" style="width: 120px" class="list-group-item">动态管理</a>
							<a onclick="display(6)" style="width: 120px" class="list-group-item">抽奖管理</a>
							<a onclick="display(7)" style="width: 120px" class="list-group-item">历史图片</a>

						</div>
					</div>

					<div class="col-sm-4">
						<section class="t-block">
							<div id="0" style="display: none">
								<ul>
									<form id="imgform" action="${APP_PATH}/poster/uploadPoster" method="post" enctype="multipart/form-data">
										<div class="panel image">
											<div class="title">图片素材</div>
											<div class="content">
												<div class="wrapper">
													<div class="upload-tip">
														支持选择1张商品图，JPG、PNG格式，每张图片9M以内
													</div>
													<div class="upload">
														<!-- <input class="bui-btn" type="button" value="本地上传">本地上传</button> -->
														<input type="button" value="选取文件" class="bui-btn" onclick="getFile()">
														<input style="display: none" type="file"  name="uploadPoster" id="getF" onchange="clickF(this,document.getElementById('img'))">
														<button class="bui-btn" type="button">素材库</button>
													</div>
													<div>
														<img id="img" src="" style="max-width: 100px;">
													</div>
												</div>
											</div>
										</div>
										<div class="panel text">
											<div class="title">文案</div>
											<div class="content">
												<div class="form-wrapper">
													<div class="form-item input">
														<label data-v-cfdfcc88="" class="form-item-label">主标题</label>
														<div data-v-cfdfcc88="" class="form-item-wrapper">
															<div data-v-0a785b19="" data-v-cfdfcc88="" class="input-search text-input">
																<div data-v-0a785b19="" class="serach-input byted-input byted-input-md byted-input-suffix"><!----> <input type="text" name="slogan" placeholder="请输入" minlength="0" maxlength="Infinity" class="bui-input"> <!----> <!----> <!---->
																</div>
																<ul data-v-0a785b19="" class="options" style="display: none;">
																</ul>
															</div>
														</div>
													</div>
													<div class="form-item input">
														<label data-v-cfdfcc88="" class="form-item-label">副标题</label>
														<div data-v-cfdfcc88="" class="form-item-wrapper">
															<div data-v-0a785b19="" data-v-cfdfcc88="" class="input-search text-input">
																<div data-v-0a785b19="" class="serach-input byted-input byted-input-md byted-input-suffix"><!----> <input type="text" placeholder="请输入" minlength="0" maxlength="Infinity" class="bui-input"> <!----> <!----> <!---->
																</div>
																<ul data-v-0a785b19="" class="options" style="display: none;">
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel">
											<button data-v-cfdfcc88="" type="submit" class="bui-btn-s">生成</button>
										</div>
									</form>
								</ul>
							</div>
							<div id="1" style="display: none">
								<ul>
									<li class="width-2">
										<form id="upGoods">
											<input type="file" name="upGoodsImg">
											<input type="text" class="form-control" placeholder="Text input" name="index">
											<input type="submit" class="btn btn-default" value="上传" onclick="submitGoods()">
										</form>
									</li>
								</ul>
							</div>


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