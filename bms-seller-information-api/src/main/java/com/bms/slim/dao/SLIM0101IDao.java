package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.entity.SlimSeller;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0101IDao extends BaseDao {

    /**
     * 查询是否有重名的实体卖家
     */
    int countSameFullNames(List<String> fullNames);

    /**
     * 批量新增实体卖家
     */
    int saveEntitySellers(List<SlimEntitySeller> entitySellers);

    /**
     *  根据cityCode获取entitySellerDisplayCode最大值
     */
    List<SlimEntitySeller> getMaxEntitySellerDisplayCode(List<String> cityCode);

    /**
     *  根据entitySellerId获取entitySellerCode最大值
     */
    List<SlimEntitySeller> getMaxEntitySellerCode();

    /**
     * 批量新增卖家联系人
     */
    int saveContacts(List<SlimContact> contacts);

}
