package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0208IParam;
import com.bms.slim.bean.result.field.SLIM0208DesignatSlaughterPermitResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0208IService extends BaseService {

    /**
     * 查询生产商生产资质-定点屠宰许可证
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0208DesignatSlaughterPermitResult> findDesignatSlaughterPermit(SLIM0208IParam slim0208IParam);

}
