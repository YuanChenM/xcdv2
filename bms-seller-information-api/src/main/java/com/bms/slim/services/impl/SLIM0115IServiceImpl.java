package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimManufacturerSupplyQualification;
import com.bms.slim.bean.entity.target.SlimManufacturerSupplyQualificationTarget;
import com.bms.slim.bean.param.SLIM0115IParam;
import com.bms.slim.bean.param.field.SLIM0115ManufactureSupplyQualificationParam;
import com.bms.slim.bean.result.SLIM0115IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0115IDao;
import com.bms.slim.services.SLIM0115IService;
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
public class SLIM0115IServiceImpl extends BaseServiceImpl implements SLIM0115IService {

    @Autowired
    private SLIM0115IDao slim0115IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0115IDao;
    }

    /**
     * 修改卖家制造商供应资质
     */
    @Override
    public SLIM0115IResult updateManufacturerSupplyQualification(SLIM0115IParam slim0115IParam) {
        List<UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget>> updateList = getUpdateList(slim0115IParam);
        
        SLIM0115IResult result = new SLIM0115IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> msqIds = new ArrayList<>();
        for (UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0115IDao.updateManufacturerSupplyQualification(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                msqIds.add(updateEntity.getEntity().getMsqId());
            } else {
                throw new BusinessException("SLIM", "msqId:" + updateEntity.getEntity().getMsqId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setMsqIds(msqIds);

        return result;
    }

    /**
     * 获取修改卖家制造商供应资质集合
     */
    private List<UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget>> getUpdateList(SLIM0115IParam slim0115IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0115IParam);

        List<UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget>> updateList = new ArrayList<>();
        SlimManufacturerSupplyQualification manufacturerSupplyQualification;
        List<SLIM0115ManufactureSupplyQualificationParam> params = slim0115IParam.getManufactureSupplyQualificationParams();
        for (SLIM0115ManufactureSupplyQualificationParam param : params) {
            manufacturerSupplyQualification = BeanUtils.toBean(param, SlimManufacturerSupplyQualification.class);
            manufacturerSupplyQualification.setUpdId(userId);
            manufacturerSupplyQualification.setUpdTime(current);
            UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget> updateManufacturerSupplyQualification = new UpdateEntity<>();
            updateManufacturerSupplyQualification.setEntity(manufacturerSupplyQualification);
            updateManufacturerSupplyQualification.setTarget(baseTarget);
            updateList.add(updateManufacturerSupplyQualification);
        }
        return updateList;
    }

    /**
     * 设置卖家制造商供应资质target
     */
    private BaseTarget setTarget(SLIM0115IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimManufacturerSupplyQualificationTarget manufacturerSupplyQualificationTarget = new SlimManufacturerSupplyQualificationTarget();
        for (String str : targets) {
            if (FieldConstant.SlimManufacturerSupplyQualification.ENTITY_SELLER_ID.equals(str)) {
                manufacturerSupplyQualificationTarget.setEntitySellerIdFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.ENTRUSTED_PRODUCER_NAME.equals(str)) {
                manufacturerSupplyQualificationTarget.setEntrustedProducerNameFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.OEM_PRODUCER_NAME.equals(str)) {
                manufacturerSupplyQualificationTarget.setOemProducerNameFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.OEM_VALID_PERIOD.equals(str)) {
                manufacturerSupplyQualificationTarget.setOemValidPeriodFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.OEM_PROTOCOL_URL.equals(str)) {
                manufacturerSupplyQualificationTarget.setOemProtocolUrlFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.FOOD_BIZ_LIC_NO.equals(str)) {
                manufacturerSupplyQualificationTarget.setFoodBizLicNoFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.FBL_VALID_PERIOD.equals(str)) {
                manufacturerSupplyQualificationTarget.setFblValidPeriodFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.FOOD_BIZ_LIC_URL.equals(str)) {
                manufacturerSupplyQualificationTarget.setFoodBizLicUrlFlg(true);
            } else if (FieldConstant.SlimManufacturerSupplyQualification.DEL_FLG.equals(str)) {
                manufacturerSupplyQualificationTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = manufacturerSupplyQualificationTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
