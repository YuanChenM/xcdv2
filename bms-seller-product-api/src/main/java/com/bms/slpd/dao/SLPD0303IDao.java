package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdItem;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.target.SlpdItemTarget;
import com.bms.slpd.bean.param.SLPD030301IParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0303IDao extends BaseDao {

    /**
     * 修改单品规格
     */
    int updateFeature(UpdateEntity<SlpdItem, SlpdItemTarget> slpdFeature);

    /**
     * 查询所有单品的breedId和itemName
     */
    List<SlpdItem> findBreedIdsAndItemNames(List<SLPD030301IParam> updItems);

    /**
     * 修改产品
     */
    int updateProduct(SlpdProduct product);

}
