/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimAccount;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.BuyerBasicRsParam;
import com.bms.byim.bean.param.BuyerOtherRsParam;
import com.bms.byim.bean.result.BuyerIsUpdateRsResult;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>ByimBasicService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimBuyerService extends BaseService {

    @Transactional
    BuyerBasicRsParam insertBuyerBasic(BuyerBasicRsParam buyerBasicRsParam);

    @Transactional
    BuyerIsUpdateRsResult updateBuyerBasic(BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam);

    @Transactional(readOnly = true)
    String findMarketSequenceCode(Serializable param);

    String findDistrictSequenceCode(Serializable param);

    @Transactional(readOnly = true)
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findPageListToBuyerIds(T var1);

    @Transactional(readOnly = true)
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findBuyerAllInfoList(T var1);

    @Transactional(readOnly = true)
    int checkAccountIsExist(BuyerBasicRsParam basicRsParam);

    @Transactional(readOnly = true)
    int checkNameIsExist(BuyerBasicRsParam basicRsParam);

    @Transactional(readOnly = true)
    int checkTelNoIsExist(BuyerBasicRsParam basicRsParam);

    @Transactional(readOnly = true)
    int checkBuyerNameIsExist(BuyerBasicRsParam basicRsParam);

    @Transactional(readOnly = true)
    int checkBuyerAccountNoIsExist(BuyerBasicRsParam basicRsParam);

    @Transactional(readOnly = true)
    BuyerAccountRsParam findBuyerAccount(BuyerAccountRsParam accountRsParam);

    @Transactional
    int deleteAccount(ByimAccount byimAccount);

    @Transactional
    int updateBuyerAccount(BaseBean<ByimAccount, ByimAccount> baseBean);

    @Transactional(readOnly = true)
    String findBuyerId(BuyerAccountRsParam accountRsParam);
}