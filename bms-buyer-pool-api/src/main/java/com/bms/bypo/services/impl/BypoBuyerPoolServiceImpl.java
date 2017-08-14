/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bypo.services.impl;

import com.bms.bypo.bean.entity.BypoBuyerPool;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.BuyerPoolRsParam;
import com.bms.bypo.bean.result.BuyerPoolRsResult;
import com.bms.bypo.dao.BypoBuyerPoolDao;
import com.bms.bypo.services.BypoBuyerPoolService;
import com.bms.bypo.utils.RestCommUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>BypoBuyerPoolService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class BypoBuyerPoolServiceImpl extends BaseServiceImpl implements BypoBuyerPoolService{

    @Autowired
    private BypoBuyerPoolDao bypoBuyerPoolDao;

    @Override
    public BaseDao getBaseDao() {
      return bypoBuyerPoolDao;
    }

    @Override
    public BuyerPoolRsResult insertBuyerPool(List<BuyerPoolRsParam> inParamList) {
        BuyerPoolRsResult result = new BuyerPoolRsResult();
        List<BypoBuyerPool> insertEntityList = new ArrayList<>();
        List<BuyerPoolRsParam> insertParamList = new ArrayList<>();
        for (BuyerPoolRsParam buyerPoolRsParam : inParamList){
            Long maxId = this.maxId("BYPO_BUYER_POOL");
            buyerPoolRsParam.setBuyerPoolId(maxId);
            buyerPoolRsParam.setDelFlg(false);
            buyerPoolRsParam.setCrtId(getLoginUserId());
            buyerPoolRsParam.setCrtTime(DateUtils.getCurrent());
            buyerPoolRsParam.setUpdId(getLoginUserId());
            buyerPoolRsParam.setUpdTime(DateUtils.getCurrent());
            buyerPoolRsParam.setVersion(1);
            insertParamList.add(buyerPoolRsParam);
            BypoBuyerPool bypoBuyerPool = BeanUtils.toBean(buyerPoolRsParam, BypoBuyerPool.class);
            insertEntityList.add(bypoBuyerPool);
        }
        result.setBuyerPoolList(insertParamList);
        int count = 0;
        List<List<BypoBuyerPool>> insertList = RestCommUtil.insertRanking(insertEntityList);
        if (!CollectionUtils.isEmpty(insertList)) {
            for (int i = 0; i < insertList.size(); i++) {
                count = count + this.batchSave(insertEntityList);
            }
        }
        result.setCount(count);
        return result;
    }

    @Override
    public BuyerPoolRsResult modifyBuyerPool(List<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> updateParamList) {
        //更新DB
        BuyerPoolRsResult buyerPoolRsResult = new BuyerPoolRsResult();
        int count = 0;
        Long[] buyerPoolId = new Long[updateParamList.size()];
        for (int i = 0; i < updateParamList.size(); i++) {
            BypoBuyerPool filterEntity = BeanUtils.toBean(updateParamList.get(i).getFilter(), BypoBuyerPool.class);
            BypoBuyerPool targetEntity = BeanUtils.toBean(updateParamList.get(i).getTarget(), BypoBuyerPool.class);
            targetEntity.setUpdId(getLoginUserId());
            targetEntity.setUpdTime(DateUtils.getCurrent());
            BaseBean<BypoBuyerPool, BypoBuyerPool> updateEntityParam = new BaseBean<>();
            updateEntityParam.setFilter(filterEntity);
            updateEntityParam.setTarget(targetEntity);
            count = count + this.modify(updateEntityParam);
            buyerPoolId[i] = updateParamList.get(i).getFilter().getBuyerPoolId();
        }
        buyerPoolRsResult.setCount(count);
        buyerPoolRsResult.setBuyerPoolId(buyerPoolId);
        return buyerPoolRsResult;
    }
}