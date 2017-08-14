package com.bms.linv.business;

import java.util.List;

import com.bms.linv.bean.param.LINV0105IParam;
import org.springframework.transaction.annotation.Transactional;

import com.framework.boot.base.BaseService;

/**
 * 商品交易
 * Created by wang_fan on 2017/4/18.
 */
public interface LinvDealBusinessService extends BaseService {

    @Transactional
    void dealStore(List<LINV0105IParam> params);

}
