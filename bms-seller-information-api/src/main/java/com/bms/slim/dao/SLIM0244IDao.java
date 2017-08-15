package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLIM0244IDao extends BaseDao {

    /**
     * 批量新增联系人
     */
    int saveContacts(List<SlimContact> list);
}
