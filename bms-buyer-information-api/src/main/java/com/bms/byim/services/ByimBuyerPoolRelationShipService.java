/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimBuyerPoolRelationShip;
import com.bms.byim.bean.param.BaseBean;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimBuyerPoolRelationShipService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimBuyerPoolRelationShipService extends BaseService {
    @Transactional
    Integer executeBatchSave(List<List<ByimBuyerPoolRelationShip>> paramList);

    @Transactional
    Integer executeUpdate(List<BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip>> paramList);
}