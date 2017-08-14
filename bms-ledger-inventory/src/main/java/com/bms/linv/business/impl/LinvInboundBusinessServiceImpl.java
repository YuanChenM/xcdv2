package com.bms.linv.business.impl;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bms.linv.bean.param.*;
import com.bms.linv.bean.result.*;
import com.framework.exception.BusinessException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.linv.bean.entity.*;
import com.bms.linv.business.LinvInboundBusinessService;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.common.ResponseDataReader;
import com.bms.linv.constant.LinvApiUrlConstant;
import com.bms.linv.constant.LinvTypeCodeMaster;
import com.bms.linv.dao.*;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 入库业务处理服务实现处理
 * Created by wang_fan on 2017/4/14.
 */
@Service
public class LinvInboundBusinessServiceImpl extends BaseServiceImpl implements LinvInboundBusinessService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Autowired
    private InvmSkuInfoDao invmSkuInfoDao;

    @Autowired
    private InvmProductInfoDao invmProductInfoDao;

    @Autowired
    private InvmCommInfoDao invmCommInfoDao;

    @Autowired
    private InvmWhInfoDao invmWhInfoDao;

    @Autowired
    private InvmNameInfoDao invmNameInfoDao;

    @Autowired
    private InvmLoadDealDetailDao invmLoadDealDetailDao;

    @Autowired
    private LinvPublicMethodService linvPublicMethodService;

    @Autowired
    private InvmLoadDao invmLoadDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 一个物流区，多个skucode 参数拼接
     * @param invmLoad
     * @return
     */
    private static String getRequestXml(InvmLoad invmLoad) {
        String lgcsCode=invmLoad.getLaCode();
        String skuString=invmLoad.getSkuCode();
        String head="{\"skuCode\":\"";
        skuString=skuString.replaceAll(",","\"}, {\"skuCode\":\"");
        String end="\"}";
        String skuResult=head+skuString+end;

        String xmlString = "{\"lgcsCode\":\""+lgcsCode+"\", \"productList\":["+skuResult+"]}";
        StringBuilder sb = new StringBuilder();
        sb.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");  //xml协议格式请根据自己的soap协议构建。不然无法使用
        sb.append("<soap:Body>");
        sb.append("<ns2:getStockByCodes xmlns:ns2=\"http://ws.top.dhc.com/\">");  //要调用的webservice服务的方法名称
        sb.append("<skuInfo>"+xmlString+"</skuInfo>"); //上面获取到的参数
        sb.append("</ns2:getStockByCodes>");
        sb.append("</soap:Body>");
        sb.append("</soap:Envelope>");
        return sb.toString();
    }


    /**
     * 向wms查询入库产品信息
     * @param param
     */
    @Override
    public List<LINV0117IResultParam> omsInbounds(LINV0117IParam param) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";

        List<LINV0117IResultParam>  resultList= new ArrayList<LINV0117IResultParam>();
        DefaultHttpClient httpClient = null;
        try {
            //查询库存数据库产品库存所有物流区域的所有的skuCode
            List<InvmLoad> invmLoadList= new ArrayList<>();
            if((null == param.getSkuCode() || "".equals(param.getSkuCode()) || (null == param.getLaCode() || "".equals(param.getLaCode())))) {
               invmLoadList = invmLoadDao.findAllSkuCode();
            }else{
                InvmLoad invmLoad = new InvmLoad();
                invmLoad.setLaCode(param.getLaCode());
                invmLoad.setSkuCode(param.getSkuCode());
                invmLoadList.add(invmLoad);
            }

            // 设置历史数据delfag置为1
            invmLoadDao.setDelFlag();

            //业务参数：一个物流区，多个skucode，去WMS查询产品库存数据并插入库存数据库
            for (int j = 0;  j< invmLoadList.size(); j++) {
                httpClient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(LinvApiUrlConstant.WMS_SKU.URL); //webservice服务地址
                String soapRequestData = getRequestXml(invmLoadList.get(j)); //soap协议的格式，定义了方法和参数
                HttpEntity re = new StringEntity(soapRequestData, HTTP.UTF_8);
                httppost.setHeader("Content-Type", "application/soap+xml; charset=utf-8");
                httppost.setEntity(re);
                HttpResponse response = httpClient.execute(httppost); //调用接口
                if (response.getStatusLine().getStatusCode() == 200) {  //调用状态
                    String xmlString = EntityUtils.toString(response.getEntity());
                    xmlString = xmlString.replaceAll("return>", "result>");
                    XStream xstream = new XStream(new DomDriver());
                    xstream.setMode(XStream.NO_REFERENCES);
                    //注册使用了注解的VO
                    xstream.processAnnotations(new Class[]{Envelope.class});
                    Envelope envelope = (Envelope) xstream.fromXML(xmlString);
                    String jsonString = envelope.getBody().getStockByCodesResponse().getResult();
                    if(!"".equals(jsonString)) {
                        Map map = JSON.parseObject(jsonString);
                        JSONArray producerProducts = (JSONArray) map.get("productList");
                        for (int i = 0; i < producerProducts.size(); i++) {
                            LINV0117IResultParam resultParam = new LINV0117IResultParam();
                            JSONObject product = producerProducts.getJSONObject(0);
                            resultParam.setLaCode(String.valueOf(product.get("lgcsCode")));
                            resultParam.setSkuCode(String.valueOf(product.get("skuCode")));
                            resultParam.setSkuName(String.valueOf(product.get("skuName")));
                            resultParam.setLotNo(String.valueOf(product.get("lotNo")));
                            resultParam.setUnit(String.valueOf(product.get("unit")));
                            resultParam.setInboundQty(String.valueOf(product.get("inboundQty")));
                            resultParam.setStatus(String.valueOf(product.get("status")));
                            resultParam.setSalesLabel(String.valueOf(product.get("salesLabel")));
                            resultParam.setConsignee(String.valueOf(product.get("consignee")));
                            resultParam.setWhCode(String.valueOf(product.get("whCode")));
                            resultParam.setWhName(String.valueOf(product.get("whName")));
                            resultParam.setCrtId(sign);
                            resultParam.setCrtTime(time);
                            resultList.add(resultParam);
                            //保存
                            resultParam.setSyncId(baseRedisDao.getTablePrimaryKey("invm_load_sync", 1));
                            resultParam.setSyncTime(time);
                            invmLoadDao.saveLoadSync(resultParam);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown(); //关闭连接
        }
        return resultList;
    }

    /**
     * 入库业务
     * 
     * @param params
     */
    @Override
    public void receiveLoads(List<LINV0101IParam> params) {

        // 业务单号重复验证
        checkProductTran(params);

        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        RestApiClient restClient = restApiClientFactory.newApiRestClient();

        for (int i = 0; i < params.size(); i++) {
            LINV0101ISourceParam source = params.get(i).getSource();
            LINV0101IDealParam deal = params.get(i).getDeal();


            // 查询是否存在该SKUCODE
            InvmSkuInfo invmSkuParam = new InvmSkuInfo();
            invmSkuParam.setSkuCode(source.getSkuCode());
            InvmSkuInfo invmSkuInfo = invmSkuInfoDao.findOne(invmSkuParam);
            // if (invmSkuInfo == null) {
            // 通过SKUCODE拿产品信息（调用卖家产品接口）
            String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLPD.CODE,
                LinvApiUrlConstant.SLPD.URIS.COMM_SEARCH);
            HashMap requestSku = new HashMap();
            requestSku.put("manufacturerProductSku", source.getSkuCode());
            BaseWebPaginationResult<HashMap> skuResult = restClient.post(url, requestSku,
                    new TypeReference<BaseWebPaginationResult<HashMap>>() {
                    });
            // 封装skuInfo参数信息
            Map skuData = ResponseDataReader.skuInfoReader(skuResult.getData(), sign, time);
            Map tempSku = (HashMap) skuResult.getData().get(0);
            String pdId = String.valueOf(tempSku.get("productId"));// 产品id
            if (invmSkuInfo == null) {
                if (skuResult.getData() != null) {
                    // 1.插入Sku信息表
                    saveSkuInfo(skuData);

                    Long logicAreaId = source.getLogicAreaId();// 物流区域
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
                } else {
                    throw new BusinessException("LINV_PRODUCT", "skuCode未找到产品信息");
                }
            }

            // 通过获取到的产品id拿商品信息（调用商品查询接口）
            String comUrl = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.COMO.CODE,
                LinvApiUrlConstant.COMO.URIS.COMM_INFO_SEARCH);
            HashMap requestCom = new HashMap();
            if (null != deal.getSalesStatusId()) {
                List<Long> arryLsParam = new ArrayList<Long>();
                arryLsParam.add(deal.getSalesStatusId());
                requestCom.put("saleStatusIds", arryLsParam.toArray(new Long[arryLsParam.size()]));
            }else{
                requestCom.put("isDefault", true);
            }
            requestCom.put("productId", pdId);
            BaseWebPaginationResult<HashMap> comResult = restClient.post(comUrl, requestCom,
                    new TypeReference<BaseWebPaginationResult<HashMap>>() {
                    });
            // 封装comInfo参数信息
            Map comData = ResponseDataReader.comInfoReader(comResult.getData(), sign, time, source);
            String commodityId = "";

            if (comResult.getData() != null) {
                Map tempCom = (HashMap) comResult.getData().get(0);
                commodityId = String.valueOf(tempCom.get("commodityId"));// 产品id
                deal.setSalesStatusId(Long.valueOf(String.valueOf(tempCom.get("saleStatusId"))));
                deal.setSalesStatusCode(String.valueOf(tempCom.get("saleStatusCode")));
                // 3.插入商品信息表
                InvmCommInfo invmCommParam = new InvmCommInfo();
                invmCommParam.setCommodityId(commodityId);
                InvmCommInfo invmCommInfo = invmCommInfoDao.findOne(invmCommParam);
                if (invmCommInfo == null) {
                    saveCommInfo(comData);
                }
            } else {
                throw new BusinessException("LINV_COMOIDITY", "productId未找到商品信息");
            }


            // 4.插入商品库存和对应交易明细
            saveComoDeal(time, source, deal, commodityId);

            // 5.插入SKU库存表
            saveLoadInfo(time, source, deal);

            // 6.仓库信息插入
            saveWhInfo(time, sign, source);

            // 7.名称信息表
            saveNameInfo(time, sign, source, deal);
        }
    }


    /**
     * 产品库存业务单号重复验证
     *
     * @param params
     */
    private void checkProductTran(List<LINV0101IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0101IDealParam deal = params.get(i).getDeal();
            InvmLoadDealDetail dealDetail = new InvmLoadDealDetail();
            dealDetail.setTransactionId(deal.getTransactionId());
            dealDetail.setTransactionNo(deal.getTransactionNo());
            dealDetail.setTransactionDetailId(deal.getTransactionDetailId());
            dealDetail.setTransactionSequence(deal.getTransactionSequence());
            int count = invmLoadDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV_PRODUCT", "业务单号重复");
            }
        }
    }

    /**
     * 名称信息表
     * 
     * @param time
     * @param sign
     * @param source
     * @param deal
     */
    private void saveNameInfo(Date time, String sign, LINV0101ISourceParam source, LINV0101IDealParam deal) {
        List<InvmNameInfo> nameInfoList = new ArrayList<InvmNameInfo>();
        InvmNameInfo nameInfo = null;
        if (!StringUtils.isEmpty(source.getLogicAreaName())) {
            nameInfo = new InvmNameInfo();
            nameInfo.setType(LinvTypeCodeMaster.NAME_INFO.LOGICAREA);
            nameInfo.setCode(source.getLogicAreaCode());
            nameInfo.setName(source.getLogicAreaName());
            dealNameInfoParam(sign, time, nameInfo);
            nameInfoList.add(nameInfo);
        }
//        if (!StringUtils.isEmpty(deal.getSupplierName())) {
//            nameInfo = new InvmNameInfo();
//            nameInfo.setType(LinvTypeCodeMaster.NAME_INFO.SUPPLIER);
//            nameInfo.setCode(deal.getSupplierCode());
//            nameInfo.setName(deal.getSupplierName());
//            dealNameInfoParam(sign, time, nameInfo);
//            nameInfoList.add(nameInfo);
//        }
        if (!StringUtils.isEmpty(source.getOwnerName())) {
            nameInfo = new InvmNameInfo();
            nameInfo.setType(LinvTypeCodeMaster.NAME_INFO.OWNER);
            nameInfo.setCode(source.getOwnerCode());
            nameInfo.setName(source.getOwnerName());
            dealNameInfoParam(sign, time, nameInfo);
            nameInfoList.add(nameInfo);
        }
        if (!StringUtils.isEmpty(source.getMasterOwnerName())) {
            nameInfo = new InvmNameInfo();
            nameInfo.setType(LinvTypeCodeMaster.NAME_INFO.OWNER);
            nameInfo.setCode("00000001");
            nameInfo.setName("鲜驰达控股集团");
            dealNameInfoParam(sign, time, nameInfo);
            nameInfoList.add(nameInfo);
        }
        for (int j = 0; j < nameInfoList.size(); j++) {
            invmNameInfoDao.save(nameInfoList.get(j));
        }
    }

    /**
     * 仓库信息插入
     * 
     * @param time
     * @param sign
     * @param source
     */
    private void saveWhInfo(Date time, String sign, LINV0101ISourceParam source) {

//        if(!(null == source.getWhId() && "".equals(source.getWhId()) || !(null == source.getWhCode() && "".equals(source.getWhCode() )))){
//                InvmWhInfo invmWhInfo = new InvmWhInfo();
//                invmWhInfo.setWhId(source.getWhId());
//                invmWhInfo.setWhCode(source.getWhCode());
//                invmWhInfo.setWhName(source.getWhName());
//                invmWhInfo.setLaId(source.getLogicAreaId());
//                InvmWhInfo invmWhReslut = invmWhInfoDao.findOne(invmWhInfo);
//            if (invmWhReslut == null) {
//                throw new BusinessException("LINV_WH", "未找到基础信息");
//            }
//        }
    }

    /**
     * 插入商品库存和对应交易明细
     * 
     * @param time
     * @param source
     * @param deal
     * @param commodityId
     */
    private void saveComoDeal(Date time, LINV0101ISourceParam source, LINV0101IDealParam deal, String commodityId) {
        InvmComoInventory invmComoInvParam = new InvmComoInventory();
        invmComoInvParam.setLaId(source.getLogicAreaId());
        invmComoInvParam.setSplatCode(source.getSalePlatform());
        invmComoInvParam.setOwnerId(source.getOwnerId());
        invmComoInvParam.setOwnerCode(source.getOwnerCode());
        invmComoInvParam.setOwnerType(source.getOwnerType());
        invmComoInvParam.setCommodityId(commodityId);
        invmComoInvParam.setUom(source.getUom());
        invmComoInvParam.setIvType(deal.getIvType());
        invmComoInvParam.setLaCode(source.getLogicAreaCode());
//        if (null == source.getOwnerdType() || "".equals(source.getOwnerdType())) {
//            invmComoInvParam.setOwnerDType(source.getOwnerType());
//        } else {
//            invmComoInvParam.setOwnerDType(source.getOwnerdType());
//        }
        invmComoInvParam.setIvQty(deal.getRecvQty());
        invmComoInvParam.setComoIvType(LinvTypeCodeMaster.COMO_INENTORY_TYPE.Actual);

        InvmComoDealDetail invmComoDealDetail = new InvmComoDealDetail();
        invmComoDealDetail.setTransactionId(deal.getTransactionId());
        invmComoDealDetail.setTransactionNo(deal.getTransactionNo());
        invmComoDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        invmComoDealDetail.setTransactionSource(deal.getTransactionSource());
        invmComoDealDetail.setTransactionType(LINV0101IParam.TRANSACTION_TYPE);
        invmComoDealDetail.setTransactionTime(time);
        invmComoDealDetail.setRefNo(deal.getRefNo());
        invmComoDealDetail.setBizType(deal.getBizType());
        invmComoDealDetail.setDealPrice(deal.getBuyPrice());
        invmComoDealDetail.setDealQty(deal.getRecvQty());

        InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
        invmComoBalanceInventory.setTransactionId(deal.getTransactionId());
        invmComoBalanceInventory.setTransactionNo(deal.getTransactionNo());
        invmComoBalanceInventory.setTransactionDetailId(deal.getTransactionDetailId());
        invmComoBalanceInventory.setTransactionSource(deal.getTransactionSource());
        invmComoBalanceInventory.setTransactionType(LINV0101IParam.TRANSACTION_TYPE);
        invmComoBalanceInventory.setTransactionTime(time);
        invmComoBalanceInventory.setRefNo(deal.getRefNo());
        invmComoBalanceInventory.setBizType(deal.getBizType());
        invmComoBalanceInventory.setDealPrice(deal.getBuyPrice());
        invmComoBalanceInventory.setInboundQty(deal.getRecvQty());
        invmComoBalanceInventory.setOutboundQty(BigDecimal.valueOf(0));

        linvPublicMethodService.addComoInv(invmComoInvParam, invmComoDealDetail, invmComoBalanceInventory);

    }

    /**
     * 插入商品信息表
     * 
     * @param comData
     */
    private void saveCommInfo(Map comData) {
        List<InvmCommInfo> comInfoList = new ArrayList();
        Object comInfoObj = comData.get(ResponseDataReader.COMM);
        if (comInfoObj != null) {
            comInfoList.addAll((List) comInfoObj);
        }
        for (int j = 0; j < comInfoList.size(); j++) {
            comInfoList.get(j).setInfoId(baseRedisDao.getTablePrimaryKey("invm_comm_info", 1));
            invmCommInfoDao.save(comInfoList.get(j));
        }
    }

    /**
     * 插入SKU库存表
     * 
     * @param time
     * @param source
     * @param deal
     */
    private void saveLoadInfo(Date time, LINV0101ISourceParam source, LINV0101IDealParam deal) {
        InvmLoad invmLoadParam = new InvmLoad();
        invmLoadParam.setLaId(source.getLogicAreaId());
        invmLoadParam.setSplatCode(source.getSalePlatform());

        // 调接口查询平台卖家id
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLIM.CODE,
            LinvApiUrlConstant.SLIM.URIS.COMM_SEARCH);
        HashMap requestSku = new HashMap();
        if (null == source.getMasterOwnerCode() || "".equals(source.getMasterOwnerCode())) {
            requestSku.put("entitySellerCode", "00000001");
        } else {
            requestSku.put("entitySellerCode", source.getMasterOwnerCode());
        }
        BaseWebPaginationResult<HashMap> skuResult = restClient.post(url, requestSku,
                new TypeReference<BaseWebPaginationResult<HashMap>>() {
                });
        if (skuResult.getData() != null) {
            Map tempSku = (HashMap) skuResult.getData().get(0);
            invmLoadParam.setOwnerId(String.valueOf(tempSku.get("entitySellerId")));
            invmLoadParam.setOwnerCode(String.valueOf(tempSku.get("entitySellerCode")));
            invmLoadParam.setOwnerType(LinvTypeCodeMaster.OWNER_TYPE.SELLER);
        } else {
            throw new BusinessException("LINV_PRODUCT", "未查询到对应平台卖家信息！");
        }
