package com.bms.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.web.result.BasePagePagingResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 价盘营销状态查询
 * @author  zhou_ling
 * @Time  2017/01/11
 * @version  1.0
 */
@ApiModel(value = "PRCE0203IParam",
    description = "价盘营销状态查询")
public class PRCE0203IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    /**
     * Getter method for property <tt>marketingStatusName</tt>.
     *
     * @return property value of marketingStatusName
     */
    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    /**
     * Setter method for property <tt>marketingStatusName</tt>.
     *
     * @param marketingStatusName value to be assigned to property marketingStatusName
     */
    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

}