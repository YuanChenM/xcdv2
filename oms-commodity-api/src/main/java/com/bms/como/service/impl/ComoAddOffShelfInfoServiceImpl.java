package com.bms.como.service.impl;

import com.bms.como.bean.param.ComoAddOffShelfInfoRsParam;
import com.bms.como.bean.result.ComoAddOffShelfInfoRsResult;
import com.bms.como.dao.ComoAddOffShelfInfoDao;
import com.bms.como.service.ComoAddOffShelfInfoService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhang_jian4 on 2017/4/5.
 */
@Service
public class ComoAddOffShelfInfoServiceImpl extends BaseServiceImpl implements ComoAddOffShelfInfoService {

    @Autowired
    private ComoAddOffShelfInfoDao comoAddOffShelfInfoDao;

    @Override
    public BaseDao getBaseDao() {
        return comoAddOffShelfInfoDao;
    }

    /**
     * 商品销售上下架管理
     */
    @Override
    public BaseRestPaginationResult<ComoAddOffShelfInfoRsResult> searchAddOffShelfInfo(ComoAddOffShelfInfoRsParam addOffShelfInfoRsParam){
        // 判断上下架时间
        Date shelfTime = null;
        if(DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfStart()) == null
                && DateUtils.parseDate(addOffShelfInfoRsParam.getOnShelfStart()) == null){
            addOffShelfInfoRsParam.setOnShelfStart(null);
        }else {
            shelfTime = DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfStart()) == null ? DateUtils.parseDate(addOffShelfInfoRsParam.getOnShelfStart()) : DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfStart());
            addOffShelfInfoRsParam.setOnShelfStart(DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS,shelfTime));
        }
        if(DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfEnd()) == null
                && DateUtils.parseDate(addOffShelfInfoRsParam.getOnShelfEnd()) == null){
            addOffShelfInfoRsParam.setOnShelfEnd(null);
        }else {
            shelfTime = DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfEnd()) == null ? DateUtils.parseDate(addOffShelfInfoRsParam.getOnShelfEnd()) : DateUtils.parseDateTime(addOffShelfInfoRsParam.getOnShelfEnd());
            addOffShelfInfoRsParam.setOnShelfEnd(DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS,shelfTime));
        }
        BaseRestPaginationResult<ComoAddOffShelfInfoRsResult> result = this.findPageList(addOffShelfInfoRsParam);
        return result;
    }

}
