package com.msk.sso.client.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jackjiang on 16/8/4.
 */
public class Md5Digest {
    public static String digest(String code) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(code.getBytes());
            return (new BigInteger(1, e.digest())).toString(16);
        } catch (NoSuchAlgorithmException var2) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }
}
