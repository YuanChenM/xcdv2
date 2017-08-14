package com.bms.como.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * REST API URL常量类
 */
public interface ApiUrlConstant {

	/**
	 * 卖家产品(SLPD)模块REST API URL
	 */
	interface SLPD {
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("slpd-api");

		/** 批量查询单品品牌规格 */
		String API1804 = "/api/classes/machinings/breeds/brands/items/properties/_find";

		/** 批量查询产品生产商 */
		String API1805 = "/api/classes/machinings/breeds/brands/items/properties/producers/_find";

		/** 批量查询制造商产品 */
		String API1806 = "/api/classes/machinings/breeds/brands/items/properties/manufacturer/_find";
	}


	/**
	 * 卖家信息(SLIM)模块REST API URL
	 */
	interface SLIM {
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("slim-api");

		/** 批量查询卖方单位 */
		String API0250 = "/api/sellers/entity/_find";

		/** 批量查询生产商生产资质-管理体系认证证书 */
		String API0220 = "/api/producers/production/qualifications/iso/_find";

		/** 批量查询卖方单位角色 */
		String API0248 = "/api/sellers/roles/_find";


	}


	/**
	 * 行政区划(REGION)模块REST API URL
	 */
	interface REGN {
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("region-api");

		/** 查询物流区 */
		String API0301 = "api/region/logistics/_search";
	}
}
