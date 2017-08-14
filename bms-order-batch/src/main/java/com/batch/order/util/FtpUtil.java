package com.batch.order.util;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.core.file.ftp.FtpUtils;

/**
 * Created by liutao on 2017/3/7.
 */
public class FtpUtil {
    public static String PATH = "ftp.ordr.upload.path";
    public static FtpUtils getFtpUtils(){
        String url = ConfigServerPropertyLoad.getFtpHost();
        int port = ConfigServerPropertyLoad.getFtpPort();
        String username = ConfigServerPropertyLoad.getFtpUserName();
        String passwd = ConfigServerPropertyLoad.getFtpPasswd();
        FtpUtils ftpUtils = new FtpUtils(url,port,username,passwd);
        return ftpUtils;
    }
}
