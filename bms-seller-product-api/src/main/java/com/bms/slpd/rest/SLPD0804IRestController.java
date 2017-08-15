package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0804IParam;
import com.bms.slpd.bean.result.SLPD0804IResult;
import com.bms.slpd.services.SLPD0804IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0804IValidator;
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

@Api(tags = "SLPD0804IRestController", description = "批量审核卖家单品品牌(规格)生产商API")
@RestController
public class SLPD0804IRestController extends BaseRestController {

	@Autowired
	private SLPD0804IService slpd0804iService;

	@ApiOperation(value = "批量审核卖家单品品牌(规格)生产商URL",
			notes = "批量审核卖家单品品牌(规格)生产商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/producers/sellers/_audit",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0804IValidator.class)
	public SLPD0804IResult auditSellerCommodities(@RequestBody SLPD0804IParam slpd0804iParam) {
		int count = this.slpd0804iService.auditSellerCommodities(slpd0804iParam);
		SLPD0804IResult slpd0804iResult = new SLPD0804IResult();
		slpd0804iResult.setCount(count);
		slpd0804iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0804iResult;
	}

}
