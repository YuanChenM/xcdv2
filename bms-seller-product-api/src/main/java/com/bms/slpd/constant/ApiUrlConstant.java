package com.bms.slpd.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * REST API URL常量类
 */
public interface ApiUrlConstant {

	/**
	 * 卖家信息(SLIM)模块REST API URL
	 */
	interface SLIM {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:8080";
		/** API根路径 */
		//String CONTEXT_PATH = "/bms-slim-api";
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("slim-api");

		/** 批量查询卖家 */
		String API0102 = "/api/sellers/_find";

		/** 批量查询卖方单位 */
		String API0250 = "/api/sellers/entity/_find";
	}

	/**
	 * 卖家信息(SLIM)模块REST API URL
	 */
	interface REGION {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:8080";
		/** API根路径 */
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("region-api");

		/** 查询物流区 */
		String logisticsSearch = "/api/region/logistics/_search";
	}

	/**
	 * 商品信息(COMO)模块REST API URL
	 */
	interface COMO {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://10.0.2.195:9070";
		/** API根路径 */
		//String CONTEXT_PATH = "/bms-slim-api";
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("como-api");

		/** 批量插入商品产品信息 */
		String API0101 = "/api/product/info/_create";
		/** 查询商品信息 */
		String API0102 = "/api/commodity/info/_search";
		/** 生成默认商品 */
		String API0103 = "/api/commodity/info/_create";
		/** 删除商品 */
		String API0104 = "/api/commodity/info/_modify";
		/** 删除产品 */
		String API0105 = "/api/product/info/_modify";

	}

	/**
	 * 库存(LINV)模块REST API URL
	 */
	interface LINV {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:8080";
		/** API根路径 */
		//String CONTEXT_PATH = "/bms-slim-api";
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("linv-api");

		/** 查询货权商品库存接口 */
		String API0101 = "/api/linv/comoInv/_search";

		/** 查询产品库存接口 */
		String API0102 = "/api/linv/loadInv/_search";
	}

	/**
	 * 库存(LINV)模块REST API URL
	 */
	interface PRCE {
		/** true：访问本地，false: 访问服务器 */
		boolean LOCAL_FLAG = false;
		/** 本地IP和端口 */
		String LOCALHOST = "http://localhost:9060";
		/** API根路径 */
		//String CONTEXT_PATH = "/bms-slim-api";
		String CONTEXT_PATH = ConfigServerPropertyLoad.getModelName("prce-api");

		/** 删除价盘信息 */
		String API0101 = "/api/prce/plate/_delete";
	}

}
