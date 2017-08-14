/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimBuyerPoolRelationShip;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.dao.ByimBuyerPoolRelationShipDao;
import com.bms.byim.services.ByimBuyerPoolRelationShipService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ByimBuyerPoolRelationShipService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimBuyerPoolRelationShipServiceImpl extends BaseServiceImpl implements ByimBuyerPoolRelationShipService {

    @Autowired
    private ByimBuyerPoolRelationShipDao byimBuyerPoolRelationShipDao;

    @Override
    public BaseDao getBaseDao() {
        return byimBuyerPoolRelationShipDao;
    }

    @Override
    public Integer executeBatchSave(List<List<ByimBuyerPoolRelationShip>> paramList) {
        int insertCount;
        int countAll = NumberUtils.INTEGER_ZERO;
        int splSize = paramList.size();
        for (int j = 0; j < splSize; j++) {
            insertCount = batchSave(paramList.get(j));
            countAll += insertCount;
        }
        return countAll;
    }

    @Override
    public Integer executeUpdate(List<BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip>> paramList) {
        for (int i = 0, sizes = paramList.size(); i < sizes; i++) {
            int updateCount = modify(paramList.get(i));
            if (updateCount == NumberConst.IntDef.INT_ZERO) {
                return updateCount;
            }
        }
        return paramList.size();
    }
}