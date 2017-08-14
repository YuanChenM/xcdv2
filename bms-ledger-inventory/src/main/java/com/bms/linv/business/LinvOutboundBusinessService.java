package com.bms.linv.business;

import java.util.List;

import com.bms.linv.bean.param.LINV0102IParam;
import org.springframework.transaction.annotation.Transactional;

import com.framework.boot.base.BaseService;

/**
 * 出库业务
 * Created by wang_fan on 2017/4/19.
 */
public interface LinvOutboundBusinessService extends BaseService {

    @Transactional
    void dispatchLoads(List<LINV0102IParam> params);

}
