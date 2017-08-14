package com.batch.bybatch.reader;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.batch.bybatch.bean.param.BuyerOrderParam;
import com.batch.bybatch.bean.param.BuyerProductParam;
import com.batch.bybatch.bean.param.OrderSearchRestParam;
import com.batch.bybatch.bean.param.RestOperatorParam;
import com.batch.bybatch.bean.result.*;
import com.batch.bybatch.constant.ApiUrlDef;
import com.batch.bybatch.constant.ByimCommConstant;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
public class BYIM0102BItemReader extends MyServiceItemReader<BuyerProductResult> {

    private static final Logger logger = LoggerFactory.getLogger(BYIM0102BItemReader.class);

    @Override
    protected List<BuyerProductResult> query() {
        List<BuyerProductResult> buyerProducts = new ArrayList<>();
        OrderSearchRestParam<BuyerOrderParam> request = new OrderSearchRestParam<>();
        BuyerOrderParam param = new BuyerOrderParam();
        setBeginAndEndTime(param);
        param.setBuyerOrderStu(new String[]{"004"});
        RestOperatorParam operator = new RestOperatorParam();
        operator.setOperatorId(ByimCommConstant.CommString.OPERATOR_ID);
        operator.setOperatorType(ByimCommConstant.CommString.OPERATOR_TYPE);
        request.setOperator(operator);
        request.setFilter(param);
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.ORDER_MODULE, ApiUrlDef.ORDER.ORDER_BY_SEARCH);
        RestBatchClient client = (new RestBatchClientFactory()).newBatchRestClient();
        OrderSearchRestResult<BuyerOrderResult> response = client.post(url, request, new TypeReference<OrderSearchRestResult<BuyerOrderResult>>() {
        }, "BYIM0102B");
        //获取买家及下单产品信息
        List<BuyerProductResult> buyerProductResults = new ArrayList<>();
        if (response != null && CollectionUtils.isNotEmpty(response.getData())) {
            List<BuyerOrderResult> buyerOrderResults = response.getData();
            for (BuyerOrderResult orderResult : buyerOrderResults) {
                //买家ID不存在数据直接过滤
                if (StringUtils.isNotEmpty(orderResult.getBuyerId())) {
                    List<BuyerOrderBatchResutl> batchOrders = orderResult.getBatchOrders();
                    if (CollectionUtils.isNotEmpty(batchOrders)) {
                        for (BuyerOrderBatchResutl orderBatchResutl : batchOrders) {
                            //买家分批订单详情信息
                            List<BuyerOrderBatchDetailResult> batchDetailResults = orderBatchResutl.getBatchOrderDetails();
                            if (CollectionUtils.isNotEmpty(batchDetailResults)) {
                                for (BuyerOrderBatchDetailResult batchDetailResult : batchDetailResults) {
                                    BuyerProductResult buyerProductResult = new BuyerProductResult();
                                    buyerProductResult.setBuyerId(orderResult.getBuyerId());
                                    buyerProductResult.setProductId(batchDetailResult.getProductId());
                                    buyerProductResults.add(buyerProductResult);
                                }
                            }
                        }
                    }
                }
            }
        }
        //通过产品ID查询产品信息
        if (CollectionUtils.isNotEmpty(buyerProductResults)) {
            //去重
            Set<BuyerProductResult> setResult = new HashSet<>();
            setResult.addAll(buyerProductResults);
            List<BuyerProductResult> results = new ArrayList<>(setResult);
            BuyerProductParam productParam = new BuyerProductParam();
            for (int i = NumberConst.IntDef.INT_ZERO; i < results.size(); i++) {
                BuyerProductResult productResult = results.get(i);
                //产品ID不存在数据直接过滤
                if (results.get(i).getProductId() != null) {
                    String[] productIds = new String[]{results.get(i).getProductId()};
                    productParam.setProductIds(productIds);
                    String productUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.SLPD_MODULE, ApiUrlDef.SLPD.productSearchByProductId);
                    RestBatchClient productClient = (new RestBatchClientFactory()).newBatchRestClient();
                    HashMap<String, Object> productResultMap = productClient.post(productUrl, productParam, new TypeReference<HashMap<String, Object>>() {
                    }, "BYIM0102B");
                    JSONArray productJsonArray = (JSONArray) productResultMap.get("data");
                    for (Object object : productJsonArray) {
                        Map<String, Object> map = (Map) object;
                        String classesId = StringUtils.toString(map.get("classesId"));
                        String machiningId = StringUtils.toString(map.get("machiningId"));
                        String breedId = StringUtils.toString(map.get("breedId"));
                        String itemId = StringUtils.toString(map.get("itemId"));
                        String brandId = StringUtils.toString(map.get("brandId"));
                        //String entitySellerId = StringUtils.toString(map.get("entitySellerId"));
                        productResult.setClassesId(NumberUtils.toLong(classesId));
                        productResult.setMachiningId(NumberUtils.toLong(machiningId));
                        productResult.setBreedId(NumberUtils.toLong(breedId));
                        productResult.setItemId(NumberUtils.toLong(itemId));
                        productResult.setBrandId(NumberUtils.toLong(brandId));
                        //productResult.setEntitySellerId(NumberUtils.toLong(entitySellerId));
                        buyerProducts.add(productResult);
                    }
                }
            }
        }
        return buyerProducts;
    }

    /**
     * 不传时间的话默认查询前一天的买家订单
     */
    private static void setBeginAndEndTime(BuyerOrderParam param) {
        if (param.getUpdTimeFrom() == null && param.getUpdTimeTo() == null) {
            Date nowTime = DateUtils.getCurrent();
            Calendar calendar = Calendar.getInstance(); //得到日历
            // 设置计算开始时间
            Date beforeTime = DateUtils.getCurrent();
            calendar.setTime(beforeTime);
            calendar.add(Calendar.DATE, -1);    //得到前一天
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            String beginTime = year + "-" + month + "-" + day + " 00:00:00";
            param.setUpdTimeFrom(DateUtils.parseDateTime(beginTime));
            // 设置计算结束时间
            calendar.setTime(nowTime);
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            day = calendar.get(Calendar.DATE);
            String endTime = year + "-" + month + "-" + day + " 00:00:00";
            param.setUpdTimeTo(DateUtils.parseDateTime(endTime));
        }
    }

}
