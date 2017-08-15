package com.bms.slpd.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0403IParam", description = "查询品牌信息入参")
public class SLPD0403IParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "品牌所有人IDList")
    private List<Long> brandOwnerIds;
    @ApiModelProperty(value = "品牌IDList")
    private List<Long> brandIds;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌所有人名称")
    private String ownerName;
    @ApiModelProperty(value = "品牌类型")
    private String brandType;
    @ApiModelProperty(value = "商标注册证号")
    private String trademarkRegNo;
    @ApiModelProperty(value = "有效期开始时间")
    private Date startValidDate;
    @ApiModelProperty(value = "有效期结束时间")
    private Date endValidDate;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "审核状态")
    private Boolean auditStu;

    public List<Long> getBrandOwnerIds() {
        return brandOwnerIds;
    }

    public void setBrandOwnerIds(List<Long> brandOwnerIds) {
        this.brandOwnerIds = brandOwnerIds;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getTrademarkRegNo() {
        return trademarkRegNo;
    }

    public void setTrademarkRegNo(String trademarkRegNo) {
        this.trademarkRegNo = trademarkRegNo;
    }

    public Date getStartValidDate() {
        return startValidDate;
    }

    public void setStartValidDate(Date startValidDate) {
        this.startValidDate = startValidDate;
    }

    public Date getEndValidDate() {
        return endValidDate;
    }

    public void setEndValidDate(Date endValidDate) {
        this.endValidDate = endValidDate;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Boolean getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }
}
