/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0204IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>PrceMarketingStatusService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrceMarketingStatusService extends BaseService {

    /**
     * 营销状态修改
     * @Param param
     * @return  修改结果
     *
     */
     @Transactional
     int modifyMarketingStatus(PRCE0204IParam param);
}