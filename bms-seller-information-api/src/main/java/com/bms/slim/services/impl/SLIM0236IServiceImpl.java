package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerLaboratory;
import com.bms.slim.bean.entity.target.SlimProducerLaboratoryTarget;
import com.bms.slim.bean.param.SLIM0236IParam;
import com.bms.slim.bean.param.field.SLIM0236ProducerLaboratoryParam;
import com.bms.slim.bean.result.SLIM0236IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0236IDao;
import com.bms.slim.services.SLIM0236IService;
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
public class SLIM0236IServiceImpl extends BaseServiceImpl implements SLIM0236IService {

    @Autowired
    private SLIM0236IDao slim0236IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0236IDao;
    }

    /**
     * 修改生产商实验室
     */
    @Override
    public SLIM0236IResult updateProducerLaboratories(SLIM0236IParam slim0236IParam) {
        List<UpdateEntity<SlimProducerLaboratory, BaseTarget>> updateList = getUpdateList(slim0236IParam);

        SLIM0236IResult result = new SLIM0236IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> laboratoryIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerLaboratory, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0236IDao.updateProducerLaboratories(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                laboratoryIds.add(updateEntity.getEntity().getLaboratoryId());
            } else {
                throw new BusinessException("SLIM", "laboratoryId:" + updateEntity.getEntity().getLaboratoryId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setLaboratoryIds(laboratoryIds);

        return result;
    }

    /**
     * 获取修改生产商实验室集合
     */
    private List<UpdateEntity<SlimProducerLaboratory, BaseTarget>> getUpdateList(SLIM0236IParam slim0236IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0236IParam);

        List<UpdateEntity<SlimProducerLaboratory, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerLaboratory producerLaboratory;
        List<SLIM0236ProducerLaboratoryParam> params = slim0236IParam.getProducerLaboratories();
        for (SLIM0236ProducerLaboratoryParam param : params) {
            producerLaboratory = BeanUtils.toBean(param, SlimProducerLaboratory.class);
            producerLaboratory.setUpdId(userId);
            producerLaboratory.setUpdTime(current);
            UpdateEntity<SlimProducerLaboratory, BaseTarget> updateProducerLaboratory = new UpdateEntity<>();
            updateProducerLaboratory.setEntity(producerLaboratory);
            updateProducerLaboratory.setTarget(baseTarget);
            updateList.add(updateProducerLaboratory);
        }
        return updateList;
    }

    /**
     * 设置生产商实验室target
     */
    private BaseTarget setTarget(SLIM0236IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerLaboratoryTarget producerLaboratoryTarget = new SlimProducerLaboratoryTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerLaboratory.SELLER_ROLE_ID.equals(str)) {
                producerLaboratoryTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.ACREAGE.equals(str)) {
                producerLaboratoryTarget.setAcreageFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.FUNCTION.equals(str)) {
                producerLaboratoryTarget.setEffectFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.INVERSTNENT.equals(str)) {
                producerLaboratoryTarget.setInverstnentFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.MEMBER.equals(str)) {
                producerLaboratoryTarget.setMemberFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.LAB_PIC_URL.equals(str)) {
                producerLaboratoryTarget.setLabPicUrlFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.ORG_FRAME_IMG_URL.equals(str)) {
                producerLaboratoryTarget.setOrgFrameImgUrlFlg(true);
            } else if (FieldConstant.SlimProducerLaboratory.QUALITY_CTRL_IMG_URL.equals(str)) {
                producerLaboratoryTarget.setQualityCtrlImgUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                producerLaboratoryTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerLaboratoryTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
