package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0704IParam;
import com.bms.slpd.bean.result.SLPD0704IResult;
import com.bms.slpd.services.SLPD0704IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0704IValidator;
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

@Api(tags = "SLPD0704IRestController", description = "批量审核单品品牌(规格)生产商API")
@RestController
public class SLPD0704IRestController extends BaseRestController {

	@Autowired
	private SLPD0704IService slpd0704iService;

	@ApiOperation(value = "批量审核单品品牌(规格)生产商URL",
			notes = "批量审核单品品牌(规格)生产商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/producers/_audit",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0704IValidator.class)
	public SLPD0704IResult auditProducerProducts(@RequestBody SLPD0704IParam slpd0704iParam) {
		int count = this.slpd0704iService.auditProducerProducts(slpd0704iParam);
		SLPD0704IResult slpd0704IResult = new SLPD0704IResult();
		slpd0704IResult.setCount(count);
		slpd0704IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0704IResult;
	}

}
