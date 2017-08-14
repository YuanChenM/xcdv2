package com.batch.bybatch.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.batch.bybatch.bean.param.BuyerAllRsParam;
import com.batch.bybatch.bean.param.BuyerPoolAndProductRsParam;
import com.batch.bybatch.bean.param.BuyerPoolRelationShipParam;
import com.batch.bybatch.bean.result.BuyerAllRsResult;
import com.batch.bybatch.bean.result.BuyerPoolAndProductRsResult;
import com.batch.bybatch.bean.result.BuyerProductResult;
import com.batch.bybatch.constant.ApiUrlDef;
import com.batch.bybatch.service.BYIM0102BService;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuan_zhifei on 2017/5/26.
 */
@Service
public class BYIM0102BServiceImpl extends BaseServiceImpl implements BYIM0102BService {
    Logger logger = LoggerFactory.getLogger(BYIM0102BServiceImpl.class);

    @Override
    public BaseDao getBaseDao() {
        return null;
    }

    @Override
    public void doProcessWork(List<? extends BuyerProductResult> results) {
        if (CollectionUtils.isNotEmpty(results)) {
            ArrayList<BuyerPoolRelationShipParam> relationShipParams = new ArrayList<>();
            for (BuyerProductResult productResult : results) {
                //调用查询买家信息接口
                String buyerUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BYIM.buyerInfoSearch);
                BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
                buyerAllRsParam.setPagination(null);
                buyerAllRsParam.setBuyerId(productResult.getBuyerId());
                RestBatchClient buyerClient = (new RestBatchClientFactory()).newBatchRestClient();
                BaseWebPaginationResult<BuyerAllRsResult> buyerResult = buyerClient.post(buyerUrl, buyerAllRsParam,
                        new TypeReference<BaseWebPaginationResult<BuyerAllRsResult>>() {
                        }, "BYIM0102B");
                if (CollectionUtils.isNotEmpty(buyerResult.getData())) {
                    //根据买家订单信息查询是否有符合买家的买家池
                    BuyerAllRsResult buyer = buyerResult.getData().get(NumberConst.IntDef.INT_ZERO);
                    BuyerPoolAndProductRsParam productRsParam = new BuyerPoolAndProductRsParam();
                    productRsParam.setPagination(null);
                    productRsParam.setLgcsAreaId(buyer.getLgcsAreaId());
                    //productRsParam.setZoneId(buyer.getZoneId());
                    productRsParam.setBuyerType(buyer.getBuyerType());
                    productRsParam.setBuyerFirstCategory(buyer.getBuyerFirstCategory());
                    productRsParam.setClassesId(productResult.getClassesId());
                    productRsParam.setMachiningId(productResult.getMachiningId());
                    productRsParam.setBreedId(productResult.getBreedId());
                    productRsParam.setFeatureId(productResult.getItemId());
                    productRsParam.setBrandId(productResult.getBrandId());
                    //productRsParam.setProducerId(productResult.getEntitySellerId());
                    //有品牌
                    productRsParam.setModifyFlg("1");
                    List<BuyerPoolAndProductRsResult> buyerPoolProducts = this.findBuyerPoolProducts(productRsParam);
                    if (CollectionUtils.isEmpty(buyerPoolProducts)) {
                        //无品牌
                        productRsParam.setModifyFlg("2");
                        buyerPoolProducts = this.findBuyerPoolProducts(productRsParam);
                        /*if (CollectionUtils.isEmpty(buyerPoolProducts)) {
                            //无品牌有生产商
                            productRsParam.setModifyFlg("3");
                            buyerPoolProducts = this.findBuyerPoolProducts(productRsParam);
                            if (CollectionUtils.isEmpty(buyerPoolProducts)) {
                                //无品牌无生产商
                                productRsParam.setModifyFlg("4");
                                buyerPoolProducts = this.findBuyerPoolProducts(productRsParam);
                            }
                        }*/
                    }
                    if (CollectionUtils.isEmpty(buyerPoolProducts)) {
                        logger.debug("买家ID：" + productResult.getBuyerId() + "产品ID：" + productResult.getProductId() + "不存在符合的该买家的买家池");
                        continue;
                    } else {
                        for (int i = NumberConst.IntDef.INT_ZERO; i < buyerPoolProducts.size(); i++) {
                            //check买家是否已添加过该买家池
                            BuyerPoolRelationShipParam relationShipParam = new BuyerPoolRelationShipParam();
                            relationShipParam.setBuyerId(productResult.getBuyerId());
                            if (buyerPoolProducts.get(i).getBuyerPoolId() != null) {
                                relationShipParam.setBuyerPoolId(buyerPoolProducts.get(i).getBuyerPoolId());
                            }
                            int result = this.findBuyerPoolRelation(relationShipParam);
                            if (result > NumberConst.IntDef.INT_ZERO) {
                                logger.debug("买家ID：" + productResult.getBuyerId() + "产品ID：" + productResult.getProductId() + "的买家已添加过买家池ID为"
                                        + relationShipParam.getBuyerPoolId() + "的买家池");
                                continue;
                            } else {
                                BuyerPoolRelationShipParam buyerPoolRelation = BeanUtils.toBean(buyerPoolProducts.get(i),
                                        BuyerPoolRelationShipParam.class);
                                buyerPoolRelation.setBuyerId(productResult.getBuyerId());
                                buyerPoolRelation.setMarketingFirstStatus(buyer.getMarketingFirstStatus());
                                buyerPoolRelation.setMarketingFirstStatusName(buyer.getMarketingFirstStatusName());
                                relationShipParams.add(buyerPoolRelation);
                            }
                        }
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(relationShipParams)) {
                this.addBuyerPoolRelation(relationShipParams);
            }
        }
    }

    private List<BuyerPoolAndProductRsResult> findBuyerPoolProducts(BuyerPoolAndProductRsParam productRsParam) {
        //调用查询买家池和产品信息接口
        String productUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYPO_MODULE, ApiUrlDef.bypo.buyerPoolProductSearch);
        //String productUrl = "http://localhost:8091/oms-bypo/api/buyerPoolAndProduct/_search";
        RestBatchClient client = (new RestBatchClientFactory()).newBatchRestClient();
        BaseWebPaginationResult<BuyerPoolAndProductRsResult> buyerPoolProductResult = client.post(productUrl, productRsParam,
                new TypeReference<BaseWebPaginationResult<BuyerPoolAndProductRsResult>>() {
                }, "BYIM0102B");
        return buyerPoolProductResult.getData();
    }

