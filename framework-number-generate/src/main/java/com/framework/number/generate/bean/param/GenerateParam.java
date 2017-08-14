package com.framework.number.generate.bean.param;

import com.framework.base.consts.StringConst;

import java.io.Serializable;

/**
 * 编码生成基础参数
 * @author jiang_nan
 * @version 1.0
 */
public class GenerateParam implements Serializable{
    /**编码长度*/
    private int length;
    /**前缀*/
    private String prefix;

    /**
     * 获得编码前缀
     * @return 获得编码前缀
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 设置编码前缀
     * @param prefix 编码前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 获得编码长度
     * @return 编码长度
     */
    public int getLength() {
        return length;
    }

    /**
     * 设置编码长度
     * @param length 编码长度
     */
    public void setLength(int length) {
        this.length = length;
    }
}
