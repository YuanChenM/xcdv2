/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ButlerExpWorkRsParam", description = "买手教育经历参数类")
public class ButlerExpWorkRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "删除标志")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "工作经历ID")
    private Long workExpId;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "经历开始日期")
    private java.util.Date expStart;
    @ApiModelProperty(value = "经历结束日期")
    private java.util.Date expEnd;
    @ApiModelProperty(value = "工作单位")
    private String company;
    @ApiModelProperty(value = "岗位")
    private String post;
    @ApiModelProperty(value = "职务")
    private String job;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "创建者")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新着")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getWorkExpId() {
        return workExpId;
    }

    public void setWorkExpId(Long workExpId) {
        this.workExpId = workExpId;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public Date getExpStart() {
        return expStart;
    }

    public void setExpStart(Date expStart) {
        this.expStart = expStart;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public Date getExpEnd() {
        return expEnd;
    }

    public void setExpEnd(Date expEnd) {
        this.expEnd = expEnd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
