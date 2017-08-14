package com.bms.dictionary.bean.param;

import com.bms.dictionary.bean.entity.DictNodeValue;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dai_youcheng on 2016-11-10.
 */
public class CreateDictParam implements Serializable {
    @ApiModelProperty(value = "ID")
    private String dictId;
    @ApiModelProperty(value = "字典目录编码")
    private String dictCode;
    @ApiModelProperty(value = "中文")
    private String dictCn;
    @ApiModelProperty(value = "英文")
    private String dictEn;
    @ApiModelProperty(value = "所属字典编码")
    private String rootCode;
    @ApiModelProperty(value = "父目录编码")
    private String parentCode;
    @ApiModelProperty(value = "是否根目录字典")
    private boolean isRoot;
    @ApiModelProperty(value = "子字典集")
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

    public String getDictCn() {
        return dictCn;
    }

    public void setDictCn(String dictCn) {
        this.dictCn = dictCn;
    }

    public String getDictEn() {
        return dictEn;
    }

    public void setDictEn(String dictEn) {
        this.dictEn = dictEn;
    }


    public boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<DictNodeValue> getValues() {
        return values;
    }

    public void setValues(List<DictNodeValue> values) {
        this.values = values;
    }
}
