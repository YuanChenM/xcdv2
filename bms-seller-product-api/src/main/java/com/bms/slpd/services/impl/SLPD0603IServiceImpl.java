package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdOrgStd;
import com.bms.slpd.bean.entity.target.SlpdOrgStdTarget;
import com.bms.slpd.bean.param.SLPD0603IParam;
import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import com.bms.slpd.bean.result.SLPD0603IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0603IDao;
import com.bms.slpd.services.SLPD0603IService;
import com.framework.base.consts.NumberConst;
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

@Service
public class SLPD0603IServiceImpl extends BaseServiceImpl implements SLPD0603IService {

    @Autowired
    private SLPD0603IDao slpd0603IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0603IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0603IResult modifyOrgStds(SLPD0603IParam requestParam) {
        List<Long> orgStdIds = new ArrayList<>();
        List<SLPD0601IOrgStdParam> list = requestParam.getOrgStdParams();
        SlpdOrgStdTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdOrgStd, SlpdOrgStdTarget>> updateList = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0601IOrgStdParam param : list) {
            UpdateEntity<SlpdOrgStd, SlpdOrgStdTarget> updateEntity = new UpdateEntity<>();
            SlpdOrgStd orgStd = BeanUtils.toBean(param, SlpdOrgStd.class);
            orgStd.setUpdTime(now);
            orgStd.setUpdId(super.getLoginUserId());

            updateEntity.setEntity(orgStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        StringBuilder builder;
        for (UpdateEntity<SlpdOrgStd, SlpdOrgStdTarget> updateEntity : updateList) {
            int num = slpd0603IDao.modifyOrgStds(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < num) {
                count += num;
                orgStdIds.add(updateEntity.getEntity().getOrgStdId());
            }else {
                builder = new StringBuilder()
                        .append("修改原种种源标准指标:")
                        .append(updateEntity.getEntity().getOrgStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
            }
        }

        SLPD0603IResult result = new SLPD0603IResult();
        result.setCount(count);
        result.setOrgStdIds(orgStdIds);
        return result;

    }

    public SlpdOrgStdTarget setTarget(SLPD0603IParam requestParam) {
         String[] targets = requestParam.getTargets();
         if (targets == null) {
             throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
         }

         SlpdOrgStdTarget orgStdTarget = new SlpdOrgStdTarget();
         List<String> invalid = new ArrayList<>();
         for (String str : targets) {
             if ("orgGoodVal".equals(str)) {
                 orgStdTarget.setOrgGoodValFlg(true);
             } else if ("orgNormalVal".equals(str)) {
                 orgStdTarget.setOrgNormalValFlg(true);
             } else if ("orgOkVal".equals(str)) {
                 orgStdTarget.setOrgOkValFlg(true);
             } else if ("remark".equals(str)) {
                 orgStdTarget.setRemarkFlg(true);
             } else if ("delFlg".equals(str)) {
                 orgStdTarget.setDelFlgFlg(true);
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

         return orgStdTarget;
    }

 }