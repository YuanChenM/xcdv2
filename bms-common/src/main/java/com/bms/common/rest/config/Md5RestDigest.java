package com.bms.common.rest.config;

import com.framework.core.utils.MD5Utils;

/**
 * Created by mao_yejun on 2017/3/20.
 */
public class Md5RestDigest {
    public static String digest(String sign, String securityKey, String timestamp) {
        StringBuffer security = new StringBuffer();
        security.append(sign).append(timestamp).append(securityKey);
        return MD5Utils.digest(security.toString());

    }
}
