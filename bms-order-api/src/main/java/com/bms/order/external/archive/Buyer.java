package com.bms.order.external.archive;

import java.util.List;

import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.constant.enumeration.BsType;
import com.bms.order.external.bean.param.BYIM0125IRestParam;
import com.bms.order.external.bean.result.BYIM0125IRestResult;
import org.springframework.util.Assert;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.BuyerEntity;
import com.bms.order.external.bean.param.BYIM0107IRestParam;
import com.bms.order.external.bean.result.BYIM0107IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.exception.BusinessException;

/**
 * 买家
 * 
 * @author li_huiqian
 *
 */
public class Buyer extends AbstractExternalArchive {

    /**
     * 买家Entity
     */
    private BuyerEntity entity;

    /**
     * 获取买家Entity
     * 
     * @return
     */
    public BuyerEntity getEntity() {
        return this.entity;
    }

    /**
     * 收货人
     */
    private List<Receiver> receivers;

    /**
     * 获取收货人
     * 
     * @return
     */
    public List<Receiver> getReceivers() {
        if (receivers != null)
            return receivers;
        return Receiver.findByBuyer(this);
    }

    private Buyer() {
    }

    /**
     * 通过买家ID查询买家信息
     * 
     * @param buyerId
     * @return
     */
    public static Buyer findById(String buyerId) {
        Assert.hasText(buyerId);

        // 获取URL
        String url = UrlConst.API_BYIM_URL + UrlConst.ACTION_BYIM0107I;

        // 构造入参
        BYIM0107IRestParam param = new BYIM0107IRestParam();
        param.setBuyerId(buyerId);

        // 返回值类型
        TypeReference<BaseRestPaginationResult<BYIM0107IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<BYIM0107IRestResult>>() {
        };

        // 构造对象
        Buyer buyer = new Buyer();
        // 调用接口
        BaseRestPaginationResult<BYIM0107IRestResult> paginationResult = buyer.getRestClient().post(url, param,
                typeReference);

        // 判断检索结果
        if (paginationResult.getTotal() > 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过一个买家ID查找到多个买家");

        if (paginationResult.getTotal() == 0)
            return null;

        // 获取买家信息
        BYIM0107IRestResult result = paginationResult.getData().get(0);
        BuyerEntity entity = new BuyerEntity();
        entity.setBuyerId(result.getBuyerId());
        entity.setFrequenterLevelCode(result.getFrequenterLevelCode());
        entity.setBuyerName(result.getBuyerName());
        entity.setBuyerCode(result.getBuyerCode());
        entity.setBuyerType(result.getBuyerType());
        entity.setBuyerTypeName(result.getBuyerTypeName());
        entity.setNetBuyerFlg(result.getIsCreditTermBuyer());
        entity.setLogisticsZoneId(result.getLgcsAreaId());
        entity.setLogisticsZoneCode(result.getLgcsAreaCode());
        entity.setLogisticsZoneName(result.getLgcsAreaName());
        entity.setProvinceId(result.getProvinceId());
        entity.setProvinceCode(result.getProvinceCode());
        entity.setProvinceName(result.getProvinceName());
        entity.setCityId(result.getCityId());
        entity.setCityCode(result.getCityCode());
        entity.setCityName(result.getCityName());
        entity.setCountryId(result.getDistrictId());
        entity.setCountryCode(result.getDistrictCode());
        entity.setCountryName(result.getDistrictName());
        entity.setStreetId(result.getStreetId());
        entity.setStreetCode(result.getStreetCode());
        entity.setStreetName(result.getStreetName());
        entity.setBuyerPhone(result.getTelNo());
        entity.setBuyerWechat(result.getBuyerWechat());
        entity.setBuyerQq(result.getBuyerQq());
        entity.setBuyerMail(result.getMailAddr());
        entity.setReceivePeriod(result.getNormalReceiveTime());
        entity.setReceiveEarliest(result.getEarliestTime());
        entity.setReceiveLatest(result.getLatestTime());
        entity.setRegionalDistributionStation(result.getDistributionId());
        entity.setRegionalDistributionStationCode(result.getDistributionCode());
        entity.setRegionalDistributionStationName(result.getDistributionName());

        // 获取管家及买手信息
        Bs bs = Bs.getBsSaBuyerId(result.getBuyerId());

        // TODO qiuwenting 买手类型还未有明确区分，全部设置在区域买手中
        if (bs != null) {
            entity.setBsType(BsType.REGIONAL_BS.getCode());
            entity.setBsId(bs.getEntity().getBsId());
            entity.setRegionalBsId(bs.getEntity().getBsId());
            entity.setRegionalBsCode(bs.getEntity().getBsCode());
            entity.setRegionalBsName(bs.getEntity().getBsName());
            entity.setNonRegionalBsId(null);
            entity.setNonRegionalBsCode(null);
            entity.setNonRegionalBsName(null);
            entity.setRegionalDistributionBsId(null);
            entity.setRegionalDistributionBsCode(null);
            entity.setRegionalDistributionBsName(null);
            entity.setNetUserBsId(null);
            entity.setNetUserBsCode(null);
            entity.setNetUserBsName(null);
            entity.setSaId(bs.getEntity().getSaId());
            entity.setSaCode(bs.getEntity().getSaCode());
            entity.setSaName(bs.getEntity().getSaName());
        }

        buyer.entity = entity;
        buyer.setDataSynced(true);

        return buyer;
    }

    /**
     * 获取环标码
     *
     * @param buyerId
     * @return
     */
    public static String getDeliveryAreaCode(String buyerId, BuyerBatchOrderAttachedEntity entity) {
        Assert.hasText(buyerId);

        // 获取URL
        String url = UrlConst.API_BYIM_URL + UrlConst.ACTION_BYIM0125I;

        // 构造入参
        BYIM0125IRestParam param = new BYIM0125IRestParam();
        param.setBuyerId(buyerId);
        param.setProvinceName(entity.getReceiverProvince());
        param.setCityName(entity.getReceiverCity());
        param.setDistrictName(entity.getReceiverDistrict());
        param.setDeliveryAddr(entity.getReceiverAddress());
        // 返回值类型
        TypeReference<BYIM0125IRestResult> typeReference = new TypeReference<BYIM0125IRestResult>() {
        };
        Buyer buyer = new Buyer();
        BYIM0125IRestResult result = buyer.getRestClient().post(url, param, typeReference);
        if (result != null){
            return result.getDeliveryAreaCode();
        }
        return "";
    }
}
