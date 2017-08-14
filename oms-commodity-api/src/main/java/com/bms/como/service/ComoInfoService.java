package com.bms.como.service;

import com.bms.como.bean.entity.ComoCommodityInfo;
import com.bms.como.bean.entity.ComoSaleStatus;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ComoDefaultRsParam;
import com.bms.como.bean.param.ComoInfoRsParam;
import com.bms.como.bean.param.ComoProductRsParam;
import com.bms.como.bean.result.ComoInfoResult;
import com.bms.como.bean.result.ComoProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public interface ComoInfoService extends BaseService {

    /**
     * 新增商品信息
     */
    @Transactional
    ComoInfoResult saveComeInfo(ComoInfoRsParam comoInfoRsParam);

    /**
     * 修改商品信息
     */
    @Transactional
    ComoInfoResult modifyComoInfo(BaseBean<ComoInfoRsParam, ComoInfoRsParam> comoInfoRsParam);


    /**
     * 查询商品信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<ComoProductResult> searchComoInfo(ComoProductRsParam comoProductRsParam);


    /**
     * 查询默认销售状态
     */
    @Transactional(readOnly = true)
    ComoSaleStatus findDefaultSaleStatu();


    /**
     * 根据产品SKU + 年月 查询数量
     */
    @Transactional(readOnly = true)
    int findComoCodeCount(String commodityCode);


    /** 修改产品下的默认商品为非默认 */
    @Transactional
    int modifyComoDefault(ComoCommodityInfo comoCommodityInfo);



    /** 查询产品下是否有默认商品 */
    @Transactional(readOnly = true)
    int findComoDefaultCount(ComoDefaultRsParam param);

    /**
     * 查询制造商产品信息
     */
    @Transactional(readOnly = true)
    Map<String, Object> getManufacturerProductInfo(String manufacturerProductSku);

}
