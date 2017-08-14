package com.bms.dictionary.bean.result;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.entity.DictNodeValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao_yejun on 2016/11/2.
 */
public class LoadNodeResult implements Serializable{
    private String dictId;
    private String dictCode;
    private String dictEn;
    private String dictCn;
    private String fullpath;
    private Long parentId;
    private List<DictLeafNode> values;

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

    public String getFullpath() {
        return fullpath;
    }

    public void setFullpath(String fullpath) {
        this.fullpath = fullpath;
    }

    public List<DictLeafNode> getValues() {
        return values;
    }

    public void setValues(List<DictLeafNode> values) {
        this.values = values;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
