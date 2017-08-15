package com.bms.order.services.impl;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0403IFilterParam;
import com.bms.order.bean.result.ORDR0403IDetailsRestResult;
import com.bms.order.bean.result.ORDR0403IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.dao.ORDR0403IDao;
import com.bms.order.services.ORDR0403IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
@Service
public class ORDR0403IServiceImpl extends BaseServiceImpl implements ORDR0403IService {

    @Autowired
    private ORDR0403IDao ordr0403IDao;

    @Override
    public SearchRestResult<ORDR0403IRestResult> search(Operator operator, SearchRestParam<ORDR0403IFilterParam> param) {

        SearchRestResult<ORDR0403IRestResult> result = new SearchRestResult<ORDR0403IRestResult>();
        this.setLikeCondition(param);
//        BaseRestPaginationResult<ORDR0403IRestResult> searchResults = super.findPageList(param);

        List<ORDR0403IRestResult> restResults = ordr0403IDao.findPageInfos(param);
        int count = restResults.size();
        if (param.getPagination() != null)
            count = ordr0403IDao.getTotalCount(param);


//        list.setTotal(count);
//        list.setData(restResults);
//        map.put("list", list);
//
//
//        List<ORDR0403IRestResult> restResultList = searchResults.getData();
        if (CollectionUtils.isNotEmpty(restResults)) {
            for (ORDR0403IRestResult restResult : restResults) {
                ORDR0403IFilterParam newParam = new ORDR0403IFilterParam();
                newParam.setSendNotifictionId(restResult.getSendNotifictionID()+"");
                List<ORDR0403IDetailsRestResult> searchDetails = super.findList(newParam);

                restResult.setDetails(searchDetails);
            }
        }
        setDisBatchCode(restResults);
        for (ORDR0403IRestResult restResult : restResults) {
            for(ORDR0403IDetailsRestResult detail : restResult.getDetails()){
                detail.setDisBatchCode(restResult.getDisBatchCode());
            }
        }
//        searchResults.setData(restResults);
        result.setData(restResults);
        result.setTotal(count);
        return result;
    }

    /**
     * 设置发货批次
     *
     * @param restResultList
     */
    private void setDisBatchCode(List<ORDR0403IRestResult> restResultList) {

        Map<Long, Integer> map = new HashedMap();
        for (ORDR0403IRestResult restResult : restResultList) {
            Long id = restResult.getDistributionNotificationId();
            Integer index = map.get(id);
            if (index == null)
                index = 0;
            index++;
            map.put(id, index);
            restResult.setDisBatchCode(String.valueOf(index));
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return ordr0403IDao;
    }


    /**
     * 设置 查询条件   前匹配
     *
     * @param param
     */
    public void setLikeCondition(SearchRestParam<ORDR0403IFilterParam> param) {
        ORDR0403IFilterParam filterParam = param.getFilter();

        String buyerCode = filterParam.getBuyerCode();//
        if (StringUtils.isNotEmpty(buyerCode)) {
            filterParam.setBuyerCode(buyerCode.trim() + "%");
        }

        String buyerName = filterParam.getBuyerName();//
        if (StringUtils.isNotEmpty(buyerName)) {
            filterParam.setBuyerName(buyerName.trim() + "%");
        }

        String buyerOrderCode = filterParam.getBuyerOrderCode();//
        if (StringUtils.isNotEmpty(buyerOrderCode)) {
            filterParam.setBuyerOrderCode(buyerOrderCode.trim() + "%");
        }
        String distributionNotificationCode = filterParam.getDistributionNotificationCode();//
        if (StringUtils.isNotEmpty(distributionNotificationCode)) {
            filterParam.setDistributionNotificationCode(distributionNotificationCode.trim() + "%");
        }
        String sendNotifictionCode = filterParam.getSendNotifictionCode();//
        if (StringUtils.isNotEmpty(sendNotifictionCode)) {
            filterParam.setSendNotifictionCode(sendNotifictionCode.trim() + "%");
        }


    }


}
