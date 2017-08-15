package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdTncStd;
import com.bms.slpd.bean.entity.target.SlpdTncStdTarget;
import com.bms.slpd.bean.param.SLPD0612IParam;
import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.bms.slpd.bean.result.SLPD0612IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0612IDao;
import com.bms.slpd.services.SLPD0612IService;
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
public class SLPD0612IServiceImpl extends BaseServiceImpl implements SLPD0612IService {

    @Autowired
    private SLPD0612IDao slpd0612IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0612IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0612IResult modifyTncStds(SLPD0612IParam requestParam) {

        Date updTime = DateUtils.getCurrent();
        SLPD0612IResult result = new SLPD0612IResult();
        List<Long> tncStdIds = new ArrayList<>();
        List<SLPD0610ITncStdParam> list = requestParam.getTncStdParams();
        SlpdTncStdTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdTncStd, SlpdTncStdTarget>> updateList = new ArrayList<>();
        int count = 0;
        for (SLPD0610ITncStdParam param : list) {
            UpdateEntity<SlpdTncStd, SlpdTncStdTarget> updateEntity = new UpdateEntity<>();
            SlpdTncStd tncStd = BeanUtils.toBean(param, SlpdTncStd.class);
            tncStd.setUpdTime(updTime);
            tncStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(tncStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }
        StringBuilder builder;
        for (UpdateEntity<SlpdTncStd, SlpdTncStdTarget> updateEntity : updateList) {
            int num = slpd0612IDao.batchModify(updateEntity);
            if (0 < num) {
                count += num;
                tncStdIds.add(updateEntity.getEntity().getTncStdId());
            }else {
                builder = new StringBuilder()
                        .append("修改加工质量标准指标:")
                        .append(updateEntity.getEntity().getTncStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }
        result.setCount(count);
        result.setTncStdIds(tncStdIds);

        return result;

    }

    public SlpdTncStdTarget setTarget(SLPD0612IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }

        SlpdTncStdTarget tncStdTarget = new SlpdTncStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("tncStdValA".equals(str)) {
                tncStdTarget.setTncStdValAFlg(true);
            } else if ("tncStdValB".equals(str)) {
                tncStdTarget.setTncStdValBFlg(true);
            } else if ("tncStdValC".equals(str)) {
                tncStdTarget.setTncStdValCFlg(true);
            } else if ("remark".equals(str)) {
                tncStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                tncStdTarget.setDelFlgFlg(true);
            } else {
                invalid.add(str);
            }
        }

        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("targets:");
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            builder.append("错误");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        return tncStdTarget;
    }

}