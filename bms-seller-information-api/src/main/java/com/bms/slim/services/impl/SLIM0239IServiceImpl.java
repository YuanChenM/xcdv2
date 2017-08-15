package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerTestEquipment;
import com.bms.slim.bean.entity.target.SlimProducerTestEquipmentTarget;
import com.bms.slim.bean.param.SLIM0239IParam;
import com.bms.slim.bean.param.field.SLIM0239ProducerTestEquipmentParam;
import com.bms.slim.bean.result.SLIM0239IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0239IDao;
import com.bms.slim.services.SLIM0239IService;
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
public class SLIM0239IServiceImpl extends BaseServiceImpl implements SLIM0239IService {

    @Autowired
    private SLIM0239IDao slim0239IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0239IDao;
    }

    /**
     * 修改生产商检测设备
     */
    @Override
    public SLIM0239IResult updateProducerTestEquipments(SLIM0239IParam slim0239IParam) {
        List<UpdateEntity<SlimProducerTestEquipment, BaseTarget>> updateList = getUpdateList(slim0239IParam);

        SLIM0239IResult result = new SLIM0239IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> testEqpIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerTestEquipment, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0239IDao.updateProducerTestEquipments(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                testEqpIds.add(updateEntity.getEntity().getTestEqpId());
            } else {
                throw new BusinessException("SLIM", "testEqpId:" + updateEntity.getEntity().getTestEqpId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setTestEqpIds(testEqpIds);

        return result;
    }

    /**
     * 获取生产商检测设备集合
     */
    private List<UpdateEntity<SlimProducerTestEquipment, BaseTarget>> getUpdateList(SLIM0239IParam slim0239IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0239IParam);

        List<UpdateEntity<SlimProducerTestEquipment, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerTestEquipment producerTestEquipment;
        List<SLIM0239ProducerTestEquipmentParam> params = slim0239IParam.getProducerTestEquipments();
        for (SLIM0239ProducerTestEquipmentParam param : params) {
            producerTestEquipment = BeanUtils.toBean(param, SlimProducerTestEquipment.class);
            producerTestEquipment.setUpdId(userId);
            producerTestEquipment.setUpdTime(current);
            UpdateEntity<SlimProducerTestEquipment, BaseTarget> updateProducerTestEquipment = new UpdateEntity<>();
            updateProducerTestEquipment.setEntity(producerTestEquipment);
            updateProducerTestEquipment.setTarget(baseTarget);
            updateList.add(updateProducerTestEquipment);
        }
        return updateList;
    }

    /**
     * 设置生产商检测设备target
     */
    private BaseTarget setTarget(SLIM0239IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerTestEquipmentTarget producerTestEquipmentTarget = new SlimProducerTestEquipmentTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerTestEquipment.SELLER_ROLE_ID.equals(str)) {
                producerTestEquipmentTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerTestEquipment.TEST_EQP_NAME.equals(str)) {
                producerTestEquipmentTarget.setTestEqpNameFlg(true);
            } else if (FieldConstant.SlimProducerTestEquipment.TEST_EQP_USE.equals(str)) {
                producerTestEquipmentTarget.setTestEqpUseFlg(true);
            } else if (FieldConstant.SlimProducerTestEquipment.TEST_EQP_PIC_URL.equals(str)) {
                producerTestEquipmentTarget.setTestEqpPicUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                producerTestEquipmentTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerTestEquipmentTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
