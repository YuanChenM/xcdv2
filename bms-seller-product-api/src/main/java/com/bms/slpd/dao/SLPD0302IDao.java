package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdBreed;
import com.bms.slpd.bean.entity.SlpdItem;
import com.bms.slpd.bean.param.wrapper.SLPD0302IItemParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0302IDao extends BaseDao {
    /**
     * 新增单品信息
     */
    int saveItems(List<SlpdItem> slpdFeatures);

    /**
     * 查询品种Sku
     */
    List<SlpdBreed> findBreedSku(List<Long> breedIds);

    /**
     * 查询单品名称是否存在
     */
    List<SlpdItem> findItemName(List<SLPD0302IItemParam> feature);

    List<SlpdItem> findItmeCode(List<SLPD0302IItemParam> insertList);
}
