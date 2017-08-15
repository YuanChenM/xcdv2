package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifOrgStd;
import com.bms.slpd.bean.entity.target.SlpdDifOrgStdTarget;
import com.bms.slpd.bean.param.SLPD0627IParam;
import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import com.bms.slpd.bean.result.SLPD0627IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0627IDao;
import com.bms.slpd.services.SLPD0627IService;
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
public class SLPD0627IServiceImpl extends BaseServiceImpl implements SLPD0627IService {
    @Autowired
    private SLPD0627IDao slpd0627IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0627IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0627IResult updateOrgDifStds(SLPD0627IParam requestParam) {
        Date updTime = DateUtils.getCurrent();
        SlpdDifOrgStdTarget target = setTarget(requestParam);

        List<SLPD0625IOrgDifStdParam> orgDifStdList = requestParam.getOrgDifStdParams();
        List<UpdateEntity<SlpdDifOrgStd, SlpdDifOrgStdTarget>> updateList = new ArrayList<>();
        UpdateEntity<SlpdDifOrgStd, SlpdDifOrgStdTarget> updateEntity = null;
        for (SLPD0625IOrgDifStdParam param : orgDifStdList) {
            updateEntity = new UpdateEntity<>();
            SlpdDifOrgStd orgDifStd = BeanUtils.toBean(param, SlpdDifOrgStd.class);
            orgDifStd.setUpdTime(updTime);
            orgDifStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(orgDifStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> orgDifStdIds = new ArrayList<>();
        for (UpdateEntity<SlpdDifOrgStd, SlpdDifOrgStdTarget> update : updateList) {
            int orgDifStdCount = slpd0627IDao.updateOrgDifStd(update);
            if (NumberConst.IntDef.INT_ZERO < orgDifStdCount) {
                count += orgDifStdCount;
                orgDifStdIds.add(update.getEntity().getOrgDifStdId());
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"orgDifStdId:" + update.getEntity().getOrgDifStdId());
            }
        }

        SLPD0627IResult result = new SLPD0627IResult();
        result.setCount(count);
        result.setOrgDifStdIds(orgDifStdIds);
        return result;
    }

    /**
     * 设置target
     */
    public SlpdDifOrgStdTarget setTarget(SLPD0627IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        StringBuilder builder = new StringBuilder();
        SlpdDifOrgStdTarget orgDifStdTarget = new SlpdDifOrgStdTarget();

        for (String str : targets) {
            if ("orgGoodDifVal".equals(str)) {
                orgDifStdTarget.setOrgGoodDifValFlg(true);
            } else if ("orgNormalDifVal".equals(str)) {
                orgDifStdTarget.setOrgNormalDifValFlg(true);
            } else if ("orgOkDifVal".equals(str)) {
                orgDifStdTarget.setOrgOkDifValFlg(true);
            } else if ("remark".equals(str)) {
                orgDifStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                orgDifStdTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        return orgDifStdTarget;
    }
}