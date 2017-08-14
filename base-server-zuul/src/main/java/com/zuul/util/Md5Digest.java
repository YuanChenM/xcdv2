package com.zuul.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mao_yejun on 2017/2/22.
 */
public class Md5Digest {
    public static String digest(String message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(message.getBytes());
            byte[] digest = messageDigest.digest();
            return (new BigInteger(1, digest)).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密失败");
        }

    }
}
