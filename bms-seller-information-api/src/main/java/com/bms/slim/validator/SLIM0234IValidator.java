package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0234IParam;
import com.bms.slim.bean.param.field.SLIM0234ProducerLaboratoryParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0234IValidator extends DefaultCustomValidator<SLIM0234IParam> {

    @Override
    public void validator(SLIM0234IParam slim0234IParam) {
        List<SLIM0234ProducerLaboratoryParam> paramList = slim0234IParam.getProducerLaboratories();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0234ProducerLaboratoryParam param : paramList) {
                this.validatorRequired("sellerRoleId",param.getSellerRoleId());
                this.validatorRequired("acreage",param.getAcreage());
                this.validatorRequired("effect",param.getEffect());
                this.validatorRequired("inverstnent",param.getInverstnent());
                this.validatorRequired("member",param.getMember());
                this.validatorRequired("labPicUrl",param.getLabPicUrl());
                this.validatorRequired("orgFrameImgUrl",param.getOrgFrameImgUrl());
                this.validatorRequired("qualityCtrlImgUrl",param.getQualityCtrlImgUrl());
            }
        }
    }

}
