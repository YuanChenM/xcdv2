package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifPkgStd;
import com.bms.slpd.bean.entity.target.SlpdDifPkgStdTarget;
import com.bms.slpd.bean.param.SLPD0647IParam;
import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import com.bms.slpd.bean.result.SLPD0647IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0647IDao;
import com.bms.slpd.services.SLPD0647IService;
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
 *<p>修改包装标准指标差异卡</p>
 */
@Service
public class SLPD0647IServiceImpl extends BaseServiceImpl implements SLPD0647IService {

    @Autowired
    private SLPD0647IDao slpd0647IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0647IDao;
    }

    /**
     *<p>修改包装标准指标差异卡</p>
     */
    @Override
    public SLPD0647IResult updateDifPkgStandards(SLPD0647IParam slpd0647IParam) {
        Date now = DateUtils.getCurrent();

        List<SLPD0646IPkgDifStdParam> params = slpd0647IParam.getPkgDifStdParams();
        List<SlpdDifPkgStd> slpdEntitys = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        SlpdDifPkgStd slpdDifPkgStdEntity = null;
        for (SLPD0646IPkgDifStdParam param : params) {
            slpdDifPkgStdEntity = BeanUtils.toBean(param, SlpdDifPkgStd.class);
            ids.add(slpdDifPkgStdEntity.getPkgDifStdId());
            slpdDifPkgStdEntity.setUpdId(super.getLoginUserId());
            slpdDifPkgStdEntity.setUpdTime(now);
            slpdEntitys.add(slpdDifPkgStdEntity);
        }

        int count = 0;
        int receive = 0;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(slpd0647IParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdDifPkgStd slpdDifPkgStd : slpdEntitys) {
                updateEntity.setEntity(slpdDifPkgStd);
                receive = slpd0647IDao.updateDifPkgStandards(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改安全标准差异:")
                            .append(slpdDifPkgStd.getPkgDifStdId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }
        SLPD0647IResult slpd0647IResult = new SLPD0647IResult();
        slpd0647IResult.setCount(count);
        slpd0647IResult.setPkgDifStdIds(ids);
        return slpd0647IResult;
    }

    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        SlpdDifPkgStdTarget target = new SlpdDifPkgStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("pkgDifInSuttle".equals(str)) {
                target.setPkgDifInSuttleFlg(true);
            } else if ("pkgDifInError".equals(str)) {
                target.setPkgDifInErrorFlg(true);
            } else if ("pkgDifInNumber".equals(str)) {
                target.setPkgDifInNumberFlg(true);
            } else if ("pkgDifInSize".equals(str)) {
                target.setPkgDifInSizeFlg(true);
            } else if ("pkgDifInTexture".equals(str)) {
                target.setPkgDifInTextureFlg(true);
            } else if ("pkgDifOutError".equals(str)) {
                target.setPkgDifOutErrorFlg(true);
            } else if ("pkgDifOutNumber".equals(str)) {
                target.setPkgDifOutNumberFlg(true);
            } else if ("pkgDifOutSize".equals(str)) {
                target.setPkgDifOutSizeFlg(true);
            } else if ("pkgDifOutTexture".equals(str)) {
                target.setPkgDifOutTextureFlg(true);
            } else if ("remark".equals(str)) {
                target.setRemarkFlg(true);
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
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return target;
    }
}