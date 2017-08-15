package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerWorkshop;
import com.bms.slim.bean.entity.target.SlimProducerWorkshopTarget;
import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.param.field.SLIM0230ProducerWorkShopParam;
import com.bms.slim.bean.result.SLIM0230IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0230IDao;
import com.bms.slim.services.SLIM0230IService;
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
public class SLIM0230IServiceImpl extends BaseServiceImpl implements SLIM0230IService {

    @Autowired
    private SLIM0230IDao slim0230IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0230IDao;
    }

    /**
     * 修改生产商车间
     */
    @Override
    public SLIM0230IResult updateProducerWorkShops(SLIM0230IParam slim0230IParam) {
        List<UpdateEntity<SlimProducerWorkshop, BaseTarget>> updateList = getUpdateList(slim0230IParam);

        SLIM0230IResult result = new SLIM0230IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> workshopIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerWorkshop, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0230IDao.updateProducerWorkShops(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                workshopIds.add(updateEntity.getEntity().getWorkshopId());
            } else {
                throw new BusinessException("SLIM", "workshopId:" + updateEntity.getEntity().getWorkshopId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setWorkshopIds(workshopIds);

        return result;
    }

    /**
     * 获取修改生产商车间集合
     */
    private List<UpdateEntity<SlimProducerWorkshop, BaseTarget>> getUpdateList(SLIM0230IParam slim0230IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0230IParam);

        List<UpdateEntity<SlimProducerWorkshop, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerWorkshop producerWorkshop;
        List<SLIM0230ProducerWorkShopParam> params = slim0230IParam.getProducerWorkShops();
        for (SLIM0230ProducerWorkShopParam param : params) {
            producerWorkshop = BeanUtils.toBean(param, SlimProducerWorkshop.class);
            producerWorkshop.setUpdId(userId);
            producerWorkshop.setUpdTime(current);
            UpdateEntity<SlimProducerWorkshop, BaseTarget> updateProducerWorkshop = new UpdateEntity<>();
            updateProducerWorkshop.setEntity(producerWorkshop);
            updateProducerWorkshop.setTarget(baseTarget);
            updateList.add(updateProducerWorkshop);
        }
        return updateList;
    }

    /**
     * 设置生产商车间target
     */
    private BaseTarget setTarget(SLIM0230IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerWorkshopTarget producerWorkshopTarget = new SlimProducerWorkshopTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerWorkshop.SELLER_ROLE_ID.equals(str)) {
                producerWorkshopTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerWorkshop.WORKSHOP_NAME.equals(str)) {
                producerWorkshopTarget.setWorkshopNameFlg(true);
            } else if (FieldConstant.SlimProducerWorkshop.PRODUCTION_PRODUCT.equals(str)) {
                producerWorkshopTarget.setProductionProductFlg(true);
            } else if (FieldConstant.SlimProducerWorkshop.PROCCESS_FLOW_CHARACTER.equals(str)) {
                producerWorkshopTarget.setProccessFlowCharacterFlg(true);
            } else if (FieldConstant.SlimProducerWorkshop.WORKSHOP_PIC_URL.equals(str)) {
                producerWorkshopTarget.setWorkshopPicUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                producerWorkshopTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerWorkshopTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
