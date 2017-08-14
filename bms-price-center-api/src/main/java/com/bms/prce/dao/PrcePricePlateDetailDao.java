/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.dao;

import com.bms.prce.bean.entity.PrcePricePlate;
import com.bms.prce.bean.entity.PrcePricePlateDetail;
import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.bean.param.PRCE0210IDealParam;
import com.bms.prce.bean.result.PRCE0209IResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>PrcePricePlateDetailDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrcePricePlateDetailDao extends BaseDao {
    List<PrcePricePlate> findPlate(PRCE0209IParam param);

    PRCE0209IResult findTargetPlate(PRCE0209IParam param);

    int deleteModify(PrcePricePlate pricePlate);

    int batchDelete(PRCE0210IDealParam param);
}