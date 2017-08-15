package com.bms.slpd.utils;

import com.bms.slpd.constant.MessageConstant;

/**
 * 提示信息工具类
 */
public class MessageUtils {

	/**
	 * 提示成功
	 */
	public static String[] getSuccessMessage() {
		return new String[]{MessageConstant.SUCCESS};
	}

	/**
	 * 提示失败
	 */
	public static String[] getFailureMessage() {
		return new String[]{MessageConstant.FAILURE};
	}

}
