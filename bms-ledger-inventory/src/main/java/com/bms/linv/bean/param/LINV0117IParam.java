package com.bms.linv.bean.param;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0117IParam",
    description = "OMS指定产品参数")
public class LINV0117IParam implements Serializable {

    private String skuCode;

    private String laCode;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLaCode() {
        return laCode;
    }

    public void setLaCode(String laCode) {
        this.laCode = laCode;
    }
}