package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifTncStd;
import com.bms.slpd.bean.entity.target.SlpdDifTncStdTarget;
import com.bms.slpd.bean.param.SLPD0636IParam;
import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import com.bms.slpd.bean.result.SLPD0636IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0636IDao;
import com.bms.slpd.services.SLPD0636IService;
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
public class SLPD0636IServiceImpl extends BaseServiceImpl implements SLPD0636IService {
    @Autowired
    private SLPD0636IDao slpd0636IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0636IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0636IResult updateTncDifStds(SLPD0636IParam requestParam) {
        Date updTime = DateUtils.getCurrent();
        SlpdDifTncStdTarget target = setTarget(requestParam);

        List<SLPD0634ITncDifStdParam> tncDifStdList = requestParam.getTncDifStdParams();
        List<UpdateEntity<SlpdDifTncStd, SlpdDifTncStdTarget>> updateList = new ArrayList<>();
        SlpdDifTncStd tncDifStd = null;
        for (SLPD0634ITncDifStdParam param : tncDifStdList) {
            UpdateEntity<SlpdDifTncStd, SlpdDifTncStdTarget> updateEntity = new UpdateEntity<>();
            tncDifStd = BeanUtils.toBean(param, SlpdDifTncStd.class);
            tncDifStd.setUpdTime(updTime);
            tncDifStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(tncDifStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        StringBuilder builder;
        List<Long> tncDifStdIds = new ArrayList<>();
        for (UpdateEntity<SlpdDifTncStd, SlpdDifTncStdTarget> updateEntity : updateList) {
            int tncDifStdCount = slpd0636IDao.updateTncDifStd(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < tncDifStdCount) {
                count += tncDifStdCount;
                tncDifStdIds.add(updateEntity.getEntity().getTncDifStdId());
            } else {
                builder = new StringBuilder()
                        .append("修改加工质量标准差异:")
                        .append(updateEntity.getEntity().getTncDifStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }

        SLPD0636IResult result = new SLPD0636IResult();
        result.setCount(count);
        result.setTncDifStdIds(tncDifStdIds);
        return result;
    }

    /**
     * 设置target
     *
     * @param requestParam
     * @return
     */
    public SlpdDifTncStdTarget setTarget(SLPD0636IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        StringBuilder builder = new StringBuilder();
        SlpdDifTncStdTarget tncDifStdTarget = new SlpdDifTncStdTarget();

        for (String str : targets) {
            if ("tncStdDifValA".equals(str)) {
                tncDifStdTarget.setTncStdDifValAFlg(true);
            } else if ("tncStdDifValB".equals(str)) {
                tncDifStdTarget.setTncStdDifValBFlg(true);
            } else if ("tncStdDifValC".equals(str)) {
                tncDifStdTarget.setTncStdDifValCFlg(true);
            } else if ("remark".equals(str)) {
                tncDifStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                tncDifStdTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        return tncDifStdTarget;
    }
}