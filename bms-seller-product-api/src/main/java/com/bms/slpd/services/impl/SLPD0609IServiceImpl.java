package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdMctStd;
import com.bms.slpd.bean.entity.target.SlpdMctStdTarget;
import com.bms.slpd.bean.param.SLPD0609IParam;
import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import com.bms.slpd.bean.result.SLPD0609IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0609IDao;
import com.bms.slpd.services.SLPD0609IService;
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
public class SLPD0609IServiceImpl extends BaseServiceImpl implements SLPD0609IService {

    @Autowired
    private SLPD0609IDao slpd0609IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0609IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0609IResult updateMctStds(SLPD0609IParam requestParam) {
        Date updTime = DateUtils.getCurrent();
        SlpdMctStdTarget target = setTarget(requestParam);

        List<SLPD0607IMctStdParam> mctStdList = requestParam.getMctStdParams();
        List<UpdateEntity<SlpdMctStd, SlpdMctStdTarget>> updateList = new ArrayList<>();
        SlpdMctStd mctStd = null;
        for (SLPD0607IMctStdParam param : mctStdList) {
            UpdateEntity<SlpdMctStd, SlpdMctStdTarget> updateEntity = new UpdateEntity<>();
            mctStd = BeanUtils.toBean(param, SlpdMctStd.class);
            mctStd.setUpdTime(updTime);
            mctStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(mctStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> mctStdIds = new ArrayList<>();
        StringBuilder builder;
        for (UpdateEntity<SlpdMctStd, SlpdMctStdTarget> updateEntity : updateList) {
            int mctStdCount = slpd0609IDao.updateMctStd(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < mctStdCount) {
                count += mctStdCount;
                mctStdIds.add(updateEntity.getEntity().getMctStdId());
            } else {
                builder = new StringBuilder()
                        .append("修改加工技术标准指标:")
                        .append(updateEntity.getEntity().getMctStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }

        SLPD0609IResult result = new SLPD0609IResult();
        result.setCount(count);
        result.setMctStdIds(mctStdIds);
        return result;
    }

    /**
     * 设置target
     */
    public SlpdMctStdTarget setTarget(SLPD0609IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        StringBuilder builder = new StringBuilder();
        SlpdMctStdTarget mctStdTarget = new SlpdMctStdTarget();

        for (String str : targets) {
            if ("mctOkVal".equals(str)) {
                mctStdTarget.setMctOkValFlg(true);
            } else if ("mctNgVal".equals(str)) {
                mctStdTarget.setMctNgValFlg(true);
            } else if ("remark".equals(str)) {
                mctStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                mctStdTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            builder.append("错误");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return mctStdTarget;
    }
}