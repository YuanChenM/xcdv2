package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0244IContactParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0244IParam", description = "联系人信息")
public class SLIM0244IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增联系人信息集合")
    private List<SLIM0244IContactParam> contactParams;

    public List<SLIM0244IContactParam> getContactParams() {
        return contactParams;
    }

    public void setContactParams(List<SLIM0244IContactParam> contactParams) {
        this.contactParams = contactParams;
    }
}
