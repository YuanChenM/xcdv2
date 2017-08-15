package com.bms.slpd.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.param.SLPD0804IParam;
import com.bms.slpd.bean.param.SLPD0806IParam;
import com.bms.slpd.bean.param.field.SLPD0806ISellerCommodityParam;
import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.bms.slpd.bean.result.SLPD0806IResult;
import com.bms.slpd.bean.result.SLPD1201IResult;
import com.bms.slpd.bean.result.wrapper.LogisticsAreaRsParam;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0807IDao;
import com.bms.slpd.services.SLPD0804IService;
import com.bms.slpd.services.SLPD0806IService;
import com.bms.slpd.services.SLPD0807IService;
import com.bms.slpd.services.SLPD1201IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0807IServiceImpl extends BaseServiceImpl implements SLPD0807IService {
    private static final Logger logger = LoggerFactory.getLogger(SLPD0807IServiceImpl.class);

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD0804IService slpd0804IService;
    @Autowired
    private SLPD0806IService slpd0806IService;
    @Autowired
    private SLPD1201IService slpd1201IService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private SLPD0807IDao slpd0807IDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd0807IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void auditSellerCommodities(SLPD0804IParam slpd0804IParam) {
        //step1 审核卖家单品品牌规格生产商
        slpd0804IService.auditSellerCommodities(slpd0804IParam);

        //step2 生成货号和商品Id
        List<SLPD0806ISellerCommodityParam> paramList = BeanUtils.toList(slpd0804IParam.getSellerCommodityParams(),SLPD0806ISellerCommodityParam.class);
        SLPD0806IParam slpd0806IParam = new SLPD0806IParam();
        slpd0806IParam.setSellerCommodityParams(paramList);
        SLPD0806IResult slpd0806IResult = slpd0806IService.addArticleNosAndCommodityIds(slpd0806IParam);

        List<String> commodityIds = slpd0806IResult.getCommodityIds();
        if (CollectionUtils.isNotEmpty(commodityIds)) {
            //step3 插入物流区商品表
            this.saveLgcsCommodities(commodityIds);
        }

    }

    /**
     * 获取所有物流区
     */
    private List<LogisticsAreaRsParam> findLogisticsAreas () {
        String url = RestApiUtils.getUrl(ApiUrlConstant.REGION.CONTEXT_PATH, ApiUrlConstant.REGION.logisticsSearch, false, null);
        return this.restApiClientFactory.newApiRestClient().post(url, new LogisticsAreaRsParam(), new TypeReference<ArrayList<LogisticsAreaRsParam>>() {
        });
    }

    /**
     * 插入物流区商品
     */

    private void saveLgcsCommodities(List<String> commodityIds) {
        List<LogisticsAreaRsParam> lgcsList = this.findLogisticsAreas();
        if (CollectionUtils.isEmpty(lgcsList)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "获取物流区失败");
        }
        List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities = new ArrayList<>();
        SLPD1201ILgcsAreaProduct lgcsCommodityParam = null;
        for (String commodityId : commodityIds) {
            for (LogisticsAreaRsParam lgcs : lgcsList) {
                lgcsCommodityParam = new SLPD1201ILgcsAreaProduct();
                lgcsCommodityParam.setProductId(commodityId);
                lgcsCommodityParam.setLgcsAreaCode(lgcs.getLgcsAreaCode());
                lgcsCommodityParam.setLgcsAreaName(lgcs.getLgcsAreaName());
                lgcsAreaCommodities.add(lgcsCommodityParam);
            }
        }
        //插入物流区商品表
        SLPD1201IResult result = this.slpd1201IService.saveLgcsCommodities(lgcsAreaCommodities);
        logger.info("物流区商品LacId:" + result.getLacIds().toArray());
    }



}
