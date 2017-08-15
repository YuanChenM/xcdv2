package com.bms.order.services.impl;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0403IFilterParam;
import com.bms.order.bean.param.ORDR0502IDetailFilterParam;
import com.bms.order.bean.param.ORDR0502IFilterParam;
import com.bms.order.bean.result.ORDR0502IDetailsRestResult;
import com.bms.order.bean.result.ORDR0502IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.dao.ORDR0502IDao;
import com.bms.order.services.ORDR0502IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_jianzhou on 2017/1/18.
 */
@Service
public class ORDR0502IServiceImpl extends BaseServiceImpl implements ORDR0502IService {

    @Autowired
    private ORDR0502IDao ordr0502IDao;

    @Override
    public SearchRestResult<ORDR0502IRestResult> search(Operator operator, SearchRestParam<ORDR0502IFilterParam> param) {

        SearchRestResult<ORDR0502IRestResult> result = new SearchRestResult<ORDR0502IRestResult>();
//        BaseRestPaginationResult<ORDR0502IRestResult> searchResults = super.findPageList(param);

        List<ORDR0502IRestResult> restResults = ordr0502IDao.findPageInfos(param);
        int count = restResults.size();
        if (param.getPagination() != null)
            count = ordr0502IDao.getTotalCount(param);

        if(CollectionUtils.isNotEmpty(restResults)){
            for(ORDR0502IRestResult restResult : restResults){
                ORDR0502IDetailFilterParam detailFilterParam = new ORDR0502IDetailFilterParam();
                detailFilterParam.setReceiveNotificationId(restResult.getReceiveNotificationId());
                List<ORDR0502IDetailsRestResult> searchDetails = super.findList(detailFilterParam);
                restResult.setDetails(searchDetails);
            }
        }
        result.setData(restResults);
        result.setTotal(count);
        return result;
    }

    @Override
    public BaseDao getBaseDao() {
        return ordr0502IDao;
    }
}
