package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0606IParam",
        description = "修改饲养标准指标集合入参")
public class SLPD0606IParam implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "原种种源标准指标信息")
    private List<SLPD0601IFedStdParam> fedStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0601IFedStdParam> getFedStdParams() {
        return fedStdParams;
    }

    public void setFedStdParams(List<SLPD0601IFedStdParam> fedStdParams) {
        this.fedStdParams = fedStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
