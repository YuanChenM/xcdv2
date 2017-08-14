package com.bms.linv.common;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bms.linv.bean.entity.InvmCommInfo;
import com.bms.linv.bean.entity.InvmProductInfo;
import com.bms.linv.bean.entity.InvmSkuInfo;
import com.bms.linv.bean.param.LINV0101ISourceParam;

/**
 * Created by duan_kai on 2017/2/9.
 */
public class ResponseDataReader {

    public static String NAME = "NAME";
    public static String SKU = "SKU";
    public static String PRO = "PRO";
    public static String COMM = "COMM";

    public static HashMap<String, List> comInfoReader(List originList, String sign, Date time,LINV0101ISourceParam source) {
        HashMap<String, List> result = new HashMap<String, List>();
        List<InvmCommInfo> comResult = new ArrayList<InvmCommInfo>();

        if (originList != null) {
            Map tempCom = (HashMap) originList.get(0);
            InvmCommInfo tCom =  new InvmCommInfo();
            tCom.setCommodityId(String.valueOf(tempCom.get("commodityId")));
            //tCom.setLaId(source.getLogicAreaId());
            tCom.setCommodityName(String.valueOf(tempCom.get("commodityName")));
            tCom.setPdId(String.valueOf(tempCom.get("productId")));
//            if(tempCom.get("producerId")!= null){
//                tCom.setPdrsId(Long.valueOf(String.valueOf(tempCom.get("producerId"))));
//                tCom.setPdrsCode(String.valueOf(tempCom.get("producerCode")));
//                tCom.setPdrsName(String.valueOf(tempCom.get("producerName")));
//            }
//            if(tempCom.get("lotNo")!= null){
//                tCom.setLotNo(String.valueOf(tempCom.get("lotNo")));
//            }
            tCom.setSaleStatusId(Long.valueOf(String.valueOf(tempCom.get("saleStatusId"))));
            tCom.setSaleStatusCode(String.valueOf(tempCom.get("saleStatusCode")));
            tCom.setSaleStatusName(String.valueOf(tempCom.get("saleStatusName")));
            tCom.setDelFlg(false);
            tCom.setCrtId(sign);
            tCom.setCrtTime(time);
            if(Boolean.valueOf(String.valueOf(tempCom.get("isDefault")))){
                comResult.add(tCom);
            }
        }
        result.put(COMM, comResult);
        return result;
    }

    /**
     * 封装SKU信息
     * @param originList
     * @param sign
     * @param time
     * @return
     */
    public static HashMap<String, List> skuInfoReader(List originList, String sign, Date time) {
        HashMap<String, List> result = new HashMap<String, List>();
        List<InvmSkuInfo> skuResult = new ArrayList<InvmSkuInfo>();

        if (originList != null) {
            Map tempSku = (HashMap) originList.get(0);
            InvmSkuInfo tSku =  new InvmSkuInfo();
            tSku.setSkuCode(String.valueOf(tempSku.get("manufacturerProductSku")));
            tSku.setPdId(String.valueOf(tempSku.get("productId")));
            tSku.setMfrsId(Long.valueOf(String.valueOf(tempSku.get("entitySellerId"))));
            tSku.setMfrsCode(String.valueOf(tempSku.get("entitySellerCode")));
            tSku.setMfrsName(String.valueOf(tempSku.get("fullName")));
            JSONArray producerProducts = (JSONArray) tempSku.get("producerProducts");
            JSONObject producerProduct = producerProducts.getJSONObject(0);
            tSku.setPdrsId(Long.valueOf(String.valueOf(producerProduct.get("entitySellerId"))));
            tSku.setPdrsCode(String.valueOf(producerProduct.get("entitySellerCode")));
            tSku.setPdrsName(String.valueOf(producerProduct.get("fullName")));
            tSku.setDelFlg(false);
            tSku.setCrtId(sign);
            tSku.setCrtTime(time);
            skuResult.add(tSku);
        }
        result.put(SKU, skuResult);
        return result;
    }

    /**
     * 封装PRODUCT信息
     * @param originList
     * @param sign
     * @param time
     * @return
     */
    public static HashMap<String, List> proInfoReader(List originList, String sign, Date time) {
        HashMap<String, List> result = new HashMap<String, List>();
        List<InvmProductInfo> proResult = new ArrayList<InvmProductInfo>();

        if (originList != null) {
            Map tempPro = (HashMap) originList.get(0);
            InvmProductInfo tPro =  new InvmProductInfo();
            tPro.setProductId(String.valueOf(tempPro.get("productId")));
            tPro.setClassesId(Long.valueOf(String.valueOf(tempPro.get("classesId"))));
            tPro.setClassesCode(String.valueOf(tempPro.get("classesCode")));
            tPro.setClassesName(String.valueOf(tempPro.get("classesName")));
            tPro.setMachiningId(Long.valueOf(String.valueOf(tempPro.get("machiningId"))));
            tPro.setMachiningCode(String.valueOf(tempPro.get("machiningCode")));
            tPro.setMachiningName(String.valueOf(tempPro.get("machiningName")));
            tPro.setBreedId(Long.valueOf(String.valueOf(tempPro.get("breedId"))));
            tPro.setBreedCode(String.valueOf(tempPro.get("breedCode")));
            tPro.setBreedSalesName(String.valueOf(tempPro.get("breedSalesName")));
            tPro.setItemId(Long.valueOf(String.valueOf(tempPro.get("itemId"))));
            tPro.setItemCode(String.valueOf(tempPro.get("itemCode")));
            tPro.setItemSku(String.valueOf(tempPro.get("itemSku")));
            tPro.setItemName(String.valueOf(tempPro.get("itemName")));
            tPro.setBrandId(Long.valueOf(String.valueOf(tempPro.get("brandId"))));
            tPro.setBrandCode(String.valueOf(tempPro.get("brandCode")));
            tPro.setBrandName(String.valueOf(tempPro.get("brandName")));
            tPro.setQualityGradeTypeCode(String.valueOf(tempPro.get("qualityGradeTypeStr")));
            tPro.setQualityGradeType(String.valueOf(tempPro.get("qualityGradeType")));
            tPro.setGrossWeight(BigDecimal.valueOf(Double.valueOf((String.valueOf(tempPro.get("grossWeight"))))));
            tPro.setNetWeightCode(String.valueOf(tempPro.get("netWeightCode")));
            tPro.setNetWeight(BigDecimal.valueOf(Double.valueOf(String.valueOf(tempPro.get("netWeight")))));
            tPro.setPackageSpecification(String.valueOf(tempPro.get("packageSpecification")));
            tPro.setPackageQuantity(String.valueOf(tempPro.get("packageQuantity")));
            tPro.setCartonDimension(String.valueOf(tempPro.get("cartonDimension")));
            tPro.setPalletStackingLimit(String.valueOf(tempPro.get("palletStackingLimit")));
            tPro.setBrandItemPropertySku(String.valueOf(tempPro.get("brandItemPropertySku")));
            tPro.setItemPropertyCode(String.valueOf(tempPro.get("itemPropertyCode")));
            tPro.setDelFlg(false);
            tPro.setCrtId(sign);
            tPro.setCrtTime(time);
            proResult.add(tPro);
        }
        result.put(PRO, proResult);
        return result;
    }

}
