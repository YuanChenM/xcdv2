package com.batch.linv.constant;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.batch.linv.bean.entity.LinvCommInfo;
import com.batch.linv.bean.entity.LinvNameInfo;
import com.batch.linv.bean.entity.LinvSkuInfo;


/**
 * Created by duan_kai on 2017/2/9.
 */
public class ResponseDataReader {

    public static String NAME = "NAME";
    public static String SKU = "SKU";
    public static String COMM = "COMM";

    public static LinvCommInfo commInfoReader(List originList,String skuCode,String sign,Date time) {
        LinvCommInfo tComm = null;
        if (originList != null ) {
                tComm = new LinvCommInfo();
                Map tempComm = (HashMap) originList.get(0);
                tComm.setSkuCode(skuCode);
                tComm.setCommodityId(String.valueOf(tempComm.get("commodityId")));
                tComm.setPid(Long.valueOf(String.valueOf(tempComm.get("itemId"))));
                tComm.setPcode(String.valueOf(tempComm.get("itemCode")));
                tComm.setBrId(Long.valueOf(String.valueOf(tempComm.get("brandId"))));
                tComm.setBrCode(String.valueOf(tempComm.get("brandCode")));
                tComm.setPbrCode(String.valueOf(tempComm.get("brandItemPropertySku")));
                tComm.setPdId(String.valueOf(tempComm.get("productId")));
                tComm.setLevel(String.valueOf(tempComm.get("qualityGradeType")));
                tComm.setNetWeight(new BigDecimal(String.valueOf(tempComm.get("netWeight"))));
                tComm.setSalesLabel(String.valueOf(tempComm.get("saleStatusCode")));
                tComm.setDefault((boolean)tempComm.get("isDefault"));
                tComm.setDelFlg(false);
                tComm.setCrtId(sign);
                tComm.setCrtTime(time);
        }
        return tComm;
    }

    public static HashMap<String, List> skuInfoReader(List originList,String sign,Date time) {
        HashMap<String, List> result = new HashMap<String, List>();
        List<LinvSkuInfo> skuResult = new ArrayList<LinvSkuInfo>();
        List<LinvNameInfo> nameResult = new ArrayList<LinvNameInfo>();

        LinvSkuInfo tSku = null;
        LinvNameInfo tName = null;

        if (originList.size() > 0) {
            for (int i = 0; i < originList.size(); i++) {
                tSku = new LinvSkuInfo();
                Map tempSku = (HashMap) originList.get(i);
                Object skuCodeObj = tempSku.get("manufacturerProductSku");
                if (skuCodeObj == null) {
                    continue;
                }
                tSku.setSkuCode(String.valueOf(tempSku.get("manufacturerProductSku")));
                tSku.setMfrsId(Long.valueOf(String.valueOf(tempSku.get("entitySellerId"))));
                tSku.setMfrsCode(String.valueOf(tempSku.get("entitySellerCode")));
                JSONArray producerProducts = (JSONArray) tempSku.get("producerProducts");
                for (int j = 0; j < producerProducts.size(); j++) {
                    JSONObject producerProduct = producerProducts.getJSONObject(j);
                    tSku.setPid(Long.valueOf(String.valueOf(producerProduct.get("itemId"))));
                    tSku.setPcode(String.valueOf(producerProduct.get("itemSku")));
                    tSku.setClassesCode(String.valueOf(producerProduct.get("classesCode")));
                    tSku.setMachiningCode(String.valueOf(producerProduct.get("machiningCode")));
                    tSku.setBreedCode(String.valueOf(producerProduct.get("breedCode")));
                    tSku.setPdesc(String.valueOf(producerProduct.get("itemName")));
                    tSku.setBrId(Long.valueOf(String.valueOf(producerProduct.get("brandId"))));
                    tSku.setBrCode(String.valueOf(producerProduct.get("brandCode")));
                    tSku.setPbrCode(String.valueOf(producerProduct.get("itemSku"))+String.valueOf(producerProduct.get("brandCode")));
                    //要用到这个ID
                    tSku.setPdId(String.valueOf(producerProduct.get("productId")));
                    tSku.setLevel(String.valueOf(producerProduct.get("qualityGradeType")));
                    tSku.setNetWeight(new BigDecimal(String.valueOf(producerProduct.get("netWeight"))));
                    tSku.setPdrsId(Long.valueOf(String.valueOf(producerProduct.get("entitySellerId"))));
                    tSku.setPdrsCode(String.valueOf(producerProduct.get("entitySellerCode")));
                    tSku.setPbrPdrsCode(String.valueOf(producerProduct.get("itemSku"))+String.valueOf(producerProduct.get("brandCode"))+String.valueOf(producerProduct.get("entitySellerCode")));
                    tSku.setPbrPdrsSpCode(String.valueOf(producerProduct.get("itemSku"))+String.valueOf(producerProduct.get("brandCode"))+String.valueOf(producerProduct.get("entitySellerCode")));
                    tSku.setDelFlg(false);
                    tSku.setCrtId(sign);
                    tSku.setCrtTime(time);
                    skuResult.add(tSku);

                    tName = new LinvNameInfo();
                    tName.setType(LinvTypeCodeMaster.NAME_INFO.BRAND);
                    tName.setCode(String.valueOf(producerProduct.get("brandCode")));
                    tName.setName(String.valueOf(producerProduct.get("brandName")));
                    nameResult.add(tName);

                    tName = new LinvNameInfo();
                    tName.setType(LinvTypeCodeMaster.NAME_INFO.PRODUCER);
                    tName.setCode(String.valueOf(producerProduct.get("entitySellerCode")));
                    tName.setName(String.valueOf(producerProduct.get("fullName")));
                    nameResult.add(tName);

                    tName = new LinvNameInfo();
                    tName.setType(LinvTypeCodeMaster.NAME_INFO.PART);
                    tName.setCode(String.valueOf(producerProduct.get("itemCode")));
                    tName.setName(String.valueOf(producerProduct.get("itemName")));
                    nameResult.add(tName);
                }
            }
        }
        result.put(NAME, nameResult);
        result.put(SKU, skuResult);
        return result;
    }
}
