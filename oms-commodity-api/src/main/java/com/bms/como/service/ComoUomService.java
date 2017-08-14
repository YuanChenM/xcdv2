package com.bms.como.service;

import com.bms.como.bean.entity.ComoCommodityUom;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public interface ComoUomService extends BaseService {
    /**
     * 查询销售单位
     */
    @Transactional(readOnly = true)
    List<ComoCommodityUom> findUomByComoIds(List<Long> comoIds);

    /**
     * 删除销售单位
     */
    @Transactional
    int delUomByComoIds(List<Long> uomSid);
}
