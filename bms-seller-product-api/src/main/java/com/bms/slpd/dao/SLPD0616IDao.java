package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdSftStd;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0616IDao extends BaseDao {
    /**
     * 新增安全标准档案卡
     */
    int saveSftStds(List<SlpdSftStd> sftStdList);
}