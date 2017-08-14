/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimDeliveryAreaService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimDeliveryAreaService extends BaseService {

    @Transactional
    int saveDeliveryArea(List<DeliveryAreaRsParam> params);

    @Transactional
    int updateDeliveryArea(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params);

    @Transactional
    int findDeliveryArea(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params);
}