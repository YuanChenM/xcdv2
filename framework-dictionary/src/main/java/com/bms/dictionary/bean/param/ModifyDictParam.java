package com.bms.dictionary.bean.param;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by dai_youcheng on 2016-11-10.
 */
public class ModifyDictParam extends BaseEntity implements Serializable{
    @ApiModelProperty(value = "目录id")
    private String dictId;
    @ApiModelProperty(value = "字典目录编码")
    private String dictCode;
    @ApiModelProperty(value = "中文")
    private String dictCn;
    @ApiModelProperty(value = "英文")
    private String dictEn;

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
}
