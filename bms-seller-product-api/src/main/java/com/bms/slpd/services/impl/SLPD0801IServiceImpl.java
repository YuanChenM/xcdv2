package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.SLIM0102IParam;
import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.param.SLPD0801IParam;
import com.bms.slpd.bean.param.wrapper.SlpdSellerCommodityParam;
import com.bms.slpd.bean.result.SLPD0801IResult;
import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0801IDao;
import com.bms.slpd.services.SLPD0701IService;
import com.bms.slpd.services.SLPD0801IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD0801IServiceImpl extends BaseServiceImpl implements SLPD0801IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Autowired
    private SLPD0801IDao slpd0801IDao;

    @Autowired
    private SLPD0701IService slpd0701IService;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
      return slpd0801IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0801IResult addSellerCommodities(SLPD0801IParam slpd0801IParam) {
        List<SlpdSellerCommodity> sellerCommodityList = new ArrayList<>();
        List<Long> sellerCommodityIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        //新增排他
        List<SlpdSellerCommodity> slpdSellerCommodities = slpd0801IDao.findSellerProductProducers(slpd0801IParam.getSlpdSellerCommodities());
        StringBuilder sellerCommoditiyStr = new StringBuilder();
        if (CollectionUtils.isNotEmpty(slpdSellerCommodities)) {
            for (SlpdSellerCommodity commodity : slpdSellerCommodities) {
                sellerCommoditiyStr.append(commodity.getSellerId()).append("-").append(commodity.getProducerProductId())
                        .append("-").append(commodity.getSaleType()).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(sellerCommoditiyStr)) {
            SLPD0801IResult result = new SLPD0801IResult();
            String [] message = new String[]{"卖家Id-产品生产商Id-销售类型:" + sellerCommoditiyStr.toString() + "已经存在,不能重复添加"};
            result.setMessage(message);
            return result;
        }

        for (SlpdSellerCommodityParam sellerCommodityParam : slpd0801IParam.getSlpdSellerCommodities()) {

            //获取卖家单品品牌生产商SKU
            //String sellerCommoditySku = getSellerCommoditySku(sellerCommodityParam);

            SlpdSellerCommodity sellerCommodity = BeanUtils.toBean(sellerCommodityParam, SlpdSellerCommodity.class);

            sellerCommodity.setSellerCommodityId(this.maxId(TableConstant.Name.SLPD_SELLER_COMMODITY));

            //TODO code生成规则
            sellerCommodity.setSellerCommodityCode(sellerCommodity.getSellerCommodityId().toString());
            sellerCommodity.setSellerCommoditySku("");

            //默认未注册
            String auditStu = CodeMasterConstant.SellerCommodityAuditStu.UNREGISTERED;
            sellerCommodity.setAuditStu(auditStu);
            sellerCommodity.setAuditHistory("auditHistory");

            sellerCommodity.setCrtId(userId);
            sellerCommodity.setUpdId(userId);
            sellerCommodity.setCrtTime(now);
            sellerCommodity.setUpdTime(now);

            sellerCommodityList.add(sellerCommodity);
            sellerCommodityIds.add(sellerCommodity.getSellerCommodityId());
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(sellerCommodityList)) {
            count = slpd0801IDao.batchInsert(sellerCommodityList);
        }

        SLPD0801IResult result = new SLPD0801IResult();
        result.setCount(count);
        result.setSellerCommodityIds(sellerCommodityIds);
        return result;
    }

    /**
     * 获得卖家单品品牌(规格)生产商的审核履历，格式：0,未注册,admin,2017-01-25;...;
     */
    private String getAuditHistory(String auditStu) {
        final String userId = super.getLoginUserId();
        final String today = DateUtils.fmtToday();

        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SellerCommodityAuditStu.NODE);
        String auditStuStr = auditStuMap.get(auditStu);
        auditStuStr = StringUtils.isBlank(auditStuStr) ? "" : auditStuStr;

        return new StringBuilder()
                .append(auditStu)
                .append(",")
                .append(auditStuStr)
                .append(",")
                .append(userId)
                .append(",")
                .append(today)
                .append(";")
                .toString();
    }

    /**
     * 获取卖家单品品牌生产商SKU
     * @return sellerCommoditySku
     */
    public String getSellerCommoditySku(SlpdSellerCommodityParam sellerCommodityParam) {

        String sellerCode = null;
        String producerProductSku = null;

        //根据sellerId获取sellerCode
        SLIM0102IParam param = new SLIM0102IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        List<Long> sellerIds = new ArrayList<>();
        sellerIds.add(sellerCommodityParam.getSellerId());
        param.setSellerIds(sellerIds);

        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH,ApiUrlConstant.SLIM.API0102,ApiUrlConstant.SLIM.LOCAL_FLAG,ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};

        HashMap<String, Object> sellerData = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        JSONArray sellerJsonArray = (JSONArray) sellerData.get("data");

        if(null == sellerJsonArray){
            throw new BusinessException("SLPD", "找不到对应sellerId的数据", String.valueOf(sellerCommodityParam.getSellerId()));
        }else{
            JSONObject sellerObject = (JSONObject) sellerJsonArray.get(NumberConst.IntDef.INT_ZERO);

            JSONArray sellerList = (JSONArray) sellerObject.get("sellerList");

            JSONObject seller = (JSONObject) sellerList.get(NumberConst.IntDef.INT_ZERO);

            sellerCode = (String) seller.get("sellerCode");

            //根据producerProductId获取producerProductSku
            SLPD0701IParam slpd0701IParam = new SLPD0701IParam();
            List<Long> producerProductIds = new ArrayList<>();
            producerProductIds.add(sellerCommodityParam.getProducerProductId());
            slpd0701IParam.setProducerProductIds(producerProductIds);

            BaseRestPaginationResult<SLPD0701IProducerProductResult> slpd0701IResult = slpd0701IService.findProducerProducts(slpd0701IParam);

            List<SLPD0701IProducerProductResult> producerProductData = slpd0701IResult.getData();

            if(CollectionUtils.isEmpty(producerProductData)) {
                throw new BusinessException("SLPD", "找不到对应producerProductId的数据", String.valueOf(sellerCommodityParam.getProducerProductId()));
            }else{
                producerProductSku = String.valueOf(producerProductData.get(0).getProducerProductId());
            }
        }

        //卖家单品品牌生产商Sku（28位）：卖家Code（8位）+单品品牌生产商Sku（20）
        String sellerCommoditySku = sellerCode + producerProductSku;

        return sellerCommoditySku;
    }
}