package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0303IParam;
import com.bms.slim.bean.result.SLIM0303IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang_haichun on 2017/1/12.
 *
 * 修改卖家品牌
 */
public interface SLIM0303IService extends BaseService {


    @Transactional
    SLIM0303IResult updateSellerBrands(SLIM0303IParam slim0303IParam);

}
