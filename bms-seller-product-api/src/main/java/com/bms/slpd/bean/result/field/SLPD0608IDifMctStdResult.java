package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdDifDiscussStd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SlpdDifMctStdResult",description = "加工技术标准档案卡")
public class SLPD0608IDifMctStdResult extends SLPDFileCardResult {
    @ApiModelProperty(value = "主键Id")
    private Long mctDifStdId;
    @ApiModelProperty(value = "加工技术类型")
    private Long mctStdType;
    @ApiModelProperty(value = "加工技术类型名称")
    private String mctStdTypeStr;
    @ApiModelProperty(value = "合格差异值")
    private String mctOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String mctNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "论证信息")
    List<SlpdDifDiscussStd> difDiscussStdList;

    public Long getMctDifStdId() {
        return mctDifStdId;
    }

    public void setMctDifStdId(Long mctDifStdId) {
        this.mctDifStdId = mctDifStdId;
    }

    public Long getMctStdType() {
        return mctStdType;
    }

    public void setMctStdType(Long mctStdType) {
        this.mctStdType = mctStdType;
    }

    public String getMctStdTypeStr() {
        return mctStdTypeStr;
    }

    public void setMctStdTypeStr(String mctStdTypeStr) {
        this.mctStdTypeStr = mctStdTypeStr;
    }

    public String getMctOkDifVal() {
        return mctOkDifVal;
    }

    public void setMctOkDifVal(String mctOkDifVal) {
        this.mctOkDifVal = mctOkDifVal;
    }

    public String getMctNgDifVal() {
        return mctNgDifVal;
    }

    public void setMctNgDifVal(String mctNgDifVal) {
        this.mctNgDifVal = mctNgDifVal;
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
