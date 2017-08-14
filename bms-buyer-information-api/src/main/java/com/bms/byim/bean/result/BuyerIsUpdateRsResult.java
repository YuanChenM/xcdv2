package com.bms.byim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/23.
 */
@ApiModel(value = "BuyerIsUpdateRsResult", description = "买家修改返回参数")
public class BuyerIsUpdateRsResult implements Serializable {
    @ApiModelProperty(value = "买家更新条数")
    private int modifyResult;
    @ApiModelProperty(value = "买家是否更新必要信息")
    private boolean isUpdate;

    public int getModifyResult() {
        return modifyResult;
    }

    public void setModifyResult(int modifyResult) {
        this.modifyResult = modifyResult;
    }

    public boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}
