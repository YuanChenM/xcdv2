package com.framework.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>MD5加密工具类。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class MD5Utils {

    public static String digest(String code) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(code.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }

}
