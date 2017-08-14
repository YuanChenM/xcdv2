/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_load对应的实体InvmLoad</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmPage extends BaseEntity {
    int startNum;
    int endNum;


    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }
}
