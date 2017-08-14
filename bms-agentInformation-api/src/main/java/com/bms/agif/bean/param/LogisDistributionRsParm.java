package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/3/14.
 */
@ApiModel(value = "RegnLogDistributionPageParm", description = "配送站信息类")
public class LogisDistributionRsParm implements Serializable {
    @ApiModelProperty(value = "配送站主键")
    private Long distributionId;
    @ApiModelProperty(value = "配送站授权销售合伙人")
    private String authorizedPartner;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站分类")
    private String distributionType;
    @ApiModelProperty(value = "配送站编码")
    private String distributionCode;
    @ApiModelProperty(value = "数据有效性标识(默认为有效)")
    private String disableFlg;

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public String getDisableFlg() {
        return disableFlg;
    }

    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }
}
