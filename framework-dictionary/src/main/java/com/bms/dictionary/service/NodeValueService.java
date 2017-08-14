package com.bms.dictionary.service;

import com.bms.dictionary.bean.param.CreateDataParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
public interface NodeValueService extends BaseService {
    @Transactional
    Boolean createDataNode(CreateDataParam createDataParam);
}
