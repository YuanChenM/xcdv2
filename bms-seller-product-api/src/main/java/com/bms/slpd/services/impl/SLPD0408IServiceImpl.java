package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdBrandOwnerRelation;
import com.bms.slpd.bean.entity.target.SlpdBrandOwnerRelationTarget;
import com.bms.slpd.bean.param.SLPD0408IParam;
import com.bms.slpd.bean.param.field.SLPD0408IBrandOwnerRelationParam;
import com.bms.slpd.bean.result.SLPD0408IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0408IDao;
import com.bms.slpd.services.SLPD0408IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 修改品牌绑定关系
 */
@Service
public class SLPD0408IServiceImpl extends BaseServiceImpl implements SLPD0408IService {

    @Autowired
    private SLPD0408IDao slpd0408IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0408IDao;
    }

    /**
     * 修改品牌绑定关系
     */
    @Override
    public SLPD0408IResult updateBrandOwnerRelations(SLPD0408IParam requestParam) {
        //导入Entity
        BaseTarget target = getTarget(requestParam.getTargets());
        List<SLPD0408IBrandOwnerRelationParam> params = requestParam.getBrandOwnerRelationParams();
        List<SlpdBrandOwnerRelation> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdBrandOwnerRelation relation = null;
        for (SLPD0408IBrandOwnerRelationParam param : params) {
            relation = BeanUtils.toBean(param, SlpdBrandOwnerRelation.class);
            ids.add(param.getBrandId());
            relation.setUpdId(super.getLoginUserId());
            relation.setUpdTime(now);
            slpdEntitys.add(relation);
        }


        //修改数据
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(target);
        int count = 0;
        int receive;
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdBrandOwnerRelation slpdBrandOwnerRelation : slpdEntitys) {
                updateEntity.setEntity(slpdBrandOwnerRelation);
                receive = slpd0408IDao.updateBrandOwnerRelations(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改品牌绑定关系:")
                            .append(slpdBrandOwnerRelation.getBoRelationId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
                }
            }
        }

        //返回
        SLPD0408IResult result = new SLPD0408IResult();
        result.setCount(count);
        result.setBrandIds(ids);
        return result;
    }

    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlpdBrandOwnerRelationTarget target = new SlpdBrandOwnerRelationTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            } else {
                invalid.add(str);
            }
        }
        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("target:");
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            builder.append("错误");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return target;
    }
}