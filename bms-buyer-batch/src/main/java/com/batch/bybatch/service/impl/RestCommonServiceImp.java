package com.batch.bybatch.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.batch.bybatch.bean.param.BuyerOrderParam;
import com.batch.bybatch.bean.param.OrderSearchRestParam;
import com.batch.bybatch.bean.param.RestOperatorParam;
import com.batch.bybatch.bean.result.BuyerOrderResult;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.bean.result.OrderSearchRestResult;
import com.batch.bybatch.constant.ApiUrlDef;
import com.batch.bybatch.constant.ByimCommConstant;
import com.batch.bybatch.service.RestCommonService;
import com.batch.bybatch.util.BaseRestClientUtil;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/3/31.
 */
@Service
public class RestCommonServiceImp implements RestCommonService {

    @Autowired
    private RestBatchClientFactory restBatchClientFactory;

    private static final Logger logger = LoggerFactory.getLogger(BaseRestClientUtil.class);

    @Override
    public OrderSearchRestResult<BuyerOrderResult> getOrderListInfo(ByimBuyerResult byimBuyerResult){
        OrderSearchRestParam<BuyerOrderParam> request = new OrderSearchRestParam<>();
        BuyerOrderParam param = new BuyerOrderParam();
        param.setBuyerId(new String[]{byimBuyerResult.getBuyerId()});
        // 设置查询时间
        setBeginAndEndTime(param);
        request.setFilter(param);

        RestOperatorParam operator = new RestOperatorParam();
        operator.setOperatorId(ByimCommConstant.CommString.OPERATOR_ID);
        operator.setOperatorType(ByimCommConstant.CommString.OPERATOR_TYPE);
        request.setOperator(operator);

        String url =  ConfigServerUtils.getAPIUrl(ApiUrlDef.ORDER_MODULE, ApiUrlDef.ORDER.ORDER_BY_SEARCH);
        logger.info("买家评级BATCH 查询订单接口url:" + url);
        logger.info("买家评级BATCH 查询订单接口参数:" + param.getBuyerId());
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        OrderSearchRestResult<BuyerOrderResult> response = client.post(url,request,new TypeReference<OrderSearchRestResult<BuyerOrderResult>>(){},"BYIM0101B");
        logger.info("买家评级BATCH 查询订单接口返回信息:" + response.getTotal() + "  ");
        return response;
    }

    /**
     * 获取查询两个半旬的时间
     */
    private static void setBeginAndEndTime(BuyerOrderParam param){
        Date nowTime = new Date();
//        nowTime = DateUtils.getCurrent();
        Calendar calendar = Calendar.getInstance(); //得到日历
        // 设置计算开始时间
        Date beforeTime = DateUtils.getCurrent();
        calendar.setTime(beforeTime);
        calendar.add(Calendar.DATE, -1);    //得到前一天
        calendar.add(Calendar.MONTH, -1);    //得到前一个月
        int year =  calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        String beginTime = year+ "-"+ month +"-"+ day + " 23:59:59";
        param.setUpdTimeFrom(DateUtils.parseDateTime(beginTime));
        // 设置计算结束时间
        calendar.setTime(nowTime);
        year =  calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);
        String endTime = year+ "-"+ month +"-"+ day + " 00:00:00";
        param.setUpdTimeTo(DateUtils.parseDateTime(endTime));
    }

}
