package com.batch.bybatch.service;

import com.batch.bybatch.bean.result.BuyerOrderResult;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.bean.result.OrderSearchRestResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/3/31.
 */
public interface RestCommonService {

    @Transactional
    OrderSearchRestResult<BuyerOrderResult> getOrderListInfo(ByimBuyerResult byimBuyerResult);
}
