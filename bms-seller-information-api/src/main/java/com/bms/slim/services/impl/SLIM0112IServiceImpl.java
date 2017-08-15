package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimAgentSupplyQualification;
import com.bms.slim.bean.entity.target.SlimAgentSupplyQualificationTarget;
import com.bms.slim.bean.param.SLIM0112IParam;
import com.bms.slim.bean.param.field.SLIM0112AgentSupplyQualificationParam;
import com.bms.slim.bean.result.SLIM0112IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0112IDao;
import com.bms.slim.services.SLIM0112IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLIM0112IServiceImpl extends BaseServiceImpl implements SLIM0112IService {

    @Autowired
    private SLIM0112IDao slim0112IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0112IDao;
    }

    /**
     * 修改卖家代理商供应资质
     */
    @Override
    public SLIM0112IResult updateAgentSupplyQualification(SLIM0112IParam slim0112IParam) {
        List<UpdateEntity<SlimAgentSupplyQualification, BaseTarget>> updateList = getUpdateList(slim0112IParam);
        
        SLIM0112IResult result = new SLIM0112IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> asqIds = new ArrayList<>();
        for (UpdateEntity<SlimAgentSupplyQualification, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0112IDao.updateAgentSupplyQualification(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                asqIds.add(updateEntity.getEntity().getAsqId());
            } else {
                throw new BusinessException("SLIM", "asqId:" + updateEntity.getEntity().getAsqId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setAsqIds(asqIds);

        return result;
    }

    /**
     * 获取修改卖家代理商供应资质集合
     */
    private List<UpdateEntity<SlimAgentSupplyQualification, BaseTarget>> getUpdateList(SLIM0112IParam slim0112IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0112IParam);

        List<UpdateEntity<SlimAgentSupplyQualification, BaseTarget>> updateList = new ArrayList<>();
        SlimAgentSupplyQualification agentSupplyQualification;
        List<SLIM0112AgentSupplyQualificationParam> params = slim0112IParam.getAgentSupplyQualificationParams();
        for (SLIM0112AgentSupplyQualificationParam param : params) {
            agentSupplyQualification = BeanUtils.toBean(param, SlimAgentSupplyQualification.class);
            agentSupplyQualification.setUpdId(userId);
            agentSupplyQualification.setUpdTime(current);
            UpdateEntity<SlimAgentSupplyQualification, BaseTarget> updateAgentSupplyQualification = new UpdateEntity<>();
            updateAgentSupplyQualification.setEntity(agentSupplyQualification);
            updateAgentSupplyQualification.setTarget(baseTarget);
            updateList.add(updateAgentSupplyQualification);
        }
        return updateList;
    }

    /**
     * 设置卖家代理商供应资质target
     */
    private BaseTarget setTarget(SLIM0112IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimAgentSupplyQualificationTarget agentSupplyQualificationTarget = new SlimAgentSupplyQualificationTarget();
        for (String str : targets) {
            if (FieldConstant.SlimAgentSupplyQualification.ENTITY_SELLER_ID.equals(str)) {
                agentSupplyQualificationTarget.setEntitySellerIdFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AGENT_NAME.equals(str)) {
                agentSupplyQualificationTarget.setAgentNameFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AGENT_AREA.equals(str)) {
                agentSupplyQualificationTarget.setAgentAreaFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AGENT_PRODUCT_RANGE.equals(str)) {
                agentSupplyQualificationTarget.setAgentProductRangeFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.ASA_VALID_PERIOD.equals(str)) {
                agentSupplyQualificationTarget.setAsaValidPeriodFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.ASA_URL.equals(str)) {
                agentSupplyQualificationTarget.setAsaUrlFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTHORIZER_NAME.equals(str)) {
                agentSupplyQualificationTarget.setAuthorizerNameFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTHORIZEE_NAME.equals(str)) {
                agentSupplyQualificationTarget.setAuthorizeeNameFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTHORIZED_PRODUCT_RANGE.equals(str)) {
                agentSupplyQualificationTarget.setAuthorizedProductRangeFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTHORIZED_BUSINESS_AREA.equals(str)) {
                agentSupplyQualificationTarget.setAuthorizedBusinessAreaFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTHORIZED_VALID_PERIOD.equals(str)) {
                agentSupplyQualificationTarget.setAuthorizedValidPeriodFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.AUTH_CERT_URL.equals(str)) {
                agentSupplyQualificationTarget.setAuthCertUrlFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.FOOD_BIZ_LIC_NO.equals(str)) {
                agentSupplyQualificationTarget.setFoodBizLicNoFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.FBL_VALID_PERIOD.equals(str)) {
                agentSupplyQualificationTarget.setFblValidPeriodFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.FOOD_BIZ_LIC_URL.equals(str)) {
                agentSupplyQualificationTarget.setFoodBizLicUrlFlg(true);
            } else if (FieldConstant.SlimAgentSupplyQualification.DEL_FLG.equals(str)) {
                agentSupplyQualificationTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = agentSupplyQualificationTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
