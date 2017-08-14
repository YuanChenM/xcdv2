package com.batch.bybatch.constant;

/**
 * Created by guan_zhongheng on 2017/2/27.
 */
public interface ByimCommConstant {

    interface CommString{
        /** 常客买家等级（频次） */
        String FREQ_MAP_F = "freqMapF";
        /** 常客买家等级（量级） */
        String FREQ_MAP_A = "freqMapA";
        /** 常客买家等级编码 */
        String FREQ_CODE = "freqCode";
        /** 买家定性评级 */
        String GRADE_MAP = "gradeMap";
        /** 未定级（频次） */
        String NOT_FREQ_MAP_F = "频次未定级";
        /** 未定级（量级） */
        String NOT_FREQ_MAP_A = "量级未定级";
        /** 未定性 */
        String NOT_GRADE_MAP = "未定性";
        /** batchID */
        String BYIM_BATCH = "BYIM0101B";
        /** 操作者类型  005 管理员*/
        String OPERATOR_TYPE = "005";
        /** 操作者id  随机*/
        String OPERATOR_ID = "123456";

        /** 订单状态 已完成*/
        String BUYER_ORDER_STU = "004";

        String STR_ZERO = "0";
        String STR_ONE = "1";
        String STR_TWO = "2";
        String STR_THREE = "3";
        String STR_FOUR = "4";
    }

    interface CommNumber{
        int NUM_ZERO = 0;
        int NUM_ONE = 1;
        int NUM_TWO = 2;
        int NUM_THREE = 3;
        int NUM_FOUR = 4;
    }
}
