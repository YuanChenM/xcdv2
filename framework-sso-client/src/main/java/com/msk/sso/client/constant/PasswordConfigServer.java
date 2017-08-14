package com.msk.sso.client.constant;

/**
 * Created by shi_yuxi on 2016/9/27.
 */
public final class PasswordConfigServer {
    //是否强制修改密码
    private static boolean IS_FORCE_MODIFY_PASSWORD;
    //密码是否会过期开关
    private static boolean IS_CHECK_PASSWORD_TIME_SERIES;
    //是否初始化密码开关
    private static boolean IS_INIT_PASSWORD;

    public static void setIsForceModifyPassword(boolean isForceModifyPassword){
        IS_FORCE_MODIFY_PASSWORD = isForceModifyPassword;
    }

    public static boolean isForceModifyPassword(){
        return IS_FORCE_MODIFY_PASSWORD;
    }


    public static void setIsCheckPasswordTimeSeries(boolean isCheckPasswordTimeSeries){
        IS_CHECK_PASSWORD_TIME_SERIES = isCheckPasswordTimeSeries;
    }
    public static boolean isCheckPasswordTimeSeries(){
        return IS_CHECK_PASSWORD_TIME_SERIES;
    }

    public static void setIsInitPassword(boolean isInitPassword){
        IS_INIT_PASSWORD = isInitPassword;
    }
    public static boolean isInitPassword(){
        return IS_INIT_PASSWORD;
    }
}
