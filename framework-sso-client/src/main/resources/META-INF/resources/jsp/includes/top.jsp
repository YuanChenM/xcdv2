<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ver" value="1"/>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>密码修改</title>
    <link href="${ctx}/static/css/pub.css?v=${ver}" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/css/demo.css?v=${ver}" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/sso/css/iconfont.css?v=${ver}" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/sso/css/iconfont-main.css?v=${ver}" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/css/jquery-ui-1.11.1.min.css?v=${ver}" rel="stylesheet" type="text/css">
    <script src="${ctx}/static/js/jquery-1.11.1.min.js?v=${ver}" type="text/javascript"></script>
    <script src="${ctx}/static/js/jquery-ui.min.js?v=${ver}" type="text/javascript"></script>
    <script src="${ctx}/static/sso/js/login.js?v=${ver}" type="text/javascript"></script>
    <style>
        .login-backgroud-color {
            background-color: white;
        }

        .custom-combobox {
            position: relative;
            display: inline-block;
        }

        .custom-combobox-toggle {
            position: absolute;
            top: 0;
            bottom: 0;
            margin-left: -1px;
            padding: 0;
            background: none;
            border: none;
        }

        .custom-combobox-input {
            margin: 0 0 0 15px;
            padding: 5px 10px 5px 0;
            width: 180px;
            background: none;
            border: none;
            font-family: "Microsoft Yahei";
            font-size: 14px;
            color: #333;
        }
    </style>
    <script type="text/javascript">

        // msgBox效果
        $.msgbox = {
            ok: function (msg, id) {
                if (id == undefined || id == null) {
                    id = "";
                } else {
                    id = "#" + id;
                }
                $(id + ".msg_box").removeClass("error_msg").addClass("ok_msg");
                $(id + ".msg_box ul").html(this.createHtml(msg));
                $(id + ".msg_box").show();
            },
            ng: function (msg, id) {
                if (id == undefined || id == null) {
                    id = "";
                } else {
                    id = "#" + id;
                }
                $(id + ".msg_box").removeClass("ok_msg").addClass("error_msg");
                $(id + ".msg_box ul").html(this.createHtml(msg));
                $(id + ".msg_box").show();
            },
            createHtml: function (msg) {
                var msgHtml = "";
                if (typeof msg == 'string') {
                    msgHtml = "<li>" + msg + "</li>";
                } else {
                    for (i = 0; i < msg.length; i++) {
                        msgHtml += "<li>" + msg[i] + "</li>";
                    }
                }
                return msgHtml;
            }
        };

        $(function () {
            $("#submitNew").click(function () {
                var oldPassword = $("#oldPassword").val();
                if (oldPassword == "") {
                    alert("请输入原密码!");
                    $("#oldPassword").focus().select();
                    return false;
                }
                var newPassword = $("#newPassword").val();
                if (newPassword == "") {
                    alert("请输入新密码!");
                    $("#newPassword").focus().select();
                    return false;
                }
                var againPassword = $("#againPassword").val();
                if (againPassword == "") {
                    alert("请输入确认密码!");
                    $("#againPassword").focus().select();
                    return false;
                }
                var obj = new Object();
                obj["oldPassword"] = oldPassword;
                obj["newPassword"] = newPassword;
                obj["againPassword"] = againPassword;
                var url = $("#fm1").attr("action");
                $.ajax({
                    type: "POST",
                    url: url,
                    data: obj,
                    dataType : "json",
                    success: function(data){

                        console.log(data);
                        if(data.status == 'false'){
                            $.msgbox.ng(data.errorMessage);
                        }else if(data.status == 'true'){
                            window.location = "${ctx}/switch/system"
                        }
                    }

                });
            });

            $("#continue").click(function () {
                window.location = "${ctx}/switch/system?continueFlag=true"
            });
            $(window).keydown(function (e) {
                if (e.which == 13) {
                    $("#submitNew").click();
                }
            });
        });
    </script>
</head>