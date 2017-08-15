package com.bms.order.services;

import com.bms.order.bean.entity.OrdrShortsellDetail;
import com.bms.order.bean.param.ORDR1102IRestParam;
import com.bms.order.bean.result.ORDR1102IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_haichun on 2017/4/26.
 */
public interface ORDR1102IService extends BaseService {

    /** 查询沽货订单 */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<ORDR1102IRestResult> findOrdrShortsell(ORDR1102IRestParam param);


    /** 查询沽货订单明细 */
    @Transactional(readOnly = true)
    List<OrdrShortsellDetail> findOrdrShortsellDetail(List<Long> orderIds);


}
