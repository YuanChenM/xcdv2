package com.bms.linv.business.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.linv.bean.entity.*;
import com.bms.linv.bean.param.LINV0119ICommodityParam;
import com.bms.linv.bean.param.LINV0119IParam;
import com.bms.linv.bean.param.LINV0118IParam;
import com.bms.linv.bean.param.LINV0118IProductParam;
import com.bms.linv.business.LinvAdjustBusinessService;
import com.bms.linv.common.NumberGenerator;
import com.bms.linv.common.ResponseDataReader;
import com.bms.linv.constant.LinvApiUrlConstant;
import com.bms.linv.constant.LinvTypeCodeMaster;
import com.bms.linv.dao.*;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zheng_xu on 2017/5/3.
 */
@Service
public class LinvAdjustBusinessServiceImpl extends BaseServiceImpl implements LinvAdjustBusinessService {
    @Autowired
    private BaseRedisDao baseRedisDao;
    @Autowired
    private InvmLoadDao invmLoadDao;
    @Autowired
    private InvmSkuInfoDao invmSkuInfoDao;
    @Autowired
    private InvmLoadDealDetailDao invmLoadDealDetailDao;
    @Autowired
    private InvmLoadAdjustDao invmLoadAdjustDao;
    @Autowired
    private InvmLoadAdjustDetailDao invmLoadAdjustDetailDao;
    @Autowired
    private InvmProductInfoDao invmProductInfoDao;
    @Autowired
    private InvmComoInventoryAdjustDao invmComoInventoryAdjustDao;
    @Autowired
    private InvmComoInventoryAdjustDetailDao invmComoInventoryAdjustDetailDao;
    @Autowired
    private InvmComoInventoryDao invmComoInventoryDao;
    @Autowired
    private InvmComoDealDetailDao invmComoDealDetailDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    /**
     * 库存调整接口
     * 
     * @param param
     */
    @Override
    public void adjustLoads(LINV0118IParam param) throws Exception {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";

        // 判断调整单号是否已存在
        checkAdjustNo(param.getAdjustCode());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(param.getAdjustDate());
        } catch (ParseException e) {
            throw new BusinessException("LINV.ADJUSTMENT", "调整日期有误");
        }

