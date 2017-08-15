package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;
import com.framework.base.bean.Sort;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买手退货原因查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0903IFilter extends RestFilter {

    private static final long serialVersionUID = 1L;

    /**
     * 退货原因ID
     */
    private Long reasonId;
    /**
     * 退货原因名称
     */
    private String reasonName;
    /**
     * 适用类型
     */
    private String applyType;
    /**
     * 适用对象
     */
    @ApiModelProperty(hidden = true)
    private String applyObject;

    private Sort[] sort;

    public Sort[] getSort() {
        return sort;
    }

    public void setSort(Sort[] sort) {
        this.sort = sort;
    }

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyObject() {
        return applyObject;
    }

    public void setApplyObject(String applyObject) {
        this.applyObject = applyObject;
    }
}
