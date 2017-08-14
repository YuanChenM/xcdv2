/*
 * 2016/11/04 自动生成 新规作成
 * (c) 江苏润和
 */
package com.batch.order.bean;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>
 * 表user对应的实体User
 * </p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class User extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** id */
    private java.lang.Integer id;
    /** name */
    private java.lang.String name;
    /** age */
    private java.lang.Integer age;
    /** password */
    private java.lang.String password;

    /**
     * <p>
     * 默认构造函数
     * </p>
     */
    public User() {}

    /**
     * <p>
     * id
     * </p>
     *
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }

    /**
     * <p>
     * id
     * </p>
     *
     * @param id id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    /**
     * <p>
     * name
     * </p>
     *
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * <p>
     * name
     * </p>
     *
     * @param name name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * <p>
     * age
     * </p>
     *
     * @return age
     */
    public java.lang.Integer getAge() {
        return age;
    }

    /**
     * <p>
     * age
     * </p>
     *
     * @param age age
     */
    public void setAge(java.lang.Integer age) {
        this.age = age;
    }

    /**
     * <p>
     * password
     * </p>
     *
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }

    /**
     * <p>
     * password
     * </p>
     *
     * @param password password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

}
