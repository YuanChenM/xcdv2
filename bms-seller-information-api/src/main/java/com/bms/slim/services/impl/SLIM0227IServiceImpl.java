package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerFactory;
import com.bms.slim.bean.entity.target.SlimProducerFactoryTarget;
import com.bms.slim.bean.param.SLIM0227IParam;
import com.bms.slim.bean.param.field.SLIM0227ProducerFactoryParam;
import com.bms.slim.bean.result.SLIM0227IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0227IDao;
import com.bms.slim.services.SLIM0227IService;
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
public class SLIM0227IServiceImpl extends BaseServiceImpl implements SLIM0227IService {

    @Autowired
    private SLIM0227IDao slim0227IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0227IDao;
    }

    /**
     * 修改生产商工厂
     */
    @Override
    public SLIM0227IResult updateProducerFactory(SLIM0227IParam slim0227IParam) {
        List<UpdateEntity<SlimProducerFactory, BaseTarget>> updateList = getUpdateList(slim0227IParam);
        
        SLIM0227IResult result = new SLIM0227IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> factoryIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerFactory, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0227IDao.updateProducerFactory(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                factoryIds.add(updateEntity.getEntity().getFactoryId());
            } else {
                throw new BusinessException("SLIM", "factoryId:" + updateEntity.getEntity().getFactoryId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setFactoryIds(factoryIds);

        return result;
    }

    /**
     * 获取修改生产商工厂集合
     */
    private List<UpdateEntity<SlimProducerFactory, BaseTarget>> getUpdateList(SLIM0227IParam slim0227IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0227IParam);

        List<UpdateEntity<SlimProducerFactory, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerFactory producerFactory;
        List<SLIM0227ProducerFactoryParam> params = slim0227IParam.getProducerFactoryParams();
        for (SLIM0227ProducerFactoryParam param : params) {
            producerFactory = BeanUtils.toBean(param, SlimProducerFactory.class);
            producerFactory.setUpdId(userId);
            producerFactory.setUpdTime(current);
            UpdateEntity<SlimProducerFactory, BaseTarget> updateproducerFactory = new UpdateEntity<>();
            updateproducerFactory.setEntity(producerFactory);
            updateproducerFactory.setTarget(baseTarget);
            updateList.add(updateproducerFactory);
        }
        return updateList;
    }

    /**
     * 设置生产商工厂target
     */
    private BaseTarget setTarget(SLIM0227IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerFactoryTarget producerFactoryTarget = new SlimProducerFactoryTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerFactory.SELLER_ROLE_ID.equals(str)) {
                producerFactoryTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerFactory.TOTAL_ASSET.equals(str)) {
                producerFactoryTarget.setTotalAssetFlg(true);
            } else if (FieldConstant.SlimProducerFactory.REGISTERED_CAPITAL.equals(str)) {
                producerFactoryTarget.setRegisteredCapitalFlg(true);
            } else if (FieldConstant.SlimProducerFactory.COVERED_AREA.equals(str)) {
                producerFactoryTarget.setCoveredAreaFlg(true);
            } else if (FieldConstant.SlimProducerFactory.WORKSHOP_AREA.equals(str)) {
                producerFactoryTarget.setWorkshopAreaFlg(true);
            } else if (FieldConstant.SlimProducerFactory.MAJOR_EQUIPMENT.equals(str)) {
                producerFactoryTarget.setMajorEquipmentFlg(true);
            } else if (FieldConstant.SlimProducerFactory.DESIGN_CAPACITY.equals(str)) {
                producerFactoryTarget.setDesignCapacityFlg(true);
            } else if (FieldConstant.SlimProducerFactory.EXPORT_SALE_PERCENT.equals(str)) {
                producerFactoryTarget.setExportSalePercentFlg(true);
            } else if (FieldConstant.SlimProducerFactory.SELF_SALE_PERCENT.equals(str)) {
                producerFactoryTarget.setSelfSalePercentFlg(true);
            } else if (FieldConstant.SlimProducerFactory.AGENT_SALE_PERCENT.equals(str)) {
                producerFactoryTarget.setAgentSalePercentFlg(true);
            } else if (FieldConstant.SlimProducerFactory.FACTORY_PIC_URL.equals(str)) {
                producerFactoryTarget.setFactoryPicUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                producerFactoryTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerFactoryTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
