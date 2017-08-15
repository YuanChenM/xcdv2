package com.bms.slim.dao;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.bms.slim.bean.entity.target.SlimContactTarget;
import com.bms.slim.bean.entity.target.SlimSellerContractPermissionTarget;
import com.framework.boot.base.BaseDao;

public interface SLIM0246IDao extends BaseDao {

    /**
     * 修改联系人信息
     */
    int updateContact(UpdateEntity<SlimContact, SlimContactTarget> updateEntity);

}
