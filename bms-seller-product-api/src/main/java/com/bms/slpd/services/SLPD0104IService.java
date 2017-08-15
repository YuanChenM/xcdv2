package com.bms.slpd.services;


import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0104IService extends BaseService {
    /**
     * <p>查询产品二级分类</p>
     * */
    @Transactional(readOnly = true)
    List<SlpdMachiningResult> findMachinings(SLPD0104IParam slpd0104IParam);

}