    private int findBuyerPoolRelation(BuyerPoolRelationShipParam relationShipParam) {
        int result = NumberConst.IntDef.INT_ZERO;
        String buyerPoolUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BYIM.buyerPoolRelationSearch);
        RestBatchClient buyerPoolClient = (new RestBatchClientFactory()).newBatchRestClient();
        ArrayList<BuyerPoolRelationShipParam> relationShipParams = buyerPoolClient.post(buyerPoolUrl, relationShipParam,
                new TypeReference<ArrayList<BuyerPoolRelationShipParam>>() {
                }, "BYIM0102B");
        if (relationShipParams != null && CollectionUtils.isNotEmpty(relationShipParams)) {
            result = NumberConst.IntDef.INT_ONE;
        }
        return result;
    }

    private void addBuyerPoolRelation(ArrayList<BuyerPoolRelationShipParam> relationShipParams) {
        ArrayList<BuyerPoolRelationShipParam> list = new ArrayList<>();
        for (int i = NumberConst.IntDef.INT_ZERO; i < relationShipParams.size(); i++) {
            //check买家是否已添加过该买家池
            BuyerPoolRelationShipParam relationShipParam = relationShipParams.get(i);
            BuyerPoolRelationShipParam relation = new BuyerPoolRelationShipParam();
            relation.setBuyerId(relationShipParam.getBuyerId());
            relation.setBuyerPoolId(relationShipParam.getBuyerPoolId());
            int result = this.findBuyerPoolRelation(relation);
            if (result > NumberConst.IntDef.INT_ZERO) {
                logger.debug("买家ID：" + relationShipParam.getBuyerId() + "的买家已添加过买家池ID为"
                        + relationShipParam.getBuyerPoolId() + "的买家池");
                continue;
            } else {
                list.add(relationShipParam);
            }
        }
        //判断新增买家买家池关系的数据是否存在重复
        Set<BuyerPoolRelationShipParam> setResult = new HashSet<>();
        setResult.addAll(list);
        ArrayList<BuyerPoolRelationShipParam> results = new ArrayList<>(setResult);
        String relationUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BYIM.buyerBuyerPoolAdd);
        RestBatchClient restClient = (new RestBatchClientFactory()).newBatchRestClient();
        Integer response = restClient.post(relationUrl, results,
                new TypeReference<Integer>() {
                }, "BYIM0102B");
        logger.debug("新增买家买家池关系条数为：" + response);
    }
}
