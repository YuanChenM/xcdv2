package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import com.bms.slpd.bean.param.field.SLPD0505IItemPropertyParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/*
 *修改品牌单品规格
 */
public interface SLPD0505IDao extends BaseDao {

    /**
     * 修改品牌单品规格
     */
    int updateItemProperties(UpdateEntity updateEntity);


    /**
     * 查询单品规格是否已经生成产品
     */
    int findExistProducts(List<Long> itemPropertyIds);

}