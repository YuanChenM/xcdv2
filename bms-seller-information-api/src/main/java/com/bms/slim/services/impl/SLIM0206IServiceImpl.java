package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.bms.slim.bean.entity.target.SlimAnimalEpidemicPreventionConditionCertificateTarget;
import com.bms.slim.bean.param.SLIM0206IParam;
import com.bms.slim.bean.param.field.SLIM0206AnimalEpidemicPreventionConditionCertificateParam;
import com.bms.slim.bean.result.SLIM0206IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0206IDao;
import com.bms.slim.services.SLIM0206IService;
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
public class SLIM0206IServiceImpl extends BaseServiceImpl implements SLIM0206IService {

    @Autowired
    private SLIM0206IDao slim0206IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0206IDao;
    }

    /**
     * 修改生产商生产资质-动物防疫条件合格证
     */
    @Override
    public SLIM0206IResult updateAnimalEpidemicPreventionConditionCertificate(SLIM0206IParam slim0206IParam) {
        List<UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget>> updateList = getUpdateList(slim0206IParam);

        SLIM0206IResult result = new SLIM0206IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> aepccIds = new ArrayList<>();
        for (UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0206IDao.updateAnimalEpidemicPreventionConditionCertificate(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                aepccIds.add(updateEntity.getEntity().getAepccId());
            } else {
                throw new BusinessException("SLIM", "aepccId:" + updateEntity.getEntity().getAepccId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setAepccIds(aepccIds);

        return result;
    }

    /**
     * 获取修改生产商生产资质-动物防疫条件合格证集合
     */
    private List<UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget>> getUpdateList(SLIM0206IParam slim0206IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0206IParam);

        List<UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget>> updateList = new ArrayList<>();
        SlimAnimalEpidemicPreventionConditionCertificate animalEpidemicPreventionConditionCertificate;
        List<SLIM0206AnimalEpidemicPreventionConditionCertificateParam> params = slim0206IParam.getAnimalEpidemicPreventionConditionCertificateParams();
        for (SLIM0206AnimalEpidemicPreventionConditionCertificateParam param : params) {
            animalEpidemicPreventionConditionCertificate = BeanUtils.toBean(param, SlimAnimalEpidemicPreventionConditionCertificate.class);
            animalEpidemicPreventionConditionCertificate.setUpdId(userId);
            animalEpidemicPreventionConditionCertificate.setUpdTime(current);
            UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget> updateAnimalEpidemicPreventionConditionCertificate = new UpdateEntity<>();
            updateAnimalEpidemicPreventionConditionCertificate.setEntity(animalEpidemicPreventionConditionCertificate);
            updateAnimalEpidemicPreventionConditionCertificate.setTarget(baseTarget);
            updateList.add(updateAnimalEpidemicPreventionConditionCertificate);
        }
        return updateList;
    }

    /**
     * 设置生产商生产资质-动物防疫条件合格证target
     */
    private BaseTarget setTarget(SLIM0206IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimAnimalEpidemicPreventionConditionCertificateTarget animalEpidemicPreventionConditionCertificateTarget = new SlimAnimalEpidemicPreventionConditionCertificateTarget();
        for (String str : targets) {
            if (FieldConstant.SlimAnimalEpidemicPreventionConditionCertificate.SELLER_ROLE_ID.equals(str)) {
                animalEpidemicPreventionConditionCertificateTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimAnimalEpidemicPreventionConditionCertificate.CERT_NO.equals(str)) {
                animalEpidemicPreventionConditionCertificateTarget.setCertNoFlg(true);
            } else if (FieldConstant.SlimAnimalEpidemicPreventionConditionCertificate.VALID_PERIOD.equals(str)) {
                animalEpidemicPreventionConditionCertificateTarget.setValidPeriodFlg(true);
            } else if (FieldConstant.SlimAnimalEpidemicPreventionConditionCertificate.ANI_EPI_PREV_CONT_CERT_URL.equals(str)) {
                animalEpidemicPreventionConditionCertificateTarget.setAniEpiPrevContCertUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                animalEpidemicPreventionConditionCertificateTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = animalEpidemicPreventionConditionCertificateTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
