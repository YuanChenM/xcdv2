package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0610IParam",description = "新增加工质量标准接口入参")
public class SLPD0610IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工技术标准指标集合")
    List<SLPD0610ITncStdParam> tncStdParams;

    public List<SLPD0610ITncStdParam> getTncStdParams() {
        return tncStdParams;
    }

    public void setTncStdParams(List<SLPD0610ITncStdParam> tncStdParams) {
        this.tncStdParams = tncStdParams;
    }
}
