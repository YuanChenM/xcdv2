package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0103IParam;
import com.bms.slim.bean.result.SLIM0103IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0103IService extends BaseService {

    /**
     * 批量修改实体卖家、卖家联系人
     */
    @Transactional
    int modifySellers(SLIM0103IParam slim0103iParam);


}
