package com.bms.slpd.dao;

import com.bms.slpd.bean.param.wrapper.SlpdBrandItemParam;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0502IDao extends BaseDao {

    /**
     * <p>根据单品Id获取单品Sku</p>
     */
    String findItemSkuByItemId(Long itemId);

    /**
     * <p>根据品牌ID获取品牌Code</p>
     */
    String findBrandCodeyBrandId(Long brandId);

    int findBrandItemCount(List<SlpdBrandItemParam> insertList);

}