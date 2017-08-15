package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerStorageCapacity;
import com.bms.slim.bean.entity.target.SlimProducerStorageCapacityTarget;
import com.bms.slim.bean.param.SLIM0233IParam;
import com.bms.slim.bean.param.field.SLIM0233ProducerStorageCapacityParam;
import com.bms.slim.bean.result.SLIM0233IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0233IDao;
import com.bms.slim.services.SLIM0233IService;
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
public class SLIM0233IServiceImpl extends BaseServiceImpl implements SLIM0233IService {

    @Autowired
    private SLIM0233IDao slim0233IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0233IDao;
    }

    /**
     * 修改生产商库容
     */
    @Override
    public SLIM0233IResult updateProducerStorageCapacities(SLIM0233IParam slim0233IParam) {
        List<UpdateEntity<SlimProducerStorageCapacity, BaseTarget>> updateList = getUpdateList(slim0233IParam);

        SLIM0233IResult result = new SLIM0233IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> storageCapacityIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerStorageCapacity, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0233IDao.updateProducerStorageCapacities(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                storageCapacityIds.add(updateEntity.getEntity().getStorageCapacityId());
            } else {
                throw new BusinessException("SLIM", "storageCapacityId:" + updateEntity.getEntity().getStorageCapacityId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setStorageCapacityIds(storageCapacityIds);

        return result;
    }

    /**
     * 获取修改生产商库容集合
     */
    private List<UpdateEntity<SlimProducerStorageCapacity, BaseTarget>> getUpdateList(SLIM0233IParam slim0233IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0233IParam);

        List<UpdateEntity<SlimProducerStorageCapacity, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerStorageCapacity producerStorageCapacity;
        List<SLIM0233ProducerStorageCapacityParam> params = slim0233IParam.getProducerStorageCapacitys();
        for (SLIM0233ProducerStorageCapacityParam param : params) {
            producerStorageCapacity = BeanUtils.toBean(param, SlimProducerStorageCapacity.class);
            producerStorageCapacity.setUpdId(userId);
            producerStorageCapacity.setUpdTime(current);
            UpdateEntity<SlimProducerStorageCapacity, BaseTarget> updateProducerStorageCapacity = new UpdateEntity<>();
            updateProducerStorageCapacity.setEntity(producerStorageCapacity);
            updateProducerStorageCapacity.setTarget(baseTarget);
            updateList.add(updateProducerStorageCapacity);
        }
        return updateList;
    }

    /**
     * 设置生产商库容target
     */
    private BaseTarget setTarget(SLIM0233IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerStorageCapacityTarget producerStorageCapacityTarget = new SlimProducerStorageCapacityTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerStorageCapacity.SELLER_ROLE_ID.equals(str)) {
                producerStorageCapacityTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerStorageCapacity.MATERIAL_CAPACITY.equals(str)) {
                producerStorageCapacityTarget.setMaterialCapacityFlg(true);
            } else if (FieldConstant.SlimProducerStorageCapacity.PRODUCT_CAPACITY.equals(str)) {
                producerStorageCapacityTarget.setProductCapacityFlg(true);
            } else if (FieldConstant.SlimProducerStorageCapacity.WAREHOUSE_PIC_URL.equals(str)) {
                producerStorageCapacityTarget.setWarehousePicUrlFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerStorageCapacityTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
