package com.bms.como.service;

import com.bms.como.bean.entity.ComoProductInfo;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ProductInfoCreateRsParam;
import com.bms.como.bean.param.ProductInfoRsParam;
import com.bms.como.bean.result.ComoProductInfoResult;
import com.bms.como.bean.result.ProductInfoResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public interface ComoProductInfoService extends BaseService {

    /**
     * 查询商品信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<ProductInfoResult> searchProductInfo(ProductInfoRsParam productInfoRsParam);


    /**
     * 新增商品信息
     */
    @Transactional
    ComoProductInfoResult createProductInfo(ProductInfoCreateRsParam productInfoCreateRsParam);



    /**
     * 修改商品信息
     */
    @Transactional
    ComoProductInfoResult modityProductInfo(BaseBean<ComoProductInfo, ComoProductInfo> comoProductInfo);
}
