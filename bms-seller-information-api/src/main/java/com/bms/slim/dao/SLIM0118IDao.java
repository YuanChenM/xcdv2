package com.bms.slim.dao;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.bms.slim.bean.entity.target.SlimSellerContractPermissionTarget;
import com.framework.boot.base.BaseDao;

public interface SLIM0118IDao extends BaseDao {

    /**
     * 修改卖家合同信息准入
     */
    int updateSCP(UpdateEntity<SlimSellerContractPermission, SlimSellerContractPermissionTarget> updateEntity);

}
