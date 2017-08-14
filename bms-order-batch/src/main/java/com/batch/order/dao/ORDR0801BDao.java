package com.batch.order.dao;

import com.batch.order.bean.entity.BuyerReturnHistoryEntity;
import com.batch.order.bean.result.ORDR0801BDetailResult;
import com.batch.order.bean.result.ORDR0801BResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0801BDao extends BaseDao {
    List<ORDR0801BResult> getReturnResults();

    List<ORDR0801BDetailResult> getReturnDetailResults(ORDR0801BResult result);

    BuyerReturnHistoryEntity getReturnInfo(ORDR0801BResult result);

    void saveHistory(BuyerReturnHistoryEntity buyerReturnHistoryEntity);

    void modifyReturnStu(ORDR0801BResult result);
}
