package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.entity.SlimSeller;
import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.field.SLIM0104ISBQParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0104IDao extends BaseDao {

    /**
     * 查询卖家实体是否已存在
     */
    List<SlimSellerBusinessQualification> findSellerEntityId(List<Long> entityId);

    /**
     * 批量新增实体卖家
     */
    int saveSBQs(List<SlimSellerBusinessQualification> sbqParams);

}
