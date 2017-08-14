package com.zuul.util;

import java.util.UUID;

/**
 * Created by mao_yejun on 2017/2/22.
 */
public class UUIDUtil {
    /**
     * @return 32位字符串
     */
    public static String getRandom() {
        UUID uuid = UUID.randomUUID();
        String primaryKey = uuid.toString();
        return primaryKey.replaceAll("-", "");
    }

}
