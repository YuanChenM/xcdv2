package com.bms.slim.services.impl;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.bms.slim.bean.entity.target.SlimSellerContractPermissionTarget;
import com.bms.slim.bean.param.SLIM0118IParam;
import com.bms.slim.bean.param.field.SLIM0118ISellerContractPermissionParam;
import com.bms.slim.bean.result.SLIM0118IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.dao.SLIM0118IDao;
import com.bms.slim.services.SLIM0118IService;
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
public class SLIM0118IServiceImpl extends BaseServiceImpl implements SLIM0118IService {
    @Autowired
    private SLIM0118IDao slim0118IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0118IDao;
    }

    @Override
    public SLIM0118IResult updateSCP(SLIM0118IParam slim0118IParam) {
        Date dateTime = DateUtils.getCurrent();
        SlimSellerContractPermissionTarget target = this.setTarget(slim0118IParam.getTargets());;
        UpdateEntity<SlimSellerContractPermission, SlimSellerContractPermissionTarget> updateEntity = null;
        SlimSellerContractPermission entity = null;
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> scpIds = new ArrayList<>();

        for (SLIM0118ISellerContractPermissionParam permission : slim0118IParam.getSellerContractPermissionParams()) {
            entity = BeanUtils.toBean(permission, SlimSellerContractPermission.class);
            entity.setUpdId(super.getLoginUserId());
            entity.setUpdTime(dateTime);
            updateEntity = new UpdateEntity<>();
            updateEntity.setEntity(entity);
            updateEntity.setTarget(target);
            count =  slim0118IDao.updateSCP(updateEntity);
            if (NumberConst.IntDef.INT_ZERO == count) {
                SLIM0118IResult result = new SLIM0118IResult();
                result.setMessages(new String[]{MessageConstant.FAILURE, "卖家合同信息准入修改失败,请刷新页面重试"});
                return result;
//                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,
//                        "卖家合同信息准入修改失败,请刷新页面重试!");
            }
            scpIds.add(entity.getScpId());
            count ++;
        }

        SLIM0118IResult result = new SLIM0118IResult();
        result.setCount(count);
        result.setScpIds(scpIds);
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    private SlimSellerContractPermissionTarget setTarget(String[] targets) {
        SlimSellerContractPermissionTarget target = new SlimSellerContractPermissionTarget();
        StringBuilder str = new StringBuilder();
        int count = NumberConst.IntDef.INT_ZERO;
        for (String targetFlg : targets) {
            if (FieldConstant.SlimSellerContractPermission.ENTITY_SELLER_ID.equals(targetFlg))
                 target.setEntitySellerIdFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.SELLER_FULL_NAME.equals(targetFlg))
                 target.setSellerFullNameFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.COUNTRY_CODE.equals(targetFlg))
                 target.setCountryCodeFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.COUNTRY_NAME.equals(targetFlg))
                 target.setCountryNameFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.PROVINCE_CODE.equals(targetFlg))
                 target.setProvinceCodeFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.PROVINCE_NAME.equals(targetFlg))
                 target.setProvinceNameFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.CITY_CODE.equals(targetFlg))
                 target.setCityCodeFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.CITY_NAME.equals(targetFlg))
                 target.setCityNameFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.BUSINESS_ADDRESS.equals(targetFlg))
                 target.setBusinessAddressFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.PAYEE_NAME.equals(targetFlg))
                 target.setPayeeNameFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.PAYEE_BANK.equals(targetFlg))
                 target.setPayeeBankFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.BANK_ACCOUNT.equals(targetFlg))
                 target.setBankAccountFlg(true);
            else if (FieldConstant.SlimSellerContractPermission.EXPRESS_ADDRESS.equals(targetFlg))
                 target.setExpressAddressFlg(true);
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
