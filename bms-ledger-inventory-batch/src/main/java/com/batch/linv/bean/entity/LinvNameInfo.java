/*
 * 2017/02/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表LINV_NAME_INFO对应的实体LinvNameInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class LinvNameInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** TYPE */
    private String type;
    /** CODE */
    private String code;
    /** NAME */
    private String name;

    /**
     * <p>默认构造函数</p>
     */
    public LinvNameInfo() {
    }

    /**
     * <p>TYPE</p>
     *
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * <p>TYPE</p>
     *
     * @param type TYPE
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * <p>CODE</p>
     *
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>CODE</p>
     *
     * @param code CODE
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * <p>NAME</p>
     *
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * <p>NAME</p>
     *
     * @param name NAME
     */
    public void setName(String name) {
        this.name = name;
    }

}
