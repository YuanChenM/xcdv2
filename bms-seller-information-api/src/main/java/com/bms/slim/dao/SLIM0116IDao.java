package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLIM0116IDao extends BaseDao {

    /**
     * 批量新增卖家合同信息准入
     */
    int saveSCPs(List<SlimSellerContractPermission> list);

    /**
     * 批量新增卖家合同联系人
     */
    int saveContacts(List<SlimContact> list);
}
