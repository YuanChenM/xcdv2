package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimShBjTjRegistration;
import com.bms.slim.bean.entity.target.SlimShBjTjRegistrationTarget;
import com.bms.slim.bean.param.SLIM0215IParam;
import com.bms.slim.bean.param.field.SLIM0215ShBjTjRegistrationParam;
import com.bms.slim.bean.result.SLIM0215IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0215IDao;
import com.bms.slim.services.SLIM0215IService;
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
public class SLIM0215IServiceImpl extends BaseServiceImpl implements SLIM0215IService {

    @Autowired
    private SLIM0215IDao slim0215IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0215IDao;
    }

    /**
     * 修改生产商生产资质-进沪(京、津)登记信息
     */
    @Override
    public SLIM0215IResult updateShBjTjRegistrations(SLIM0215IParam slim0215IParam) {
        List<UpdateEntity<SlimShBjTjRegistration, BaseTarget>> updateList = getUpdateList(slim0215IParam);
        
        SLIM0215IResult result = new SLIM0215IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sbtRegIds = new ArrayList<>();
        for (UpdateEntity<SlimShBjTjRegistration, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0215IDao.updateShBjTjRegistration(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                sbtRegIds.add(updateEntity.getEntity().getSbtRegId());
            } else {
                throw new BusinessException("SLIM", "sbtRegId:" + updateEntity.getEntity().getSbtRegId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setSbtRegIds(sbtRegIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-进沪(京、津)登记信息集合
     */
    private List<UpdateEntity<SlimShBjTjRegistration, BaseTarget>> getUpdateList(SLIM0215IParam slim0215IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0215IParam);

        List<UpdateEntity<SlimShBjTjRegistration, BaseTarget>> updateList = new ArrayList<>();
        SlimShBjTjRegistration shBjTjRegistration;
        List<SLIM0215ShBjTjRegistrationParam> params = slim0215IParam.getShBjTjRegistrationParams();
        for (SLIM0215ShBjTjRegistrationParam param : params) {
            shBjTjRegistration = BeanUtils.toBean(param, SlimShBjTjRegistration.class);
            shBjTjRegistration.setUpdId(userId);
            shBjTjRegistration.setUpdTime(current);
            UpdateEntity<SlimShBjTjRegistration, BaseTarget> updateShBjTjRegistration = new UpdateEntity<>();
            updateShBjTjRegistration.setEntity(shBjTjRegistration);
            updateShBjTjRegistration.setTarget(baseTarget);
            updateList.add(updateShBjTjRegistration);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-进沪(京、津)登记信息target
     */
    private BaseTarget setTarget(SLIM0215IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimShBjTjRegistrationTarget shBjTjRegistrationTarget = new SlimShBjTjRegistrationTarget();
        for (String str : targets) {
            if (FieldConstant.SlimShBjTjRegistration.SELLER_ROLE_ID.equals(str)) {
                shBjTjRegistrationTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimShBjTjRegistration.WORKUNIT_NAME.equals(str)) {
                shBjTjRegistrationTarget.setWorkunitNameFlg(true);
            } else if (FieldConstant.SlimShBjTjRegistration.PRODUCT_CATEGORY_NAME.equals(str)) {
                shBjTjRegistrationTarget.setProductCategoryNameFlg(true);
            } else if (FieldConstant.SlimShBjTjRegistration.REG_DATE.equals(str)) {
                shBjTjRegistrationTarget.setRegDateFlg(true);
            } else if (FieldConstant.SlimShBjTjRegistration.SBT_REG_URL.equals(str)) {
                shBjTjRegistrationTarget.setSbtRegUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                shBjTjRegistrationTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = shBjTjRegistrationTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
