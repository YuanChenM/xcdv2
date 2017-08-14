package com.bms.puch.fms.constant;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * oms到fms的push订单类型
 */
public interface MessageDef {

    String ERROR_BAD_PARAM_MSG = "传入参数有误！";
    String ERROR_BAD_DATA_MSG = "没有可以执行的数据！";
    String ERROR_POST_FAIL = "异常：FMS接口调用失败！";
    String ERROR_ENV = "此环境不能推送信息到FMS！";
}
