package com.bms.slpd.dao;

import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import com.bms.slpd.bean.result.field.SLPD0501IItemPropertyResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/*
 *新增品牌单品规格
 */
public interface SLPD0504IDao extends BaseDao {

    /**
     * 查询新增的单品规格是否已经存在
     */
    List<SLPD0501IItemPropertyResult> findExistItemProperties(List<SLPD0504IItemPropertyParam> saveParam);

}