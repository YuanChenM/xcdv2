package com.framework.batch.constant;

/** 
 * <p>批处理常量集中管理。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/07
 * @version 1.0.0
 */
public interface BatchConstant {
	
	/**
	 * 批处理公共常量
	 */
	interface batchs {
	}

	/**
	 * 作业块常量
	 */
	interface Chunks {
		/** 提交间隔 */
		int COMMIT_INTERVAL = 100;
		
		/** 重试次数 */
		int RETRY_LIMIT = 3;
	}
	
	/**
	 * 作业步常量
	 */
	interface Steps {
	}
	
	/**
	 * 作业常量
	 */
	interface Jobs {
	}
	
	/**
	 * 条目常量
	 */
	interface Items {
		/** 每页条数 */
		int PAGE_SIZE = 100;
	}
	
}
