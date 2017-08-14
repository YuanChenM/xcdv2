package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLIM0102IResult", description = "批量查询仓库信息的出参")
public class LINV0114IResult implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区ID")
    private Long logisticsId;
    @ApiModelProperty(value = "仓库ID")
    private Long whId;
    @ApiModelProperty(value = "仓库编码")
    private String whCode;
    @ApiModelProperty(value = "仓库名称")
    private String whName;
    @ApiModelProperty(value = "仓库地址")
    private String whAddr;

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

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

    public String getWhAddr() {
        return whAddr;
    }

    public void setWhAddr(String whAddr) {
        this.whAddr = whAddr;
    }
}
