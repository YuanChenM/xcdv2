package com.bms.slim.dao;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.entity.SlimSeller;
import com.bms.slim.bean.entity.target.SlimContactTarget;
import com.bms.slim.bean.entity.target.SlimEntitySellerTarget;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0103IDao extends BaseDao {


    /**
     * 根据实体卖家ID，修改实体卖家
     */
    int updateEntitySeller(UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget> entitySellerUe);

    /**
     * 根据卖家联系人ID，修改卖家联系人
     */
    int updateContact(UpdateEntity<SlimContact, SlimContactTarget> contactUe);

}
