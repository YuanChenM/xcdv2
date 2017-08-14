package com.bms.linv.business;

import com.bms.linv.bean.param.LINV0119IParam;
import com.bms.linv.bean.param.LINV0118IParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zheng_xu on 2017/5/3.
 */
public interface LinvAdjustBusinessService {
    /**
     * 库存调整
     * 
     * @param param
     */
    @Transactional
    void adjustLoads(LINV0118IParam param) throws Exception;

    /**
     * 商品库存调整
     * 
     * @param param
     */
    @Transactional
    void adjustComoInv(LINV0119IParam param) throws Exception;
}
