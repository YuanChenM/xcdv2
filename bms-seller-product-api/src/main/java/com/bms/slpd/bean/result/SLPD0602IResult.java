package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0602IDifOrgStdResult;
import com.bms.slpd.bean.result.field.SLPD0602IOrgStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0602IResult",description = "查询原种种源标准指标接口出参")
public class SLPD0602IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标准档案卡")
    private Map<Long,List<SLPD0602IOrgStdResult>> slpdStds;
    @ApiModelProperty(value = "差异档案卡")
    private Map<Object,List<SLPD0602IDifOrgStdResult>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public Map<Long, List<SLPD0602IOrgStdResult>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, List<SLPD0602IOrgStdResult>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, List<SLPD0602IDifOrgStdResult>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, List<SLPD0602IDifOrgStdResult>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
