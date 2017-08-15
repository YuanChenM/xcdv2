package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSeller;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0102IDao extends BaseDao {

	/**
	 * 根据实体卖家ID，批量查询联系人
	 */
	List<SlimContact> findContactsByEntitySellerIds(List<Long> workunitIds);

}
