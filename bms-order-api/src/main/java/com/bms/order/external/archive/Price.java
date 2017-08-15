package com.bms.order.external.archive;

import com.bms.order.constant.UrlConst;
import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.enumeration.PriceReturnType;
import com.bms.order.external.bean.entity.PlateDetailEntity;
import com.bms.order.external.bean.entity.PriceEntity;
import com.bms.order.external.bean.param.PRCE0211IRestParam;
import com.bms.order.external.bean.param.PriceRestParam;
import com.bms.order.external.bean.result.PRCE0211IPlateDetail;
import com.bms.order.external.bean.result.PRCE0211IRstResult;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/1.
 */
public class Price extends AbstractExternalArchive {

    private PriceEntity entity;

    public PriceEntity getEntity() {
        return entity;
    }

    private Price() {
    }

    /**
     * 查询价格
     *
     * @param paramList
     * @return
     */
    public static List<PriceEntity> queryPricePlate(ArrayList<PriceRestParam> paramList) {
        Assert.notNull(paramList);
        List<PriceEntity> list = new ArrayList<>();
        ArrayList<PRCE0211IRestParam> restParamList = convert(paramList);
        String url = UrlConst.API_PRCE_URL + UrlConst.ACTION_PRCE0211I;
        TypeReference<ArrayList<PRCE0211IRstResult>> typeReference = new TypeReference<ArrayList<PRCE0211IRstResult>>() {
        };
        Price price = new Price();
        // 调用接口（使用关联对象的rest client）
        List<PRCE0211IRstResult> paginationResult = price.getRestClient().post(url, restParamList, typeReference);

        if (null == paginationResult) {
            return null;
        }
        for (PRCE0211IRstResult result : paginationResult) {
            PriceEntity entity = new PriceEntity();
            entity.setPricePlateId(result.getPricePlateId());
            entity.setGoodId(result.getGoodId());
            entity.setStartTime(result.getStartTime());
            entity.setEndTime(result.getEndTime());
            entity.setLgcsAreaCode(result.getLgcsAreaCode());
            entity.setWayTypeId(result.getWayTypeId());
            entity.setWayTypeName(result.getWayTypeName());
            entity.setPrice(result.getPrice());
            entity.setUnitPrice(result.getUnitPrice());
            entity.setWayConfigId(result.getWayConfigId());
            entity.setWayDesc(result.getWayDesc());
            entity.setWayLevel(result.getWayLevel());
            list.add(entity);
        }
        return list;
    }

    /**
     * 查询价格通道
     *
     * @param paramList
     * @return
     */
    public static List<PriceEntity> queryPricePlateDetail(ArrayList<PriceRestParam> paramList) {
        Assert.notNull(paramList);
        List<PriceEntity> list = new ArrayList<>();
        String url = UrlConst.API_PRCE_URL + UrlConst.ACTION_PRCE0211I;
        ArrayList<PRCE0211IRestParam> restParamList = convert(paramList);
        TypeReference<ArrayList<PRCE0211IRstResult>> typeReference = new TypeReference<ArrayList<PRCE0211IRstResult>>() {
        };
        Price price = new Price();
        // 调用接口（使用关联对象的rest client）
        List<PRCE0211IRstResult> paginationResult = price.getRestClient().post(url, restParamList, typeReference);
        if (null == paginationResult) {
            return null;
        }
        for (PRCE0211IRstResult result : paginationResult) {
            if (null == result.getPlateDetailList()) {
                continue;
            }
            PriceEntity entity = new PriceEntity();
            entity.setPricePlateId(result.getPricePlateId());
            entity.setGoodId(result.getGoodId());
            entity.setStartTime(result.getStartTime());
            entity.setEndTime(result.getEndTime());
            entity.setLgcsAreaCode(result.getLgcsAreaCode());
            entity.setWayConfigId(result.getWayConfigId());
            entity.setWayDesc(result.getWayLevel().toString());
            PlateDetailEntity detailEntity = new PlateDetailEntity();
            for (PRCE0211IPlateDetail detail : result.getPlateDetailList()) {
                detailEntity = new PlateDetailEntity();
                detailEntity.setGoodId(result.getGoodId());
                detailEntity.setWayTypeId(detail.getWayTypeId());
                detailEntity.setWayTypeName(detail.getWayTypeName());
                detailEntity.setPrice(detail.getPrice());
                detailEntity.setUnitPrice(detail.getUnitPrice());
                detailEntity.setStartQty(detail.getStartQty());
                detailEntity.setEndQty(detail.getEndQty());
                detailEntity.setWayConfigId(detail.getWayConfigId());
                detailEntity.setWayDesc(detail.getWayLevel().toString());
                entity.getPlateDetailList().add(detailEntity);
            }
            list.add(entity);
        }
        return list;
    }

    /**
     * 组装查询价盘参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<PRCE0211IRestParam> convert(ArrayList<PriceRestParam> paramList) {
        ArrayList<PRCE0211IRestParam> list = new ArrayList<>();
        PRCE0211IRestParam param = new PRCE0211IRestParam();
        for (PriceRestParam restParam : paramList) {
            param = new PRCE0211IRestParam();
            param.setGoodId(restParam.getGoodId());
            param.setLgcsAreaCode(restParam.getLgcsAreaCode());
            param.setUserType(restParam.getUserType());
            param.setBuyerLevel(restParam.getBuyerLevel());
            if (null == restParam.getCompareTimeTwo()) {
                param.setCompareTime(new String[]{DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, restParam.getCompareTimeOne())});
            } else {
                param.setCompareTime(new String[]{DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, restParam.getCompareTimeOne()), DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, restParam.getCompareTimeTwo())});
            }
            param.setReturnType(restParam.getReturnType());
            param.setQty(restParam.getQty());
            list.add(param);
        }
        return list;
    }
}
