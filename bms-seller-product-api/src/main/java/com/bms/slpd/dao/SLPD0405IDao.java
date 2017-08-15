package com.bms.slpd.dao;

import com.bms.slpd.bean.result.field.SLPD0403IBrandResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandOwnerResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/*
 *查询品牌所有人信息
 */
public interface SLPD0405IDao extends BaseDao {
    /**
     * 根据品牌Id查询品牌所有人信息
     */
     List<SLPD0403IBrandResult> findBrandOwner(List<Long> list);

    //查询最大code的数据
    SlpdBrandOwnerResult findBrandOwnerByCode();
}