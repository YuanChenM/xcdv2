package com.framework.base.service.impl;

import com.framework.base.service.MessageService;
import com.framework.exception.AbstractManagedException;
import com.framework.exception.BusinessException;
import com.framework.exception.ValidatorException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.exception.bean.ExceptionMessage;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.i18n.util.MessageManager;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2016/11/9.
 */
@Service
public class MessageServiceImpl implements MessageService {
    /**
     * 得到返回的异常信息
     *
     * @param request
     * @param errorAttributes
     * @param <T>
     * @return
     */
    @Override
    public <T extends Throwable> Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        T exception = (T) errorAttributes.getError(requestAttributes);
        Map<String, Object> resultMap = this.dealExceptionMessage(exception, request, errorAttributes, serverProperties);
        return resultMap;
    }

    /**
     * 通过异常得到异常返回信息
     *
     * @param exception
     * @param <T>
     * @return
     */
    public <T extends Throwable> Map<String, Object> dealExceptionMessage(T exception, HttpServletRequest request, ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        Map<String, Object> message = new HashedMap();
        List<String> messages = new ArrayList<>();
        if (null != exception) {
            if (exception instanceof BusinessException) {
                BusinessException messageException = (BusinessException) exception;
                if (!CollectionUtils.isEmpty(messageException.getBusinessExceptionMessages())) {
                    for (BusinessExceptionMessage exceptionMessage : messageException.getBusinessExceptionMessages()) {
                        String messageCode = "";
                        if (null == exceptionMessage.getMessageParams()) {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getMessageCode());
                        } else {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getMessageCode(), exceptionMessage.getMessageParams());
                        }
                        messages.add(messageCode);
                    }
                }
            } else if (exception instanceof ValidatorException) {
                ValidatorException messageException = (ValidatorException) exception;
                if (!CollectionUtils.isEmpty(messageException.getValidatorExceptionMessages())) {
                    for (ValidatorExceptionMessage exceptionMessage : messageException.getValidatorExceptionMessages()) {
                        String messageCode = "";
                        if (null == exceptionMessage.getMessageParams()) {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getFieldName()) + MessageManager.getMessage(exceptionMessage.getMessageCode());
                        } else {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getFieldName()) +
                                    MessageManager.getMessage(exceptionMessage.getMessageCode(), exceptionMessage.getMessageParams());
                        }
                        messages.add(messageCode);
                    }
                }
            } else if (exception instanceof AbstractManagedException) {
                AbstractManagedException messageException = (AbstractManagedException) exception;
                if (!CollectionUtils.isEmpty(messageException.getMessages())) {
                    for (ExceptionMessage exceptionMessage : messageException.getMessages()) {
                        String messageCode = "";
                        if (null == exceptionMessage.getMessageParams()) {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getMessageCode());
                        } else {
                            messageCode = messageCode + MessageManager.getMessage(exceptionMessage.getMessageCode(), exceptionMessage.getMessageParams());
                        }
                        messages.add(messageCode);
                    }
                }
            }
            if (!CollectionUtils.isEmpty(messages)) {
                message.put("message", messages);
            }
        } else {
            Map<String, Object> resultMap = getErrorAttributes(request, isIncludeStackTrace(request, serverProperties), errorAttributes);
            messages.add((String) resultMap.get("message"));
            message.put("message", messages);
        }
        return message;
    }

    public Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace, ErrorAttributes errorAttributes) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        errorAttributes.getError(requestAttributes);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    /**
     * Determine if the stacktrace attribute should be included.
     *
     * @param request the source request
     * @return if the stacktrace attribute should be included
     */
    public boolean isIncludeStackTrace(HttpServletRequest request, ServerProperties serverProperties) {
        ErrorProperties.IncludeStacktrace include = serverProperties.getError().getIncludeStacktrace();
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
}
