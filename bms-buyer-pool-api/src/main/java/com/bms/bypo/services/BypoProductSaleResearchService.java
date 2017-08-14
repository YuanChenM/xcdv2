/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleResearchRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>BypoProductSaleResearchService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BypoProductSaleResearchService extends BaseService {

    @Transactional
    Integer insert(ProductSaleResearchRsParam param);

    @Transactional
    Integer update(BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam> param);
}