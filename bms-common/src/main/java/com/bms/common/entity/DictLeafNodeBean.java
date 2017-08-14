package com.bms.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/2.
 */
public class DictLeafNodeBean implements Serializable{
    private static final long serialVersionUID = 1L;
    /** DICT_ID */
    private Long dictId;
    /** DICT_CODE */
    private String dictCode;
    /** DICT_EN */
    private String dictEn;
    /** DICT_CN */
    private String dictCn;
    List<DictNodeBean> values;
    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictEn() {
        return dictEn;
    }

    public void setDictEn(String dictEn) {
        this.dictEn = dictEn;
    }

    public String getDictCn() {
        return dictCn;
    }

    public void setDictCn(String dictCn) {
        this.dictCn = dictCn;
    }

    public List<DictNodeBean> getValues() {
        return values;
    }

    public void setValues(List<DictNodeBean> values) {
        this.values = values;
    }
}
