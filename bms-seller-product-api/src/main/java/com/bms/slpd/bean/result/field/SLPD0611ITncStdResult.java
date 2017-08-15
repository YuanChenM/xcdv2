package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdDiscussStd;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SLPD0611ITncStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "主键ID")
    private Long tncStdId;
    @ApiModelProperty(value = "加工质量类型ID")
    private Long tncStdType;
    @ApiModelProperty(value = "A1级质量标准")
    private String tncStdValA;
    @ApiModelProperty(value = "A2级质量标准")
    private String tncStdValB;
    @ApiModelProperty(value = "A3级质量标准")
    private String tncStdValC;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "加工质量类型名称")
    private String tncStdTypeStr;
    @ApiModelProperty(value = "论证信息")
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

    public String getTncStdTypeStr() {
        return tncStdTypeStr;
    }

    public void setTncStdTypeStr(String tncStdTypeStr) {
        this.tncStdTypeStr = tncStdTypeStr;
    }

    public List<SlpdDiscussStd> getDiscussStdList() {
        return discussStdList;
    }

    public void setDiscussStdList(List<SlpdDiscussStd> discussStdList) {
        this.discussStdList = discussStdList;
    }
}
