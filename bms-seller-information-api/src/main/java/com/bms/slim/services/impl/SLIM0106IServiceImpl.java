package com.bms.slim.services.impl;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.entity.target.SlimSellerBusinessQualificationTarget;
import com.bms.slim.bean.param.SLIM0106IParam;
import com.bms.slim.bean.result.SLIM0106IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.dao.SLIM0106IDao;
import com.bms.slim.services.SLIM0106IService;
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
public class SLIM0106IServiceImpl extends BaseServiceImpl implements SLIM0106IService {
    @Autowired
    private SLIM0106IDao slim0106IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0106IDao;
    }

    @Override
    public SLIM0106IResult updateSBQ(SLIM0106IParam slim0106IParam) {
        Date dateTime = DateUtils.getCurrent();
        SlimSellerBusinessQualification entity = BeanUtils.toBean(slim0106IParam, SlimSellerBusinessQualification.class);
        entity.setUpdId(super.getLoginUserId());
        entity.setUpdTime(dateTime);
        SlimSellerBusinessQualificationTarget target = this.setTarget(slim0106IParam.getTargets());
        UpdateEntity<SlimSellerBusinessQualification, SlimSellerBusinessQualificationTarget> updateEntity = new UpdateEntity<>();
        updateEntity.setEntity(entity);
        updateEntity.setTarget(target);
        int count =  slim0106IDao.updateSBQ(updateEntity);
        SLIM0106IResult result = new SLIM0106IResult();
        if (NumberConst.IntDef.INT_ZERO == count) {
            result.setMessages(new String[]{MessageConstant.FAILURE, "卖家经营资质修改失败,请刷新页面重试"});
            return result;

        }
        result.setCount(count);
        List<Long> sbqIds = new ArrayList<>();
        sbqIds.add(slim0106IParam.getSbqId());
        result.setSbqIds(sbqIds);
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    private SlimSellerBusinessQualificationTarget setTarget(String[] targets) {
        SlimSellerBusinessQualificationTarget target = new SlimSellerBusinessQualificationTarget();
        StringBuilder str = new StringBuilder();
        int count = NumberConst.IntDef.INT_ZERO;
        for (String targetFlg : targets) {
            if (FieldConstant.SlimSellerBusinessQualification.THREE_IN_ONE_FLG.equals(targetFlg))
                 target.setThreeInOneFlgFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.THREE_IN_ONE_NO.equals(targetFlg))
                 target.setThreeInOneNoFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.THREE_IN_ONE_URL.equals(targetFlg))
                 target.setThreeInOneUrlFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.ORGANIZATION_CODE.equals(targetFlg))
                 target.setOrganizationCodeFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.ORG_CODE_CERT_URL.equals(targetFlg))
                 target.setOrgCodeCertUrlFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.TAX_REG_CERT_NO.equals(targetFlg))
                 target.setTaxRegCertNoFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.TAX_REG_CERT_URL.equals(targetFlg))
                 target.setTaxRegCertUrlFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.VAT_TAXPAYER_QUAL_URL.equals(targetFlg))
                 target.setVatTaxpayerQualUrlFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.BUSINESS_LICENSE_NO.equals(targetFlg))
                 target.setBusinessLicenseNoFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.BUSINESS_LICENSE_URL.equals(targetFlg))
                 target.setBusinessLicenseUrlFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.COMPANY_NAME.equals(targetFlg))
                 target.setCompanyNameFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.COMPANY_NATURE.equals(targetFlg))
                 target.setCompanyNatureFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.COMPANY_ADDRESS.equals(targetFlg))
                 target.setCompanyAddressFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.LEGAL_PERSON.equals(targetFlg))
                 target.setLegalPersonFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.REGISTERED_CAPITAL.equals(targetFlg))
                 target.setRegisteredCapitalFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.PAID_IN_CAPITAL.equals(targetFlg))
                 target.setPaidInCapitalFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.FOUNDING_DATE.equals(targetFlg))
                 target.setFoundingDateFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.OPERATION_PERIOD.equals(targetFlg))
                 target.setOperationPeriodFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.BUSINESS_SCOPE.equals(targetFlg))
                 target.setBusinessScopeFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.DEPOSIT_BANK.equals(targetFlg))
                 target.setDepositBankFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.BANK_ACCOUNT.equals(targetFlg))
                 target.setBankAccountFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.BANK_LEGAL_PERSON.equals(targetFlg))
                target.setBankLegalPersonFlg(true);
            else if (FieldConstant.SlimSellerBusinessQualification.ACC_PERMIT_CERT_URL.equals(targetFlg))
                target.setAccPermitCertUrlFlg(true);
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
