/**
 * 
 */
Main.message = {
        searchSuccess:"检索成功",
        searchFailure:"检索失败，请联系管理员。",
        saveSuccess:"保存成功",
        saveFailure:"保存失败，请联系管理员。",
        connectionFailure:"服务器故障或者没有找到请求的资源",
        systemError:"发生系统错误",
        sessionTimeout:"连接超时，请重新登录",
};
Main.message.title={
        warning:"警告",
        error:"错误",
        info:"消息",
        confirm:"确认",
};
alertMessage={
		title:{
			info:"提示信息",
            warn:"警告信息",
            error:"错误信息",
            confirm:"确认信息",
		},
		button:{
			ok:"确定",
			cancel:"取消",
		}
};
//jQuery validate
$.extend($.validator.messages, {
    required: "<spring:message javaScriptEscape='true' code='spring.constraints.NotEmpty.message'/>",
    between:"应在{0}到{1}之间",
    exist:"{0}已经存在了",
    compare:"{0}应该小于{1}",
    remote: "<spring:message javaScriptEscape='true' code='E0027'/>",
    email: "<spring:message javaScriptEscape='true' code='spring.constraints.Email.message'/>",
    url: "<spring:message javaScriptEscape='true' code='spring.constraints.URL.message'/>",
    date: "<spring:message javaScriptEscape='true' code='spring.constraints.Date.message'/>",
    dateISO: "<spring:message javaScriptEscape='true' code='E0031'/>",
    number: "<spring:message javaScriptEscape='true' code='spring.constraints.Number.message'/>",
    digits: "<spring:message javaScriptEscape='true' code='E0033'/>",
    creditcard: "<spring:message javaScriptEscape='true' code='E0034'/>",
    equalTo: "<spring:message javaScriptEscape='true' code='E0035'/>",
    accept: "<spring:message javaScriptEscape='true' code='E0036'/>",
    maxlength: $.validator.format("<spring:message javaScriptEscape='true' code='spring.constraints.MaxLength.message'/>".replace('{max}','{0}')),
    minlength: $.validator.format("<spring:message javaScriptEscape='true' code='spring.constraints.MinLength.message'/>".replace('{min}','{0}')),
    rangelength: $.validator.format("<spring:message javaScriptEscape='true' code='spring.constraints.Length.message'/>".replace('{max}','{1}').replace('{min}','{0}')),
    range: $.validator.format("<spring:message javaScriptEscape='true' code='spring.constraints.Range.message'/>".replace('{max}','{1}').replace('{min}','{0}')),
    max: $.validator.format("<spring:message javaScriptEscape='true' code='validator.message.max'/>".replace('{value}','{0}')),
    min: $.validator.format("<spring:message javaScriptEscape='true' code='validator.message.min'/>".replace('{value}','{0}')),
    alphanumeric: "<spring:message javaScriptEscape='true' code='E0043'/>",
    lettersonly: "<spring:message javaScriptEscape='true' code='E0044'/>",
    phone: "<spring:message javaScriptEscape='true' code='E0045'/>",
    forcode:"<spring:message javaScriptEscape='true' code='com.unilogi.core.validation.constraints.Code.message'/>",
    maxnumber:$.validator.format("<spring:message javaScriptEscape='true' code='E0047'/>"),
    forrefno:"<spring:message javaScriptEscape='true' code='com.unilogi.core.validation.constraints.Refno.message'/>",
    forpartno:"<spring:message javaScriptEscape='true' code='com.unilogi.core.validation.constraints.Partno.message'/>",
    forascii:"<spring:message javaScriptEscape='true' code='com.unilogi.core.validation.constraints.ASCII.message'/>",
    gtzero:"<spring:message javaScriptEscape='true' code='E0053'/>",
    gteqzero:"<spring:message javaScriptEscape='true' code='E0054'/>"
        
});

