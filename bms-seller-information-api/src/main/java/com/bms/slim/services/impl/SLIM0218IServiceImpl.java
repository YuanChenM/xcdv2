package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimFoodProductionLicense;
import com.bms.slim.bean.entity.target.SlimFoodProductionLicenseTarget;
import com.bms.slim.bean.param.SLIM0218IParam;
import com.bms.slim.bean.param.field.SLIM0218FoodProductionLicenseParam;
import com.bms.slim.bean.result.SLIM0218IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0218IDao;
import com.bms.slim.services.SLIM0218IService;
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
public class SLIM0218IServiceImpl extends BaseServiceImpl implements SLIM0218IService {

    @Autowired
    private SLIM0218IDao slim0218IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0218IDao;
    }

    /**
     * 修改生产商生产资质-食品生产许可证
     */
    @Override
    public SLIM0218IResult updateFoodProductionLicense(SLIM0218IParam slim0218IParam) {
        List<UpdateEntity<SlimFoodProductionLicense, BaseTarget>> updateList = getUpdateList(slim0218IParam);
        
        SLIM0218IResult result = new SLIM0218IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> fplIds = new ArrayList<>();
        for (UpdateEntity<SlimFoodProductionLicense, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0218IDao.updateFoodProductionLicense(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                fplIds.add(updateEntity.getEntity().getFplId());
            } else {
                throw new BusinessException("SLIM", "fplId:" + updateEntity.getEntity().getFplId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setFplIds(fplIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-食品生产许可证集合
     */
    private List<UpdateEntity<SlimFoodProductionLicense, BaseTarget>> getUpdateList(SLIM0218IParam slim0218IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0218IParam);

        List<UpdateEntity<SlimFoodProductionLicense, BaseTarget>> updateList = new ArrayList<>();
        SlimFoodProductionLicense foodProductionLicense;
        List<SLIM0218FoodProductionLicenseParam> params = slim0218IParam.getFoodProductionLicenseParams();
        for (SLIM0218FoodProductionLicenseParam param : params) {
            foodProductionLicense = BeanUtils.toBean(param, SlimFoodProductionLicense.class);
            foodProductionLicense.setUpdId(userId);
            foodProductionLicense.setUpdTime(current);
            UpdateEntity<SlimFoodProductionLicense, BaseTarget> updateFoodProductionLicense = new UpdateEntity<>();
            updateFoodProductionLicense.setEntity(foodProductionLicense);
            updateFoodProductionLicense.setTarget(baseTarget);
            updateList.add(updateFoodProductionLicense);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-食品生产许可证target
     */
    private BaseTarget setTarget(SLIM0218IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimFoodProductionLicenseTarget foodProductionLicenseTarget = new SlimFoodProductionLicenseTarget();
        for (String str : targets) {
            if (FieldConstant.SlimFoodProductionLicense.SELLER_ROLE_ID.equals(str)) {
                foodProductionLicenseTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimFoodProductionLicense.CERT_NO.equals(str)) {
                foodProductionLicenseTarget.setCertNoFlg(true);
            } else if (FieldConstant.SlimFoodProductionLicense.CATEGORY_RANGE.equals(str)) {
                foodProductionLicenseTarget.setCategoryRangeFlg(true);
            } else if (FieldConstant.SlimFoodProductionLicense.VALID_PERIOD.equals(str)) {
                foodProductionLicenseTarget.setValidPeriodFlg(true);
            } else if (FieldConstant.SlimFoodProductionLicense.FOOD_PROD_LIC_URL.equals(str)) {
                foodProductionLicenseTarget.setFoodProdLicUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                foodProductionLicenseTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = foodProductionLicenseTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
