package com.bms.slim.utils;

import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;

/**
 * REST API工具类
 */
public class RestApiUtils {

	/**
	 * 获取访问URL，若false，则访问服务器，否则访问本地。
	 */
	public static String getUrl(String contextPath, String uri, boolean localFlag, String localhost) {
        String http = null;
        if (localFlag) {
            http = localhost;
            return new StringBuilder().append(http).append("/").append(contextPath).append(uri).toString();
        }
        else {
            return ConfigServerUtils.getAPIUrl(contextPath, uri);
        }
	}

}
