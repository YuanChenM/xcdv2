package com.bms.como.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.como.bean.entity.ComoCommodityInfo;
import com.bms.como.bean.entity.ComoCommodityUom;
import com.bms.como.bean.entity.ComoProductInfo;
import com.bms.como.bean.entity.ComoSaleStatus;
import com.bms.como.bean.param.*;
import com.bms.como.bean.result.ComoInfoResult;
import com.bms.como.bean.result.ComoProductResult;
import com.bms.como.bean.result.ProductInfoResult;
import com.bms.como.constant.ApiUrlConstant;
import com.bms.como.constant.MessageConstant;
import com.bms.como.constant.TableConstant;
import com.bms.como.dao.ComoInfoDao;
import com.bms.como.service.ComoInfoService;
import com.bms.como.service.ComoProductInfoService;
import com.bms.como.service.ComoSaleStatusService;
import com.bms.como.service.ComoUomService;
import com.bms.fms.notice.FmsNotice;
import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_haichun on 2017/3/28.
 */
@Service
public class ComoInfoServiceImpl extends BaseServiceImpl implements ComoInfoService {
    Logger logger = LoggerFactory.getLogger(ComoInfoServiceImpl.class);

    private final boolean FLAG_TRUE = true;
    private final boolean FLAG_FALSE = false;

    @Autowired
    private ComoInfoDao comoInfoDao;
    @Autowired
    private ComoProductInfoService comoProductInfoService;
    @Autowired
    private ComoSaleStatusService comoSaleStatusService;
    @Autowired
    private ComoUomService comoUomService;

    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private FmsNotice fmsNotice;


    @Override
    public BaseDao getBaseDao() {
        return comoInfoDao;
    }

    /**
     * 新增商品信息
     */
    @Override
    public ComoInfoResult saveComeInfo(ComoInfoRsParam comoInfoRsParam) {
        //商品名称重名判断
        int num = comoInfoDao.findComoInfoByName(comoInfoRsParam);
        if(num > NumberConst.IntDef.INT_ZERO){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "存在同名商品，推荐把商品名称按照品牌+单品+净重+等级的方式来命名");
        }

        ComoInfoResult comoInfoResult = new ComoInfoResult();
        ComoCommodityInfo comoCommodityInfo = BeanUtils.toBean(comoInfoRsParam, ComoCommodityInfo.class);
        Long maxId = this.maxId(TableConstant.Name.COMO_COMMODITY_INFO);
        comoInfoRsParam.setCommodityId(maxId);
        int result = this.checkParam(comoInfoRsParam);
        if (result > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("como", "COMO.E01004");
        } else {
            String userId = super.getLoginUserId();
            Date date = DateUtils.getCurrent();
            comoCommodityInfo.setCommodityId(maxId);
            /** 是否为产品的默认商品，缺省为否 */
            if (null == comoInfoRsParam.getIsDefault()) {
                comoCommodityInfo.setIsDefault(FLAG_FALSE);
            }
            /** 有效状态，若不传，默认有效 */
            if (null == comoInfoRsParam.getIsValid()) {
                comoCommodityInfo.setIsValid(FLAG_TRUE);
            }
            /** 是否开放给买手，缺省为是 */
            if (null == comoInfoRsParam.getIsOpenToAgent()) {
                comoCommodityInfo.setIsOpenToAgent(FLAG_TRUE);
            }

            ComoSaleStatus saleStatus = null;
            if (null == comoInfoRsParam.getSalesStatusId()) {
                /** 获取默认销售状态 */
                saleStatus = this.findDefaultSaleStatu();
            } else {
                saleStatus = comoSaleStatusService.findOne(comoInfoRsParam.getSalesStatusId());
            }
            if (null == saleStatus) {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "未查询到销售状态");
            }

            comoCommodityInfo.setSaleStatusId(saleStatus.getSaleStatusId());
            comoCommodityInfo.setSaleStatusDesc(saleStatus.getSaleStatusName());