//        if (null == source.getOwnerdType() || "".equals(source.getOwnerdType())) {
//            invmLoadParam.setOwnerDType(LinvTypeCodeMaster.OWNER_TYPE.SELLER);
//        } else {
//            invmLoadParam.setOwnerDType(source.getOwnerdType());
//        }
        invmLoadParam.setSkuCode(source.getSkuCode());
        invmLoadParam.setLotNo(deal.getLotNo());
        invmLoadParam.setUom(source.getUom());
        invmLoadParam.setSaleStatusId(deal.getSalesStatusId());
        invmLoadParam.setIvType(deal.getIvType());
        invmLoadParam.setLaCode(source.getLogicAreaCode());
        invmLoadParam.setWhId(Long.valueOf("1"));
        invmLoadParam.setWhCode("0000");
//        invmLoadParam.setSpId(deal.getSupplierId());
//        invmLoadParam.setSpCode(deal.getSupplierCode());
        invmLoadParam.setIvQty(deal.getRecvQty());
        invmLoadParam.setSaleStatusCode(deal.getSalesStatusCode());

        // 插入SKU交易明细表
        InvmLoadDealDetail invmLoadDealDetail = new InvmLoadDealDetail();
        invmLoadDealDetail.setTransactionId(deal.getTransactionId());
        invmLoadDealDetail.setTransactionNo(deal.getTransactionNo());
        invmLoadDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        invmLoadDealDetail.setTransactionSequence(deal.getTransactionSequence());
        invmLoadDealDetail.setTransactionSource(deal.getTransactionSource());
        invmLoadDealDetail.setTransactionType(LINV0101IParam.TRANSACTION_TYPE);
        invmLoadDealDetail.setTransactionTime(time);
        invmLoadDealDetail.setRefNo(deal.getRefNo());
        invmLoadDealDetail.setBizType(deal.getBizType());
        invmLoadDealDetail.setSpId(deal.getSupplierId());
        invmLoadDealDetail.setSkuCode(source.getSkuCode());
        invmLoadDealDetail.setLotNo(deal.getLotNo());
        invmLoadDealDetail.setSaleStatusId(deal.getSalesStatusId());
        invmLoadDealDetail.setDealQty(deal.getRecvQty());
        invmLoadDealDetail.setDealPrice(deal.getBuyPrice());

        linvPublicMethodService.addProductInv(invmLoadParam, invmLoadDealDetail);

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
     * 名称信息共通字段处理
     *
     * @param sign
     * @param time
     * @param nameInfo
     */
    private void dealNameInfoParam(String sign, Date time, InvmNameInfo nameInfo) {
        nameInfo.setDelFlg(false);
        nameInfo.setCrtId(sign);
        nameInfo.setCrtTime(time);
        nameInfo.setUpdId(sign);
        nameInfo.setUpdTime(time);
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
