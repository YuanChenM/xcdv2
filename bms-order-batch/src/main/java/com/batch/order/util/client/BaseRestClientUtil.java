package com.batch.order.util.client;

import com.alibaba.fastjson.TypeReference;
import com.batch.order.bean.RestRequest;
import com.batch.order.bean.RestResponse;
import com.batch.order.bean.inv.param.LINV0103IParam;
import com.batch.order.bean.inv.param.LINV0110IParam;
import com.batch.order.bean.inv.result.LINV0110IInvResult;
import com.batch.order.bean.param.MailSendRsParam;
import com.batch.order.bean.param.ProductsRestParam;
import com.batch.order.bean.param.QueryApproveManufactureRestParam;
import com.batch.order.bean.price.param.PRCE0211IParam;
import com.batch.order.bean.price.result.PRCE0211IResult;
import com.batch.order.bean.result.OrderBatchEmailResult;
import com.batch.order.bean.result.ProductsRestResult;
import com.batch.order.bean.result.QueryApproveManufactureRestResult;
import com.batch.order.bean.seller.param.SLIM0250IParam;
import com.batch.order.bean.seller.result.SLIM0250IEntitySellerResult;
import com.batch.order.constant.OrderConstant;
import com.batch.order.constant.UrlConst;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.base.rest.SearchRestRequest;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/1/10.
 */
