package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdMctStd;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0607IDao extends BaseDao {

    /**
     * 新增加工技术标准指标
     */
    int saveMctStds(List<SlpdMctStd> mctStdList);

}