        // 开始调整
        for (LINV0118IProductParam productParam : param.getProductList()) {
            String qty = productParam.getAdjustQty();
            BigDecimal adjustQty = new BigDecimal(qty);

            // 插入调整明细
            Long id = baseRedisDao.getTablePrimaryKey("invm_load_adjust", 1);
            saveAdjustAndDetail(param, date,time, productParam, adjustQty, id);

            // 处理load交易明细对象
            InvmLoadDealDetail loadDealDetail = new InvmLoadDealDetail();
            loadDealDetail.setTransactionId(id);
            loadDealDetail.setTransactionDetailId(baseRedisDao.getTablePrimaryKey("invm_load_adjust_detail", 1));
            loadDealDetail.setTransactionNo(param.getAdjustCode());
            loadDealDetail.setTransactionSequence(1);
            loadDealDetail.setTransactionSource("WMS");
            loadDealDetail.setTransactionType(LINV0118IParam.TRANSACTION_TYPE);
            loadDealDetail.setTransactionTime(time);
            loadDealDetail.setSkuCode(productParam.getSkuCode());
            loadDealDetail.setLotNo(productParam.getLotNo());
            loadDealDetail.setCrtId(param.getAdjustPerson());
            loadDealDetail.setCrtTime(time);
            loadDealDetail.setBizType("016");

            //
            if (productParam.getFromInventoryStatus().equals(productParam.getToInventoryStatus())) {
                // 出入库状态相同时，根据参数查询记录，应定位一条
                InvmLoad loadParam = productParam.searchLoadParam();// load查询对象
                loadParam.setIvType(productParam.getFromInventoryStatus());
                List<InvmLoad> loadList = invmLoadDao.findAll(loadParam);

                // 调整数量为正数时
                if (adjustQty.compareTo(new BigDecimal(0)) >= 0) {
                    if (loadList.size() >= 1) {
                        InvmLoad invmLoad = loadList.get(0);
                        invmLoad.setIvQty(adjustQty);
                        invmLoad.setUpdId(param.getAdjustPerson());
                        invmLoad.setUpdTime(time);
                        invmLoadDao.modify(invmLoad);

                        // 新增产品库存交易明细
                        loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                        loadDealDetail.setLoadNo(invmLoad.getLoadNo());
                        loadDealDetail.setDealQty(adjustQty);
                        loadDealDetail.setSaleStatusId(invmLoad.getSaleStatusId());
                        invmLoadDealDetailDao.save(loadDealDetail);
                    } else {
                        //查询skuCode是否存在
                        checkSkuCode(time, sign, productParam);

                        // 不存在则新增
                        String loadNo = NumberGenerator.getNewLoadNumber();
                        InvmLoad loadSaveParam = getInvmLoadParam(param, time, productParam, adjustQty, loadNo,
                            productParam.getToInventoryStatus());
                        invmLoadDao.save(loadSaveParam);
                        // 新增产品交易明细
                        loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                        loadDealDetail.setLoadNo(loadNo);
                        loadDealDetail.setDealQty(adjustQty);
                        loadDealDetail.setSaleStatusId(loadSaveParam.getSaleStatusId());
                        invmLoadDealDetailDao.save(loadDealDetail);
                    }
                } else {// 调整数量小于0时
                    if (loadList.size() >= 1) {
                        InvmLoad invmLoad = loadList.get(0);
                        BigDecimal updateQty = new BigDecimal(0).subtract(adjustQty);
                        if (updateQty.compareTo(invmLoad.getIvQty()) > 0) {
                            throw new BusinessException("LINV.ADJUSTMENT", "调整数量不能大于出库方库存数量");
                        }
                        invmLoad.setIvQty(adjustQty);
                        invmLoad.setUpdId(param.getAdjustPerson());
                        invmLoad.setUpdTime(time);
                        invmLoadDao.modify(invmLoad);

                        // 新增产品库存交易明细
                        loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                        loadDealDetail.setLoadNo(invmLoad.getLoadNo());
                        loadDealDetail.setDealQty(adjustQty);
                        loadDealDetail.setSaleStatusId(invmLoad.getSaleStatusId());
                        invmLoadDealDetailDao.save(loadDealDetail);
                    } else {
                        throw new BusinessException("LINV.ADJUSTMENT", "未查询到出库方库存");
                    }
                }
            } else {// 不相同
                if (adjustQty.compareTo(BigDecimal.valueOf(0)) < 0) {// 数量必须为正数
                    throw new BusinessException("LINV.ADJUSTMENT", "调整数量不能小于0");
                }
                // 1、查询出库方库存，存在则验证出库数量并扣减，否则不做操作
                InvmLoad loadParam = productParam.searchLoadParam();// load查询对象
                loadParam.setIvType(productParam.getFromInventoryStatus());
                InvmLoad outInvmLoad = invmLoadDao.findOne(loadParam);
                if (null != outInvmLoad) {
                    if (adjustQty.compareTo(outInvmLoad.getIvQty()) > 0) {
                        throw new BusinessException("LINV.ADJUSTMENT", "调整数量大于出库方库存数量");
                    }
                    // 修改出库方库存
                    outInvmLoad.setIvQty(BigDecimal.valueOf(0).subtract(adjustQty));
                    outInvmLoad.setUpdTime(time);
                    outInvmLoad.setUpdId(param.getAdjustPerson());
                    invmLoadDao.modify(outInvmLoad);
                    // 增加明细
                    loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                    loadDealDetail.setLoadNo(outInvmLoad.getLoadNo());
                    loadDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(adjustQty));
                    loadDealDetail.setSaleStatusId(outInvmLoad.getSaleStatusId());
                    invmLoadDealDetailDao.save(loadDealDetail);
                }

                // 2、查询调整入库方库存，存在则增加数量，不存在则新增
                loadParam.setIvType(productParam.getToInventoryStatus());
                InvmLoad inInvmLoad = invmLoadDao.findOne(loadParam);
                if (null != inInvmLoad) {
                    // 修改入库方库存
                    inInvmLoad.setIvQty(adjustQty);
                    inInvmLoad.setUpdTime(time);
                    inInvmLoad.setUpdId(param.getAdjustPerson());
                    invmLoadDao.modify(inInvmLoad);
                    // 增加明细
                    loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                    loadDealDetail.setLoadNo(inInvmLoad.getLoadNo());
                    loadDealDetail.setDealQty(adjustQty);
                    loadDealDetail.setSaleStatusId(inInvmLoad.getSaleStatusId());
                    invmLoadDealDetailDao.save(loadDealDetail);
                } else {
                    String loadNo = NumberGenerator.getNewLoadNumber();
                    Long saleStatusId=null;
                    if (null != outInvmLoad) {// 出库方存在，则入库方新增数据基本一致
                        outInvmLoad.setLoadNo(loadNo);
                        outInvmLoad.setIvQty(adjustQty);
                        outInvmLoad.setIvType(productParam.getToInventoryStatus());
                        outInvmLoad.setCrtId(param.getAdjustPerson());
                        outInvmLoad.setCrtTime(time);
                        saleStatusId=outInvmLoad.getSaleStatusId();
                        invmLoadDao.save(outInvmLoad);
                    } else {// 出库方不存在
                        //查询skuCode是否存在
                        checkSkuCode(time, sign, productParam);

                        InvmLoad loadSaveParam = getInvmLoadParam(param, time, productParam, adjustQty, loadNo,
                            productParam.getToInventoryStatus());
                        saleStatusId=loadSaveParam.getSaleStatusId();
                        invmLoadDao.save(loadSaveParam);
                    }
                    // 新增产品交易明细
                    loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                    loadDealDetail.setLoadNo(loadNo);
                    loadDealDetail.setDealQty(adjustQty);
                    loadDealDetail.setSaleStatusId(saleStatusId);
                    invmLoadDealDetailDao.save(loadDealDetail);
                }
            }
        }
    }

    /**
     * 查询SkuCode是否存在
     * @param time
     * @param sign
     * @param productParam
     */
    private void checkSkuCode(Date time, String sign, LINV0118IProductParam productParam) {
        InvmSkuInfo invmSkuParam = new InvmSkuInfo();
        invmSkuParam.setSkuCode(productParam.getSkuCode());
        InvmSkuInfo invmSkuInfo = invmSkuInfoDao.findOne(invmSkuParam);
        if(invmSkuInfo == null){
            RestApiClient restClient = restApiClientFactory.newApiRestClient();
            String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLPD.CODE,
                    LinvApiUrlConstant.SLPD.URIS.COMM_SEARCH);
            HashMap requestSku = new HashMap();
            requestSku.put("manufacturerProductSku", productParam.getSkuCode());
            BaseWebPaginationResult<HashMap> skuResult = restClient.post(url, requestSku,
                    new TypeReference<BaseWebPaginationResult<HashMap>>() {
                    });
            if (skuResult.getData() != null) {
                Map skuData = ResponseDataReader.skuInfoReader(skuResult.getData(), sign, time);
                Map tempSku = (HashMap) skuResult.getData().get(0);
                String pdId = String.valueOf(tempSku.get("productId"));// 产品id
                // 1.插入Sku信息表
                saveSkuInfo(skuData);

                // 通过pdId查询产品信息接口
                String proUrl = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLPC.CODE,
                        LinvApiUrlConstant.SLPC.URIS.COMM_SEARCH);
                HashMap requestPro = new HashMap();
                List<String> arryParam = new ArrayList<String>();
                arryParam.add(pdId);
                requestPro.put("productIds", arryParam.toArray(new String[arryParam.size()]));
                BaseWebPaginationResult<HashMap> proResult = restClient.post(proUrl, requestPro,
                        new TypeReference<BaseWebPaginationResult<HashMap>>() {
                        });
                // 封装productInfo参数信息
                Map proData = ResponseDataReader.proInfoReader(proResult.getData(), sign, time);
                if (proResult.getData() != null) {
                    // 2.插入产品信息表
                    saveProductInfo(proData);
                } else {
                    throw new BusinessException("LINV_PRODUCT", "productId未找到商品信息");
                }

            }else {
                throw new BusinessException("LINV_PRODUCT", "skuCode未找到产品信息");
            }
        }
    }

    /**
     * 插入Sku信息表
     *
     * @param skuData
     */
    private void saveSkuInfo(Map skuData) {
        List<InvmSkuInfo> skuInfoList = new ArrayList();
        Object skuInfoObj = skuData.get(ResponseDataReader.SKU);
        if (skuInfoObj != null) {
            skuInfoList.addAll((List) skuInfoObj);
        }
        for (int j = 0; j < skuInfoList.size(); j++) {
            invmSkuInfoDao.save(skuInfoList.get(j));
        }
    }

    /**
     * 插入产品信息表
     *
     * @param proData
     */
    private void saveProductInfo(Map proData) {
        List<InvmProductInfo> proInfoList = new ArrayList();
        Object proInfoObj = proData.get(ResponseDataReader.PRO);
        if (proInfoObj != null) {
            proInfoList.addAll((List) proInfoObj);
        }
        for (int j = 0; j < proInfoList.size(); j++) {
            proInfoList.get(j).setProductPid(baseRedisDao.getTablePrimaryKey("invm_product_info", 1));
            invmProductInfoDao.save(proInfoList.get(j));
        }
    }

    /**
     * 新增调整表及其明细表
     * 
     * @param param
     * @param date
     * @param productParam
     * @param adjustQty
     * @return
     */
    private void saveAdjustAndDetail(LINV0118IParam param, Date date,Date time, LINV0118IProductParam productParam,
        BigDecimal adjustQty, Long id) {

        InvmLoadAdjust adjust = new InvmLoadAdjust();
        adjust.setLoadAdjustId(id);
        adjust.setLoadAdjustCode(NumberGenerator.getNewLoadAdjustmentNumber());
        adjust.setWmsAdjustCode(param.getAdjustCode());
        adjust.setAdjustDate(date);
        adjust.setAdjustPerson(param.getAdjustPerson());
        adjust.setReasonCode(param.getReasonCode());
        adjust.setReasonName(param.getReasonName());
        adjust.setCrtId(param.getAdjustPerson());
        adjust.setCrtTime(time);
        invmLoadAdjustDao.save(adjust);
        // 插入调整明细
        InvmLoadAdjustDetail adjustDetail = new InvmLoadAdjustDetail();
        adjustDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_load_adjust_detail", 1));
        adjustDetail.setLoadAdjustId(id);

        adjustDetail.setLogicId(getLogicId(productParam));
        adjustDetail.setLogicCode(productParam.getLgcsCode());

        // 根据SlCode拿slId
        adjustDetail.setOwnerId(getSellerId(productParam));
        adjustDetail.setOwnerType(LinvTypeCodeMaster.OWNER_TYPE.SELLER);
        adjustDetail.setOwnerCode(productParam.getSlCode());
        adjustDetail.setWhId(Long.valueOf(1));
        adjustDetail.setWhCode("0000");
        adjustDetail.setWhName("上海分拣中心");
        adjustDetail.setSkuCode(productParam.getSkuCode());
        adjustDetail.setLotNo(productParam.getLotNo());
        adjustDetail.setUom(productParam.getUnit());

        adjustDetail.setSaleStatusId(getSaleStatusId(productParam));
        adjustDetail.setSaleStatusCode(productParam.getSalesLabel());
        adjustDetail.setIvTypeFrom(productParam.getFromInventoryStatus());
        adjustDetail.setIvTypeTo(productParam.getToInventoryStatus());
        adjustDetail.setAdjustQty(adjustQty);
        adjustDetail.setCrtId(param.getAdjustPerson());
        adjustDetail.setCrtTime(time);
        invmLoadAdjustDetailDao.save(adjustDetail);
    }

    /**
     * 处理新增load表参数
     *
     * @param param
     * @param date
     * @param productParam
     * @param adjustQty
     * @param loadNo
     * @return
     */
    private InvmLoad getInvmLoadParam(LINV0118IParam param, Date date, LINV0118IProductParam productParam,
        BigDecimal adjustQty, String loadNo, String toInventoryStatus) {
        // 新增
        InvmLoad loadSaveParam = new InvmLoad();
        loadSaveParam.setLoadNo(loadNo);
        loadSaveParam.setLaId(getLogicId(productParam));
        loadSaveParam.setLaCode(productParam.getLgcsCode());
        loadSaveParam.setSplatCode("001");
        loadSaveParam.setOwnerId(getSellerId(productParam));
        loadSaveParam.setOwnerCode(productParam.getSlCode());
        loadSaveParam.setOwnerType(LinvTypeCodeMaster.OWNER_TYPE.SELLER);
        loadSaveParam.setWhId(Long.valueOf(1));
        loadSaveParam.setWhCode("0000");
        //loadSaveParam.setSpCode(productParam.getSupplierCode());
        loadSaveParam.setSkuCode(productParam.getSkuCode());
        loadSaveParam.setLotNo(productParam.getLotNo());
        loadSaveParam.setUom(productParam.getUnit());
        loadSaveParam.setIvQty(adjustQty);
        loadSaveParam.setIvType(toInventoryStatus);
        loadSaveParam.setSaleStatusId(getSaleStatusId(productParam));
        loadSaveParam.setSaleStatusCode(productParam.getSalesLabel());
        loadSaveParam.setCrtId(param.getAdjustPerson());
        loadSaveParam.setCrtTime(date);
        return loadSaveParam;
    }

    /**
     * 根据LogicCode拿LogicId
     * 
     * @param productParam
     */
    private Long getLogicId(LINV0118IProductParam productParam) {
        Long logicId = null;
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.REGION.REGION,
            LinvApiUrlConstant.REGION.URIS.REGION_SEARCH);
        HashMap requestSku = new HashMap();
        requestSku.put("lgcsAreaCode", productParam.getLgcsCode());
        List<HashMap> logicResult = restClient.post(url, requestSku,
            new TypeReference<ArrayList<HashMap>>() {});
        if (logicResult.size() > 0) {
            Map tempSku = (HashMap) logicResult.get(0);
            logicId = Long.valueOf(String.valueOf(tempSku.get("lgcsAreaId")));
        } else {
            throw new BusinessException("LINV.ADJUSTMENT", "未查询到对应物流区域信息！");
        }
        return logicId;
    }

    /**
     * 根据saleStatusIdCode拿saleStatusId
     * 
     * @param productParam
     */
    private Long getSaleStatusId(LINV0118IProductParam productParam) {
        Long saleStatusId = null;
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.COMO.CODE,
            LinvApiUrlConstant.COMO.URIS.COMM_SALESTATUS_SEARCH);
        HashMap requestSku = new HashMap();
        requestSku.put("saleStatusCode", productParam.getSalesLabel());
        BaseWebPaginationResult<HashMap> saleStatusResult = restClient.post(url, requestSku,
            new TypeReference<BaseWebPaginationResult<HashMap>>() {});
        if (saleStatusResult.getData() != null) {
            Map tempSku = (HashMap) saleStatusResult.getData().get(0);
            saleStatusId = Long.valueOf(String.valueOf(tempSku.get("saleStatusId")));
        } else {
            throw new BusinessException("LINV.ADJUSTMENT", "未查询到对应销售状态信息！");
        }
        return saleStatusId;
    }

    /**
     * 根据SlCode拿slId
     * 
     * @param productParam
     */
    private String getSellerId(LINV0118IProductParam productParam) {
        String sellerId = "";
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLIM.CODE,
            LinvApiUrlConstant.SLIM.URIS.COMM_SEARCH);
        HashMap requestSku = new HashMap();
        requestSku.put("entitySellerCode", productParam.getSlCode());
        BaseWebPaginationResult<HashMap> sellerResult = restClient.post(url, requestSku,
            new TypeReference<BaseWebPaginationResult<HashMap>>() {});
        if (sellerResult.getData() != null) {
            Map tempSku = (HashMap) sellerResult.getData().get(0);
            sellerId = String.valueOf(tempSku.get("entitySellerId"));
        } else {
            throw new BusinessException("LINV.ADJUSTMENT", "未查询到对应平台卖家信息！");
        }
        return sellerId;
    }

    /**
     * 判断调整单号是否重复
     * 
     * @param adjustNo
     */
    private void checkAdjustNo(String adjustNo) {
        InvmLoadAdjust adjust = new InvmLoadAdjust();
        adjust.setWmsAdjustCode(adjustNo);
        InvmLoadAdjust result = invmLoadAdjustDao.findOne(adjust);
        if (null != result) {
            throw new BusinessException("LINV.ADJUSTMENT", "库存调整单号已存在");
        }
    }

    /**
     * 商品库存调整
     *
     * @param param
     */
    @Override
    public void adjustComoInv(LINV0119IParam param) throws Exception {
        Date time = DateUtils.getCurrent();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date adjustDate = new Date();
        try {
            adjustDate = sdf.parse(param.getAdjustDate());
        } catch (ParseException e) {
            throw new BusinessException("LINV.ADJUSTMENT", "调整日期有误");
        }
        // 开始调整
        for (LINV0119ICommodityParam commParam : param.getCommodityList()) {
            // 1、查询出库方商品库存
            InvmComoInventory outComoInv = new InvmComoInventory();
            outComoInv.setLaId(param.getLgcsId());
            outComoInv.setLaCode(param.getLgcsCode());
            outComoInv.setOwnerId(param.getOwnerId());
            outComoInv.setOwnerCode(param.getOwnerCode());
            outComoInv.setOwnerType(param.getOwnerType());
            outComoInv.setCommodityId(commParam.getCommodityId());
            outComoInv.setUom(commParam.getUom());
            outComoInv.setIvType(commParam.getFromInvStatus());
            outComoInv.setComoIvType(LinvTypeCodeMaster.COMO_INENTORY_TYPE.Actual);
            InvmComoInventory outCommResult = invmComoInventoryDao.findOne(outComoInv);
            if (null == outCommResult) {
                throw new BusinessException("LINV.ADJUSTMENT", "出库方商品库存不存在");
            }
            String fromStoreNo = outCommResult.getStoreNo();
            // 调整库存状态相同
            if (commParam.getFromInvStatus().equals(commParam.getToInvStatus())) {

                // 1、新增商品调整主表
                InvmComoInventoryAdjust comoInvAdjust = doSaveComoAdjust(param, adjustDate,time);

                // 2、新增商品调整明细表
                InvmComoInventoryAdjustDetail comoInvAdjustDetail = new InvmComoInventoryAdjustDetail();
                Long detailId = baseRedisDao.getTablePrimaryKey("invm_como_inventory_adjust_detail", 1);
                comoInvAdjustDetail.setDetailId(detailId);
                comoInvAdjustDetail.setComoAdjustId(comoInvAdjust.getComoAdjustId());
                comoInvAdjustDetail.setStoreNoFrom(fromStoreNo);
                comoInvAdjustDetail.setStoreNoTo(fromStoreNo);
                comoInvAdjustDetail.setAdjustQty(new BigDecimal(commParam.getAdjustQty()));
                comoInvAdjustDetail.setCrtId("WMS");
                comoInvAdjustDetail.setCrtTime(time);
                invmComoInventoryAdjustDetailDao.save(comoInvAdjustDetail);

                // 3、修改出库方商品数量
                outCommResult.setIvQty(new BigDecimal(commParam.getAdjustQty()));
                outCommResult.setUpdId("WMS");
                outCommResult.setUpdTime(time);
                invmComoInventoryDao.modify(outCommResult);

                // 4、新增商品交易明细
                InvmComoDealDetail dealDetail = new InvmComoDealDetail();
                dealDetail.setStoreDealId(baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1));
                dealDetail.setStoreNo(fromStoreNo);
                dealDetail.setTransactionId(comoInvAdjust.getComoAdjustId());
                dealDetail.setTransactionNo(comoInvAdjust.getComoAdjustCode());
                dealDetail.setTransactionDetailId(detailId);
                dealDetail.setTransactionSource("XCD");
                dealDetail.setTransactionType(LINV0119IParam.TRANSACTION_TYPE);
                dealDetail.setTransactionTime(time);
                dealDetail.setBizType(LinvTypeCodeMaster.COMO_ADJUSTMENT.ComoInvAdjust);
                dealDetail.setDealQty(new BigDecimal(commParam.getAdjustQty()));
                dealDetail.setCrtId("WMS");
                dealDetail.setCrtTime(time);
                dealDetail.setBizType("015");
                invmComoDealDetailDao.save(dealDetail);
            } else {// 调整库存状态不相同
                // 1、查询入库方商品库存
                InvmComoInventory inComoInv = new InvmComoInventory();
                inComoInv.setLaId(param.getLgcsId());
                inComoInv.setLaCode(param.getLgcsCode());
                inComoInv.setOwnerId(param.getOwnerId());
                inComoInv.setOwnerCode(param.getOwnerCode());
                inComoInv.setOwnerType(param.getOwnerType());
                inComoInv.setCommodityId(commParam.getCommodityId());
                inComoInv.setUom(commParam.getUom());
                inComoInv.setIvType(commParam.getToInvStatus());
                inComoInv.setComoIvType(LinvTypeCodeMaster.COMO_INENTORY_TYPE.Actual);
                InvmComoInventory inCommResult = invmComoInventoryDao.findOne(inComoInv);
                String toStoreNo = "";
                if (null == inCommResult) {
                    // 入库方不存在，则新增
                    toStoreNo = NumberGenerator.getNewCommodityNumber();
                    inComoInv.setStoreNo(toStoreNo);
                    inComoInv.setIvQty(new BigDecimal(commParam.getAdjustQty()));
                    inComoInv.setSplatCode("001");
                    inComoInv.setCrtId("WMS");
                    inComoInv.setCrtTime(time);
                    invmComoInventoryDao.save(inComoInv);
                } else {
                    // 修改入库方商品库存
                    toStoreNo = inCommResult.getStoreNo();
                    inCommResult.setIvQty(new BigDecimal(commParam.getAdjustQty()));
                    inCommResult.setUpdId("WMS");
                    inCommResult.setUpdTime(time);
                    invmComoInventoryDao.modify(inCommResult);
                }
                // 2、新增商品调整主表
                InvmComoInventoryAdjust comoInvAdjust = doSaveComoAdjust(param, adjustDate,time);

                // 3、新增商品调整明细表
                InvmComoInventoryAdjustDetail comoInvAdjustDetail = new InvmComoInventoryAdjustDetail();
                Long detailId = baseRedisDao.getTablePrimaryKey("invm_como_inventory_adjust_detail", 1);
                comoInvAdjustDetail.setDetailId(detailId);
                comoInvAdjustDetail.setComoAdjustId(comoInvAdjust.getComoAdjustId());
                comoInvAdjustDetail.setStoreNoFrom(fromStoreNo);
                comoInvAdjustDetail.setStoreNoTo(toStoreNo);
                comoInvAdjustDetail.setAdjustQty(new BigDecimal(commParam.getAdjustQty()));
                comoInvAdjustDetail.setCrtId("WMS");
                comoInvAdjustDetail.setCrtTime(time);
                invmComoInventoryAdjustDetailDao.save(comoInvAdjustDetail);

                // 4、修改出库方商品数量
                outCommResult.setIvQty(new BigDecimal(0).subtract(new BigDecimal(commParam.getAdjustQty())));
                outCommResult.setUpdId("WMS");
                outCommResult.setUpdTime(time);
                invmComoInventoryDao.modify(outCommResult);
                // 5、新增出库方商品交易明细
                InvmComoDealDetail outDealDetail = new InvmComoDealDetail();
                outDealDetail.setStoreDealId(baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1));
                outDealDetail.setStoreNo(fromStoreNo);
                outDealDetail.setTransactionId(comoInvAdjust.getComoAdjustId());
                outDealDetail.setTransactionNo(comoInvAdjust.getComoAdjustCode());
                outDealDetail.setTransactionDetailId(detailId);
                outDealDetail.setTransactionSource("XCD");
                outDealDetail.setTransactionType(LINV0119IParam.TRANSACTION_TYPE);
                outDealDetail.setTransactionTime(time);
                outDealDetail.setBizType(LinvTypeCodeMaster.COMO_ADJUSTMENT.ComoInvAdjust);
                outDealDetail.setDealQty((new BigDecimal(0).subtract(new BigDecimal(commParam.getAdjustQty()))));
                outDealDetail.setCrtId("WMS");
                outDealDetail.setCrtTime(time);
                outDealDetail.setBizType("015");
                invmComoDealDetailDao.save(outDealDetail);

                // 6、新增入库方交易明细
                InvmComoDealDetail inDealDetail = new InvmComoDealDetail();
                inDealDetail.setStoreDealId(baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1));
                inDealDetail.setStoreNo(toStoreNo);
                inDealDetail.setTransactionId(comoInvAdjust.getComoAdjustId());
                inDealDetail.setTransactionNo(comoInvAdjust.getComoAdjustCode());
                inDealDetail.setTransactionDetailId(detailId);
                inDealDetail.setTransactionSource("XCD");
                inDealDetail.setTransactionType(LINV0119IParam.TRANSACTION_TYPE);
                inDealDetail.setTransactionTime(time);
                inDealDetail.setBizType(LinvTypeCodeMaster.COMO_ADJUSTMENT.ComoInvAdjust);
                inDealDetail.setDealQty(new BigDecimal(commParam.getAdjustQty()));
                inDealDetail.setCrtId("WMS");
                inDealDetail.setCrtTime(time);
                inDealDetail.setBizType("015");
                invmComoDealDetailDao.save(inDealDetail);
            }
        }
    }

    /**
     * 新增商品调整主表
     * 
     * @param param
     * @param adjustDate
     * @return
     */
    private InvmComoInventoryAdjust doSaveComoAdjust(LINV0119IParam param, Date adjustDate,Date time) {
        Long adjustId = (baseRedisDao.getTablePrimaryKey("invm_como_inventory_adjust", 1));
        String adjustCode = NumberGenerator.getNewCommAdjustmentNumber();
        InvmComoInventoryAdjust comoInvAdjust = new InvmComoInventoryAdjust();
        comoInvAdjust.setComoAdjustId(adjustId);
        comoInvAdjust.setComoAdjustCode(adjustCode);
        comoInvAdjust.setLaId(param.getLgcsId());
        comoInvAdjust.setLaCode(param.getLgcsCode());
        comoInvAdjust.setOwnerId(param.getOwnerId());
        comoInvAdjust.setOwnerCode(param.getOwnerCode());
        comoInvAdjust.setOwnerType(param.getOwnerType());
        comoInvAdjust.setAdjustDate(adjustDate);
        comoInvAdjust.setAdjustPerson(param.getAdjustPerson());
        comoInvAdjust.setRemark(param.getAdjustRemark());
        comoInvAdjust.setCrtId("WMS");
        comoInvAdjust.setCrtTime(time);
        invmComoInventoryAdjustDao.save(comoInvAdjust);
        return comoInvAdjust;
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
