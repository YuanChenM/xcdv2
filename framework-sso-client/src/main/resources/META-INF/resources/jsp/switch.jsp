<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统-系统选择</title>
    <link href="${ctx}/static/css/pub.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/css/jquery-ui-1.11.1.min.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
    <script src="${ctx}/static/js/jquery-ui.min.js"></script>
	<script src="${ctx}/static/js/jquery.SuperSlide.js"></script>
    <style>
        #module-list {
            list-style-type: none;
            margin: auto;
        }

        #module-list button {
            margin: 5px;
            float: left;
            width: 220px;
            height: 40px;
            font-size: 1.2em;
            text-align: center;
        }

        #module-list button[disabled] {
            color: #bbb;
        }

        #login-bg a {
            font-family: "Microsoft Yahei",Tahoma,Simsun,sans-serif;
            font-size: 16px;
            color: blue;
            text-decoration: underline;
        }

/* tabBar */
.tabBar{width:600px;font-family:"Microsoft YaHei";}
.tabBar .bd{padding:10px 40px 0 40px;clear:both;position:relative;height:200px;overflow:hidden;}
.tabBar .bd .conWrap{width:500px;}
.tabBar .prev,.tabBar .next{position:absolute;right:10px;top:80px;}
.tabBar .next{left:auto;right:10px;}
.tabBar .prevStop,.tabBar .nextStop{display:none;}
.tabBar .bd p{padding-bottom:10px}
    </style>

    <script type="text/javascript">
        $(function () {
            $("button[src]").button().click(function (event) {
                event.preventDefault();
                var url = $(this).attr("src");
                var $sysCode = $(this).attr("systemCode");
                $("#sysCode").val($sysCode);
                var $module = $(this).attr("module");
                $("#sysModel").val($module);
                $("#sysName").val($(this).text());
                $("form#module-list").attr("action", url).submit();
            });
            $("#logoutLink").click(function (event) {
                event.preventDefault();
                $("form#logoutFrom").submit();
            });
			$(".tabBar").slide({
				mainCell:".conWrap",
				effect:"top", 
				trigger:"click", 
				pnLoop:false
			});
        });
		
    </script>
</head>
<body>

<div>

    <div id="popup_filter"></div>
    <div class="wrapper">
        <div id="login_hd">
            <div class="login_hd">
                <div id="login-logo"
                     style="height:98px; background: url('${ctx}/static/sso/images/logo.png') no-repeat;background-size: 25%;vertical-align: central;">
                </div>
            </div>
			<div style="position: absolute;right: 10px;top: 20px;">
			<form id="logoutFrom" action="${ctx}/logout" method="post" style="float:left;">
                    <div id="login-bg" class="form login-backgroud-color" style="top: 30px; height:70px; width:100%;">
                        <span style="margin-right:30px;line-height:20px;float: right;"><a id="logoutLink" href="#">退出</a></span>
                    </div>
                </form>
			</div>
        </div>
        <div class="login_middle" style="background: url('${ctx}/static/sso/images/wallpaper-1.png') no-repeat center;">
			
            <div id="background" class="login_box_bg" style="width:635px;top: 14%;">
                <form id="module-list" action="${ctx}/main" method="post" style="position:relative;top:14%;">
                    <div class="form login-backgroud-color" style="height:210px; width:100%; padding: 10px 0 0 20px;">
                    <input type="hidden" name="sysCode" id="sysCode"/>
                    <input type="hidden" name="sysModel" id="sysModel"/>
                    <input type="hidden" name="sysName" id="sysName"/>
					
					<div class="tabBar" style="position: absolute;top: 0px;">
						<div class="bd">
							<div class="conWrap">
								<c:set var="moduleLength" value="${fn:length(moduleList)}"/>
								<c:set var="pageSize" value="8"/>
								<c:choose>
									<c:when test="moduleLength%pageSize == 0">
										<fmt:parseNumber var="eachLenth" integerOnly="true" value="${moduleLength/pageSize}" />
									</c:when>
									<c:otherwise>
										<fmt:parseNumber var="eachLenth" integerOnly="true" value="${moduleLength/pageSize + 1}" />
									</c:otherwise>
								</c:choose>
								
								<c:forEach var="pageIndex" begin="1" end="${eachLenth}">
									<div class="con">
												<c:forEach items="${moduleList}" var="systemModule" varStatus="status" begin="${(pageIndex - 1)*8}" end="${pageIndex*pageSize - 1}">
													<c:choose>
														<c:when test='${systemModule.sysMainUrl != null && systemModule.sysMainUrl != ""}'>
															<button src="${systemModule.sysMainUrl}"
																	module="${systemModule.sysModule}" systemCode="${systemModule.sysCode}">${systemModule.sysShowName}</button>
														</c:when>
														<c:otherwise>
															<button disabled>${systemModule.sysShowName}</button>
														</c:otherwise>
													</c:choose>
												</c:forEach>
									</div>
								</c:forEach>
							</div>
							<a class="prev prevStop" href="javascript:void(0)"><img src="${ctx}/static/js/up.gif"></a>
							<a class="next" href="javascript:void(0)"><img src="${ctx}/static/js/down.gif"></a>
						</div>
						
					</div>
                    
                    </div>
                </form>
            </div>
        </div>
        <div>
            <p class="copyright" style="text-align: center; margin-bottom: 60px;">Copyright © 2016 Xian Chi Da
                Group. All Rights Reserved.<br/>网站备案/许可证号：沪ICP备14048034号-1</p>
        </div>

    </div>

</div>
</body>
</html>