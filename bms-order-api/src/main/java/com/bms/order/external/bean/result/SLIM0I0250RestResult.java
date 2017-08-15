package com.bms.order.external.bean.result;

import com.bms.order.common.rest.param.RestBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class SLIM0I0250RestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long entitySellerId;

    private String entitySellerCode;

    private String fullName;

    private String shortName;

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getEntitySellerCode() {
        return entitySellerCode;
    }

    public void setEntitySellerCode(String entitySellerCode) {
        this.entitySellerCode = entitySellerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
