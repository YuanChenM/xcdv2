package com.bms.como.dao;

import com.bms.como.bean.entity.ComoCommodityUom;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public interface ComoUomDao extends BaseDao {
    /**
     * 查询销售单位
     */
    List<ComoCommodityUom> findUomByComoIds(List<Long> comoIds);

    /**
     * 删除销售单位
     */
    int delUomByComoIds(List<Long> uomSid);
}
