package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0104IResult", description = "查询二级分类接口出参")
public class SLPD0104IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;

    @ApiModelProperty(value = "查询产品二级分类返回结果")
    private List<SlpdMachiningResult> machiningList;

    public List<SlpdMachiningResult> getMachiningList() {
        return machiningList;
    }

    public void setMachiningList(List<SlpdMachiningResult> machiningList) {
        this.machiningList = machiningList;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
