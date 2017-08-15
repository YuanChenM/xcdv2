package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.bms.slim.bean.entity.SlimDesignatSlaughterPermit;
import com.bms.slim.bean.entity.target.SlimAnimalEpidemicPreventionConditionCertificateTarget;
import com.bms.slim.bean.entity.target.SlimDesignatSlaughterPermitTarget;
import com.bms.slim.bean.param.SLIM0209IParam;
import com.bms.slim.bean.param.field.SLIM0209DesignatSlaughterPermitParam;
import com.bms.slim.bean.result.SLIM0209IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0209IDao;
import com.bms.slim.services.SLIM0209IService;
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
public class SLIM0209IServiceImpl extends BaseServiceImpl implements SLIM0209IService {

    @Autowired
    private SLIM0209IDao slim0209IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0209IDao;
    }

    /**
     * 修改生产商生产资质-定点屠宰许可证
     */
    @Override
    public SLIM0209IResult updateDesignatSlaughterPermit(SLIM0209IParam slim0209IParam) {
        List<UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget>> updateList = getUpdateList(slim0209IParam);

        SLIM0209IResult result = new SLIM0209IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> dspIds = new ArrayList<>();
        for (UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0209IDao.updateDesignatSlaughterPermit(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                dspIds.add(updateEntity.getEntity().getDspId());
            } else {
                throw new BusinessException("SLIM", "dspId:" + updateEntity.getEntity().getDspId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setDspIds(dspIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-定点屠宰许可证集合
     */
    private List<UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget>> getUpdateList(SLIM0209IParam slim0209IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0209IParam);

        List<UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget>> updateList = new ArrayList<>();
        SlimDesignatSlaughterPermit designatSlaughterPermit;
        List<SLIM0209DesignatSlaughterPermitParam> params = slim0209IParam.getDesignatSlaughterPermitParams();
        for (SLIM0209DesignatSlaughterPermitParam param : params) {
            designatSlaughterPermit = BeanUtils.toBean(param, SlimDesignatSlaughterPermit.class);
            designatSlaughterPermit.setUpdId(userId);
            designatSlaughterPermit.setUpdTime(current);
            UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget> updateDesignatSlaughterPermit = new UpdateEntity<>();
            updateDesignatSlaughterPermit.setEntity(designatSlaughterPermit);
            updateDesignatSlaughterPermit.setTarget(baseTarget);
            updateList.add(updateDesignatSlaughterPermit);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-定点屠宰许可证target
     */
    private BaseTarget setTarget(SLIM0209IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimDesignatSlaughterPermitTarget designatSlaughterPermitTarget = new SlimDesignatSlaughterPermitTarget();
        for (String str : targets) {
            if (FieldConstant.SlimDesignatSlaughterPermit.SELLER_ROLE_ID.equals(str)) {
                designatSlaughterPermitTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimDesignatSlaughterPermit.APPROVAL_NO.equals(str)) {
                designatSlaughterPermitTarget.setApprovalNoFlg(true);
            } else if (FieldConstant.SlimDesignatSlaughterPermit.DSGT_SLGT_PRMT_CODE.equals(str)) {
                designatSlaughterPermitTarget.setDsgtSlgtPrmtCodeFlg(true);
            } else if (FieldConstant.SlimDesignatSlaughterPermit.DSGT_SLGT_PRMT_URL.equals(str)) {
                designatSlaughterPermitTarget.setDsgtSlgtPrmtUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                designatSlaughterPermitTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = designatSlaughterPermitTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
