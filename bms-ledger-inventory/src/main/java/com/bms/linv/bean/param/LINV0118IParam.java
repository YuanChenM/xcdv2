package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zheng_xu on 2017/5/03.
 */
@ApiModel(value = "LINV0118IParam",
        description = "库存调整列表")
@XmlRootElement(name="param")
public class LINV0118IParam implements Serializable {
    public static String TRANSACTION_TYPE = "118";
    @ApiModelProperty(value = "WMS中调整单号")
    @XmlElement(name="adjustCode")
    private String adjustCode;
    @ApiModelProperty(value = "调整时间")
    @XmlElement(name="adjustDate")
    private String adjustDate;
    @ApiModelProperty(value = "调整操作人")
    @XmlElement(name="adjustPerson")
    private String adjustPerson;
    @ApiModelProperty(value = "调整原因编码")
    @XmlElement(name="reasonCode")
    private String reasonCode;
    @ApiModelProperty(value = "调整原因")
    @XmlElement(name="reasonName")
    private String reasonName;
    @ApiModelProperty(value = "产品列表")
    @XmlElement(name="productList")
    private List<LINV0118IProductParam> productList;

    public String getAdjustCode() {
        return adjustCode;
    }

    public void setAdjustCode(String adjustCode) {
        this.adjustCode = adjustCode;
    }

    public String getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(String adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getAdjustPerson() {
        return adjustPerson;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public void setAdjustPerson(String adjustPerson) {
        this.adjustPerson = adjustPerson;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public List<LINV0118IProductParam> getProductList() {
        return productList;
    }

    public void setProductList(List<LINV0118IProductParam> productList) {
        this.productList = productList;
    }
}
