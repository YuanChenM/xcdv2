package com.framework.resource.validator;

import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
public class ValidatorPageResourceSave extends DefaultCustomValidator<PageResourceDoc> {
    @Override
    public void validator(PageResourceDoc request) {
        this.validatorRequired("res.E00024", request);
        if (null != request) {
            this.validatorRequired("res.E00015", request.getPageName());
            this.validatorRequired("res.E00016", request.getPageDesc());
            this.validatorRequired("res.E00017", request.getIsMenu());
            this.validatorRequired("res.E00018", request.getPageUrl());
        }
    }
}
