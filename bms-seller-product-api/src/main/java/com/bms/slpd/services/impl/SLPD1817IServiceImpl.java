package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.target.SlpdProductTarget;
import com.bms.slpd.bean.param.SLPD1805IParam;
import com.bms.slpd.bean.param.SLPD1817IParam;
import com.bms.slpd.bean.param.field.SLPD1817IProductParam;
import com.bms.slpd.bean.param.wrapper.ComoProductRsParam;
import com.bms.slpd.bean.result.SLPD1817IResult;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD1817IDao;
import com.bms.slpd.services.SLPD1805IService;
import com.bms.slpd.services.SLPD1817IService;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD1817IServiceImpl extends BaseServiceImpl implements SLPD1817IService {
    private static final Logger logger = LoggerFactory.getLogger(SLPD1817IServiceImpl.class);
    @Autowired
    private SLPD1817IDao slpd1817IDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private SLPD1805IService slpd1805IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd1817IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD1817IResult updateProducts(SLPD1817IParam requestParam) {
        SLPD1817IResult result = new SLPD1817IResult();

        List<String> productIds = new ArrayList<>();
        List<SLPD1817IProductParam> productList = requestParam.getProductParams();
        for (SLPD1817IProductParam param : productList) {
            productIds.add(param.getProductId());
        }

        //step1 判断产品生产商是否已生成
        SLPD1805IParam slpd1805iParam = new SLPD1805IParam();
        slpd1805iParam.setProductIds(productIds);
        BaseRestPaginationResult<SLPD1805IProductProducerResult> producerProduct = slpd1805IService.findProductProducers(slpd1805iParam);
        if (NumberConst.IntDef.INT_ZERO < producerProduct.getTotal()) {
            result.setMessages(new String[]{"F", ("产品已生成生产商产品,请先删除生产商产品.").toString()});
            return result;
        }

        //step2 判断产品是否存在商品库存,不存在允许删除,同时删除对应的商品,否则不允许删除
        this.searchCommodityInfo(productIds);
//        if (this.searchCommodityInfo(productIds)) {
//            result.setMessages(new String[]{"F", ("产品已生成商品,请重新选择.").toString()});
//            return result;
//        }

        String userId = super.getLoginUserId();
        Date updTime = DateUtils.getCurrent();

        SlpdProductTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdProduct, SlpdProductTarget>> updateList = new ArrayList<>();
        SlpdProduct product = null;

        for (SLPD1817IProductParam param : productList) {
            UpdateEntity<SlpdProduct, SlpdProductTarget> updateEntity = new UpdateEntity<>();
            product = BeanUtils.toBean(param, SlpdProduct.class);
            product.setUpdId(userId);
            product.setUpdTime(updTime);
            updateEntity.setEntity(product);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        for (UpdateEntity<SlpdProduct, SlpdProductTarget> updateEntity : updateList) {
            int productCount = slpd1817IDao.updateProduct(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < productCount) {
                count += productCount;
                productIds = new ArrayList<>();
                productIds.add(updateEntity.getEntity().getProductId());
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "productId:" + updateEntity.getEntity().getProductId() + "不存在");
            }
        }

        result.setCount(count);
        result.setProductIds(productIds);
        return result;
    }

    /**
     * 设置target
     */
    private SlpdProductTarget setTarget(SLPD1817IParam requestParam) {
        String[] targets = requestParam.getTargets();
        StringBuilder builder = new StringBuilder();
        SlpdProductTarget productTarget = new SlpdProductTarget();

        for (String str : targets) {
            if ("delFlg".equals(str)) {
                productTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("指定的target有误").toString());
        }

        return productTarget;
    }

    /**
     * 查询产品是否已经生成商品
     */
    private void searchCommodityInfo(List<String> productIds) {
        ComoProductRsParam comoProductRsParam = null;
        for (String productId : productIds) {
            comoProductRsParam = new ComoProductRsParam();
            comoProductRsParam.setProductId(productId);
            comoProductRsParam.setPagination(null);
            //API调API"http://10.0.2.184:9070/oms-como/api/commodity/info/_search";
            RestApiClient restApiClient = this.restApiClientFactory.newApiRestClient();
            String url = RestApiUtils.getUrl(ApiUrlConstant.COMO.CONTEXT_PATH, ApiUrlConstant.COMO.API0102, ApiUrlConstant.COMO.LOCAL_FLAG, ApiUrlConstant.COMO.LOCALHOST);
            TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
            };

            Map<String, Object> resultMap = restApiClient.post(url, comoProductRsParam, typeReference);
            if (NumberConst.IntDef.INT_ZERO < (Integer) resultMap.get("total")) {
                List<Long> commodityIds = new ArrayList<>();
                List<Map<String, Object>> restCommodityData = (List<Map<String, Object>>) resultMap.get("data");
                for (Map<String, Object> map : restCommodityData) {
                    commodityIds.add(Long.valueOf((Integer)map.get("commodityId")));
                }
                if (this.checkLinvCommodity(commodityIds)) {
                    throw new BusinessException("SLPD", "产品已生成对应的商品库存,删除失败.");
                } else {
                    //存在商品,但没有库存,删除商品模块的产品和商品
                    this.delCommodityAndProduct(restCommodityData, productId);
                }
            }
        }
    }

    /**
     * 根据commodityIds查询货权库存是否存在
     */
    private Boolean checkLinvCommodity(List<Long> commodityIds) {
        RestApiClient restApiClient = this.restApiClientFactory.newApiRestClient();
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        String linvUrl = RestApiUtils.getUrl(ApiUrlConstant.LINV.CONTEXT_PATH, ApiUrlConstant.LINV.API0101, ApiUrlConstant.LINV.LOCAL_FLAG, ApiUrlConstant.LINV.LOCALHOST);
        HashMap<String, Object> linvParamMap = new HashMap<>();
        List<String> linvCommodityIds = new ArrayList<>();
        for (Long commodityId : commodityIds) {
            linvCommodityIds.add(commodityId.toString());
        }
        linvParamMap.put("commodityId", linvCommodityIds);
        linvParamMap.put("pagination", null);
        //判断是否生成商品库存
        Map<String, Object> linvResult = restApiClient.post(linvUrl, linvParamMap, typeReference);
        if (NumberConst.IntDef.INT_ZERO < (Integer) linvResult.get("total")) {
            //生成库存不允许删除
//            throw new BusinessException("SLPD", "产品已生成对应的商品库存,删除失败.");
            return true;
        }
        return false;
    }

    /**
     * 删除商品模块商品和产品信息
     */
    private void delCommodityAndProduct(List<Map<String, Object>> commodities, String productId) {
        String delCommodityUrl = RestApiUtils.getUrl(ApiUrlConstant.COMO.CONTEXT_PATH, ApiUrlConstant.COMO.API0104, ApiUrlConstant.COMO.LOCAL_FLAG, ApiUrlConstant.COMO.LOCALHOST);
        String delProductUrl = RestApiUtils.getUrl(ApiUrlConstant.COMO.CONTEXT_PATH, ApiUrlConstant.COMO.API0105, ApiUrlConstant.COMO.LOCAL_FLAG, ApiUrlConstant.COMO.LOCALHOST);
        String delPrceProductUrl = RestApiUtils.getUrl(ApiUrlConstant.PRCE.CONTEXT_PATH, ApiUrlConstant.PRCE.API0101, ApiUrlConstant.PRCE.LOCAL_FLAG, ApiUrlConstant.PRCE.LOCALHOST);
        RestApiClient restApiClient = this.restApiClientFactory.newApiRestClient();
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> commodityParam = null;
        HashMap<String, Object> commodityRestParam = null;
        for (Map<String, Object> map : commodities) {
            commodityParam = new HashMap<>();
            commodityParam.put("commodityId", map.get("commodityId"));
            commodityParam.put("version", map.get("version"));
            commodityParam.put("delFlg", true);
            commodityRestParam = new HashMap<>();
            commodityRestParam.put("filter", commodityParam);
            commodityRestParam.put("target", commodityParam);
            restApiClient.post(delCommodityUrl, commodityRestParam, typeReference);    //删除商品
            logger.info("删除商品信息成功,商品id:" + map.get("commodityId"));
        }

        //删除商品模块产品
        HashMap<String, Object> productParam = new HashMap<>();
        HashMap<String, Object> productRestParam = new HashMap<>();
        productParam.put("productId", productId);
        productParam.put("delFlg", true);
        productParam.put("version", NumberConst.IntDef.INT_ONE);    //暂定固定值1
        productRestParam.put("filter", productParam);
        productRestParam.put("target", productParam);
        restApiClient.post(delProductUrl, productRestParam, typeReference);
        logger.info("删除商品模块产品成功,产品id:" + productId);
        //删除价盘信息
        ArrayList<Map<String,Object>> prceParamList = new ArrayList<>();
        Map<String,Object> precCommodityParam = null;
        for (Map<String, Object> map : commodities) {
            precCommodityParam = new HashedMap();
            precCommodityParam.put("goodId", map.get("commodityId"));
            prceParamList.add(precCommodityParam);
        }
        if (CollectionUtils.isNotEmpty(prceParamList)) {
            TypeReference<Integer> prceTypeRerence = new TypeReference<Integer>() {
            };
            restApiClient.post(delPrceProductUrl, prceParamList, prceTypeRerence);    //删除商品
            logger.info("删除价盘信息成功,商品id参数:" + JSON.toJSONString(prceParamList));
        }
    }

}