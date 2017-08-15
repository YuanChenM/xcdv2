package com.bms.order.services.impl;

import com.bms.order.bean.entity.OrdrShortsellDetail;
import com.bms.order.bean.param.ORDR1102IRestParam;
import com.bms.order.bean.result.ORDR1102IRestResult;
import com.bms.order.dao.ORDR1102IDao;
import com.bms.order.services.ORDR1102IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_haichun on 2017/4/26.
 */
@Service
public class ORDR1102IServiceImpl extends BaseServiceImpl implements ORDR1102IService {
    private final String PAGINGLEVEL_ONE = "1";//查询订单信息
    private final String PAGINGLEVEL_TWO = "2";//查询订单明细


    @Autowired
    private ORDR1102IDao ordr1102IDao;

    @Override
    public BaseDao getBaseDao() {
        return ordr1102IDao;
    }


    @Override
    public BaseRestPaginationResult<ORDR1102IRestResult> findOrdrShortsell(ORDR1102IRestParam param) {
        BaseRestPaginationResult<ORDR1102IRestResult> shortsellResult = new BaseRestPaginationResult();
        if(param.getPagingLevel().equals(PAGINGLEVEL_ONE) || param.getPagingLevel().equals(PAGINGLEVEL_TWO)){
            shortsellResult = findPageList(param);
            if(shortsellResult != null && CollectionUtils.isNotEmpty(shortsellResult.getData()) && param.getPagingLevel().equals(PAGINGLEVEL_TWO)){
                List<Long> orderIds = new ArrayList<>();
                for(ORDR1102IRestResult shortsell : shortsellResult.getData()){
                    orderIds.add(shortsell.getOrderId());
                }
                if(CollectionUtils.isNotEmpty(orderIds)){
                    List<OrdrShortsellDetail> shortsellDetailList = this.findOrdrShortsellDetail(orderIds);
                    if(CollectionUtils.isNotEmpty(shortsellDetailList)){
                        List<OrdrShortsellDetail> detailList = null;
                        for(ORDR1102IRestResult shortsell : shortsellResult.getData()){
                            detailList = new ArrayList<>();
                            for(OrdrShortsellDetail detail : shortsellDetailList){
                                if(detail.getOrderId().equals(shortsell.getOrderId())){
                                    detailList.add(detail);
                                }
                            }
                            shortsell.setDetails(detailList);
                        }
                    }
                }
            }
        }
        return shortsellResult;
    }

    @Override
    public List<OrdrShortsellDetail> findOrdrShortsellDetail(List<Long> orderIds) {
        return ordr1102IDao.findOrdrShortsellDetail(orderIds);
    }
}
