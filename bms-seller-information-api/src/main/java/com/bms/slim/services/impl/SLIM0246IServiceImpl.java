package com.bms.slim.services.impl;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.target.SlimContactTarget;
import com.bms.slim.bean.param.SLIM0246IParam;
import com.bms.slim.bean.result.SLIM0246IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.dao.SLIM0246IDao;
import com.bms.slim.services.SLIM0246IService;
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
public class SLIM0246IServiceImpl extends BaseServiceImpl implements SLIM0246IService {
    @Autowired
    private SLIM0246IDao slim0246IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0246IDao;
    }

    @Override
    public SLIM0246IResult updateContact(SLIM0246IParam slim0246IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        SlimContactTarget target = this.setTarget(slim0246IParam.getTargets());
        SlimContact entity = BeanUtils.toBean(slim0246IParam, SlimContact.class);
        entity.setUpdId(userId);
        entity.setUpdTime(current);
        UpdateEntity<SlimContact, SlimContactTarget> updateEntity = new UpdateEntity<>();
        updateEntity.setEntity(entity);
        updateEntity.setTarget(target);

        int count = slim0246IDao.updateContact(updateEntity);
        if (NumberConst.IntDef.INT_ZERO == count) {
//            SLIM0246IResult result = new SLIM0246IResult();
//            result.setMessages(new String[]{MessageConstant.FAILURE, "联系人修改失败,请刷新页面重试"});
//            return result;
            throw new BusinessException(MessageConstant.MODULE_NAME_EN,
                    "联系人修改失败,请刷新页面重试!");
        }

        SLIM0246IResult result = new SLIM0246IResult();
        List<Long> contactIds = new ArrayList<>();
        contactIds.add(slim0246IParam.getContactId());
        result.setCount(count);
        result.setContactIds(contactIds);
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    private SlimContactTarget setTarget(String[] targets) {
        SlimContactTarget target = new SlimContactTarget();
        StringBuilder str = new StringBuilder();
        int count = NumberConst.IntDef.INT_ZERO;
        for (String targetFlg : targets) {
            if (FieldConstant.SlimContact.CONTACT_NAME.equals(targetFlg))
                target.setContactNameFlg(true);
            else if (FieldConstant.SlimContact.CONTACT_TYPE.equals(targetFlg))
                target.setContactTypeFlg(true);
            else if (FieldConstant.SlimContact.MOBILE.equals(targetFlg))
                target.setMobileFlg(true);
            else if (FieldConstant.SlimContact.WECHAT.equals(targetFlg))
                target.setWechatFlg(true);
            else if (FieldConstant.SlimContact.QQ.equals(targetFlg))
                target.setQqFlg(true);
            else if (FieldConstant.SlimContact.EMAIL.equals(targetFlg))
                target.setEmailFlg(true);
            else if (FieldConstant.Common.DEL_FLG.equals(targetFlg))
                target.setDelFlgFlg(true);
            else {
                ++count;
                str.append(targetFlg).append(",");
            }
        }

        if (NumberConst.IntDef.INT_ZERO < count) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, str.append("字段名无效").toString());
        }
        return target;
    }
}
