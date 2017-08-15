
package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.param.SLPD0101IParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0101IDao extends BaseDao {

    /**
     * 查询一级分类
     */
    List<SlpdClasses> findClasses(SLPD0101IParam slpd0101IParam);
}