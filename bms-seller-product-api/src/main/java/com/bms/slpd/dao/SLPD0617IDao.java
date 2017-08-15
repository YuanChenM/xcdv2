package com.bms.slpd.dao;

import com.bms.slpd.bean.param.SLPD0617IParam;
import com.bms.slpd.bean.result.field.SLPD0617IDifSftStdResult;
import com.bms.slpd.bean.result.field.SLPD0617ISftStdResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0617IDao extends BaseDao {
    /**
     * 查询安全标准档案卡
     */
    List<SLPD0617ISftStdResult> findSftStds(SLPD0617IParam breedId);

    /**
     * 查询安全标准差异卡
     */
    List<SLPD0617IDifSftStdResult> findSftDifStds(SLPD0617IParam productId);
}
