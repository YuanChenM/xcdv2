package com.bms.dictionary.bean.result;

import com.bms.dictionary.bean.entity.DictNodeValue;
import com.framework.base.rest.result.BaseRestResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao_yejun on 2016/11/2.
 */
public class FindNodeResult implements Serializable {
    private String dictId;
    private String dictCode;
    private String dictEn;
    private String dictCn;
    private Long parentId;
    private List<DictNodeValue> values;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public List<DictNodeValue> getValues() {
        return values;
    }

    public void setValues(List<DictNodeValue> values) {
        this.values = values;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
