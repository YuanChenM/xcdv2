<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<jsp:directive.include file="includes/top.jsp"/>
<body>
<div class="loginback">
    <div>
        <div class="logo-bg">
            <img src="${ctx}/static/images/logo.png">
        </div>
        <div class="systemname">
            OMS系统V2.0
            <span><hr/></span>
        </div>
        <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">
            <ul class="loginput-wrap">
                <li>用户登录</li>
                <li>
                    <c:choose>
                        <c:when test="${not empty sessionScope.openIdLocalId}">
                            <strong>${sessionScope.openIdLocalId}</strong>
                            <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text"
                                        placeholder="用户名"
                                        cssErrorClass="error"
                                        id="username"
                                        size="25"
                                        tabindex="1"
                                        accesskey="${userNameAccessKey}"
                                        path="username"
                                        autocomplete="off"
                                        autocapitalize="off"
                                        htmlEscape="true"/>
                        </c:otherwise>
                    </c:choose>
                    <i class="icon icon-user"></i>
                </li>
                <li>
                    <form:input type="password"
                                id="password"
                                placeholder="密码"
                                size="25"
                                tabindex="1"
                                path="password"
                                accesskey="${passwordAccessKey}"
                                htmlEscape="true"
                                autocomplete="off"
                                autocapitalize="off"/>
                    <i class="icon icon-lock"></i>
                </li>
                <li>
					 <span class="input-group identity">
              <div class="input-group-btn">
                  <sso:CodeMaster  viewType="select" codeType="UserType" id="userType" name="userType"/>
              </div>
            </span>
                </li>
                <li>
                    <input type="hidden" name="lt" value="${loginTicket}"/>
                    <input type="hidden" name="execution" value="${flowExecutionKey}"/>
                    <input type="hidden" name="_eventId" value="submit"/>
                    <span class="loginbtn btn-primary btn-block" name="submitNew" id="submitNew"><span>登录</span></span>
                </li>
                <div style="margin-left:9%;height:20px;">
                <span style="font-size:12px;color:red;line-height:20px;">
                    <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="true"/>
                </span>
                </div>
                <div style="margin-left:9%;margin-top: 35%">
                    <span>
                       <a href="http://www.miitbeian.gov.cn/"  style="color: #ffffff;" target="_blank">网站备案/许可证号：沪ICP备14048035号-2</a>
                    </span>
                </div>
            </ul>
        </form:form>
    </div>
</div>
</body>
</html>

