/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.result.PRCE0205IResult;
import com.bms.prce.bean.result.PRCE0205IWayConfigResult;
import com.bms.prce.dao.PrceMarketingWayConfigDao;
import com.bms.prce.service.PrceMarketingWayConfigService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DecimalUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>PrceMarketingWayConfigService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrceMarketingWayConfigServiceImpl extends BaseServiceImpl implements PrceMarketingWayConfigService {

    @Autowired
    private PrceMarketingWayConfigDao prceMarketingWayConfigDao;

    /**
     * 处理查询结果
     *
     * @param results
     */
    public void dealWayConfig(List<PRCE0205IResult> results) {
        for (PRCE0205IResult result : results) {
            List<PRCE0205IWayConfigResult> detailResults = result.getWayConfigList();
            if (CollectionUtils.isNotEmpty(detailResults)) {
                for (int i = 0; i < detailResults.size(); i++) {
                    PRCE0205IWayConfigResult detailResult = detailResults.get(i);
                    // 通道等级描述
                    detailResult.setWayDesc(detailResult.getWayDesc() + (i+1) + '级');
                    // 相邻等级系数差
                    if (i == 0) {
                        detailResult.setRatioDiff(null);
                    } else {
                        if (detailResult.getSumBalanceRatio() == null) {
                            detailResult.setRatioDiff(DecimalUtils.subtract(detailResult.getBalanceRatio(), detailResults.get(i - 1).getBalanceRatio()));
                        } else {
                            detailResult.setRatioDiff(DecimalUtils.subtract(detailResult.getSumBalanceRatio(), detailResults.get(i - 1).getSumBalanceRatio()));
                        }
                    }
                    // 通道准入描述
                    if (detailResult.getEndQty() == null) {
                        detailResult.setQtyDesc('≥' + detailResult.getStartQty().toString());
                    } else {
                        detailResult.setQtyDesc(detailResult.getStartQty().toString() + '-' + detailResult.getEndQty().toString());
                    }
                }
            }
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return prceMarketingWayConfigDao;
    }
}