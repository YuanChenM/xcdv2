package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimHalalFoodProductionOperationLicense;
import com.bms.slim.bean.entity.target.SlimHalalFoodProductionOperationLicenseTarget;
import com.bms.slim.bean.param.SLIM0212IParam;
import com.bms.slim.bean.param.field.SLIM0212HalalFoodProductionOperationLicenseParam;
import com.bms.slim.bean.result.SLIM0212IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0212IDao;
import com.bms.slim.services.SLIM0212IService;
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
public class SLIM0212IServiceImpl extends BaseServiceImpl implements SLIM0212IService {

    @Autowired
    private SLIM0212IDao slim0212IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0212IDao;
    }

    /**
     * 修改生产商生产资质-清真食品生产经营许可证
     */
    @Override
    public SLIM0212IResult updateHalalFoodProductionOperationLicenses(SLIM0212IParam slim0212IParam) {
        List<UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget>> updateList = getUpdateList(slim0212IParam);
        
        SLIM0212IResult result = new SLIM0212IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> hfpolIds = new ArrayList<>();
        for (UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0212IDao.updateHalalFoodProductionOperationLicense(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                hfpolIds.add(updateEntity.getEntity().getHfpolId());
            } else {
                throw new BusinessException("SLIM", "hfpolId:" + updateEntity.getEntity().getHfpolId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setHfpolIds(hfpolIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-清真食品生产经营许可证集合
     */
    private List<UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget>> getUpdateList(SLIM0212IParam slim0212IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0212IParam);

        List<UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget>> updateList = new ArrayList<>();
        SlimHalalFoodProductionOperationLicense halalFoodProductionOperationLicense;
        List<SLIM0212HalalFoodProductionOperationLicenseParam> params = slim0212IParam.getHalalFoodProductionOperationLicenseParams();
        for (SLIM0212HalalFoodProductionOperationLicenseParam param : params) {
            halalFoodProductionOperationLicense = BeanUtils.toBean(param, SlimHalalFoodProductionOperationLicense.class);
            halalFoodProductionOperationLicense.setUpdId(userId);
            halalFoodProductionOperationLicense.setUpdTime(current);
            UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget> updateHalalFoodProductionOperationLicense = new UpdateEntity<>();
            updateHalalFoodProductionOperationLicense.setEntity(halalFoodProductionOperationLicense);
            updateHalalFoodProductionOperationLicense.setTarget(baseTarget);
            updateList.add(updateHalalFoodProductionOperationLicense);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-清真食品生产经营许可证target
     */
    private BaseTarget setTarget(SLIM0212IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimHalalFoodProductionOperationLicenseTarget halalFoodProductionOperationLicenseTarget = new SlimHalalFoodProductionOperationLicenseTarget();
        for (String str : targets) {
            if (FieldConstant.SlimHalalFoodProductionOperationLicense.SELLER_ROLE_ID.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.CERT_NO.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setCertNoFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.COMM_INSP_CERT_NO.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setCommInspCertNoFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.ISSUE_DATE_BEGIN.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setIssueDateBeginFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.ISSUE_DATE_END.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setIssueDateEndFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.ISSUE_AUTHORITY.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setIssueAuthorityFlg(true);
            } else if (FieldConstant.SlimHalalFoodProductionOperationLicense.HALAL_FOOD_PROD_OPT_LIC_URL.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setHalalFoodProdOptLicUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                halalFoodProductionOperationLicenseTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = halalFoodProductionOperationLicenseTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
