/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.linv.services;

import com.bms.linv.bean.param.LINV0112IInvParam;
import com.bms.linv.bean.param.LINV0113IParam;
import com.bms.linv.bean.result.LINV0112IInvResult;
import com.bms.linv.bean.result.LINV0113IResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>InvmComoInventoryService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface InvmComoInventoryService extends BaseService {


    /**
     *货权商品库存查询
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<LINV0113IResult> findComoInv(LINV0113IParam param);

    /**
     *平台商品总库存查询
     */
    @Transactional
    List<LINV0112IInvResult> findComoInvRelation(LINV0112IInvParam param);
}