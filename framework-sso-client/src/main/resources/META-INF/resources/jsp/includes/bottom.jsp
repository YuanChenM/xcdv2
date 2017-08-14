<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <p class="copyright" style="text-align: center; margin-bottom: 60px;">Copyright © 2016 Xian Chi Da
        Group. All Rights Reserved.<br/>网站备案/许可证号：沪ICP备14048034号-1</p>
</div>
<spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
<script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script>

