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
    <link rel="stylesheet" href="${APP_PATH}/css/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${APP_PATH}/css/bootstrap-theme.min.css">
    <!---->
    <script src="${APP_PATH}/js/jquery-1.11.3.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${APP_PATH}/js/bootstrap.min.js"></script>
    <link href="${APP_PATH}/css/denglu.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!--第一背景-->
    <div id="background_con">
        <div id="mainbody">
            <div align="center" id="logo">
                <img src="${APP_PATH}/img/person.png" />
            </div>
            <div class="word" id="word1">
                <h4 align="center">
                    欢迎登陆哦
                </h4>
            </div>
            <form action="${APP_PATH}/fanUsr/fanLogin" method="post">
                <div align="center" id="input1">
                    <div align="center" class="input-group">
                                <span class="input-group-addon" id="basic-addon1">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true">
                                    </span>
                                </span>
                        <input type="text" id="username" name="username" style="width: 320px;height: 45px;"
                               class="form-control" placeholder="用户名" aria-describedby="basic-addon1"
<%--                               onblur="testUserName()" --%>
                                    />
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
                <div id="attention">
                    <div id="attention3" class="href">
                        <a href="${APP_PATH}/fansignup.jsp">
                            注册账号
                        </a>
                    </div>
                </div>
                <div id="submit">
                    <button class="btn btn-large btn-block btn-primary" style="width: 360px;height: 45px;"
                            type="submit">
                        登录
                    </button>
                </div>
            </form>

            <!--下实线-->
            <div id="hr">
                <hr />
            </div>

        </div>
    </div>
</body>

</html>