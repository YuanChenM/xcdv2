package com.batch.prce.dao;

import com.batch.prce.bean.entity.PrceProductInfo;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public interface PRCE0101BDao extends BaseDao {
    int batchInsertHis(List<PrceProductInfo> param);
}
