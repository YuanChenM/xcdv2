package com.bms.bymt.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2016/12/15.
 */
@ApiModel(value = "TermGradeResultParam", description = "批发定性定级结果信息类")
public class TermGradeResultParam implements Serializable {
    @ApiModelProperty(value = "定级结果主键")
    private Long gradeResultId;
    @ApiModelProperty(value = "定级详情ID")
    private Long gradeInfoId;
    @ApiModelProperty(value = "批发市场级别")
    private String termMarketLevel;
    @ApiModelProperty(value = "辐射范围")
    private String marketRange;
    @ApiModelProperty(value = "服务对象级别")
    private String serveType;
    @ApiModelProperty(value = "批发市场UUID")
    private String termMarketId;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;

    public Long getGradeResultId() {
        return gradeResultId;
    }

    public void setGradeResultId(Long gradeResultId) {
        this.gradeResultId = gradeResultId;
    }

    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }

    public String getTermMarketLevel() {
        return termMarketLevel;
    }

    public void setTermMarketLevel(String termMarketLevel) {
        this.termMarketLevel = termMarketLevel;
    }

    public String getMarketRange() {
        return marketRange;
    }

    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getTermMarketId() {
        return termMarketId;
    }

    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }
}
