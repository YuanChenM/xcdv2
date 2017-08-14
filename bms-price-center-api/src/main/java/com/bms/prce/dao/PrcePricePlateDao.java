package com.bms.prce.dao;

import com.bms.prce.bean.entity.PrcePricePlate;
import com.bms.prce.bean.param.*;
import com.bms.prce.bean.result.PRCE0211IResult;
import com.bms.prce.bean.result.PRCE0213IPlateDetailResult;
import com.bms.prce.bean.result.PRCE0213IResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface PrcePricePlateDao extends BaseDao {
    List<PrcePricePlate> findPlateByTime(PRCE0210IDealParam param);

    List<PRCE0211IResult> findPlates(PRCE0211IParam param);

    int deleteModify(PRCE0210IDealParam param);

    int modifyByTime(PRCE0210IDealParam param);

    int saveByTime(PRCE0210IDealParam param);

    Long findPlateId(PRCESearchParam param);

    List<PRCE0213IResult> findPrcePricePlateList(PRCE0213IParam param);

    List<PRCE0213IPlateDetailResult> findPrcePricePlate(PRCE0213IParam param);
}