package com.bms.slim.services;

import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.param.SLIM0101IParam;
import com.bms.slim.bean.param.field.SLIM0101IEntitySellerParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface SLIM0101IService extends BaseService {

    /**
     * 批量新增卖家、实体卖家、卖家联系人
     */
    @Transactional
    List<Long> addSellers(SLIM0101IParam slim0101iParam);

    /**
     * 根据卖家分类producerFlg、producerAgentFlg、manufacturerFlg、manufacturerAgentFlg标识，设置RequiredFlg标识
     */
    @Transactional(readOnly = true)
    void setEntitySellerRequiredFlags(SlimEntitySeller entitySeller);

    /** 根据cityCode获取entitySellerDisplayCode最大值 */
    @Transactional(readOnly = true)
    Map<String, String> getMaxSellerDisplayCode(List<SLIM0101IEntitySellerParam> entitySellerParams);

    /** 获取maxSellerCode最大值 */
    @Transactional(readOnly = true)
    String getMaxSellerCode();

}
