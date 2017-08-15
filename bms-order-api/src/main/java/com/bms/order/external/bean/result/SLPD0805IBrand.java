package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */ // 品牌信息
public class SLPD0805IBrand implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3148963176321251727L;
    // 品牌ID
    private Long brandId;
    // 品牌编码
    private String brandCode;
    // 品牌名称
    private String brandName;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
