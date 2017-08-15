package com.bms.order.dao;

import com.bms.order.bean.entity.BuyerOrderEntity;
import com.framework.boot.base.BaseDao;

/**
 * Created by ni_shaotang on 2016/12/30.
 */
public interface ORDR0201IDao extends BaseDao {
    Integer getOtherOrderCount(BuyerOrderEntity entity);
}
