package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by zhang_jian4 on 2017/3/31.
 */
@ApiModel(value = "ComoShelfListRecordRsParam", description = "商品销售上下架管理-新增商品上下架操作记录入参")
public class ComoShelfListRecordRsParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    /**
     * 记录商品上下架操作的记录表
     * COMO_SHELF_LIST_RECORD
     */
    @ApiModelProperty(value = "主键-记录ID")
    private Long recordId;
    @ApiModelProperty(value = "处理类型，CodeMaster")
    private String handleType;
    @ApiModelProperty(value = "处理备注")
    private String handleRemark;
    @ApiModelProperty(value = "提交的销售上架日期")
    private Date addShelfTime;
    @ApiModelProperty(value = "提交的销售下架日期")
    private Date offShelfTime;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer ver;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }

    public Date getAddShelfTime() {
        return addShelfTime;
    }

    public void setAddShelfTime(Date addShelfTime) {
        this.addShelfTime = addShelfTime;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
