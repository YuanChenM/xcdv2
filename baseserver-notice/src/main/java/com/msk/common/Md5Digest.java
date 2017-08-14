package com.msk.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhang_jian3 on 2016/11/30.
 */
public class Md5Digest {
    public Md5Digest() {}

    public static String digest(String code) {
        String MD5Code = "";
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(code.getBytes());
            MD5Code = (new BigInteger(1, e.digest())).toString(16);
        } catch (NoSuchAlgorithmException var2) {
            var2.printStackTrace();
        }
        return MD5Code;
    }
}
