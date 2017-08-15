package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimIsoManagementSystemCertification;
import com.bms.slim.bean.entity.target.SlimIsoManagementSystemCertificationTarget;
import com.bms.slim.bean.param.SLIM0221IParam;
import com.bms.slim.bean.param.field.SLIM0221IsoManagementSystemCertificationParam;
import com.bms.slim.bean.result.SLIM0221IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0221IDao;
import com.bms.slim.services.SLIM0221IService;
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
public class SLIM0221IServiceImpl extends BaseServiceImpl implements SLIM0221IService {

    @Autowired
    private SLIM0221IDao slim0221IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0221IDao;
    }

    /**
     * 修改生产商生产资质-管理体系认证证书
     */
    @Override
    public SLIM0221IResult updateIsoManagementSystemCertification(SLIM0221IParam slim0221IParam) {
        List<UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget>> updateList = getUpdateList(slim0221IParam);
        
        SLIM0221IResult result = new SLIM0221IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> isoMscIds = new ArrayList<>();
        for (UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0221IDao.updateIsoManagementSystemCertification(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                isoMscIds.add(updateEntity.getEntity().getIsoMscId());
            } else {
                throw new BusinessException("SLIM", "isoMscId:" + updateEntity.getEntity().getIsoMscId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setIsoMscIds(isoMscIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-管理体系认证证书集合
     */
    private List<UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget>> getUpdateList(SLIM0221IParam slim0221IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0221IParam);

        List<UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget>> updateList = new ArrayList<>();
        SlimIsoManagementSystemCertification isoManagementSystemCertification;
        List<SLIM0221IsoManagementSystemCertificationParam> params = slim0221IParam.getIsoManagementSystemCertificationParams();
        for (SLIM0221IsoManagementSystemCertificationParam param : params) {
            isoManagementSystemCertification = BeanUtils.toBean(param, SlimIsoManagementSystemCertification.class);
            isoManagementSystemCertification.setUpdId(userId);
            isoManagementSystemCertification.setUpdTime(current);
            UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget> updateIsoManagementSystemCertification = new UpdateEntity<>();
            updateIsoManagementSystemCertification.setEntity(isoManagementSystemCertification);
            updateIsoManagementSystemCertification.setTarget(baseTarget);
            updateList.add(updateIsoManagementSystemCertification);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-管理体系认证证书target
     */
    private BaseTarget setTarget(SLIM0221IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimIsoManagementSystemCertificationTarget isoManagementSystemCertificationTarget = new SlimIsoManagementSystemCertificationTarget();
        for (String str : targets) {
            if (FieldConstant.SlimIsoManagementSystemCertification.SELLER_ROLE_ID.equals(str)) {
                isoManagementSystemCertificationTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERT_TYPE.equals(str)) {
                isoManagementSystemCertificationTarget.setCertTypeFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.ISO_TYPE.equals(str)) {
                isoManagementSystemCertificationTarget.setIsoTypeFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERT_NO.equals(str)) {
                isoManagementSystemCertificationTarget.setCertNoFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERTIFICATION_STANDARD.equals(str)) {
                isoManagementSystemCertificationTarget.setCertificationStandardFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERTIFICATION_SCOPE.equals(str)) {
                isoManagementSystemCertificationTarget.setCertificationScopeFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.ISSUE_DATE_VALID_PERIOD.equals(str)) {
                isoManagementSystemCertificationTarget.setIssueDateValidPeriodFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERTIFICATION_AUTHORITY.equals(str)) {
                isoManagementSystemCertificationTarget.setCertificationAuthorityFlg(true);
            } else if (FieldConstant.SlimIsoManagementSystemCertification.CERT_URL.equals(str)) {
                isoManagementSystemCertificationTarget.setCertUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                isoManagementSystemCertificationTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = isoManagementSystemCertificationTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
