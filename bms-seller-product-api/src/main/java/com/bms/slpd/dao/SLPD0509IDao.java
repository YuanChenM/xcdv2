package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0509IDao extends BaseDao {

	/**
	 * 修改代理商产品的审核状态
	 */
	int updateAgentProductAuditStu(SlpdAgentSupplyProduct product);

	/**
	 * 查询未准入的制造商
	 */
	List<SlpdManufacturerProduct> findManufacturers(List<Long> agentIds);

}
