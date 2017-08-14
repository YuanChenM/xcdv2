package com.bms.dictionary.bean.param;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by dai_youcheng on 2016-11-10.
 */
public class ModifyDataParam extends BaseEntity implements Serializable {
    @ApiModelProperty(value = "字典值id")
    private String dataId;
    @ApiModelProperty(value = "中文")
    private String dataCn;
    @ApiModelProperty(value = "英文")
    private String dataEn;
    @ApiModelProperty(value = "值")
    private String dataValue;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataCn() {
        return dataCn;
    }

    public void setDataCn(String dataCn) {
        this.dataCn = dataCn;
    }

    public String getDataEn() {
        return dataEn;
    }

    public void setDataEn(String dataEn) {
        this.dataEn = dataEn;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }
}
