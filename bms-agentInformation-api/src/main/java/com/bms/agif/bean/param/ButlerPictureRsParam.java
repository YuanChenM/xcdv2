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

@ApiModel(value = "ButlerPictureRsParam", description = "冻品管家证照图片信息Param")
public class ButlerPictureRsParam implements Serializable {
    @ApiModelProperty(value = "证照图片ID")
    private Long picId;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "证照图片")
    private String licensePic;
    @ApiModelProperty(value = "是否默认照片")
    private Boolean defaultFlg;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public Boolean getDefaultFlg() {
        return defaultFlg;
    }

    public void setDefaultFlg(Boolean defaultFlg) {
        this.defaultFlg = defaultFlg;
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
