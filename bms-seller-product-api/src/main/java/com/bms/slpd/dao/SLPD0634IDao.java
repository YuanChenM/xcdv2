package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdDifTncStd;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0634IDao extends BaseDao {
    /**
     * 新增加工质量标准差异
     */
    int saveTncDifStds(List<SlpdDifTncStd> tncStdList);

}