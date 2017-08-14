package com.bms.linv.business;

import java.util.List;

import com.bms.linv.bean.param.LINV0117IParam;
import com.bms.linv.bean.result.LINV0117IReslut;
import com.bms.linv.bean.result.LINV0117IResultParam;
import org.springframework.transaction.annotation.Transactional;

import com.bms.linv.bean.param.LINV0101IParam;
import com.framework.boot.base.BaseService;

/**
 * 入库业务
 * Created by wang_fan on 2017/4/14.
 */
public interface LinvInboundBusinessService extends BaseService {

    @Transactional
    void receiveLoads(List<LINV0101IParam> params);

    @Transactional
    List<LINV0117IResultParam> omsInbounds(LINV0117IParam params);


}
