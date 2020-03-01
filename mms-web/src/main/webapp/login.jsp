<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    application.setAttribute("APP_PATH", request.getContextPath());
%>

<html>
<head>
    <meta charset="utf-8" />
    <title>
    </title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <!---->
    <script src="js/jquery-1.11.3.js">
    </script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js">
    </script>
    <script>
        function testUserName() {
            //步骤1：取值
            var userName = document.getElementById("username").value.trim(); //trim()方法，去掉字符串两端的空格。
            //步骤2：判断是否为空
            if (userName.length > 11 || userName.length < 11) {
                document.getElementById("span1").innerHTML = "手机号/邮箱格式错误！";
                userName.setCustomValidity("密码不一致。");
            } else {
                document.getElementById("span1").innerHTML = "";
            }
        }
        function testPSW() {
            //步骤1：取值
            var psww = document.getElementById("psw").value.trim();
            //步骤2：判断是否小于6位
            if (psww.length < 6) {
                document.getElementById("span2").innerHTML = "密码不能小于6位!";
            } else {
                document.getElementById("span2").innerHTML = "";
            }
        }
    </script>
    <link href="css/denglu.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!--第一背景-->
    <div id="background_con">
        <div id="mainbody">
            <div align="center" id="logo">
                <img src="img/smartisan_logo.png" />
            </div>
            <div class="word" id="word1">
                <h4 align="center">
                    使用Smartisan ID 登录在线商城
                </h4>
            </div>
            <form action="#" method="post">
                <div align="center" id="input1">
                    <div align="center" class="input-group">
                                <span class="input-group-addon" id="basic-addon1">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true">
                                    </span>
                                </span>
                        <input type="text" id="username" name="username" style="width: 320px;height: 45px;"
                               class="form-control" placeholder="手机号/邮箱" aria-describedby="basic-addon1"
                               onblur="testUserName()" />
                        <span style="color: red;" id="span1">
                                </span>
                    </div>
                </div>
                <div align="center" id="input2">
                    <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2">
                                    <span class="glyphicon glyphicon-lock" aria-hidden="true">
                                    </span>
                                </span>
                        <input type="password" id="psw" name="psw" style="width: 320px;height: 45px;"
                               class="form-control" placeholder="密码" aria-describedby="basic-addon2" onblur="testPSW()"
                        />
                        <span style="color: red;" id="span2">
                                </span>
                    </div>
                </div>
            </form>
            <div id="attention">
                <div id="attention3" class="href">
                    <a href="Signup.html">
                        注册Smartisan ID&nbsp;
                    </a>
                </div>
            </div>
            <div id="submit">
                <button class="btn btn-large btn-block btn-primary" style="width: 360px;height: 45px;"
                        type="button">
                    登录
                </button>
            </div>
            <!--下实线-->
            <div id="hr">
                <hr />
            </div>

        </div>
    </div>
</body>

</html>