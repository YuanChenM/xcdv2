package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdDifDiscussStd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0501IDifTncStdResult", description = "加工质量标准指标差异")
public class SLPD0501IDifTncStdResult extends SLPDFileCardResult {

    @ApiModelProperty("加工质量标准指标ID")
    private Long tncDifStdId;
    @ApiModelProperty("加工质量标准指标类型")
    private String tncStdType;
    @ApiModelProperty("加工质量标准指标类型")
    private String tncStdTypeStr;
    @ApiModelProperty("A1级质量标准差异值")
    private String tncStdDifValA;
    @ApiModelProperty("A2级质量标准差异值")
    private String tncStdDifValB;
    @ApiModelProperty("A3级质量标准差异值")
    private String tncStdDifValC;
    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty(value = "论证信息集合")
    List<SlpdDifDiscussStd> difDiscussStdList;

    public Long getTncDifStdId() {
        return tncDifStdId;
    }

    public void setTncDifStdId(Long tncDifStdId) {
        this.tncDifStdId = tncDifStdId;
    }

    public String getTncStdType() {
        return tncStdType;
    }

    public void setTncStdType(String tncStdType) {
        this.tncStdType = tncStdType;
    }

    public String getTncStdTypeStr() {
        return tncStdTypeStr;
    }

    public void setTncStdTypeStr(String tncStdTypeStr) {
        this.tncStdTypeStr = tncStdTypeStr;
    }

    public String getTncStdDifValA() {
        return tncStdDifValA;
    }

    public void setTncStdDifValA(String tncStdDifValA) {
        this.tncStdDifValA = tncStdDifValA;
    }

    public String getTncStdDifValB() {
        return tncStdDifValB;
    }

    public void setTncStdDifValB(String tncStdDifValB) {
        this.tncStdDifValB = tncStdDifValB;
    }

    public String getTncStdDifValC() {
        return tncStdDifValC;
    }

    public void setTncStdDifValC(String tncStdDifValC) {
        this.tncStdDifValC = tncStdDifValC;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SlpdDifDiscussStd> getDifDiscussStdList() {
        return difDiscussStdList;
    }

    public void setDifDiscussStdList(List<SlpdDifDiscussStd> difDiscussStdList) {
        this.difDiscussStdList = difDiscussStdList;
    }
}
