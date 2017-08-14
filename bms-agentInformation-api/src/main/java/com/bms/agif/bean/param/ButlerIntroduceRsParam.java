/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表AGIF_BUTLER_INTRODUCE对应的实体AgifButlerIntroduce</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
@ApiModel(value = "ButlerIntroduceRsParam", description = "管家自我介绍Param")
public class ButlerIntroduceRsParam implements Serializable {

    @ApiModelProperty(value = "自我介绍ID")
    private Long introduceId;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "类型 0：经历，1：服务心得，2：感悟或理想")
    private String introduceType;
    @ApiModelProperty(value = "详细")
    private String introduceDetail;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;


    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public String getIntroduceType() {
        return introduceType;
    }

    public void setIntroduceType(String introduceType) {
        this.introduceType = introduceType;
    }

    public String getIntroduceDetail() {
        return introduceDetail;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public void setIntroduceDetail(String introduceDetail) {
        this.introduceDetail = introduceDetail;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}
