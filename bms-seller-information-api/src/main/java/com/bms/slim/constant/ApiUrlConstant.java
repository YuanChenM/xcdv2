package com.bms.slim.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * REST API URL常量类
 */
public interface ApiUrlConstant {

	/**
	 * 卖家产品(SLPD)模块REST API URL
	 */
	interface SLPD {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:8080";
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("slpd-api");
	}

	/** 物流区接口 */
	interface REGION {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:8080";
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("region-api");

		String regionZoneSearch = "/api/region/zone/district/_search";
	}

}
