package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0209IParam;
import com.bms.slim.bean.result.SLIM0209IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0209IService extends BaseService {

    /**
     * 修改生产商生产资质-定点屠宰许可证
     */
    @Transactional
    SLIM0209IResult updateDesignatSlaughterPermit(SLIM0209IParam slim0209IParam);

}
