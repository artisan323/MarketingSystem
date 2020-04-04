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
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">
        .car_hidden{ background: #f8f8f8; position: relative; } .car_hidden .car_total{
                                                                    position: absolute; bottom: 20px; left: 0; right: 0; margin: auto; }
    </style>
    <script type="text/javascript">
        $(function() {
            $.ajax({
                url:"${APP_PATH}/goods/getGoodsInfo",
                type:"get",
                success:function(data){
                    console.log(data.data);
                    var showdiv = $("#getName1");
                    alert(data);
                    showdiv.html(data.data.good1.gdName);
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
        <div class="white-main">
            <ul>
                <li>
                    <a href="#">
                        商品
                    </a>
                </li>
                <li>
                    <a href="#">
                        活动
                    </a>
                </li>
                <li>
                    <a href="#">
                        福利
                    </a>
                </li>
                <li>
                    <a href="#">
                        视频动态
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>
<div class="main">
<%--    <div class="main-main">--%>
<%--        <!--<section>--%>
<%--        <div class="cover"></div>--%>
<%--        </section>-->--%>
<%--        <img src="${APP_PATH}/poster/getPoster">--%>
<%--    </div>--%>
    <section class="t-block">
        <h5>
            我的海报
        </h5>
        <img src="${APP_PATH}/poster/getPoster">
    </section>
    <section class="t-block">
        <h5>
            热门商品
        </h5>
        <ul>
            <li class="width-1">
                <div class="goods-block">
                    <div class="goods-img">
                        <ul>
                            <li>
                                <img src="${APP_PATH}/goods/getGoods?index=1" width="206" height="206">
                            </li>
                        </ul>
                    </div>
                    <h3 id="getName1">

                    </h3>
                </div>
            </li>
            <li class="width-1 getshadow">
                <div class="goods-block">
                    <div class="goods-img">
                        <ul>
                            <li>
                                <img src="${APP_PATH}/goods/getGoods?index=2" width="206" height="206">
<%--                                <img src="pic/index/remen2.jpg" width="206" height="206" />--%>
                            </li>
                        </ul>
                    </div>
                    <h3 id="getName2">
                        《深泽直人》
                    </h3>

                </div>
            </li>
            <li class="width-1 getshadow">
                <div class="goods-block">
                    <div class="goods-img">
                        <ul>
                            <li>
                                <img src="pic/index/remen3.jpg" width="206" height="206" />
                            </li>
                        </ul>
                    </div>
                    <h3>
                        Smartisan T2
                    </h3>

                </div>
            </li>
            <li class="width-1 getshadow">
                <div class="goods-block">
                    <div class="goods-img">
                        <ul>
                            <li>
                                <img src="pic/index/remen4.jpg" width="206" height="206" />
                            </li>
                        </ul>
                    </div>
                    <h3>
                        Smartisan S-100 半入耳式耳机
                    </h3>
                </div>
            </li>
        </ul>
    </section>
    <section class="t-block">
        <h5>
            活动
        </h5>

    </section>
    <section class="t-block">
        <h5>
            品牌精选
        </h5>

    </section>
    <section class="t-block">
        <h5>
            锤子科技动态
        </h5>
        <ul>
            <li class="width-1 getshadow" style="height:200px;background:url(pic/index/keji1.jpg) no-repeat center;background-size:100%;">
            </li>
            <li class="width-1 getshadow" style="height:200px;background:url(pic/index/keji2.jpg) no-repeat center;background-size:100%;">
            </li>
            <li class="width-1 getshadow" style="height:200px;background:url(pic/index/keji3.jpg) no-repeat center;background-size:100%;">
            </li>
            <li class="width-1 getshadow" style="height:200px;background:url(pic/index/keji4.png) no-repeat center;background-size:100%;">
            </li>
        </ul>
    </section>

    <section class="t-block" id="luntan">
        <h5>
            论坛精选
        </h5>

    </section>
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