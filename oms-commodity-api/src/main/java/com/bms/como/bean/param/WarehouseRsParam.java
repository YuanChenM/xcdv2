package com.bms.como.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/12.
 */
@ApiModel(value = "WarehouseRsParam", description = "仓库信息入参")
public class WarehouseRsParam implements Serializable {
    @ApiModelProperty(value = "仓库编码")
    private String whCode;
    @ApiModelProperty(value = "仓库名称")
    private String whName;
    @ApiModelProperty(value = "入库批次集合")
    private List<BatchStorageRsParam> lotList;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public List<BatchStorageRsParam> getLotList() {
        return lotList;
    }

    public void setLotList(List<BatchStorageRsParam> lotList) {
        this.lotList = lotList;
    }
}
