package com.bms.puch.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
@ApiModel(value = "ScheduleParam",
        description = "计划订单表")
@XmlRootElement(name = "Schedule")
public class ScheduleParam implements Serializable {

    @ApiModelProperty(value = "计划入库单号")
    @XmlElement(name = "scheduleCode")
    private String scheduleCode;

    @ApiModelProperty(value = "计划入库时间")
    @XmlElement(name = "scheduleDate")
    @XmlInlineBinaryData
    private Date scheduleDate;

    @ApiModelProperty(value = "明细")
    @XmlElement(name = "detailList")
    @XmlInlineBinaryData
    private List<PuchDetailParam> detailList;

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public List<PuchDetailParam> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<PuchDetailParam> detailList) {
        this.detailList = detailList;
    }
}
