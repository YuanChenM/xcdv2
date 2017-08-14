package com.framework.core.utils;

import java.util.UUID;

/**
 * <p>UUID工具类</p>
 *
 * @Author mao_yejun
 * @CreateDate 2016/11/10.
 * @Version 1.0
 */
public class UUIDUtils {
    /**
     * @return 32位字符串
     */
    public static String genPrimaryKey() {
        UUID uuid = UUID.randomUUID();
        String primaryKey = uuid.toString();
        return primaryKey.replaceAll("-", "");
    }

}
