/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services;

import com.bms.bypo.bean.param.StandardProductRsParam;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>BypoStandardProductService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BypoStandardProductService extends BaseService {
    @Transactional(readOnly = true)
    int standardProductIsExist(StandardProductRsParam standardProductRsParam);

    @Transactional(readOnly = true)
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findStandardProduct(StandardProductRsParam rsParam);
}