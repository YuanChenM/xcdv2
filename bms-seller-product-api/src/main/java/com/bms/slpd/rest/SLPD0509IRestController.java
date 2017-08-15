package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0509IParam;
import com.bms.slpd.bean.result.SLPD0509IResult;
import com.bms.slpd.services.SLPD0509IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0509IValidator;
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

@Api(tags = "SLPD0509IRestController", description = "批量审核代理商产品生产商API")
@RestController
public class SLPD0509IRestController extends BaseRestController {

	@Autowired
	private SLPD0509IService slpd0509iService;

	@ApiOperation(value = "批量审核代理商产品生产商URL",
			notes = "批量禁止代理商产品生产商,准入代理商产品生产商,及所对应制造商生产商产品,生产商产品,产品")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/agent/supply/_audit",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0509IValidator.class)
	public SLPD0509IResult auditProducts(@RequestBody SLPD0509IParam slpd0509iParam) {
		int count = this.slpd0509iService.auditAgentProducts(slpd0509iParam);
		SLPD0509IResult slpd0509IResult = new SLPD0509IResult();
		slpd0509IResult.setCount(count);
		slpd0509IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0509IResult;
	}

}
