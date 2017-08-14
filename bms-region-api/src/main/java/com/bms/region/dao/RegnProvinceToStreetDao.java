package com.bms.region.dao;

import com.bms.region.bean.param.RegnRelationParam;
import com.bms.region.bean.result.RegnRelationResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/2/15.
 */
public interface RegnProvinceToStreetDao extends BaseDao {

    List<RegnRelationResult> findProvincePageList(RegnRelationParam param);

    int countProvinceAll(RegnRelationParam param);
}
