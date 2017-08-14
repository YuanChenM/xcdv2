package com.msk.comm.constant;

/**
 * Created by zhu_kai1 on 2016/12/7.
 */
public interface Constant {

    /** 数据字典接口初始化url **/
    interface DictUrl {
        /** 模块名 **/
        String MODEL_NAME = "base-dictionary";
        /** 方法路径 **/
        String FIND_CATALOG = "api/dict/catalog/_find";
    }

    interface ApiUrl {
        /** 模块名 **/
        String MODEL_NAME = "base-authority";
        /** 方法路径 **/
        String USER_SEARCH = "api/authority/user/_search";
    }
}
