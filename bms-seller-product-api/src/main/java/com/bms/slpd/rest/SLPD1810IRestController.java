package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1810IParam;
import com.bms.slpd.bean.result.SLPD1810IResult;
import com.bms.slpd.services.SLPD1810IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD1810IValidator;
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

@Api(tags = "SLPD1810IRestController", description = "批量新增单品品牌规格代理商")
@RestController
public class SLPD1810IRestController extends BaseRestController {

	@Autowired
	private SLPD1810IService slpd1810IService;

	@ApiOperation(value = "批量新增单品品牌规格代理商",
			notes = "批量新增单品品牌规格代理商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/agent/supply/_add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD1810IValidator.class)
	public SLPD1810IResult addAgentSupplyProducts(@RequestBody SLPD1810IParam slpd1810IParam) {
		SLPD1810IResult slpd1810IResult = slpd1810IService.addAgentSupplyProducts(slpd1810IParam);
		slpd1810IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1810IResult;

	}

}
