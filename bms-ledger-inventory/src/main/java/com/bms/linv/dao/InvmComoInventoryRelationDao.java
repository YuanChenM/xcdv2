package com.bms.linv.dao;

import com.bms.linv.bean.result.LINV0112IInvResult;
import com.framework.boot.base.BaseDao;

/**
 * Created by guan_zhongheng on 2017/4/18.
 */
public interface InvmComoInventoryRelationDao extends BaseDao {
    LINV0112IInvResult findProductMaxQty(LINV0112IInvResult param);
}
