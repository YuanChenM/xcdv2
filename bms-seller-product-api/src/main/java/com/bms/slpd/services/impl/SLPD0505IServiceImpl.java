package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdItemProperty;
import com.bms.slpd.bean.entity.target.SlpdItemPropertyTarget;
import com.bms.slpd.bean.param.SLPD0505IParam;
import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import com.bms.slpd.bean.param.field.SLPD0505IItemPropertyParam;
import com.bms.slpd.bean.result.SLPD0505IResult;
import com.bms.slpd.bean.result.field.SLPD0501IItemPropertyResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0504IDao;
import com.bms.slpd.dao.SLPD0505IDao;
import com.bms.slpd.services.SLPD0505IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *修改单品规格
 */
@Service
public class SLPD0505IServiceImpl extends BaseServiceImpl implements SLPD0505IService {

    @Autowired
    private SLPD0504IDao slpd0504IDao;

    @Autowired
    private SLPD0505IDao slpd0505IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0505IDao;
    }

    /**
     * 修改单品规格
     */
    @Override
    public SLPD0505IResult updateItemProperties(SLPD0505IParam slpd0505IParam) {
        SLPD0505IResult result = new SLPD0505IResult();

        List<SLPD0505IItemPropertyParam> itemProperties = slpd0505IParam.getItemProperties();
        List<Long> itemPropertyIds = new ArrayList<>();
        List<SLPD0504IItemPropertyParam> propertyParams = new ArrayList<>();
        for (SLPD0505IItemPropertyParam itemPropertyParam : itemProperties) {
            itemPropertyIds.add(itemPropertyParam.getItemPropertyId());
            if(itemPropertyParam.getDelFlg() == null) {
                SLPD0504IItemPropertyParam param = BeanUtils.toBean(itemPropertyParam, SLPD0504IItemPropertyParam.class);
                propertyParams.add(param);
            }
        }

        //查询单品规格是否已经生成产品
        int existProduct = this.slpd0505IDao.findExistProducts(itemPropertyIds);
        if (existProduct > NumberConst.IntDef.INT_ZERO) {
            result.setMessage(new String[]{"F", ("单品规格已生成产品,请重新选择.").toString()});
            return result;
        }

        if(CollectionUtils.isNotEmpty(propertyParams)){
            //排他
            List<SLPD0501IItemPropertyResult> resultExist = this.slpd0504IDao.findExistItemProperties(propertyParams);
            if (CollectionUtils.isNotEmpty(resultExist)) {
                result.setMessage(new String[]{"F", ("单品规格已存在,请重新填写.").toString()});
                return result;
            }
        }

        List<SLPD0505IItemPropertyParam> params = slpd0505IParam.getItemProperties();
        Date now = DateUtils.getCurrent();
        String updId = super.getLoginUserId();
        SlpdItemPropertyTarget target = setTarget(slpd0505IParam);
        List<UpdateEntity<SlpdItemProperty, SlpdItemPropertyTarget>> updateList = new ArrayList<>();
        UpdateEntity<SlpdItemProperty, SlpdItemPropertyTarget> updateEntity = null;
        SlpdItemProperty slpdItemProperty = null;
        for (SLPD0505IItemPropertyParam brandItemProperty : params) {
            slpdItemProperty = BeanUtils.toBean(brandItemProperty, SlpdItemProperty.class);
            slpdItemProperty.setUpdId(updId);
            slpdItemProperty.setUpdTime(now);

            updateEntity = new UpdateEntity<>();
            updateEntity.setEntity(slpdItemProperty);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> returnIds = new ArrayList<>();
        for (UpdateEntity<SlpdItemProperty, SlpdItemPropertyTarget> updateParam : updateList) {
            int num = slpd0505IDao.updateItemProperties(updateParam);
            if (NumberConst.IntDef.INT_ZERO < num) {
                count += num;
                returnIds.add(updateParam.getEntity().getItemPropertyId());
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "修改单品规格失败,请刷新页面重试");
            }
        }

        result.setCount(count);
        result.setItemPropertyIds(returnIds);
        return result;
    }

    /**
     * 设置target
     *
     * @param slpd0505IParam
     * @return
     */

    private SlpdItemPropertyTarget setTarget(SLPD0505IParam slpd0505IParam) {
        String[] targets = slpd0505IParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "targets不能为空");
        }
        SlpdItemPropertyTarget target = new SlpdItemPropertyTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("sourceType".equals(str)) {
                target.setSourceTypeFlg(true);
            } else if ("grossWeight".equals(str)) {
                target.setGrossWeightFlg(true);
            } else if ("packageSpecification".equals(str)) {
                target.setPackageSpecificationFlg(true);
            } else if ("packageQuantity".equals(str)) {
                target.setPackageQuantityFlg(true);
            } else if ("cartonDimension".equals(str)) {
                target.setCartonDimensionFlg(true);
            } else if ("cartonLength".equals(str)) {
                target.setCartonLengthFlg(true);
            } else if ("cartonWidth".equals(str)) {
                target.setCartonWidthFlg(true);
            } else if ("cartonHeight".equals(str)) {
                target.setCartonHeightFlg(true);
            } else if ("palletStackingLimit".equals(str)) {
                target.setPalletStackingLimitFlg(true);
            } else if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            } else {
                invalid.add(str);
            }
        }
        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("指定的target字段有误").toString());
        }
        return target;
    }
}