            /** 查询产品信息 */
            ComoProductInfo productInfo = null;
            if(null != comoInfoRsParam.getProductPid()){
                ArrayList<Long> productPids = new ArrayList<>();
                productPids.add(comoInfoRsParam.getProductPid());
                List<ComoProductInfo> comoProductInfoList = comoProductInfoService.findList(productPids);
                if (CollectionUtils.isEmpty(comoProductInfoList)) {
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "未查询到产品信息");
                }
                productInfo = comoProductInfoList.get(NumberConst.IntDef.INT_ZERO);
            }else if(StringUtils.isNotEmpty(comoInfoRsParam.getProductId())){
                ProductInfoRsParam productInfoParam = new ProductInfoRsParam();
                List<String> productIds = new ArrayList<>();
                productIds.add(comoInfoRsParam.getProductId());
                productInfoParam.setProductIds(productIds);

                BaseRestPaginationResult<ProductInfoResult> productInfoResults = comoProductInfoService.searchProductInfo(productInfoParam);
                if(null != productInfoResults && CollectionUtils.isNotEmpty(productInfoResults.getData())){
                    ProductInfoResult productInfoResult = productInfoResults.getData().get(NumberConst.IntDef.INT_ZERO);
                    productInfo = BeanUtils.toBean(productInfoResult,ComoProductInfo.class);
                }else {
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "未查询到产品信息");
                }
            }else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少产品ID");
            }

            comoCommodityInfo.setProductPid(productInfo.getProductPid());
            /** 生成商品名称 */
            if (StringUtils.isEmpty(comoInfoRsParam.getCommodityName())) {
                String commodityName = new StringBuilder().append(saleStatus.getSaleStatusName()).append(productInfo.getBrandName()).
                        append(productInfo.getBreedSalesName()).append(productInfo.getItemName()).toString();
                comoCommodityInfo.setCommodityName(commodityName);
            } else {
                comoCommodityInfo.setCommodityName(comoInfoRsParam.getCommodityName());
            }
            //查询顺序码
            String commodityCode = new StringBuilder().append(productInfo.getBrandItemPropertySku()).append(DateUtils.format("yyMM", new Date())).toString();
            int codeCount = this.findComoCodeCount(DbUtils.buildLikeCondition(commodityCode, DbUtils.LikeMode.FRONT)) + 1;
            comoCommodityInfo.setCommodityCode(new StringBuilder().append(commodityCode).append(String.format("%03d", codeCount)).toString());

            comoCommodityInfo.setCrtId(userId);
            comoCommodityInfo.setUpdId(userId);
            comoCommodityInfo.setCrtTime(date);
            comoCommodityInfo.setUpdTime(date);


            /** 查询产品下面是否有默认商品 */
            ComoDefaultRsParam defaultRsParam = new ComoDefaultRsParam();
            defaultRsParam.setProductPid(comoCommodityInfo.getProductPid());
            int comoDefaultCount = this.findComoDefaultCount(defaultRsParam);
            if(comoDefaultCount == NumberConst.IntDef.INT_ZERO){
                comoCommodityInfo.setIsDefault(FLAG_TRUE);
            }
            /** 如果是默认商品，则该产品下其他商品为非默认 */
            if (FLAG_TRUE == comoCommodityInfo.getIsDefault()) {
                if(comoDefaultCount > NumberConst.IntDef.INT_ZERO){
                    this.modifyComoDefault(comoCommodityInfo);
                }
            }

            int count = comoInfoDao.save(comoCommodityInfo);
            /** 新增商品单位 */
            this.addComoUom(comoInfoRsParam.getUomList(), maxId);

            comoInfoResult.setCount(count);
            comoInfoResult.setCommodityId(maxId);
            comoInfoResult.setMessage(MessageConstant.SUCCESS);
            return comoInfoResult;
        }
    }

    /**
     * 验证相同的标准产品ID+销售状态ID的数据是否相同，保证商品数据的唯一性
     *
     * @param comoInfoRsParam
     * @return
     */
    private int checkParam(ComoInfoRsParam comoInfoRsParam) {
        //查询商品数据中是否已存在
        return this.comoInfoDao.checkComoInfoRsParam(comoInfoRsParam);
    }

    /**
     * 修改商品信息
     */
    @Override
    public ComoInfoResult modifyComoInfo(BaseBean<ComoInfoRsParam, ComoInfoRsParam> comoInfoRsParam) {
        int result = this.checkParam(comoInfoRsParam.getTarget());
        if (result > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("como", "COMO.E01004");
        } else {
            ComoInfoResult comoInfoResult = new ComoInfoResult();
            ComoInfoRsParam comoInfoFilter = BeanUtils.toBean(comoInfoRsParam.getFilter(), ComoInfoRsParam.class);
            ComoInfoRsParam comoInfoTarget = BeanUtils.toBean(comoInfoRsParam.getTarget(), ComoInfoRsParam.class);
            BaseBean<ComoInfoRsParam, ComoCommodityInfo> baseBean = new BaseBean<>();
            baseBean.setFilter(comoInfoFilter);

            ComoCommodityInfo comoCommodityInfo = BeanUtils.toBean(comoInfoTarget, ComoCommodityInfo.class);
            comoCommodityInfo.setUpdId(super.getLoginUserId());
            comoCommodityInfo.setUpdTime(DateUtils.getCurrent());
            comoCommodityInfo.setSaleStatusId(comoInfoTarget.getSalesStatusId());
            comoCommodityInfo.setSaleStatusDesc(comoInfoTarget.getSalesStatusDesc());

            baseBean.setTarget(comoCommodityInfo);

            /** 查询商品信息  判断是否修改了商品名称 */
            boolean changeComoNameFlg = false;
            if(StringUtils.isNotEmpty(comoCommodityInfo.getCommodityName())){
                ComoCommodityInfo oldComoInfo = comoInfoDao.findOne(comoInfoFilter.getCommodityId());
                if(oldComoInfo != null && !comoCommodityInfo.getCommodityName().equals(oldComoInfo.getCommodityName())){
                    changeComoNameFlg = true;
                }
            }



            /** 如果是默认商品，则该产品下其他商品为非默认 */
            if (null != comoCommodityInfo.getIsDefault() && FLAG_TRUE == comoCommodityInfo.getIsDefault()) {
                this.modifyComoDefault(comoCommodityInfo);
            }


            int count = comoInfoDao.modify(baseBean);
            /** 修改商品单位 */
            this.updateComoUom(comoInfoTarget.getUomList(), comoInfoTarget.getCommodityId());

            comoInfoResult.setCount(count);
            if (count == NumberConst.IntDef.INT_ZERO) {
                comoInfoResult.setMessage("修改失败,请刷新重试");
            } else {
                comoInfoResult.setMessage(MessageConstant.SUCCESS);
            }
            comoInfoResult.setCommodityId(comoInfoFilter.getCommodityId());

            /** 如果修改了商品名称   fms推送  */
            if(changeComoNameFlg){
                try{
                    fmsNotice.sendCommodity(String.valueOf(comoInfoFilter.getCommodityId()));
                }catch (Exception e){
                    logger.debug("fmsNotice.sendCommodity("+comoInfoFilter.getCommodityId()+")失败,原因："+e.getMessage());
                }
            }

            return comoInfoResult;
        }
    }


    /**
     * 查询商品信息
     */
    @Override
    public BaseRestPaginationResult<ComoProductResult> searchComoInfo(ComoProductRsParam comoProductRsParam) {
        String manufacturerProductSku = comoProductRsParam.getManufacturerProductSku();
        if(StringUtils.isNotEmpty(manufacturerProductSku)){
            String productId = StringConst.BLANK;
            //查询制造商产品
            Map<String, Object> manufacturerProductMap = this.getManufacturerProductInfo(manufacturerProductSku);
            if(null != manufacturerProductMap && manufacturerProductMap.containsKey("data") && CollectionUtils.isNotEmpty((List<Map<String, Object>>) manufacturerProductMap.get("data"))){
                Map<String,Object> manufacturerProduct = ((List<Map<String,Object>>) manufacturerProductMap.get("data")).get(0);
                productId = (String)manufacturerProduct.get("productId");
            }
            comoProductRsParam.setProductId(productId);
        }

        BaseRestPaginationResult<ComoProductResult> restResult = super.findPageList(comoProductRsParam);
        if (restResult != null && CollectionUtils.isNotEmpty(restResult.getData())) {
            Set<Long> comoIdsSet = new HashSet<>();
            for (ComoProductResult comoProduct : restResult.getData()) {
                comoIdsSet.add(comoProduct.getCommodityId());
            }
            /** 查询商品销售单位 */
            if (CollectionUtils.isNotEmpty(comoIdsSet)) {
                List<Long> comoIds = new ArrayList<>(comoIdsSet);
                List<ComoCommodityUom> comoCommodityUomList = comoUomService.findUomByComoIds(comoIds);
                if (CollectionUtils.isNotEmpty(comoIds)) {
                    List<ComoCommodityUom> uomList = null;
                    for (ComoProductResult comoProduct : restResult.getData()) {
                        uomList = new ArrayList<>();
                        for (ComoCommodityUom uom : comoCommodityUomList) {
                            if (comoProduct.getCommodityId().equals(uom.getCommodityId())) {
                                uomList.add(uom);
                            }
                        }
                        comoProduct.setUomList(uomList);
                    }
                }
            }
        }
        return restResult;
    }


    /**
     * 查询默认销售状态
     */
    @Override
    public ComoSaleStatus findDefaultSaleStatu() {
        return comoInfoDao.findDefaultSaleStatu();
    }


    /**
     * 根据产品SKU + 年月 查询数量
     */
    @Override
    public int findComoCodeCount(String commodityCode) {
        return comoInfoDao.findComoCodeCount(commodityCode);
    }


    /**
     * 修改产品下的默认商品为非默认
     */
    @Override
    public int modifyComoDefault(ComoCommodityInfo comoCommodityInfo) {
        return comoInfoDao.modifyComoDefault(comoCommodityInfo);
    }

    /**
     * 查询产品下是否有默认商品
     */
    @Override
    public int findComoDefaultCount(ComoDefaultRsParam param) {
        return comoInfoDao.findComoDefaultCount(param);
    }


    /**
     * 插入销售单位
     */
    private void addComoUom(List<UomRsParam> uomRsParams, Long comoId) {
        if (CollectionUtils.isNotEmpty(uomRsParams)) {
            List<ComoCommodityUom> uomList = new ArrayList<>();
            ComoCommodityUom uom = null;
            boolean flag = false;
            String userId = super.getLoginUserId();
            Date date = DateUtils.getCurrent();
            int temp = NumberConst.IntDef.INT_ZERO;
            for (UomRsParam param : uomRsParams) {
                uom = new ComoCommodityUom();
                uom.setUomSid(this.maxId(TableConstant.Name.COMO_COMMODITY_UOM));
                uom.setCommodityId(comoId);
                uom.setUom(param.getUom());
                uom.setIsDefault(param.getIsDefault() == null ? FLAG_TRUE : param.getIsDefault());
                uom.setCrtId(userId);
                uom.setUpdId(userId);
                uom.setCrtTime(date);
                uom.setUpdTime(date);
                /** 有多个销售单位时，只能设置一个 */
                if (temp != NumberConst.IntDef.INT_ZERO && flag && uom.getIsDefault()) {
                    uom.setIsDefault(FLAG_FALSE);
                }

                if (uom.getIsDefault()) {
                    flag = true;
                }
                uomList.add(uom);
                temp++;
            }
            if (!flag && CollectionUtils.isNotEmpty(uomList)) {
                uomList.get(NumberConst.IntDef.INT_ZERO).setIsDefault(FLAG_TRUE);
            }
            /** 插入数据 */
            comoUomService.batchSave(uomList);
        }
    }

    /**
     * 修改销售单位(先删除 后增加)
     */
    private void updateComoUom(List<UomRsParam> uomRsParams, Long comoId) {
        if (CollectionUtils.isNotEmpty(uomRsParams) && null != comoId) {
            List<Long> comoIds = new ArrayList<>();
            comoIds.add(comoId);
            List<ComoCommodityUom> comoCommodityUomList = comoUomService.findUomByComoIds(comoIds);
            if (CollectionUtils.isNotEmpty(comoCommodityUomList)) {
                List<Long> uomSids = new ArrayList<>();
                for (ComoCommodityUom uom : comoCommodityUomList) {
                    uomSids.add(uom.getUomSid());
                }
                /** 删除原来的数据 */
                comoUomService.delUomByComoIds(uomSids);
            }
            this.addComoUom(uomRsParams, comoId);
        }
    }


    /**
     * 查询产品信息
     */
    private Map<String, Object> getProductInfo(ProductRsParam param) {
        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLPD.CONTEXT_PATH, ApiUrlConstant.SLPD.API1804);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;
    }

    /**
     * 查询制造商产品信息
     */
    public Map<String, Object> getManufacturerProductInfo(String manufacturerProductSku) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("manufacturerProductSku",manufacturerProductSku);

        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLPD.CONTEXT_PATH, ApiUrlConstant.SLPD.API1806);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;
    }

}
