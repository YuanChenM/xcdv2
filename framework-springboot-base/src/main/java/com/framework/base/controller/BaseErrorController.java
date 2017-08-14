package com.framework.base.controller;

import com.framework.base.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 异常信息获取类，重写ErrorController类
 * 主要负责系统的异常页面的处理以及错误信息的显示
 *
 * @author liu_tao2
 * @version 1.0
 */
@Controller
@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerProperties.class})
public class BaseErrorController implements ErrorController  {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ServerProperties serverProperties;

    private ErrorAttributes errorAttributes;

    /**
     * 初始化BaseErrorController
     *
     * @param errorAttributes
     */
    @Autowired
    public BaseErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    /**
     * 定义error的JSON数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "{service}/{type}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> errorMessage(HttpServletRequest request,@PathVariable("service") String service) {
        MessageServiceFactory messageServiceFactory = MessageServiceFactory.getInstance();
        messageService = messageServiceFactory.getMessageService(service);
        Map<String, Object> body = messageService.getErrorAttributes(request,errorAttributes,serverProperties);
        HttpStatus status = getStatus(request);
        return new ResponseEntity<Map<String, Object>>(body, status);
    }

    public Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        this.errorAttributes.getError(requestAttributes);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    /**
     * Determine if the stacktrace attribute should be included.
     *
     * @param request the source request
     * @return if the stacktrace attribute should be included
     */
    public boolean isIncludeStackTrace(HttpServletRequest request) {
        ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }

    /**
     * 是否包含trace
     *
     * @param request
     * @return
     */
    public boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    /**
     * 获取错误编码
     *
     * @param request
     * @return
     */
    public HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
