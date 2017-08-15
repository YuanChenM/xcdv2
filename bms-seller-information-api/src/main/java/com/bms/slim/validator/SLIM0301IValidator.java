package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0301IParam;
import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import com.bms.slim.constant.MessageConstant;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 *
 * 新增卖家品牌验证
 */
public class SLIM0301IValidator extends DefaultCustomValidator<SLIM0301IParam> {

    @Override
    public void validator(SLIM0301IParam slim0301IParam) {
        List<SlimSellerBrandParam> sellerBreedList = slim0301IParam.getSellerBreedList();


        /*this.validatorRequired(MessageConstant.Label.Beans, sellerBreedList);

        for (SlimSellerBrandParam param : sellerBreedList) {
            this.validatorRequired(MessageConstant.Label.BrandId,param.getBrandId());
            this.validatorRequired(MessageConstant.Label.EntitySellerId,param.getEntitySellerId());
            this.validatorMaxLength(MessageConstant.Label.UpdId, param.getUpdId(), true, 32);
            this.validatorMaxLength(MessageConstant.Label.CrtId, param.getCrtId(), true, 32);
        }*/

    }
}
