/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_name_info对应的实体InvmNameInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmNameInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 基础数据的类型 */
    private String type;
    /** 系统ID，能唯一识别信息的字段 */
    private String code;
    /** 名称 */
    private String name;

    /**
     * <p>默认构造函数</p>
     */
    public InvmNameInfo() {
    }

    /**
     * <p>基础数据的类型</p>
     *
     * @return 基础数据的类型
     */
    public String getType() {
        return type;
    }

    /**
     * <p>基础数据的类型</p>
     *
     * @param type 基础数据的类型
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * <p>系统ID，能唯一识别信息的字段</p>
     *
     * @return 系统ID，能唯一识别信息的字段
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>系统ID，能唯一识别信息的字段</p>
     *
     * @param code 系统ID，能唯一识别信息的字段
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * <p>名称</p>
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * <p>名称</p>
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

}
