<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OMS</title>
    <link href="${ctx}/static/css/bootstrap.css" rel="stylesheet">
    <script src="${ctx}/static/js/core/jquery-1.11.1.min.js?v=${ver}"></script>
    <script src="${ctx}/static/js/core/bootstrap.js?v=${ver}" type="text/javascript"></script>
    <style>
        .quitContinue {
            position: absolute;
            height: 100%;
            width: 100%;
            display: flex;
            flex-flow: column;
            font-family: "微软雅黑";
        }

        .quitTop {
            display: flex;
            flex-flow: column;
            position: absolute;
            top: 50px;
            width: 100%;
        }

        .quitMain {
            width: 100%;
            height: 100%;
            min-width: 500px;
            background-image: url("${ctx}/static/images/loginback.png");
            background-size: 100% 100%;
            display: flex;
            flex-flow: column;
        }

        .quitMain > span {
            margin: auto;
            background-color: white;
            padding: 30px 50px;
            border-radius: 3px;
            box-shadow: 12px 12px 20px #04061b;
        }

        .quitBottom {
            position: absolute;
            bottom: 0px;
            width: 100%;
            height: 120px;
            padding-top: 25px;
            color: white;
        }

        .quitBottom div, .quitMain > span div {
            text-align: center;
            padding: 3px 0px 3px 0px;
        }

        .wait {
            padding: 10px 0px 10px 0px !important;
            width: 245px;
            border-radius: 3px;
            background-color: #1c94c4;
            color: white;
            text-align: center;
            margin-top: 50px;
        }

        .quitMessage {
            margin-top: 20px;
        }

        .quitLogo {
            width: 250px;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="quitContinue">
    <div class="quitMain">
        <div class="quitTop">
            <img src="${ctx}/static/images/logo.png" class="quitLogo"/>
        </div>
        <span>
            <div style="font-size: 28px">用户退出成功</div>
            <div class="quitMessage">系统将在<span class="quitNum">3</span>秒内返回登录页面</div>
            <div class="wait">请等待</div>
             </span>
        <div class="quitBottom">
            <div>Copyright 2016 Xian Chi Da Group.All Rights Reservea</div>
            <div><a href="http://www.miitbeian.gov.cn/"  style="color: #ffffff;" target="_blank">网站备案/许可证号：沪ICP备14048035号-2</a></div>
        </div>
    </div>
</div>
</body>
<script>
    var i = 3;
    function remainTime() {
        if (i == 0) {
            location.href = '${ctx}/login?service=<%=request.getParameter("service") %>';
        }
        $(".quitNum").text(i--);
        setTimeout("remainTime()", 1000);
    }
    remainTime();
</script>
</html>