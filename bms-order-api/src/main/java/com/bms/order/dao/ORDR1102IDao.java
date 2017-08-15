package com.bms.order.dao;

import com.bms.order.bean.entity.OrdrShortsellDetail;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wang_haichun on 2017/4/26.
 */
public interface ORDR1102IDao extends BaseDao {


    /** 查询沽货订单明细 */
    List<OrdrShortsellDetail> findOrdrShortsellDetail(List<Long> orderIds);
}
