/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.entity.ByimAccount;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.BuyerOtherRsParam;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>ByimBasicDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimBuyerDao extends BaseDao {
    String findMarketSequenceCode(Serializable param);

    String findDistrictSequenceCode(Serializable param);

    <T> List<T> findPageListToBuyerIds(Serializable param);

    <T> List<T> findBuyerAllInfoList(Serializable param);

    int checkAccountIsExist(Serializable param);

    int checkNameIsExist(Serializable param);

    int checkTelNoIsExist(Serializable param);

    int checkBuyerNameIsExist(Serializable param);

    int checkBuyerAccountNoIsExist(Serializable param);

    int saveAccount(Serializable var1);

    BuyerAccountRsParam findBuyerAccount(Serializable param);

    int updateBuyerAccount(BaseBean<ByimAccount, ByimAccount> baseBean);

    int deleteAccount(ByimAccount byimAccount);

    String findCode();

    String findBuyerId(BuyerOtherRsParam buyerOtherRsParam);
}