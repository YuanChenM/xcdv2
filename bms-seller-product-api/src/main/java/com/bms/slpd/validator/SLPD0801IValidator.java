package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0801IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 新增(卖家)单品品牌(规格)生产商注册Validator
 */
public class SLPD0801IValidator extends DefaultCustomValidator<SLPD0801IParam> {

    @Override
    public void validator(SLPD0801IParam slpd0801IParam) {
        /*this.validatorRequired(MessageConstant.Label.Beans,slpd0801IParam.getSlpdSellerCommodities());
        for (SlpdSellerCommodityParam param : slpd0801IParam.getSlpdSellerCommodities()) {
            this.validatorRequired(MessageConstant.Label.SellerId,param.getSellerId());
            this.validatorMaxLength(MessageConstant.Label.SellerName, param.getSellerName(), false, 256);
            this.validatorRequired(MessageConstant.Label.ProducerProductId,param.getProducerProductId());
            this.validatorMaxLength(MessageConstant.Label.ArticleNo, param.getArticleNo(), false, 32);
            this.validatorMaxLength(MessageConstant.Label.CommodityId, param.getCommodityId(), false, 32);
            this.validatorMaxLength(MessageConstant.Label.SalesTitle, param.getSalesTitle(), false, 512);
            this.validatorRequired(MessageConstant.Label.CrtId,param.getCrtId());
        }*/
    }

}
