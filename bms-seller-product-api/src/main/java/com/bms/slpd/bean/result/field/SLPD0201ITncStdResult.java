package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdDiscussStd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0201ITncStdResult", description = "加工质量标准指标")
public class SLPD0201ITncStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "加工质量标准指标ID")
    private Long tncStdId;
    @ApiModelProperty(value = "加工质量标准指标类型")
    private Long tncStdType;
    @ApiModelProperty(value = "加工质量标准指标类型")
    private String tncStdTypeStr;
    @ApiModelProperty(value = "A1级质量标准")
    private String tncStdValA;
    @ApiModelProperty(value = "A2级质量标准")
    private String tncStdValB;
    @ApiModelProperty(value = "A3级质量标准")
    private String tncStdValC;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "论证信息集合")
    private List<SlpdDiscussStd> discussStdList;

    public Long getTncStdId() {
        return tncStdId;
    }

    public void setTncStdId(Long tncStdId) {
        this.tncStdId = tncStdId;
    }

    public Long getTncStdType() {
        return tncStdType;
    }

    public void setTncStdType(Long tncStdType) {
        this.tncStdType = tncStdType;
    }

    public String getTncStdTypeStr() {
        return tncStdTypeStr;
    }

    public void setTncStdTypeStr(String tncStdTypeStr) {
        this.tncStdTypeStr = tncStdTypeStr;
    }

    public String getTncStdValA() {
        return tncStdValA;
    }

    public void setTncStdValA(String tncStdValA) {
        this.tncStdValA = tncStdValA;
    }

    public String getTncStdValB() {
        return tncStdValB;
    }

    public void setTncStdValB(String tncStdValB) {
        this.tncStdValB = tncStdValB;
    }

    public String getTncStdValC() {
        return tncStdValC;
    }

    public void setTncStdValC(String tncStdValC) {
        this.tncStdValC = tncStdValC;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SlpdDiscussStd> getDiscussStdList() {
        return discussStdList;
    }

    public void setDiscussStdList(List<SlpdDiscussStd> discussStdList) {
        this.discussStdList = discussStdList;
    }
}
