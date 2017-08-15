package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.enumeration.AgentType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.BsDemesneEntity;
import com.bms.order.external.bean.entity.BsEntity;
import com.bms.order.external.bean.param.AGIF0209IRestParam;
import com.bms.order.external.bean.param.AGIF0205IRestParam;
import com.bms.order.external.bean.param.AGIF0212IRestParam;
import com.bms.order.external.bean.param.AGIF0401IRestParam;
import com.bms.order.external.bean.result.AGIF0209IRestResult;
import com.bms.order.external.bean.result.AGIF0205IRestResult;
import com.bms.order.external.bean.result.AGIF0212IRestResult;
import com.bms.order.external.bean.result.AGIF0401IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 买手
 * Created by ni_shaotang on 2017/3/15.
 */
public class Bs extends AbstractExternalArchive {
    private BsEntity entity;

    public BsEntity getEntity() {
        return entity;
    }

    //禁止外部构建
    private Bs() {

    }

    /**
     * 根据买家id获取买手和管家信息
     *
     * @return
     */
    public static Bs getBsSaBuyerId(String buyerId) {
        Assert.hasText(buyerId);
        BsEntity bsEntity = new BsEntity();
        // 获取URL
        String url = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0401I;
        AGIF0401IRestParam param = new AGIF0401IRestParam();
        param.setBuyerId(buyerId);
        Bs bs = new Bs();
        // 返回值类型
        TypeReference<BaseRestPaginationResult<AGIF0401IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<AGIF0401IRestResult>>() {
        };
        BaseRestPaginationResult<AGIF0401IRestResult> result = bs.getRestClient().post(url, param, typeReference);
        // 判断检索结果
        if (result.getTotal() > 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过一个买家ID查找到多个买手和管家");

        if (result.getTotal() == 0)
            return null;
        AGIF0401IRestResult agif0401IRestResult = result.getData().get(0);
        bsEntity.setBsId(agif0401IRestResult.getAgentId());
        bsEntity.setBsCode(agif0401IRestResult.getAgentCode());
        bsEntity.setBsName(agif0401IRestResult.getAgentName());
        bsEntity.setSaCode(agif0401IRestResult.getButlerCode());
        bsEntity.setSaId(agif0401IRestResult.getButlerId());
        bsEntity.setSaName(agif0401IRestResult.getButlerName());
        bsEntity.setSaTelNo(agif0401IRestResult.getButlerTelNo());
        bsEntity.setSaAccount(agif0401IRestResult.getButlerAccount());
        bsEntity.setLgcsAreaName(agif0401IRestResult.getLgcsAreaName());
        bsEntity.setZoneName(agif0401IRestResult.getZoneName());
        bsEntity.setDistributionName(agif0401IRestResult.getDistributionName());
        bsEntity.setDemesneName(agif0401IRestResult.getDemesneName());

        bs.entity = bsEntity;
        bs.setDataSynced(true);

        return bs;
    }

    /**
     * 根据买手ID获取下单时所需的买手基本信息（包括物流区信息）
     *
     * @return
     */
    public static Bs getBsInfoById(String bsId) {

        Bs bs = Bs.getBsById(bsId);
//        BsDemesneEntity demesneEntity = Bs.getBsDemesneById(bsId);
//
//        if (demesneEntity != null) {
//                bs.getEntity().setLgcsAreaId(demesneEntity.getLgcsAreaId());
//                bs.getEntity().setLgcsAreaCode(demesneEntity.getLgcsAreaCode());
//                bs.getEntity().setLgcsAreaName(demesneEntity.getLgcsAreaName());
//        } else {
//            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060108);
//        }
        return bs;
    }

    /**
     * 通过ID获取买手/合伙人信息
     *
     * @return
     */
    public static Bs getBsById(String bsId) {
        Assert.notNull(bsId);
        BsEntity bsEntity = new BsEntity();
        // 获取URL
        String url = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0209I;
        AGIF0209IRestParam param = new AGIF0209IRestParam();
        param.setAgentId(bsId);
//        param.setAgentType(Integer.parseInt(AgentType.Bs.getCode()));
        Bs bs = new Bs();
        // 返回值类型
        TypeReference<BaseRestPaginationResult<AGIF0209IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<AGIF0209IRestResult>>() {
        };
        BaseRestPaginationResult<AGIF0209IRestResult> result = bs.getRestClient().post(url, param, typeReference);
        // 判断检索结果
        if (result.getTotal() > 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过一个买手ID查找到多个买手");

        if (result.getTotal() == 0)
            return null;
        AGIF0209IRestResult agif0209IRestResult = result.getData().get(0);

        return convertBsEntity(agif0209IRestResult);
    }

    public static Bs convertBsEntity(AGIF0209IRestResult agif0209IRestResult) {
        Bs bs = new Bs();
        BsEntity bsEntity = new BsEntity();

        bsEntity.setAccountid(agif0209IRestResult.getAccountid());
        bsEntity.setMailAddr(agif0209IRestResult.getMailAddr());
        bsEntity.setAccountName(agif0209IRestResult.getAccountName());
        bsEntity.setTelNo(agif0209IRestResult.getTelNo());
        bsEntity.setBsId(agif0209IRestResult.getAgentId());
        bsEntity.setPartnerId(agif0209IRestResult.getPartnerId());
        bsEntity.setBsCode(agif0209IRestResult.getAgentcode());
        bsEntity.setBsName(agif0209IRestResult.getAgentname());
        bsEntity.setCategorycode(agif0209IRestResult.getCategorycode());
        bsEntity.setCategoryname(agif0209IRestResult.getCategoryname());
        bsEntity.setLevelName(agif0209IRestResult.getLevelName());
        bsEntity.setIsCreditTermBs(agif0209IRestResult.getIsCreditTermAgent());
        bsEntity.setBsSex(agif0209IRestResult.getAgentSex());
        bsEntity.setBsPic(agif0209IRestResult.getAgentPic());
        bsEntity.setBsCardId(agif0209IRestResult.getAgentCardId());
        bsEntity.setProvinceId(agif0209IRestResult.getProvinceId());
        bsEntity.setProvinceCode(agif0209IRestResult.getProvinceCode());
        bsEntity.setProvinceName(agif0209IRestResult.getProvinceName());
        bsEntity.setCityId(agif0209IRestResult.getCityId());
        bsEntity.setCityCode(agif0209IRestResult.getCityCode());
        bsEntity.setCityName(agif0209IRestResult.getCityName());
        bsEntity.setDistrictId(agif0209IRestResult.getDistrictId());
        bsEntity.setDistrictCode(agif0209IRestResult.getDistrictCode());
        bsEntity.setDistrictName(agif0209IRestResult.getDistrictName());
        bsEntity.setStreetId(agif0209IRestResult.getStreetId());
        bsEntity.setStreetCode(agif0209IRestResult.getStreetCode());
        bsEntity.setStreetName(agif0209IRestResult.getStreetName());
        bsEntity.setBsAddr(agif0209IRestResult.getAgentAddr());
        bsEntity.setBsWechat(agif0209IRestResult.getAgentWechat());
        bsEntity.setBsQq(agif0209IRestResult.getAgentQq());
        bsEntity.setBsBankName(agif0209IRestResult.getAgentBankName());
        bsEntity.setBsBankAccountName(agif0209IRestResult.getAgentBankAccountName());
        bsEntity.setBsBankAccount(agif0209IRestResult.getAgentBankAccount());
        bsEntity.setBsPicWeb(agif0209IRestResult.getAgentPicWeb());
        bsEntity.setAgentType(agif0209IRestResult.getAgentType());


        // 设置区域信息
        bsEntity.setLgcsAreaId(agif0209IRestResult.getLgcsAreaId());
        bsEntity.setLgcsAreaCode(agif0209IRestResult.getLgcsAreaCode());
        bsEntity.setLgcsAreaName(agif0209IRestResult.getLgcsAreaName());

        bs.entity = bsEntity;
        bs.setDataSynced(true);

        return bs;
    }

    /**
     * 根据买手ID获取买手物流区信息（第一条的物流区）
     *
     * @return
     */
    public static BsDemesneEntity getBsDemesneById(String bsId) {
        Assert.notNull(bsId);
        BsDemesneEntity bsDemesneEntity = new BsDemesneEntity();
        // 获取URL
        String url = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0205I;
        AGIF0205IRestParam param = new AGIF0205IRestParam();
        param.setAgentId(bsId);
        Bs bs = new Bs();
        // 返回值类型
        TypeReference<BaseRestPaginationResult<AGIF0205IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<AGIF0205IRestResult>>() {
        };
        BaseRestPaginationResult<AGIF0205IRestResult> result = bs.getRestClient().post(url, param, typeReference);
        // 判断检索结果

        if (result.getTotal() == 0)
            return null;
        AGIF0205IRestResult agif0205IRestResult = result.getData().get(0);
        bsDemesneEntity.setBsDemesneId(agif0205IRestResult.getAgentDemesneId());
        bsDemesneEntity.setBsId(agif0205IRestResult.getAgentId());
        bsDemesneEntity.setLgcsAreaId(agif0205IRestResult.getLgcsAreaId());
        bsDemesneEntity.setLgcsAreaCode(agif0205IRestResult.getLgcsAreaCode());
        bsDemesneEntity.setLgcsAreaName(agif0205IRestResult.getLgcsAreaName());
        bsDemesneEntity.setZoneId(agif0205IRestResult.getZoneId());
        bsDemesneEntity.setZoneCode(agif0205IRestResult.getZoneCode());
        bsDemesneEntity.setZoneName(agif0205IRestResult.getZoneName());
        bsDemesneEntity.setDistributionId(agif0205IRestResult.getDistributionId());
        bsDemesneEntity.setDistributionType(agif0205IRestResult.getDistributionType());
        bsDemesneEntity.setDistributionName(agif0205IRestResult.getDistributionName());
        bsDemesneEntity.setDistributionCode(agif0205IRestResult.getDistributionCode());
        bsDemesneEntity.setDemesneId(agif0205IRestResult.getDemesneId());
        bsDemesneEntity.setDemesneType(agif0205IRestResult.getDemesneType());
        bsDemesneEntity.setDemesneName(agif0205IRestResult.getDemesneName());
        bsDemesneEntity.setDemesneCode(agif0205IRestResult.getDemesneCode());
        bsDemesneEntity.setAuthorizedBs(agif0205IRestResult.getAuthorizedAgent());
        bsDemesneEntity.setAuthorizedPartner(agif0205IRestResult.getAuthorizedPartner());
        bsDemesneEntity.setDemesneArea(agif0205IRestResult.getDemesneArea());
        bsDemesneEntity.setManagementDistrict(agif0205IRestResult.getManagementDistrict());
        bsDemesneEntity.setDemesneEast(agif0205IRestResult.getDemesneEast());
        bsDemesneEntity.setDemesneSouth(agif0205IRestResult.getDemesneSouth());
        bsDemesneEntity.setDemesneWest(agif0205IRestResult.getDemesneWest());
        bsDemesneEntity.setDemesneNorth(agif0205IRestResult.getDemesneNorth());
        bsDemesneEntity.setTerminalMarketNum(agif0205IRestResult.getTerminalMarketNum());
        bsDemesneEntity.setFoodMarketNum(agif0205IRestResult.getFoodMarketNum());
        bsDemesneEntity.setCookingGatheringNum(agif0205IRestResult.getCookingGatheringNum());
        bsDemesneEntity.setMealsGatheringNum(agif0205IRestResult.getMealsGatheringNum());
        bsDemesneEntity.setProcessNum(agif0205IRestResult.getProcessNum());
        bsDemesneEntity.setPlanPic(agif0205IRestResult.getPlanPic());
        bsDemesneEntity.setRemarks(agif0205IRestResult.getRemarks());
        return bsDemesneEntity;
    }
}
