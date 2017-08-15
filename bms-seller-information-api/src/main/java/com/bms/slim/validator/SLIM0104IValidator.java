package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0104IParam;
import com.bms.slim.bean.param.field.SLIM0104ISBQParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SLIM0104IValidator extends DefaultCustomValidator<SLIM0104IParam> {

    @Override
    public void validator(SLIM0104IParam slim0104IParam) {
        this.validateSBQParams(slim0104IParam.getSbqParams());
    }

    /**
     * 校验实体卖家参数
     */
    private void validateSBQParams(List<SLIM0104ISBQParam> sbqParams) {
        super.validatorRequired("sbqParams", sbqParams);
        if (CollectionUtils.isEmpty(sbqParams)) {
            return;
        }

        final int i256 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX;

        for (SLIM0104ISBQParam sbqParam : sbqParams) {
            if (null == sbqParam) {
                return;
            }
            super.validatorRequired("entitySellerId", sbqParam.getEntitySellerId());
            super.validatorRequired("threeInOneFlg", sbqParam.getThreeInOneFlg());
            if (null != sbqParam.getThreeInOneFlg() && sbqParam.getThreeInOneFlg()) {
                super.validatorMaxLength("threeInOneNo", sbqParam.getThreeInOneNo(), true, i256);
//                super.validatorMaxLength("threeInOneUrl", sbqParam.getThreeInOneUrl(), true, i256);
            } else {
                super.validatorMaxLength("orgCodeCertUrl", sbqParam.getOrgCodeCertUrl(), true, i256);
                super.validatorMaxLength("taxRegCertUrl", sbqParam.getTaxRegCertUrl(), true, i256);
                super.validatorMaxLength("vatTaxpayerQualUrl", sbqParam.getVatTaxpayerQualUrl(), true, i256);
                super.validatorMaxLength("businessLicenseNo", sbqParam.getBusinessLicenseNo(), true, i256);
                super.validatorMaxLength("businessLicenseUrl", sbqParam.getBusinessLicenseUrl(), true, i256);
            }
            super.validatorMaxLength("organizationCode", sbqParam.getOrganizationCode(), true, i256);
            super.validatorMaxLength("taxRegCertNo", sbqParam.getTaxRegCertNo(), true, i256);
            super.validatorMaxLength("companyName", sbqParam.getCompanyName(), true, i256);
            super.validatorMaxLength("companyNature", sbqParam.getCompanyNature(), true, i256);
            super.validatorMaxLength("companyAddress", sbqParam.getCompanyAddress(), true, i256);
            super.validatorMaxLength("legalPerson", sbqParam.getLegalPerson(), true, i256);
            super.validatorMaxLength("bankLegalPerson", sbqParam.getBankLegalPerson(), true, i256);
            super.validatorDecimal("registeredCapital", sbqParam.getRegisteredCapital(), true, 15, 2, 5);
            super.validatorDecimal("paidInCapital", sbqParam.getPaidInCapital(), true, 15, 2, 5);
            super.validatorDate("foundingDate", sbqParam.getFoundingDate(), true);
            super.validatorMaxLength("operationPeriod", sbqParam.getOperationPeriod(), true, i256);
            super.validatorMaxLength("businessScope", sbqParam.getBusinessScope(), true, i256);
            super.validatorMaxLength("depositBank", sbqParam.getDepositBank(), true, i256);
            super.validatorMaxLength("bankAccount", sbqParam.getBankAccount(), true, i256);
            super.validatorMaxLength("accPermitCertUrl", sbqParam.getAccPermitCertUrl(), true, i256);
        }
    }
}
