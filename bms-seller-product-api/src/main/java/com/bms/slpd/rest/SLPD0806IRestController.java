package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0806IParam;
import com.bms.slpd.bean.result.SLPD0806IResult;
import com.bms.slpd.services.SLPD0806IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0806IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SLPD0806IRestController", description = "批量添加卖家单品品牌(规格)生产商货号及商品ID")
@RestController
public class SLPD0806IRestController extends BaseRestController {

	@Autowired
	private SLPD0806IService slpd0806iService;

	@ApiOperation(value = "批量添加卖家单品品牌(规格)生产商货号及商品IDURL",
			notes = "批量添加卖家单品品牌(规格)生产商货号及商品ID")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/producers/sellers/articleNos/commodityIds/_add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0806IValidator.class)
	public SLPD0806IResult addArticleNosAndCommodityIds(@RequestBody SLPD0806IParam slpd0806iParam) {
		SLPD0806IResult result = this.slpd0806iService.addArticleNosAndCommodityIds(slpd0806iParam);

		result.setMessages(MessageUtils.getSuccessMessage());
		return result;
	}

}
