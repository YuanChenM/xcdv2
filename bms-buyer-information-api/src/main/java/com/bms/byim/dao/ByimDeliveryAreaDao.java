/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.framework.boot.base.BaseDao;

/**
 * <p>ByimDeliveryAreaDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimDeliveryAreaDao extends BaseDao {
    int findDeliveryArea(BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam> param);
}