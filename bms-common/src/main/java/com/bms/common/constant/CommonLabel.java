package com.bms.common.constant;

/**
 * Created by mao_yejun on 2016/12/9.
 */
public interface CommonLabel {
    /**
     * button prefix
     */
    String BUTTON = "COMMON.BUTTON.";
    String LABEL = "COMMON.LABEL.";

    /**
     * button label
     */
    interface Button {
        /**
         * PREVIOUS:上一步
         */
        String PREVIOUS = BUTTON + "PREVIOUS";
        /**
         * NEXT:下一步
         */
        String NEXT = BUTTON + "NEXT";
        /**
         * SEARCH:搜索
         */
        String SEARCH = BUTTON + "SEARCH";
        /**
         * ADD:新增
         */
        String ADD = BUTTON + "ADD";
        /**
         * DETAILS:详情
         */
        String DETAILS = BUTTON + "DETAILS";
        /**
         * EDIT:编辑
         */
        String EDIT = BUTTON + "EDIT";
        /**
         * DELETE:删除
         */
        String DELETE = BUTTON + "DELETE";
        /**
         * SAVE:保存
         */
        String SAVE = BUTTON + "SAVE";

    }

    /**
     * label
     */
    interface Label {
        /**
         * SNO:编号
         */
        String SNO = LABEL + "SNO";
        /**
         * OPERATE:操作
         */
        String OPERATE = LABEL + "OPERATE";
        /**
         * PAGING:从{0}到{1}/共{2}条数据
         */
        String PAGING = LABEL + "PAGING";
        /**
         * JUMP:跳转
         */
        String JUMP = LABEL + "JUMP";
    }
}
