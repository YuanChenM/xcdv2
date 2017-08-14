package com.bms.bypo.validator;

import com.bms.bypo.bean.BaseRequest;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleResearchRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by zhang_jian4 on 2016/12/21.
 */
public class ProductSaleResearchModifyValidator extends DefaultCustomValidator<BaseRequest<BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam>>> {
    @Override
    public void validator(BaseRequest<BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam>> baseBeanBaseRequest) {
        if (CollectionUtils.isNotEmpty(baseBeanBaseRequest.getBeans())) {
            List<BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam>> params;
            if (baseBeanBaseRequest.getBeans() != null) {
                params = baseBeanBaseRequest.getBeans();
                int size = params.size();
                ProductSaleResearchRsParam filter;
                ProductSaleResearchRsParam target;
                for (int i = 0; i < size; i++) {
                    filter = params.get(i).getFilter();
                    target = params.get(i).getTarget();
                    this.validatorRequired("调研ID为必填项", filter.getResearchId());
                    if (filter.getResearchId() != null) {
                        this.validatorLong(MessageDef.Label.L00018, filter.getResearchId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                    }

                    if (StringUtils.isNotEmpty(target.getLgcsAreaCode())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00003, target.getLgcsAreaCode(), true, 2);
                    }
                    if (StringUtils.isNotEmpty(target.getLgcsAreaName())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00004, target.getLgcsAreaName(), true, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerType())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00005, target.getBuyerType(), true, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerFirstCategory())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00006, target.getBuyerFirstCategory(), true, 2);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerFirstCategoryName())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00007, target.getBuyerFirstCategoryName(), true, 16);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerSubCategory())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00008, target.getBuyerSubCategory(), true, 1);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerSubCategoryName())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00009, target.getBuyerSubCategoryName(), true, 16);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerPoolCode())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00010, target.getBuyerPoolCode(), true, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerPoolName())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00011, target.getBuyerPoolName(), true, 16);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerId())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00015, target.getBuyerId(), true, 36);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerCode())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00016, target.getBuyerCode(), true, 32);
                    }
                    if (StringUtils.isNotEmpty(target.getBuyerName())) {
                        this.validatorMaxLength(i, MessageDef.Label.L00017, target.getBuyerName(), true, 8);
                    }

                    if(target.getPricePlateStart() != null){
                        this.validatorDate("所属价盘开始时间为DATE类型", target.getPricePlateStart(), true);
                    }
                    if(target.getPricePlateEnd() != null){
                        this.validatorDate("所属价盘结束时间为DATE类型", target.getPricePlateEnd(), true);
                    }
                }
            } else {
                this.validatorRequired(MessageDef.Label.L00018, null);
            }
        }
    }
}
