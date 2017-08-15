package com.bms.slim.constant;


/**
 * <p>国际化信息常量类。</p>
 */
public interface MessageConstant {

    /** URL访问成功 */
    String SUCCESS = "S";
    /** URL访问失败 */
    String FAILURE = "F";

    /** 模块名(中文) */
    String MODULE_NAME_ZH = "卖家信息管理系统";
    /** 模块名(英文) */
    String MODULE_NAME_EN = "Seller Information Management System";
    /** 模块名(英文)简称 */
    String MODULE_SHORT_NAME_EN = "SLIM";

    /**
     * <p>错误信息。</p>
     */
    interface Error {

    }

    /**
     * <p>警告信息。</p>
     */
    interface Warn {

    }

    /**
     * <p>提示信息。</p>
     */
    interface Info {

    }

    /**
     * <p>文本片段。</p>
     */
    interface Label {

    }

}
