package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.bms.slpd.bean.result.SLPD0610IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0610IService extends BaseService {

    /**
     * <p>新增加工质量标准</p>
     */
    @Transactional
    SLPD0610IResult addTncStds(List<SLPD0610ITncStdParam> list);

}