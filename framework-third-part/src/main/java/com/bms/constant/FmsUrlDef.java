package com.bms.constant;

/**
 * Created by mao_yejun on 2017/5/8.
 */
public class FmsUrlDef {
    public static String postUrl;
    public static String postHost;
    public static String fmsUser;
    public static String fmsPsd;
    public static String noticeUrl;
    public static Boolean fmsPushFlg = false;

    public static String getPostUrl() {
        return postUrl;
    }

    public static void setPostUrl(String postUrl) {
        FmsUrlDef.postUrl = postUrl;
    }

    public static String getPostHost() {
        return postHost;
    }

    public static void setPostHost(String postHost) {
        FmsUrlDef.postHost = postHost;
    }

    public static String getFmsUser() {
        return fmsUser;
    }

    public static void setFmsUser(String fmsUser) {
        FmsUrlDef.fmsUser = fmsUser;
    }

    public static String getFmsPsd() {
        return fmsPsd;
    }

    public static void setFmsPsd(String fmsPsd) {
        FmsUrlDef.fmsPsd = fmsPsd;
    }

    public static String getNoticeUrl() {
        return noticeUrl;
    }

    public static void setNoticeUrl(String noticeUrl) {
        FmsUrlDef.noticeUrl = noticeUrl;
    }

    public static Boolean getFmsPushFlg() {
        return fmsPushFlg;
    }

    public static void setFmsPushFlg(Boolean fmsPushFlg) {
        FmsUrlDef.fmsPushFlg = fmsPushFlg;
    }
}
