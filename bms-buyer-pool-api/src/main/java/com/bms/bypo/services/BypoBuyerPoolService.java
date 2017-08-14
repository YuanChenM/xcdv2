/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.BuyerPoolRsParam;
import com.bms.bypo.bean.result.BuyerPoolRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BypoBuyerPoolService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BypoBuyerPoolService extends BaseService {

    /**
     * 每100条插入DB
     * 并返回插入的数据和插入条数
     * @param inParamList
     * @return
     */
    @Transactional
    BuyerPoolRsResult insertBuyerPool(List<BuyerPoolRsParam> inParamList);

    /**
     * 更新DB数据
     * @param updateParamList
     * @return
     */
    @Transactional
    BuyerPoolRsResult modifyBuyerPool(List<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> updateParamList);
}