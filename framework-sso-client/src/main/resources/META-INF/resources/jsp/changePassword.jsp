<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:directive.include file="includes/top.jsp"/>
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
        </div>
        <div class="login_middle" style="background: url('${ctx}/static/sso/images/wallpaper-1.png') no-repeat center;">
            <form method="post" id="fm1" action="${ctx}/change/password" htmlEscape="true" method="POST">
                <div id="background" class="login_box_bg">
                    <div id="login-bg" class="form login-backgroud-color" style="top: 20px; height:45px;">
                        <span style="margin-left:9%;font-size:24px;line-height:20px;">修改密码</span>
                    </div>
                    <div id="newVersionLogin" class="form login-backgroud-color">

                        <table class="all_input" style="border-collapse: separate;">
                            <tbody>
                            <tr>
                                <td></td>
                                <td style="height:45px;padding: 5px;">
                                    <label id="lblNewPassword" for="oldPassword"></label>
                                    <i class="iconfont icon-login">&#xe61f;</i>
                                    <input type="password"
                                            class="module_app_input___gray_neoskin"
                                            style="margin-left:15px; margin-top: 0; width:200px;"
                                            placeholder="原密码"
                                            cssErrorClass="error"
                                            id="oldPassword"
                                            name="oldPassword"
                                            size="25"
                                            tabindex="1"
                                            path="oldPassword"
                                            htmlEscape="true"
                                            autocomplete="off"
                                            autocapitalize="off"
                                            />
                                </td>
                                <td></td>
                            </tr>
                            <tr class="line">
                                <td></td>
                                <td class="tdline_2" width="30" style="height: 0px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="height:40px;padding: 5px;">
                                    <i class="iconfont icon-login">&#xe61f;</i>
                                    <input type="password"
                                           class="module_app_input___gray_neoskin"
                                           style="margin-left:15px; margin-top: 0; width:200px;"
                                           placeholder="新密码"
                                           cssErrorClass="error"
                                           id="newPassword"
                                           name="newPassword"
                                           size="25"
                                           tabindex="1"
                                           path="newPassword"
                                           htmlEscape="true"
                                           autocomplete="off"
                                           autocapitalize="off"
                                            />
                                </td>
                                <td></td>
                            </tr>
                            <tr class="line">
                                <td></td>
                                <td class="tdline_2" width="30" style="height: 0px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="height:40px;padding: 5px;">
                                    <i class="iconfont icon-login">&#xe61f;</i>
                                    <input type="password"
                                           class="module_app_input___gray_neoskin"
                                           style="margin-left:15px; margin-top: 0; width:200px;"
                                           placeholder="确认密码"
                                           cssErrorClass="error"
                                           id="againPassword"
                                           name="againPassword"
                                           size="25"
                                           tabindex="1"
                                           path="againPassword"
                                           htmlEscape="true"
                                           autocomplete="off"
                                           autocapitalize="off"
                                            />
                                    <a class="forget" href="#"></a>
                                </td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                        <div id="tree_msg" class="msg_box">
                            <ul>
                            </ul>
                        </div>
                        <div class="btn_wrap login-backgroud-color">
                            <c:if test="${isForceModifyPassword == true}">
                                <input type="button" name="submitNew" value="确定" id="submitNew" class="btn_login_submit">
                            </c:if>
                            <c:if test="${isForceModifyPassword == false}">
                                <input type="button" name="submitNew" value="确定" id="submitNew" class="btn_login_submit" style="width: 100px;">
                                <input type="button" name="submitNew" value="继续" id="continue" class="btn_login_submit" style="width: 100px;">
                            </c:if>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <jsp:directive.include file="includes/bottom.jsp"/>
    </div>
</div>
</body>