@Service
public class BaseRestClientUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(BaseRestClientUtil.class);

    @Autowired
    RestBatchClientFactory restBatchClientFactory;

    /**
     * 查询价盘接口
     *
     * @param paramList
     * @return
     */
    public List<PRCE0211IResult> getPriceResult(ArrayList<PRCE0211IParam> paramList) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = UrlConst.API_PRCE_URL + UrlConst.ACTION_PRCE0211I;
        logger.debug("查询价盘接口url:" + url);
        logger.debug("查询价盘接口参数:" + paramList);

        List<PRCE0211IResult> result = client.post(
                url, paramList,
                new TypeReference<ArrayList<PRCE0211IResult>>() {
                }, "ORDR0201B");
        logger.debug("查询价盘接口结果:" + result);
        return result;
    }

    /**
     * 产品库存查询
     *
     * @param param
     * @return
     */
    public BaseRestPaginationResult<LINV0110IInvResult> loadInvSearch(LINV0110IParam param) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0110I;
        logger.debug("产品库存查询接口url:" + url);
        logger.debug("产品库存查询接口参数:" + param);
        BaseRestPaginationResult<LINV0110IInvResult> result = client.post(url, param,new TypeReference<BaseRestPaginationResult<LINV0110IInvResult>>() {
                }, "ORDR0201B");
        logger.debug("产品库存查询接口结果:" + result);
        return result;
    }

    /**
     * 查询买家对于认可生产商信息
     *
     * @param restParam
     * @return
     */
    public RestResponse<QueryApproveManufactureRestResult> getBuyerManufactureInfo(QueryApproveManufactureRestParam restParam) {

        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        SearchRestRequest<QueryApproveManufactureRestParam> param = new SearchRestRequest<>();
        param.setFilter(restParam);
        String url = ConfigServerUtils.getGateWayUrl() + "/bms-order-api/api/buyers/manufacture/_find";
        logger.debug("查询买家对于认可生产商信息url:" + url);
        logger.debug("查询买家对于认可生产商信息参数:" + param);
        RestResponse<QueryApproveManufactureRestResult> result = client.post(
                url, param,
                new TypeReference<RestResponse<QueryApproveManufactureRestResult>>() {
                }, "ORDR0201B");
        logger.debug("查询买家对于认可生产商信息结果:" + result);
        return result;
    }

    /**
     * 查询商品对应的信息
     *
     * @param restParam
     * @return
     */
    public RestResponse<ProductsRestResult> getProductInfo(ProductsRestParam restParam) {

        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        SearchRestRequest<ProductsRestParam> param = new SearchRestRequest<>();
        param.setFilter(restParam);
        String url = ConfigServerUtils.getGateWayUrl() + "/bms-order-api/api/products/_find";
        logger.debug("查询商品对应的信息url:" + url);
        logger.debug("查询商品对应的信息参数:" + param);
        RestResponse<ProductsRestResult> result = client.post(
                url, param,
                new TypeReference<RestResponse<ProductsRestResult>>() {
                }, "ORDR0201B");
        logger.debug("查询商品对应的信息结果:" + result);
        return result;
    }

    /**
     * 查询生产商信息
     *
     * @param restParam
     * @return
     */
    public SLIM0250IEntitySellerResult getManufactureInfo(SLIM0250IParam restParam) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;
        logger.debug("查询生产商信息接口url:" + url);
        logger.debug("查询生产商信息接口参数:" + restParam);
        BaseRestPaginationResult<SLIM0250IEntitySellerResult> result = client.post(
                url, restParam,
                new TypeReference<BaseRestPaginationResult<SLIM0250IEntitySellerResult>>() {
                }, "ORDR0201B");
        logger.debug("查询生产商信息接口结果:" + result);
        if (null != result && !CollectionUtils.isEmpty(result.getData())) {
            return result.getData().get(NumberUtils.INTEGER_ZERO);
        }
        return null;
    }

    /**
     * 查询卖家信息
     *
     * @param param
     * @return
     */
    public List<SLIM0250IEntitySellerResult> getSellerInfo(SLIM0250IParam param) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;
        logger.debug("查询卖家信息接口url:" + url);
        logger.debug("查询卖家信息接口参数:" + param);
        BaseRestPaginationResult<SLIM0250IEntitySellerResult> result = client.post(
                url, param,
                new TypeReference<BaseRestPaginationResult<SLIM0250IEntitySellerResult>>() {
                }, "ORDR0201B");
        logger.debug("查询卖家信息接口结果:" + result);
        if (null != result && !CollectionUtils.isEmpty(result.getData())) {
            return result.getData();
        }
        return null;
    }

    /**
     * 普通库存占用
     *
     * @param params
     */
    public void addAllocateInv(ArrayList<LINV0103IParam> params) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0103I;
        logger.debug("产品库存占用接口url:" + url);
        logger.debug("产品库存占用参数:" + params);
        client.post(url, params, new TypeReference<String>(){}, "ORDR0201B");
        logger.debug("普通库存占用结果:成功");
    }

    /**
     * 发送邮件
     *
     * @param param
     */
    public RestResponse<String> sendMail(RestRequest<MailSendRsParam> param) {
        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = ConfigServerUtils.getAPIUrl("base-mail", "api/text/mail/template/_send");
        logger.debug("发送邮件接口url:" + url);
        logger.debug("发送邮件参数:" + param);
        RestResponse<String> restResponse = client.post(url, param, new TypeReference<RestResponse<String>>() {
        }, "ORDR0201B");
        return restResponse;
    }

    /**
     * 发送邮件
     *
     * @param emailResults
     */
    public void sendFailMail(List<OrderBatchEmailResult> emailResults) {
        logger.debug("batch出错，sendEmail");
        RestRequest<MailSendRsParam> restRequest = new RestRequest<MailSendRsParam>();
        MailSendRsParam param = new MailSendRsParam();

        // 模板邮件地址
        String[] arr = OrderConstant.EmailAddress.EMAIL_ADDRESS.split(",");
        if (arr==null || arr.length==0){
            return;
        }
        param.setMailTo(arr);
        // 模板邮件主题
        param.setSubject("订单batch出错提醒");
        if (CollectionUtils.isEmpty(emailResults)){
            return;
        }
        // 模板邮件内容
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("orders", emailResults);
        param.setTemplateData(templateData);
        // 模板名称
        param.setTemplateName("OrderBatchErrorNotice.vm");
        restRequest.setParam(param);


        RestBatchClient client = restBatchClientFactory.newBatchRestClient();
        String url = ConfigServerUtils.getAPIUrl("base-mail", "api/text/mail/template/_send");
        logger.debug("发送邮件接口url:" + url);
        logger.debug("发送邮件参数:" + param);
        RestResponse<String> restResponse = client.post(url, restRequest, new TypeReference<RestResponse<String>>() {
        }, "OrderBatch");
    }
}
