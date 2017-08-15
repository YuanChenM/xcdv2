package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.framework.boot.base.BaseDao;

import java.util.List;


/*
 *查询品牌信息
 */
public interface SLPD0403IDao extends BaseDao {

    List<SlpdBrandResult> findListByName(List<SlpdBrand> params);

    //查询最大code的数据
    SlpdBrandResult findBrandByCode();

}