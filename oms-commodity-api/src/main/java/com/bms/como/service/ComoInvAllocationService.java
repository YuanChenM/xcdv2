/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.service;

import com.bms.como.bean.entity.ComoInvAllocationDetail;
import com.bms.como.bean.entity.ComoInvAllocationResult;
import com.bms.como.bean.param.AllocationResultRsParam;
import com.bms.como.bean.param.ComoInvAllocationRsParam;
import com.bms.como.bean.result.ComoInvAllocationRsResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ComoInvAllocationService。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ComoInvAllocationService extends BaseService {
    @Transactional
    ComoInvAllocationRsResult saveInvAllocation(ComoInvAllocationRsParam invAllocationRsParam);

    @Transactional(readOnly = true)
    BaseRestPaginationResult<ComoInvAllocationRsResult> searchInvAllocations(ComoInvAllocationRsParam invAllocationRsParam);

    @Transactional
    int saveInvAllocationResult(AllocationResultRsParam rsParam);


    /**
     * 根据AL-年月 查询数量
     */
    @Transactional(readOnly = true)
    int findInvAllocationCodeCount(String allocationCode);


    @Transactional
    int modifyInvAllocationDetail(ComoInvAllocationDetail param);


    @Transactional
    int addInvAllocationDetail(List<ComoInvAllocationResult> param);
}