package com.msk.common;

/**
 * Created by mao_yejun on 2016/10/19.
 */
public interface SystemServerDef {

    /** 权限模块接口初始化url **/
    interface authorityRestUrl {
        /** 查询用户信息 **/
        String SEARCH_USER = "/api/authority/user/_search";
    }
}
