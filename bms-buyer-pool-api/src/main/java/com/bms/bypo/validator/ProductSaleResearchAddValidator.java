package com.bms.bypo.validator;

import com.bms.bypo.bean.param.ProductSaleResearchRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2016/12/21.
 */
public class ProductSaleResearchAddValidator extends DefaultCustomValidator<ProductSaleResearchRsParam> {
    @Override
    public void validator(ProductSaleResearchRsParam param) {

        if (param != null) {
            this.validatorRequired(MessageDef.Label.L00003, param.getLgcsAreaCode());
            this.validatorRequired(MessageDef.Label.L00004, param.getLgcsAreaName());

            this.validatorRequired(MessageDef.Label.L00005, param.getBuyerType());
            this.validatorRequired(MessageDef.Label.L00006, param.getBuyerFirstCategory());
            this.validatorRequired(MessageDef.Label.L00007, param.getBuyerFirstCategoryName());
            this.validatorRequired(MessageDef.Label.L00008, param.getBuyerSubCategory());
            this.validatorRequired(MessageDef.Label.L00009, param.getBuyerSubCategoryName());

            this.validatorRequired(MessageDef.Label.L00011, param.getBuyerPoolName());
            this.validatorRequired(MessageDef.Label.L00010, param.getBuyerPoolCode());

            /*this.validatorMaxLength(NumberConst.IntDef.INT_ONE, MessageDef.Label.L00020,param.getBuyerCode(), true, 3);*/

            this.validatorRequired(MessageDef.Label.L00015, param.getBuyerId());
            this.validatorRequired(MessageDef.Label.L00016, param.getBuyerName());
            this.validatorRequired(MessageDef.Label.L00017, param.getBuyerCode());
            /*this.validatorRequired("所属价盘开始时间为必输项", param.getPricePlateStart());
            this.validatorRequired("所属价盘结束时间为必输项", param.getPricePlateEnd());*/

            if (StringUtils.isNotEmpty(param.getLgcsAreaCode())) {
                this.validatorMaxLength(MessageDef.Label.L00003, param.getLgcsAreaCode(), true, 2);
            }
            if (StringUtils.isNotEmpty(param.getLgcsAreaName())) {
                this.validatorMaxLength(MessageDef.Label.L00004, param.getLgcsAreaName(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getBuyerType())) {
                this.validatorMaxLength(MessageDef.Label.L00005, param.getBuyerType(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getBuyerFirstCategory())) {
                this.validatorMaxLength(MessageDef.Label.L00006, param.getBuyerFirstCategory(), true, 2);
            }
            if (StringUtils.isNotEmpty(param.getBuyerFirstCategoryName())) {
                this.validatorMaxLength(MessageDef.Label.L00007, param.getBuyerFirstCategoryName(), true, 16);
            }
            if (StringUtils.isNotEmpty(param.getBuyerSubCategory())) {
                this.validatorMaxLength(MessageDef.Label.L00008, param.getBuyerSubCategory(), true, 1);
            }
            if (StringUtils.isNotEmpty(param.getBuyerSubCategoryName())) {
                this.validatorMaxLength(MessageDef.Label.L00009, param.getBuyerSubCategoryName(), true, 16);
            }
            if (StringUtils.isNotEmpty(param.getBuyerPoolCode())) {
                this.validatorMaxLength(MessageDef.Label.L00010, param.getBuyerPoolCode(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getBuyerPoolName())) {
                this.validatorMaxLength(MessageDef.Label.L00011, param.getBuyerPoolName(), true, 16);
            }
            if (StringUtils.isNotEmpty(param.getBuyerId())) {
                this.validatorMaxLength(MessageDef.Label.L00015, param.getBuyerId(), true, 36);
            }
            if (StringUtils.isNotEmpty(param.getBuyerCode())) {
                this.validatorMaxLength(MessageDef.Label.L00016, param.getBuyerCode(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getBuyerName())) {
                this.validatorMaxLength(MessageDef.Label.L00017, param.getBuyerName(), true, 8);
            }
            if (param.getPricePlateStart() != null) {
                this.validatorDate("所属价盘开始时间为DATE类型", param.getPricePlateStart(), true);
            }
            if (param.getPricePlateEnd() != null) {
                this.validatorDate("所属价盘结束时间为DATE类型", param.getPricePlateEnd(), true);
            }
        } else {
            this.validatorRequired("提交内容不能为空", null);
        }
    }
}
