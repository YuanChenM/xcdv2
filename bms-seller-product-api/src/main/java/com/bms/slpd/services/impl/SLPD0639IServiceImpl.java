package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifGnqStd;
import com.bms.slpd.bean.entity.target.SlpdDifGnqStdTarget;
import com.bms.slpd.bean.param.SLPD0639IParam;
import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import com.bms.slpd.bean.result.SLPD0639IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0639IDao;
import com.bms.slpd.services.SLPD0639IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SLPD0639IServiceImpl extends BaseServiceImpl implements SLPD0639IService {

    @Autowired
    private SLPD0639IDao slpd0639IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0639IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0639IResult modifyDifGnqStds(SLPD0639IParam requestParam) {
        SLPD0639IResult result = new SLPD0639IResult();
        List<Long> gnqDifStdIds = new ArrayList<>();
        List<SLPD0637IGnqDifStdParam> list = requestParam.getGnqDifStdParams();
        SlpdDifGnqStdTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdDifGnqStd, SlpdDifGnqStdTarget>> updateList = new ArrayList<>();
        int count = 0;
        for (SLPD0637IGnqDifStdParam param : list) {
            UpdateEntity<SlpdDifGnqStd, SlpdDifGnqStdTarget> updateEntity = new UpdateEntity<>();
            SlpdDifGnqStd tncStd = BeanUtils.toBean(param, SlpdDifGnqStd.class);
            tncStd.setUpdTime(DateUtils.getCurrent());
            tncStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(tncStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        StringBuilder builder;
        for (UpdateEntity<SlpdDifGnqStd, SlpdDifGnqStdTarget> updateEntity : updateList) {
            int num = slpd0639IDao.batchModify(updateEntity);
            if (0 < num) {
                count += num;
                gnqDifStdIds.add(updateEntity.getEntity().getGnqDifStdId());
            }else {
                builder = new StringBuilder()
                        .append("修改通用质量标准差异:")
                        .append(updateEntity.getEntity().getGnqDifStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }
        result.setCount(count);
        result.setGnqDifStdIds(gnqDifStdIds);

        return result;
    }

    public SlpdDifGnqStdTarget setTarget(SLPD0639IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }

        SlpdDifGnqStdTarget difGnqStdTarget = new SlpdDifGnqStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("gnqOkDifVal".equals(str)) {
                difGnqStdTarget.setGnqOkDifValFlg(true);
            } else if ("gnqNgDifVal".equals(str)) {
                difGnqStdTarget.setGnqNgDifValFlg(true);
            } else if ("remark".equals(str)) {
                difGnqStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                difGnqStdTarget.setDelFlgFlg(true);
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

        return difGnqStdTarget;
    }
}