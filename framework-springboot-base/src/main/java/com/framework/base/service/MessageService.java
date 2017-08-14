package com.framework.base.service;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author liu_tao2
 * @version 1.0
 */
public interface MessageService {
    /**
     * 得到返回的异常信息
     *
     * @param request
     * @param errorAttributes
     * @param <T>
     * @return
     */
    <T extends Throwable> Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributes errorAttributes,ServerProperties serverProperties);
}
