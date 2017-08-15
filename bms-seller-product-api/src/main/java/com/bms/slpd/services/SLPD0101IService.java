
package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.param.SLPD0101IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0101IService extends BaseService {

    /**
     * <p>查询产品一级分类</p>
     */
    @Transactional(readOnly = true)
    List<SlpdClasses> findClasses(SLPD0101IParam slpd0101IParam);

}